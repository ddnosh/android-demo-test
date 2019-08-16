package com.androidwind.demo.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener{

    private Button toasting;
    private SettingController controller;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        toasting = findViewById(R.id.toasting);
        toasting.setOnClickListener(this);
        controller = new SettingController();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toasting) {
            toasting.setText(controller.getTitle());
        }
    }
}
