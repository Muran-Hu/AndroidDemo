package com.droid.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Stack;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

/**
 * Created by Muran Hu on 2018-12-26.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class TouchView extends View {

  Stack stack;

  public TouchView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {

    switch(event.getActionMasked()) {
      case ACTION_DOWN:
        System.out.println("action_down");
        break;
      case ACTION_MOVE:
        System.out.println("action_move");
        break;
      case ACTION_UP:
        System.out.println("action_up");
        break;
    }

    return true;
  }
}

