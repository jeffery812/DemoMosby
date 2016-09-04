package com.example.zhihuitang.demomosby.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by zhihuitang on 04/09/16.
 */
public interface HelloWorldView extends MvpView {
    // displays "Hello" greeting text in red text color
    void showHello(String greetingText);

    // displays "Goodbye" greeting text in blue text color
    void showGoodbye(String greetingText);
}
