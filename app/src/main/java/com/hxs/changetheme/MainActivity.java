package com.hxs.changetheme;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yanzhenjie.sofia.Sofia;

import java.io.File;

import cn.feng.skin.manager.base.BaseActivity;
import cn.feng.skin.manager.listener.ILoaderListener;
import cn.feng.skin.manager.loader.SkinManager;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvDefault;
    private TextView tvBlue;
    private TextView tvLime;
    private TextView tvGold;
    private TextView tvRed;
    private TextView tvHotpick;

    String SKIN_NAME;       //皮肤名字
    String SKIN_DIR;        //皮肤路径
    File skin;              //皮肤文件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Sofia.with(this);       //沉浸状态栏
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvDefault = (TextView) findViewById(R.id.tv_default);
        tvBlue = (TextView) findViewById(R.id.tv_blue);
        tvLime = (TextView) findViewById(R.id.tv_lime);
        tvGold = (TextView) findViewById(R.id.tv_gold);
        tvRed = (TextView) findViewById(R.id.tv_red);
        tvHotpick = (TextView) findViewById(R.id.tv_hotpick);

        tvDefault.setOnClickListener(this);
        tvBlue.setOnClickListener(this);
        tvLime.setOnClickListener(this);
        tvGold.setOnClickListener(this);
        tvRed.setOnClickListener(this);
        tvHotpick.setOnClickListener(this);
    }

    /**
     * 修改主题
     * @param SKIN_NAME
     */
    public void ChangTheme(String SKIN_NAME){
        SKIN_DIR = Environment.getExternalStorageDirectory() + "/skin/" + SKIN_NAME;
        skin = new File(SKIN_DIR);
        SkinManager.getInstance().load(skin.getAbsolutePath(), new ILoaderListener() {
            @Override
            public void onStart() {
                Toast.makeText(MainActivity.this, "开始加载", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed() {
                Toast.makeText(MainActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == tvDefault) {
            SkinManager.getInstance().restoreDefaultTheme();
        } else if (v == tvBlue) {
            SKIN_NAME = "bule.skin";
            ChangTheme(SKIN_NAME);
        } else if (v == tvLime) {
            SKIN_NAME = "lime.skin";
            ChangTheme(SKIN_NAME);
        } else if (v == tvGold) {
            SKIN_NAME = "gold.skin";
            ChangTheme(SKIN_NAME);
        } else if (v == tvRed) {
            SKIN_NAME = "red.skin";
            ChangTheme(SKIN_NAME);
        } else if (v == tvHotpick) {
            SKIN_NAME = "hotpink.skin";
            ChangTheme(SKIN_NAME);
        }
    }
}
