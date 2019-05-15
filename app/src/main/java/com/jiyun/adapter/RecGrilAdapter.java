package com.jiyun.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jiyun.base.BaseApp;
import com.jiyun.bean.GankItemBean;
import com.jiyun.bean.SelectionsBean;
import com.jiyun.day03.R;
import com.jiyun.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class RecGrilAdapter extends RecyclerView.Adapter<RecGrilAdapter.ViewHolder> {

    private Context context;
    public List<GankItemBean> list;

    public RecGrilAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<GankItemBean> list) {
        this.list.addAll(list);
        for (final GankItemBean gankItemBean : this.list) {
            if (gankItemBean.getScale() == 0) {
                Glide.with(context)
                        .load(gankItemBean.getUrl())
                        .into(new SimpleTarget<Drawable>() {
                            @Override
                            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                float scale = resource.getIntrinsicWidth() * 1.0f / resource.getIntrinsicHeight();
                                gankItemBean.setScale(scale);
                                notifyDataSetChanged();
                            }
                        });
            }else {
                notifyDataSetChanged();
            }
        }
    }

    @NonNull
    @Override
    public RecGrilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.image_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecGrilAdapter.ViewHolder holder, final int position) {
        int imageWidth = BaseApp.mWidthPixels / 2 - SystemUtil.dp2px(6);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.img.getLayoutParams();
        params.width = imageWidth;
        if (list.get(position).getScale() != 0) {
            params.height = (int) (imageWidth / list.get(position).getScale());
        }
        params.topMargin = params.leftMargin = SystemUtil.dp2px(3);
        holder.img.setLayoutParams(params);
        RoundedCorners corners = new RoundedCorners(SystemUtil.dp2px(5));
        RequestOptions options = RequestOptions.bitmapTransform(corners);
        Glide.with(context)
                .load(list.get(position).getUrl())
                .apply(options)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
