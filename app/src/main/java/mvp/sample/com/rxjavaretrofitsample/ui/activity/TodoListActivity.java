package mvp.sample.com.rxjavaretrofitsample.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mvp.sample.com.rxjavaretrofitsample.R;
import mvp.sample.com.rxjavaretrofitsample.base.AbstractObserver;
import mvp.sample.com.rxjavaretrofitsample.model.TodoModel;
import mvp.sample.com.rxjavaretrofitsample.network.NetworkInteraction;
import mvp.sample.com.rxjavaretrofitsample.network.retrofit.RetrofitInteraction;
import mvp.sample.com.rxjavaretrofitsample.ui.adapter.TodoListAdapter;

public class TodoListActivity extends AppCompatActivity {

    private RecyclerView todoList;
    private ProgressBar progressBar;
    private ViewGroup errorLayout;

    private TodoListAdapter todoAdapter;
    private NetworkInteraction networkInteraction;


    private void showError(String errorMsg) {
        todoList.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        errorLayout.setVisibility(View.VISIBLE);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoAdapter = new TodoListAdapter(null);

        errorLayout = (ViewGroup) findViewById(R.id.errorLayout);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        todoList = (RecyclerView) findViewById(R.id.todoList);
        todoList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        todoList.setAdapter(todoAdapter);

        networkInteraction = new RetrofitInteraction();

        fetchData();

    }

    private void fetchData() {
        showProgress();

        networkInteraction.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    private void hideProgress() {
        todoList.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        errorLayout.setVisibility(View.GONE);


    }

    private void showProgress() {
        todoList.setVisibility(View.GONE);
        errorLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }


    public void retry(View view) {
        fetchData();
    }
    //Anonymous Classes

    private AbstractObserver<List<TodoModel>> subscriber = new AbstractObserver<List<TodoModel>>() {
        @Override
        public void onNext(List<TodoModel> value) {

            hideProgress();
            todoAdapter.setData(value);
        }

        @Override
        public void onError(Throwable e) {
            Log.e("pass", e.getMessage(), e);
            showError("");
        }
    };


}
