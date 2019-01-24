package com.droid.layout;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Muran Hu on 2018-12-26.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class Utils {
  public static float dp2px(int dp) {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem()
            .getDisplayMetrics());
  }
}
