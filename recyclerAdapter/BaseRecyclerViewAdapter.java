package com.mingying.laohucaijing.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.base.commonlibrary.utils.DeviceUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author Wsw
 * @description:
 * @date :2020/3/6 10:36
 */
public abstract class BaseRecyclerViewAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public BaseRecyclerViewAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }
    public BaseRecyclerViewAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
        if (addHeadView() != null){
            addHeaderView(addHeadView());
        }
    }


    @Override
    protected void convert(BaseViewHolder helper, T item) {
        bindView(helper, item, helper.getAdapterPosition());
    }

    @Override
    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        super.setOnItemClickListener((adapter, view, position) -> {
        	//放置重点击
            if (!DeviceUtils.isFastDoubleClick()) {
                BaseRecyclerViewAdapter.this.onItemClick(getData().get(position), position);
            }
        });
    }



    protected abstract void bindView(BaseViewHolder holder, T bean, int position);

    protected abstract void onItemClick(T bean, int position);

    protected abstract View addHeadView();

}