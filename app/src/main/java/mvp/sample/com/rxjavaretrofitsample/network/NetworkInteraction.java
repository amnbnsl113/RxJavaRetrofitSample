package mvp.sample.com.rxjavaretrofitsample.network;

import java.util.List;

import io.reactivex.Observable;
import mvp.sample.com.rxjavaretrofitsample.model.TodoModel;

/**
 * @author amanbansal
 * @version 1.0
 * @since 30/7/17
 */
public interface NetworkInteraction {

    Observable<List<TodoModel>> getPosts();
}
