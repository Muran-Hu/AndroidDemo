package com.droid.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Muran Hu on 2018-12-26.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class SquareView extends View {
  public SquareView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    int width = getMeasuredWidth();
    int height = getMeasuredHeight();
    int size = Math.max(width, height);

    setMeasuredDimension(size, size);
  }

//  @Override
//  public void layout(int l, int t, int r, int b) {
//
//    int width = r - l;
//    int height = b - t;
//    int size = Math.max(width, height);
//
//    super.layout(l, t, l + size, t + size);
//  }
}
