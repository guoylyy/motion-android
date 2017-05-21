package com.mianli.uband;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

/**
 * Created by jingpeng on 2017/5/22.
 */

public class UbandApplication extends Application {

    private static final String TAG = UbandApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        initEaseMob();
    }

    private void initEaseMob() {
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        options.setAutoLogin(false);
        //初始化
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }
}
