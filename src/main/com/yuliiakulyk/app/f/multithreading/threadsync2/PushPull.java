package main.com.yuliiakulyk.app.f.multithreading.threadsync2;

import main.com.yuliiakulyk.app.f.multithreading.threadsync2.Helper;

/**
 * Created by Yuliia Kulyk on 01.02.2018.
 */
public class PushPull implements Runnable{
    private String text;
    private Helper helper;

    public PushPull(String text, Helper helper) {
        this.text = text;
        this.helper = helper;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.helper.setProcess(this.text);
        }
    }
}
