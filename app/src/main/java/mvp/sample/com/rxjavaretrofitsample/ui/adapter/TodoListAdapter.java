package mvp.sample.com.rxjavaretrofitsample.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import mvp.sample.com.rxjavaretrofitsample.R;
import mvp.sample.com.rxjavaretrofitsample.model.TodoModel;

/**
 * @author amanbansal
 * @version 1.0
 * @since 30/7/17
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.MyViewHolder> {
    private List<TodoModel> todoModels;

    public TodoListAdapter(List<TodoModel> todoModels) {
        this.todoModels = todoModels;
        if (todoModels == null) {
            this.todoModels = new ArrayList<>();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TodoModel todoModel = todoModels.get(position);
        holder.titleText.setText(todoModel.getTitle());
        holder.titleDesc.setText(todoModel.getBody());
    }

    @Override
    public int getItemCount() {
        return todoModels.size();
    }

    public void setData(List<TodoModel> value) {
        if (value != null) {
            todoModels = value;
            notifyDataSetChanged();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView titleDesc;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleText = (TextView) itemView.findViewById(R.id.titleText);
            titleDesc = (TextView) itemView.findViewById(R.id.titleDesc);
        }
    }
}
