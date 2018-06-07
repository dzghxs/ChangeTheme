package com.hxs.changetheme;

import android.app.Application;

import cn.feng.skin.manager.loader.SkinManager;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
        SkinManager.getInstance().load();
    }
}
