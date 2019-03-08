package com.droid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MyView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  public MyView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    // 不调用 super.onMeasure() 方法，完全自己定义 View 的尺寸
    // super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    // 自己计算出 width 和 height
    int width = 0;
    int height = 0;

    // 计算出宽度高度之后，调用 resolveSize 进行修正，满足父 View 对子 View 的要求
    // 限制：类型和大小
    // int specType = MeasureSpec.getMode(widthMeasureSpec);
    // int specSize = MeasureSpec.getSize(widthMeasureSpec);
    // specType:
    // MeasureSpec.AT_MOST - 最大限制
    // MeasureSpec.UNSPECIFIED - 无限制
    // MeasureSpec.EXACTLY - 精确限制
    width = resolveSize(width, widthMeasureSpec);
    height = resolveSize(height, heightMeasureSpec);

    System.out.println("width: " + width);
    System.out.println("height: " + height);

    setMeasuredDimension(width, height);
  }

  {
    paint.setColor(Color.RED);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawCircle(200, 200, 100, paint);
  }
}
