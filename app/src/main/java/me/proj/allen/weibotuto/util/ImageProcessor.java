package me.proj.allen.weibotuto.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by Allen on 2017/6/6.
 */
public class ImageProcessor {
    /**
     * Decode a bitmap from resource whose original density may be too large to be loaded. This method provides a way to
     * automatically reduce to fit for the density that provided.
     *
     * @param res       The resources.
     * @param resId     The ID of the resource.
     * @param reqWidth  The requested width.
     * @param reqHeight The requested Height.
     * @return Bitmap as a result.
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(res, resId, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;

        while (width > reqWidth || height > reqHeight) {
            inSampleSize = inSampleSize * 2;
            width = width / 2;
            height = height / 2;
        }

        Log.d("TEST", String.valueOf(inSampleSize));
        return inSampleSize;
    }
}
