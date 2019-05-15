package com.jiyun.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.bean.GankItemBean;
import com.jiyun.day03.R;
import com.jiyun.fragment.GankFragment;
import com.jiyun.util.DateUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class RecTechAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<GankItemBean> mList;

    private String tech;

    public RecTechAdapter(Context mContext, List<GankItemBean> mList, String tech) {
        inflater = LayoutInflater.from(mContext);
        this.mList = mList;
        this.tech = tech;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_gank, null));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(tech.equals(GankFragment.types[0])) {
            ((ViewHolder)holder).ivIcon.setImageResource(R.mipmap.ic_android);
        } else if(tech.equals(GankFragment.types[1])) {
            ((ViewHolder)holder).ivIcon.setImageResource(R.mipmap.ic_ios);
        } else if(tech.equals(GankFragment.types[2])) {
            ((ViewHolder)holder).ivIcon.setImageResource(R.mipmap.ic_web);
        }
        ((ViewHolder)holder).tvContent.setText(mList.get(position).getDesc());
        ((ViewHolder)holder).tvAuthor.setText(mList.get(position).getWho());
        ((ViewHolder)holder).tvTime.setText(DateUtil.formatDateTime(DateUtil.subStandardTime(mList.get(position).getPublishedAt()), true));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_tech_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_tech_title)
        TextView tvContent;
        @BindView(R.id.tv_tech_author)
        TextView tvAuthor;
        @BindView(R.id.tv_tech_time)
        TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
