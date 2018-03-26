package com.example.latte.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.detail.GoodsDetailDelegate;
import com.example.latte_ui.recycler.MultipleFields;
import com.example.latte_ui.recycler.MultipleItemEntity;

/**
 * Created by mac on 2017/10/8.
 */

public class IndexItemClickListener extends SimpleClickListener {

    private final LatteDelegate DELEGATE;

    private IndexItemClickListener(LatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    public static SimpleClickListener create(LatteDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//        final MultipleItemEntity entity = (MultipleItemEntity) baseQuickAdapter.getData().get(position);
//        final int goodsId = entity.getField(MultipleFields.ID);
//        final GoodsDetailDelegate delegate = GoodsDetailDelegate.create(goodsId);
//        DELEGATE.getSupportDelegate().start(delegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
    }
}
