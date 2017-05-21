package com.mianli.uband.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.mianli.uband.R;
import com.mianli.uband.api.Api;
import com.mianli.uband.api.BaseObserver;
import com.mianli.uband.api.BaseSchedulers;
import com.mianli.uband.entity.BaseEntity;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<BaseEntity> observable = Api.INSTANCE.get().jsSdkAuth();
        observable.compose(BaseSchedulers.compose()).subscribe(new BaseObserver() {

        });

        EMClient.getInstance().login("jingpeng", "123456", new EMCallBack() {
            //回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.e(TAG, "登录聊天服务器成功！");
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.e(TAG, "登录聊天服务器失败！");
            }
        });
    }
}
