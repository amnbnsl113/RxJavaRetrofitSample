package mvp.sample.com.rxjavaretrofitsample.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author amanbansal
 * @version 1.0
 * @since 30/7/17
 */
public abstract class AbstractObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public abstract void onNext(T value);

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
