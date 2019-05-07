package com.example.wholeman.mvptodo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class TodoDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TODO_ID = "EXTRA_TODO_ID";

    public static void start(Context context, String todoId) {
        Intent intent = new Intent(context, TodoDetailActivity.class);
        intent.putExtra(EXTRA_TODO_ID, todoId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_todo_detail);

    }

}
