package com.loadadserro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import e.com.lib.PromoteMaster;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;
    private ImageView imTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imTest = findViewById(R.id.image_test);
        tvHello = findViewById(R.id.tv_hello);
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PromoteMaster promoteMaster = new PromoteMaster();
                promoteMaster.Instance(MainActivity.this, true);
            }
        });
    }
}
