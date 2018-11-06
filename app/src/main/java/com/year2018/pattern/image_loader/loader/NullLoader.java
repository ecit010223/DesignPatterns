package com.year2018.pattern.image_loader.loader;

import android.graphics.Bitmap;
import android.util.Log;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:47
 */
public class NullLoader extends AbsLoader {
    @Override
    protected Bitmap onLoadImage(BitmapRequest request) {
        Log.e(NullLoader.class.getSimpleName(), "### wrong schema, your image uri is : "
                + request.imageUri);
        return null;
    }
}
