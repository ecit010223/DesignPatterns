package com.year2018.pattern.image_loader.request;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.year2018.pattern.image_loader.config.DisplayConfig;
import com.year2018.pattern.image_loader.core.SimpleImageLoader;
import com.year2018.pattern.image_loader.policy.LoadPolicy;
import com.year2018.pattern.image_loader.utils.ImageViewHelper;
import com.year2018.pattern.image_loader.utils.Md5Helper;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * author：zyh
 * on: 2018/8/1 20:51
 * 网络请求类. 注意GET和DELETE不能传递参数,因为其请求的性质所致,
 * 用户可以将参数构建到url后传递进来到Request中.
 */
public class BitmapRequest implements Comparable<BitmapRequest> {
    Reference<ImageView> mImageViewRef;
    public DisplayConfig displayConfig;
    public SimpleImageLoader.ImageListener imageListener;
    public String imageUri = "";
    public String imageUriMd5 = "";
    /**
     * 请求序列号
     */
    public int serialNum = 0;
    /**
     * 是否取消该请求
     */
    public boolean isCancel = false;

    /**
     *
     */
    public boolean justCacheInMem = false;

    /**
     * 加载策略
     */
    LoadPolicy mLoadPolicy = SimpleImageLoader.getInstance().getConfig().loadPolicy;

    /**
     * @param imageView
     * @param uri
     * @param config
     * @param listener
     */
    public BitmapRequest(ImageView imageView, String uri, DisplayConfig config,
                         SimpleImageLoader.ImageListener listener) {
        mImageViewRef = new WeakReference<ImageView>(imageView);
        displayConfig = config;
        imageListener = listener;
        imageUri = uri;
        imageView.setTag(uri);
        imageUriMd5 = Md5Helper.toMD5(imageUri);
    }

    /**
     * @param policy
     */
    public void setLoadPolicy(LoadPolicy policy) {
        if (policy != null) {
            mLoadPolicy = policy;
        }
    }

    /**
     * 判断imageview的tag与uri是否相等
     *
     * @return
     */
    public boolean isImageViewTagValid() {
        return mImageViewRef.get() != null ? mImageViewRef.get().getTag().equals(imageUri) : false;
    }

    public ImageView getImageView() {
        return mImageViewRef.get();
    }

    public int getImageViewWidth() {
        return ImageViewHelper.getImageViewWidth(mImageViewRef.get());
    }

    public int getImageViewHeight() {
        return ImageViewHelper.getImageViewHeight(mImageViewRef.get());
    }

    @Override
    public int compareTo(@NonNull BitmapRequest another) {
        return mLoadPolicy.compare(this, another);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imageUri == null) ? 0 : imageUri.hashCode());
        result = prime * result + ((mImageViewRef == null) ? 0 : mImageViewRef.get().hashCode());
        result = prime * result + serialNum;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BitmapRequest other = (BitmapRequest) obj;
        if (imageUri == null) {
            if (other.imageUri != null)
                return false;
        } else if (!imageUri.equals(other.imageUri))
            return false;
        if (mImageViewRef == null) {
            if (other.mImageViewRef != null)
                return false;
        } else if (!mImageViewRef.get().equals(other.mImageViewRef.get()))
            return false;
        if (serialNum != other.serialNum)
            return false;
        return true;
    }
}
