package com.example.admin.recyclersliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.recyclersliding.view.ListAdapter;

/**
 * 嵌套RecyclerView Demo
 *
 * @author raotong (582057218@qq.com)
 * @version RecyclerCoverFlow
 * @Datetime 2017-08-05 10:50
 * @since RecyclerCoverFlow
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initList();
    }
    private void initList() {
        mList = (RecyclerView) findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mList.setAdapter(new ListAdapter());
    }
}
