package com.example.admin.recyclersliding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void buttonOne(View view){
        intent=new Intent(this,JustRecyclerViewActivity.class);
        startActivity(intent);
    }
    public  void buttonTwo(View view){
       Intent  intent=new Intent(this,ViewpagerActivity.class);
        startActivity(intent);
    }
    public  void buttonThree(View view){
        Intent  intent=new Intent(this,RecyclerViewActivity.class);
        startActivity(intent);
    }
}
