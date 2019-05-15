package com.example.memory;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    /*private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mTv.setText(msg.what + "");
        }
    };*/
    /**
     * Hello World!
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
//        mHandler.sendEmptyMessageDelayed(0,8000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mHandler.removeCallbacksAndMessages(null);
    }

    /*public class MyHandler extends Handler {
        private static final String TAG = "MyHandler";
        private WeakReference<MainActivity> mReference;
        public MyHandler(MainActivity activity) {
            mReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG, "handleMessage: " + msg.what);
            if (mReference.get() != null) {
                mReference.get().mTv.setText(msg.what + "");
            }
        }
    }*/

    /*static class MyHandler extends Handler{
        private WeakReference<MainActivity> mReference;
        private static final String TAG = "MyHandler";
        public MyHandler(MainActivity activity){
            mReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG, "handleMessage: "+msg.what);
            if (mReference.get() != null) {
                mReference.get().mTv.setText(msg.what+"");
            }
        }
    }*/
}
