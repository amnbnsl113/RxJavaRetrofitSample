package mvp.sample.com.rxjavaretrofitsample.network.retrofit;

import java.util.List;

import io.reactivex.Observable;
import mvp.sample.com.rxjavaretrofitsample.model.TodoModel;
import retrofit2.http.GET;

/**
 * @author amanbansal
 * @version 1.0
 * @since 2/1/17
 */

public interface ApiInterfaceRetrofit {

    @GET("posts")
    Observable<List<TodoModel>> getPosts();

}
