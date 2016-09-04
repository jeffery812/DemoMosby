package com.example.zhihuitang.demomosby.presenter;

import com.example.zhihuitang.demomosby.GreetingGeneratorTask;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.example.zhihuitang.demomosby.view.HelloWorldView;

/**
 * Created by zhihuitang on 04/09/16.
 */
public class HelloWorldPresenter extends MvpBasePresenter<HelloWorldView>{
    // Greeting Task is "business logic"
    private GreetingGeneratorTask greetingTask;

    private void cancelGreetingTaskIfRunning(){
        if (greetingTask != null){
            greetingTask.cancel(true);
        }
    }

    public void greetHello(){
        cancelGreetingTaskIfRunning();

        greetingTask = new GreetingGeneratorTask("Hello", new GreetingGeneratorTask.GreetingTaskListener(){
            public void onGreetingGenerated(String greetingText){
                if (isViewAttached())
                    getView().showHello(greetingText);
            }
        });
        greetingTask.execute();
    }

    public void greetGoodbye(){
        cancelGreetingTaskIfRunning();

        greetingTask = new GreetingGeneratorTask("Goodbye", new GreetingGeneratorTask.GreetingTaskListener(){
            public void onGreetingGenerated(String greetingText){
                if (isViewAttached())
                    getView().showGoodbye(greetingText);
            }
        });
        greetingTask.execute();
    }

    // Called when Activity gets destroyed, so cancel running background task
    public void detachView(boolean retainPresenterInstance){
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance){
            cancelGreetingTaskIfRunning();
        }
    }
}
