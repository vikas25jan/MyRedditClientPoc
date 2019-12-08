package demo.com.reddit;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import demo.com.reddit.model.Entry;
import demo.com.reddit.model.Feed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private FeedCustomAdapter feedCustomAdapter;
    private ArrayList<DataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.feed_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        data = new ArrayList<DataModel>();
        feedCustomAdapter = new FeedCustomAdapter(data);
        recyclerView.setAdapter(feedCustomAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RedditFeedApi.BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        RedditFeedApi redditFeedApi = retrofit.create(RedditFeedApi.class);
        Call<Feed> call = redditFeedApi.getFeed();

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                Log.i(TAG,"Vikas "+response.body()+" \n");
                Log.i(TAG,"Vikas "+response.body().getTitle()+" \n");
                List<Entry> entries = response.body().getEntries();
                if(entries == null){
                    Log.i(TAG," vikas : null entries ");
                    return;
                }

                for(Entry entry : entries){
                    Log.i(TAG,"Vikas "+entry.getTitle());
                }

                populateList(entries);
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.i(TAG," vikas : FAILURE "+t.getMessage());
            }
        });

    }

    private void populateList(List<Entry> list){
        for(Entry entry : list){

            DataModel model = new DataModel();
            model.setAuthor(entry.getAuthor().getName());
            model.setContent(entry.getContent());
            model.setTitle(entry.getTitle());
            data.add(model);
        }

        feedCustomAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
