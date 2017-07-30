package mvp.sample.com.rxjavaretrofitsample.base;

import io.reactivex.observers.DisposableObserver;

/**
 * @author amanbansal
 * @version 1.0
 * @since 30/7/17
 */
public abstract class AbstractObserver<T> extends DisposableObserver<T> {


    @Override
    public abstract void onNext(T value);

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
