package com.smart.melo.mvpdemo;

/**
 * Created by melo on 2017/5/8.
 */
public class IMainModel {
    public void downLoad(final CallBack callBack) {
        String str = "能够拥有一份美丽的心情，不是因为我们获得的颇多，而是我们计较的很少；我们深深懂得，多，有时也是一种负担，是另外一种失去；少，并非真正不足，而是一种隐形的有余。很多的时候，我们审时度势，选择了舍弃，学会舍弃并不意味着全然失去，而是一种更宽阔更博大的获得！";
        callBack.getResult(str);
    }


    public interface CallBack {
        void getResult(String str);
    }
}
