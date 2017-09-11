package com.example.admin.recyclersliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.recyclersliding.adapter.Adapter;
import com.example.admin.recyclersliding.view.CoverFlowLayoutManger;
import com.example.admin.recyclersliding.view.RecyclerCoverFlow;

public class JustRecyclerViewActivity extends AppCompatActivity {
    private RecyclerCoverFlow mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_recycler_view);
        initView();
    }

    private void initView() {
        mList = (RecyclerCoverFlow) findViewById(R.id.list);
//        mList.setFlatFlow(true); //平面滚动
//        mList.setGreyItem(true); //设置灰度渐变
        //mList.setAlphaItem(true); //设置半透渐变
        mList.setAdapter(new Adapter(this));
        mList.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                ((TextView)findViewById(R.id.index)).setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
    }
}
