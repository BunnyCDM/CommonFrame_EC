package com.example.latte.ec.main.personal.order;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.util.callback.CallbackManager;
import com.example.latte.util.callback.CallbackType;
import com.example.latte.util.callback.IGlobalCallback;
import com.example.latte_ui.widget.AutoPhotoLayout;
import com.example.latte_ui.widget.StarLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mac on 2017/10/8.
 */

public class OrderCommentDelegate extends LatteDelegate {


    @BindView(R2.id.top_tv_comment_commit)
    AppCompatTextView topTvCommentCommit;
    @BindView(R2.id.tb_shop_cart)
    Toolbar tbShopCart;
    @BindView(R2.id.img_order_comment)
    AppCompatImageView imgOrderComment;
    @BindView(R2.id.tv_comment_title)
    TextView tvCommentTitle;
    @BindView(R2.id.custom_star_layout)
    StarLayout mStarLayout = null;
    @BindView(R2.id.et_order_comment)
    AppCompatEditText etOrderComment;
    @BindView(R2.id.custom_auto_photo_layout)
    AutoPhotoLayout mAutoPhotoLayout = null;


    @OnClick(R2.id.top_tv_comment_commit)
    void onClickSubmit() {
        Toast.makeText(getContext(), "评分： " + mStarLayout.getStarCount(), Toast.LENGTH_LONG).show();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_order_comment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mAutoPhotoLayout.setDelegate(this);
        CallbackManager.getInstance()
                .addCallback(CallbackType.ON_CROP, new IGlobalCallback<Uri>() {
                    @Override
                    public void executeCallback(@Nullable Uri args) {
                        mAutoPhotoLayout.onCropTarget(args);
                    }
                });
    }

}
