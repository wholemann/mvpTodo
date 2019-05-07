package com.example.wholeman.mvptodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoRecyclerAdapter.OnTodoClickListener {

    private RecyclerView mRecyclerViewTodoList;
    private TodoRecyclerAdapter mTodoRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_todo_list);

        mRecyclerViewTodoList = findViewById(R.id.rv_todo_list);

        mTodoRecyclerAdapter = new TodoRecyclerAdapter(this, this);
        
        mRecyclerViewTodoList.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewTodoList.setAdapter(mTodoRecyclerAdapter);
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchTodoList();
    }

    private void fetchTodoList() {
        ArrayList<Todo> mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(new Todo("today todo" + i));
        }
        bindTodoList(mList);
    }

    private void bindTodoList(List<Todo> mList) {
        mTodoRecyclerAdapter.bindTodoList(mList);
    }

    @Override
    public void onTodoItemClicked(Todo todo) {
        TodoDetailActivity.start(this, todo.getId());
    }
}
