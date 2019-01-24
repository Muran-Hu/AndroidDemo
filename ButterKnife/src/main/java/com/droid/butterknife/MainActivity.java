package com.droid.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.tv_butterknife)
  TextView tvButterknife;
  @BindView(R.id.cb_butterknife)
  CheckBox cbButterknife;
  @BindView(R.id.btn_butterknife)
  Button btnButterknife;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

  }

  @OnClick(R.id.btn_butterknife)
  void setBtnButterknife(View view) {
    Toast.makeText(this, "点击了", Toast.LENGTH_LONG).show();
  }
}
