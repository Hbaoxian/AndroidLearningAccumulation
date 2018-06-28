package com.hbaoxian.androidaccumulation.config;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.AppGlideModule;

public class GlidePicModel extends AppGlideModule {


    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {

        String internalCachePath = "glide_cache";

    }
}
