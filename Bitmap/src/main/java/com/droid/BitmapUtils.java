package com.droid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapUtils {
    public static Bitmap getBitmap(String filePath, int reqWidth, int reqHeight) {
        BitmapFactory.Options newOptions = new BitmapFactory.Options();
        newOptions.inJustDecodeBounds = true;
        newOptions.inPreferredConfig = Bitmap.Config.RGB_565;

        BitmapFactory.decodeFile(filePath, newOptions);

        int width = newOptions.outWidth;
        int height = newOptions.outHeight;
        newOptions.inSampleSize = calculateSameSize(width, height, reqWidth, reqHeight);

        newOptions.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath, newOptions);
    }

    private static int calculateSameSize(int width, int height, int reqWidth, int reqHeight) {
        int sameSize = 1;

        

        return sameSize;
    }
}
