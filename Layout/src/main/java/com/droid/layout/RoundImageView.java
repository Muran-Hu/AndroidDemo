package com.droid.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Muran Hu on 2018-12-26.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class RoundImageView extends View {

  private static final float PADDING = Utils.dp2px(20);
  private static final float RADIUS = Utils.dp2px(100);
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  public RoundImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    int width = (int) ((PADDING + RADIUS) * 2);
    int height = (int) ((PADDING + RADIUS) * 2);

    setMeasuredDimension(width, height);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint);
  }
}
