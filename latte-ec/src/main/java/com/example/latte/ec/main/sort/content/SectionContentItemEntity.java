package com.example.latte.ec.main.sort.content;

/**
 * Created by mac on 2017/10/8.
 */

public class SectionContentItemEntity {

    private int mGoodsId = 0;
    private String mGoodsName = null;
    private String mGoodsThumb = null;//缩略图

    public int getGoodsId() {
        return mGoodsId;
    }

    public void setGoodsId(int goodsId) {
        this.mGoodsId = goodsId;
    }

    public String getGoodsName() {
        return mGoodsName;
    }

    public void setGoodsName(String goodsName) {
        this.mGoodsName = goodsName;
    }

    public String getGoodsThumb() {
        return mGoodsThumb;
    }

    public void setGoodsThumb(String goodsThumb) {
        this.mGoodsThumb = goodsThumb;
    }

}
