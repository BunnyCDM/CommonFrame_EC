package com.example.latte.net;

import android.content.Context;

import com.example.latte.net.callback.IError;
import com.example.latte.net.callback.IFailure;
import com.example.latte.net.callback.IRequest;
import com.example.latte.net.callback.ISuccess;
import com.example.latte.ui.loader.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 该类是把建造者和宿主类分割开来，不用静态内部类的方法
 */

public class RestClientBuilder {

    //private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();//内存管理更精确
    private final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();//内存管理更精确
    private String mUrl = null;
    private IRequest mIRequest = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private File mFile = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;

    RestClientBuilder() {//不允许外部类直接new它，只允许同包去new它
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        this.PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        this.PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder url(String url) { //觉得这个方法很好不需要优化就加上final，好处java编译器很好的优化
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder success(ISuccess isuccess) {
        this.mISuccess = isuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure ifailure) {
        this.mIFailure = ifailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String file) {//其实是filepath
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder raw(String raw) {//原始数据
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS,
                mDownloadDir, mExtension,
                mName, mIRequest, mISuccess,
                mIFailure, mIError,
                mBody, mFile,
                mContext, mLoaderStyle);
    }


}
