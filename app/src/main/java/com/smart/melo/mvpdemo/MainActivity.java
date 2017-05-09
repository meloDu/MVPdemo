package com.smart.melo.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//MVP简单设计思想
public class MainActivity extends AppCompatActivity implements IMainView {

    private TextView mTextView;
    private Button mButton;
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn_download);
        mTextView = (TextView) findViewById(R.id.text);
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.attachView(this);
        //点击下载图片
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPresenter.downLoad();
            }
        });

    }

    @Override
    public void onSuccess(String str) {
        if (str.length() != 0) {
            mTextView.setText(str);
        }

    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMainPresenter != null) {
            mMainPresenter.detachView();
            mMainPresenter = null;
        }
    }
}
