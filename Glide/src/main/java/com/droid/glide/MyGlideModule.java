package com.droid.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;

public class MyGlideModule implements GlideModule {

    private static final int DISK_CACHE_SIZE = 500 * 1024 * 1024;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // 设置cache存储为外部存储
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, DISK_CACHE_SIZE));
        // 设置编码格式为 ARGB_8888，Glide默认为 RGB_565
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // 自定义 OkHttp 为网络请求库，替换掉 Glide 默认 HTTPURLConnection
        glide.register(GlideUrl.class, InputStream.class, new OkHttpGlideUrlLoader.Factory());
    }
}
