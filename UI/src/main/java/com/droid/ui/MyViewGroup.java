package com.droid.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MyViewGroup extends ViewGroup {

  public MyViewGroup(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int selfWidthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
    int selfWidthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

    int childWidthSpec;
    int childHeightSpec = 0;

    int widthUsed = 0;

    for (int i = 0; i < getChildCount(); i++) {
      View childView = getChildAt(i);
      LayoutParams lp = childView.getLayoutParams();
      switch (lp.width) {
        case MATCH_PARENT:
          if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
            childWidthSpec = MeasureSpec.makeMeasureSpec((selfWidthSpecSize - widthUsed), MeasureSpec.EXACTLY);
          } else {
            childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
          }
          break;
        case WRAP_CONTENT:
          if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
            childWidthSpec = MeasureSpec.makeMeasureSpec((selfWidthSpecSize - widthUsed), MeasureSpec.AT_MOST);
          } else {
            childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
          }
          break;
        default:
          childWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
          break;
      }
      childView.measure(childWidthSpec, childHeightSpec);
    }
  }

  @Override
  protected void onLayout(boolean flag, int l, int t, int r, int b) {
    for (int i = 0; i < getChildCount(); i++) {
      View childView = getChildAt(i);
      childView.layout(l, t, r, b);
    }
  }
}
