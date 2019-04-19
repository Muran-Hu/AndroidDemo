package com.droid.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {

  public static final String URL = "https://cn.bing.com/sa/simg/hpb/NorthMale_EN-US8782628354_1920x1080.jpg";
  public static final String URL_GIG = "http://p1.pstatp.com/large/166200019850062839d3";

  Button mBtn;
  ImageView mImageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mBtn = findViewById(R.id.btn);
    mImageView = findViewById(R.id.img);

    mBtn.setOnClickListener(v -> Glide.with(MainActivity.this)
            .load(URL)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(mImageView));
  }
}
