package com.mianli.uband.api;

import android.util.Log;

import com.mianli.uband.entity.BaseEntity;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    private static final String TAG = BaseObserver.class.getSimpleName();

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        Log.d(TAG, "onSubscribe");
    }

    @Override
    public void onNext(BaseEntity<T> value) {
        Log.d(TAG, value.getMessage());
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }
}