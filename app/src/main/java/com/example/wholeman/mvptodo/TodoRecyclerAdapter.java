package com.example.wholeman.mvptodo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.ViewHolder> {

    public interface OnTodoClickListener {
        void onTodoItemClicked(Todo todo);
    }

    private List<Todo> mTodoList;
    private Context mContext;
    private final OnTodoClickListener mListener;


    public TodoRecyclerAdapter(Context context, OnTodoClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_todo_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Todo todo = mTodoList.get(position);
        viewHolder.bindTodo(todo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTodoItemClicked(todo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTodoList.isEmpty() ? 0 : mTodoList.size();
    }

    public void bindTodoList(List<Todo> todoList) {
        mTodoList = new ArrayList<>(todoList);
        notifyDataSetChanged();
    }

    public void onTodoItemClicked(Todo todo) {
        mListener.onTodoItemClicked(todo);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewTodo;
        TextView mTextViewDate;
        TextView mTextViewState;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            mTextViewTodo = itemView.findViewById(R.id.tv_todo);
            mTextViewDate = itemView.findViewById(R.id.tv_date);
            mTextViewState = itemView.findViewById(R.id.tv_state);
        }

        private void bindTodo(Todo todo) {
            mTextViewTodo.setText(todo.getText());
            mTextViewDate.setText(todo.getCreateDate());
            if ((todo.isCompleted())) {
                setCompleted();
            } else {
                setActive();
            }
        }

        private void setCompleted(){
            mTextViewState.setCompoundDrawablesWithIntrinsicBounds(
                    mContext.getDrawable(R.drawable.ic_done), null, null, null);
            mTextViewState.setText(R.string.todo_completed);
        }

        private void setActive(){
            mTextViewState.setCompoundDrawablesWithIntrinsicBounds(
                    mContext.getDrawable(R.drawable.ic_active), null, null, null);
            mTextViewState.setText(R.string.todo_active);
        }
    }
}
