package com.example.zhihuitang.demomosby;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zhihuitang.demomosby.presenter.HelloWorldPresenter;
import com.example.zhihuitang.demomosby.view.HelloWorldView;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<HelloWorldView, HelloWorldPresenter> implements HelloWorldView {

    @BindView(R.id.greetingTextView)
    TextView greetingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.helloButton)
    public void onHelloButtonClicked(){
        presenter.greetHello();
    }

    @OnClick(R.id.goodbyeButtonClicked)
    public void onGoodbyeButtonClicked(){
        presenter.greetGoodbye();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    @Override
    public void showHello(String greetingText) {
        greetingTextView.setTextColor(Color.RED);
        greetingTextView.setText(greetingText);

    }

    @Override
    public void showGoodbye(String greetingText) {
        greetingTextView.setTextColor(Color.BLUE);
        greetingTextView.setText(greetingText);

    }
}
