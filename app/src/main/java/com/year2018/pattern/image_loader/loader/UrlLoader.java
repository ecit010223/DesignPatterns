package com.year2018.pattern.image_loader.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.year2018.pattern.image_loader.request.BitmapRequest;
import com.year2018.pattern.image_loader.utils.IOUtil;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * author：zyh
 * on: 2018/8/1 20:47
 */
public class UrlLoader extends AbsLoader {

    @Override
    protected Bitmap onLoadImage(BitmapRequest request) {
        final String imageUrl = request.imageUri;
        FileOutputStream fos = null;
        InputStream is = null;
        Bitmap bitmap = null ;
        HttpURLConnection conn = null ;
        try {
            URL url = new URL(imageUrl);
            conn = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(conn.getInputStream());
            bitmap =  BitmapFactory.decodeStream(is, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeQuietly(is);
            IOUtil.closeQuietly(fos);
            if ( conn != null ) {
                // 关闭流
                conn.disconnect();
            }
        }
        return bitmap;
    }
}
