package com.example.android.demoasynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    //khai báo MyAsyntask
    MyAsynctask mytt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button) findViewById(R.id.button1);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStart();
            }
        });
    }
    private void doStart()
    {
        //truyền this (chính là MainActivity hiện tại) qua Child Thread
        mytt =new MyAsynctask(this);
        //Kích hoạt Tiến trình
        //khi gọi hàm này thì onPreExecute của mytt sẽ thực thi trước
        mytt.execute();
    }
}
