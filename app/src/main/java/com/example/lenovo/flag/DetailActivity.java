package com.example.lenovo.flag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        TextView textView=(TextView) findViewById(R.id.detail_country);
        textView.setText(country);
        ImageView imageView=(ImageView) findViewById(R.id.detail_image);
        imageView.setImageResource(getResources().getIdentifier(country,"drawable",getPackageName()));

    }
}
