package com.example.latte.net;

import android.content.Context;

import com.example.latte.net.callback.IError;
import com.example.latte.net.callback.IFailure;
import com.example.latte.net.callback.IRequest;
import com.example.latte.net.callback.ISuccess;
import com.example.latte.ui.loader.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by mac on 2017/9/16.
 *
 * 该类是把建造者和宿主类分割开来，不用静态内部类的方法
 */

public class RestClientBuilder {

    private String mURL = null;
//    private static final Map<String, Object> PARAMS = RestCreator.getParams();//内存管理更精确
    private final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();//内存管理更精确
    private IRequest mIREQUEST = null;
    private ISuccess mISUCCESS = null;
    private IFailure mIFAILURE = null;
    private IError mIERROR = null;
    private RequestBody mBODY = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {//觉得这个方法很好不需要优化就加上final，好处java编译器很好的优化
        this.mURL = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        this.PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, String value) {
        this.PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBODY = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIREQUEST = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess isuccess) {
        this.mISUCCESS = isuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure ifailure) {
        this.mIFAILURE = ifailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIERROR = iError;
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

    public final RestClient build() {
        return new RestClient(mURL, PARAMS,
                mDownloadDir, mExtension,
                mName, mIREQUEST, mISUCCESS,
                mIFAILURE, mIERROR,
                mBODY, mFile,
                mContext, mLoaderStyle);
    }


}
