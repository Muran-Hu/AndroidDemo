package com.droid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MyImageView extends ImageView {

  public MyImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//    int width = getMeasuredWidth();
//    int height = getMeasuredHeight();
//
//    if (width > height) {
//      width = height;
//    }
//
//    setMeasuredDimension(width, height);

    int width = 200;
    int height = 300;

    setMeasuredDimension(width, height);
  }
}
