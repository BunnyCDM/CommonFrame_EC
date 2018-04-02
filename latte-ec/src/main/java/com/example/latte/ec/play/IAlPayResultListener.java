package com.example.latte.ec.play;

/**
 * Created by mac on 2017/10/8.
 *
 * 支付过程会有相应回调（可查看对应文档）
 */

public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();

}
