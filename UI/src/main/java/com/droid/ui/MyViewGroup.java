package com.droid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Muran Hu on 2019-03-03.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class MyViewGroup extends ViewGroup {
  public MyViewGroup(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onLayout(boolean changed, int l, int t, int r, int b) {

  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
  }
}
