package com.year2018.pattern.image_loader.loader;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:43
 */
public interface Loader {
    public void loadImage(BitmapRequest request);
}
