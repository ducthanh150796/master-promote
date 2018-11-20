package com.loadadserro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import e.com.lib.PromoteMaster;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello = findViewById(R.id.tv_hello);
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PromoteMaster.Instance(MainActivity.this,true);
            }
        });
    }
}
