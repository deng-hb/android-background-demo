package com.denghb.clock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGALocalImageSize;


public class MainActivity extends Activity {

    private ClockView mClock;

    private BGABanner mBackgroundBanner;
    private BGABanner mForegroundBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClock = (ClockView) findViewById(R.id.clock);

        mClock.resume();
        mBackgroundBanner = findViewById(R.id.banner_guide_background);
        mForegroundBanner = findViewById(R.id.banner_guide_foreground);

        // Bitmap 的宽高在 maxWidth maxHeight 和 minWidth minHeight 之间
        BGALocalImageSize localImageSize = new BGALocalImageSize(720, 1280, 320, 640);
        // 设置数据源
        //
        mBackgroundBanner.setAutoPlayAble(true);
        mBackgroundBanner.setAutoPlayInterval(3000);
        mBackgroundBanner.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
                R.drawable.uoko_guide_background_1,
                R.drawable.uoko_guide_background_2,
                R.drawable.uoko_guide_background_3);


        mForegroundBanner.setAutoPlayAble(true);
        mForegroundBanner.setAutoPlayInterval(3000);
        mForegroundBanner.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
                R.drawable.uoko_guide_foreground_1,
                R.drawable.uoko_guide_foreground_2,
                R.drawable.uoko_guide_foreground_3);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 如果开发者的引导页主题是透明的，需要在界面可见时给背景 Banner 设置一个白色背景，避免滑动过程中两个 Banner 都设置透明度后能看到 Launcher
        mBackgroundBanner.setBackgroundResource(android.R.color.white);
    }
}
