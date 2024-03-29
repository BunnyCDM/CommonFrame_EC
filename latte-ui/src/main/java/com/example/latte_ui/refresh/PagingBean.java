package com.example.latte_ui.refresh;

/**
 * Created by mac on 2017/10/12.
 * <p>
 * 储存分页相关数据，为了能够实现链式调用，所以就返回对象本身（return this;）
 */

public final class PagingBean {

    private int mPageIndex = 0;//当前是第几页

    private int mTotal = 0;//总数据条数

    private int mPageSize = 0;//一页显示几条数据

    private int mCurrentCount = 0;//当前已经显示了几条数据

    private int mDelayed = 0;//加载延迟


    public int getPageIndex() {
        return mPageIndex;
    }

    public PagingBean setPageIndex(int mPageIndex) {
        this.mPageIndex = mPageIndex;
        return this;
    }

    public int getTotal() {
        return mTotal;
    }

    public PagingBean setTotal(int mTotal) {
        this.mTotal = mTotal;
        return this;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public PagingBean setPageSize(int mPageSize) {
        this.mPageSize = mPageSize;
        return this;
    }

    public int getCurrentCount() {
        return mCurrentCount;
    }

    public PagingBean setCurrentCount(int mCurrentCount) {
        this.mCurrentCount = mCurrentCount;
        return this;
    }

    public int getDelayed() {
        return mDelayed;
    }

    public PagingBean setDelayed(int mDelayed) {
        this.mDelayed = mDelayed;
        return this;
    }

    PagingBean addIndex() {
        mPageIndex++;
        return this;
    }

}
