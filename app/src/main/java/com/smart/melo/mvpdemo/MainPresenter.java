package com.smart.melo.mvpdemo;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by melo on 2017/5/8.
 */
public class MainPresenter<IV> {
    private Reference<IV> view;

    private IMainView mIMainView;
    private IMainModel mIMainModel;

    public MainPresenter(IMainView mIMainView) {
        this.mIMainView = mIMainView;
        mIMainModel = new IMainModel();
    }

    public void downLoad() {
        mIMainModel.downLoad(mCallBack);
    }

    private IMainModel.CallBack mCallBack = new IMainModel.CallBack() {
        @Override
        public void getResult(String str) {
            mIMainView.onSuccess(str);
        }
    };


    public void attachView(IV v) {
        view = new WeakReference<>(v);
    }

    public IV getView() {
        return view.get();
    }


    public void detachView() {
        if (view != null) {
            view.clear();
            view = null;
        }
    }
}
