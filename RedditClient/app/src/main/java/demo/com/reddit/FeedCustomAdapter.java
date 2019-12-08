package demo.com.reddit;


import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import demo.com.reddit.model.Entry;

public class FeedCustomAdapter extends RecyclerView.Adapter<FeedCustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public void setList(List<Entry> list) {
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView content;
        TextView author;
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.content = (TextView) itemView.findViewById(R.id.content_tv);
            this.author = (TextView) itemView.findViewById(R.id.author);
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            //this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public FeedCustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView content = holder.content;
        TextView author = holder.author;
        TextView title = holder.title;

        content.setText("");//Html.fromHtml(dataSet.get(listPosition).getContent())
        author.setText("Author: "+dataSet.get(listPosition).getAuthor());
        title.setText(dataSet.get(listPosition).getTitle());
        //imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
