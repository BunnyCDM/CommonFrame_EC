package com.example.latte.ec.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by mac on 2017/10/8.
 * <p>
 * 具体商品信息
 */

public class GoodsDetailDelegate extends LatteDelegate {

    private static final String ARG_GOODS_ID = "ARG_GOODS_ID";

    /**
     * @param goodsId
     * @return
     * @BindView(R2.id.app_bar_detail) AppBarLayout mAppBar = null;
     * @BindView(R2.id.collapsing_toolbar_detail) CollapsingToolbarLayout mCollapsingToolbarLayout = null;
     * @BindView(R2.id.detail_banner) ConvenientBanner<String> mBanner = null;
     * //@BindView(R2.id.frame_goods_info)
     * //ContentFrameLayout frameGoodsInfo;
     * @BindView(R2.id.goods_detail_toolbar) Toolbar mToolbar = null;
     * //@BindView(R2.id.icon_goods_back)
     * //IconTextView iconGoodsBack;
     * //@BindView(R2.id.tv_detail_title_text)
     * //AppCompatTextView tvDetailTitleText;
     * @BindView(R2.id.tab_layout) TabLayout mTabLayout = null;
     * @BindView(R2.id.view_pager) ViewPager mViewPager = null;
     * <p>
     * //@BindView(R2.id.rl_favor)
     * //RelativeLayout rlFavor;
     * @BindView(R2.id.icon_favor) IconTextView mIconFavor = null;
     * //@BindView(R2.id.ll_bottom)
     * //LinearLayoutCompat llBottom;
     * //@BindView(R2.id.rl_shop_cart)
     * //RelativeLayout rlShopCart;
     * @BindView(R2.id.icon_shop_cart) IconTextView mIconShopCart = null;
     * @BindView(R2.id.tv_shopping_cart_amount) CircleTextView mCircleTextView = null;
     * @BindView(R2.id.rl_add_shop_cart) RelativeLayout mRlAddShopCart = null;
     */


    public static GoodsDetailDelegate create(int goodsId) {
        final Bundle args = new Bundle();
        args.putInt(ARG_GOODS_ID, goodsId);
        final GoodsDetailDelegate delegate = new GoodsDetailDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }


    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();//返回水平打开
    }

}
