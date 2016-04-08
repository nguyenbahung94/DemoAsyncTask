package com.example.android.demoasynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by everything on 4/7/16.
 */
public class MyAsynctask extends AsyncTask<Void,Integer,Void> {
    Activity contextcha;

    public MyAsynctask(Activity ct) {
        contextcha = ct;
    }
    //hàm này sẽ được thực hiện đầu tiên

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(contextcha, "onPreExecute!",
                Toast.LENGTH_LONG).show();
    }
    //sau đó tới hàm doInBackground

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i <= 100; i++) {
            //nghỉ 100 milisecond thì tiến hành update UI
            SystemClock.sleep(100);
            //khi gọi hàm này thì onProgressUpdate sẽ thực thi
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //thông qua contextCha để lấy được control trong MainActivity
        ProgressBar paCha=(ProgressBar) contextcha
                .findViewById(R.id.progressBar1);
        int giatri=values[0];
        //tăng giá trị của Progressbar lên
        paCha.setProgress(giatri);
        //đồng thời hiện thị giá trị là % lên TextView
        TextView txtmsg=(TextView)
                contextcha.findViewById(R.id.textview1);
        txtmsg.setText(giatri + "%");
    }
   // sau khi tiến trình thực hiện xong thì hàm này sảy ra
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(contextcha, "Update xong roi do!",
                Toast.LENGTH_LONG).show();
    }
}
