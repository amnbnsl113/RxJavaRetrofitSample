package mvp.sample.com.rxjavaretrofitsample.network.retrofit;

import java.util.List;

import io.reactivex.Observable;
import mvp.sample.com.rxjavaretrofitsample.model.TodoModel;
import mvp.sample.com.rxjavaretrofitsample.network.NetworkInteraction;

/**
 * @author amanbansal
 * @version 1.0
 * @since 2/1/17
 */
public class RetrofitInteraction implements NetworkInteraction {

    static ApiInterfaceRetrofit requestInterface = RetrofitAdapter.getRetrofit(null).create(ApiInterfaceRetrofit.class);


    @Override
    public Observable<List<TodoModel>> getPosts() {
        return requestInterface.getPosts();
    }
}
