package com.droid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  Button moreBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    moreBtn = findViewById(R.id.more_btn);

    moreBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        showExtraLayout();
      }
    });

  }

  private void showExtraLayout() {
    ViewStub viewStub = findViewById(R.id.view_stub);
    if (null != viewStub) {
      viewStub.inflate();

    }
  }
}
