package com.androidwind.demo.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class WeatherActivity extends BaseTActivity<WeatherPresenter> implements WeatherContract.View, View.OnClickListener {

    private WeatherData mWeatherData;
    private TextView status, desc;
    private Button ganmao, wendu;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        mPresenter.initData();
        status = findViewById(R.id.status);
        desc = findViewById(R.id.desc);
        ganmao = findViewById(R.id.ganmao);
        ganmao.setOnClickListener(this);
        wendu = findViewById(R.id.wendu);
        wendu.setOnClickListener(this);
    }

    @Override
    public void refreshView(WeatherData data) {
        mWeatherData = data;
        status.setText("status:" + data.status);
        desc.setText("desc:" + data.desc);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ganmao) {
            mPresenter.showTest1();
            // Toast.makeText(WeatherActivity.this, mWeatherData.data.ganmao, Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.wendu) {
            mPresenter.showTest2();
            // Toast.makeText(WeatherActivity.this, mWeatherData.data.wendu, Toast.LENGTH_LONG).show();
        }
    }

    public void setPresenter(WeatherPresenter presenter) {
        this.mPresenter = presenter;
    }
}
