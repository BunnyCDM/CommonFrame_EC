package com.example.latte.ec.play;

/**
 * Created by mac on 2017/10/8.
 */

public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();

}
