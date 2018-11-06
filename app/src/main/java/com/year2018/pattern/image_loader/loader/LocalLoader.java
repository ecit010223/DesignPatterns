package com.year2018.pattern.image_loader.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.year2018.pattern.image_loader.request.BitmapRequest;
import com.year2018.pattern.image_loader.utils.BitmapDecoder;

import java.io.File;

/**
 * author：zyh
 * on: 2018/8/1 20:46
 */
public class LocalLoader extends AbsLoader {
    @Override
    protected Bitmap onLoadImage(BitmapRequest request) {
        final String imagePath = Uri.parse(request.imageUri).getPath();
        final File imgFile = new File(imagePath);
        if (!imgFile.exists()) {
            return null;
        }

        // 从sd卡中加载的图片仅缓存到内存中,不做本地缓存
        request.justCacheInMem = true;

        // 加载图片
        BitmapDecoder decoder = new BitmapDecoder() {

            @Override
            public Bitmap decodeBitmapWithOption(BitmapFactory.Options options) {
                return BitmapFactory.decodeFile(imagePath, options);
            }
        };

        return decoder.decodeBitmap(request.getImageViewWidth(),
                request.getImageViewHeight());
    }
}
