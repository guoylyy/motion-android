package com.mianli.uband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
    }
}
