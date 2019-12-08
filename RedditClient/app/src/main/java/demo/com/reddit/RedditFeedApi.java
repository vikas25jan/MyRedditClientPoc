package demo.com.reddit;

import demo.com.reddit.model.Feed;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RedditFeedApi {
    String BASE_URL = "https://www.reddit.com/r/";

    @GET("popular/.rss")
    Call<Feed> getFeed();
}
