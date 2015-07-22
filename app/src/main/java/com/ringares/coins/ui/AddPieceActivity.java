package com.ringares.coins.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ringares.coins.R;
import com.ringares.coins.event.AddPieceEvent;

import de.greenrobot.event.EventBus;

public class AddPieceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView key_0, key_1, key_2, key_3, key_4, key_5, key_6, key_7, key_8, key_9;
    private TextView key_clear, key_minus, key_plus, key_ok, key_dot;
    private ImageView key_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    private void initView() {
        setContentView(R.layout.activity_add_piece);

        key_0 = (TextView) findViewById(R.id.key_0);
        key_1 = (TextView) findViewById(R.id.key_1);
        key_2 = (TextView) findViewById(R.id.key_2);
        key_3 = (TextView) findViewById(R.id.key_3);
        key_4 = (TextView) findViewById(R.id.key_4);
        key_5 = (TextView) findViewById(R.id.key_5);
        key_6 = (TextView) findViewById(R.id.key_6);
        key_7 = (TextView) findViewById(R.id.key_7);
        key_8 = (TextView) findViewById(R.id.key_8);
        key_9 = (TextView) findViewById(R.id.key_9);

        key_clear = (TextView) findViewById(R.id.key_clear);
        key_minus = (TextView) findViewById(R.id.key_minus);
        key_plus = (TextView) findViewById(R.id.key_plus);
        key_ok = (TextView) findViewById(R.id.key_ok);
        key_dot = (TextView) findViewById(R.id.key_dot);

        key_back = (ImageView) findViewById(R.id.key_back);
    }

    private void initListener() {
        key_0.setOnClickListener(this);
        key_1.setOnClickListener(this);
        key_2.setOnClickListener(this);
        key_3.setOnClickListener(this);
        key_4.setOnClickListener(this);
        key_5.setOnClickListener(this);
        key_6.setOnClickListener(this);
        key_7.setOnClickListener(this);
        key_8.setOnClickListener(this);
        key_9.setOnClickListener(this);
        key_clear.setOnClickListener(this);
        key_minus.setOnClickListener(this);
        key_plus.setOnClickListener(this);
        key_ok.setOnClickListener(this);
        key_dot.setOnClickListener(this);
        key_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.key_0:
                break;
            case R.id.key_1:
                break;
            case R.id.key_2:
                break;
            case R.id.key_3:
                break;
            case R.id.key_4:
                break;
            case R.id.key_5:
                break;
            case R.id.key_6:
                break;
            case R.id.key_7:
                break;
            case R.id.key_8:
                break;
            case R.id.key_9:
                break;
            case R.id.key_back:
                break;
            case R.id.key_minus:
                break;
            case R.id.key_plus:
                break;
            case R.id.key_clear:
                break;
            case R.id.key_dot:
                break;
            case R.id.key_ok:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().post(new AddPieceEvent("textetxtetxte"));
        super.onDestroy();
    }
}
