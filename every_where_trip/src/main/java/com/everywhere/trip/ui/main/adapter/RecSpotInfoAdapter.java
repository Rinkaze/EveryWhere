package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.bean.SpotInfo;
import com.everywhere.trip.util.GlideUtil;

import java.util.List;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class RecSpotInfoAdapter extends RecyclerView.Adapter {

    private Context context;
    private SpotInfo.ResultEntity.SpotEntity spotEntity;
    private final int TOP_TYPE = 0;
    private final int CONTENT_TYPE = 1;

    public RecSpotInfoAdapter(Context context, SpotInfo.ResultEntity.SpotEntity spotEntity) {
        this.context = context;
        this.spotEntity = spotEntity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TOP_TYPE){
            return new TopHolder(View.inflate(context,R.layout.item_spotinfo_top,null));
        }else {
            return new ContentHolder(View.inflate(context,R.layout.item_spotinfo_content,null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TOP_TYPE){
            TopHolder topHolder = (TopHolder) holder;
            topHolder.tvTitle.setText(spotEntity.getTitle());
            topHolder.tvAddress.setText("33.0km  |  "+spotEntity.getAddress());
            GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang,R.mipmap.zhanweitu_touxiang,
                    spotEntity.getPhoto(),topHolder.ivHeader,context);
            topHolder.tvAuthor.setText(spotEntity.getBanmiName());
            topHolder.tvOccupation.setText(spotEntity.getOccupation());
        }else {
            ContentHolder contentHolder = (ContentHolder) holder;
            SpotInfo.ResultEntity.SpotEntity.ContentEntity contentEntity = spotEntity.getContent().get(position - 1);
            GlideUtil.loadUrlImage(R.mipmap.zhanweitu_touxiang,R.mipmap.zhanweitu_touxiang,
                    contentEntity.getUrl(),contentHolder.img,context);
            contentHolder.tvContent.setText(contentEntity.getText());
        }
    }

    @Override
    public int getItemCount() {
        return 1+spotEntity.getContent().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TOP_TYPE;
        }else {
            return CONTENT_TYPE;
        }
    }

    class TopHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvAddress;
        ImageView ivHeader;
        TextView tvAuthor;
        TextView tvOccupation;
        public TopHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAddress = itemView.findViewById(R.id.tv_address);
            ivHeader = itemView.findViewById(R.id.iv_header);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvOccupation = itemView.findViewById(R.id.tv_occupation);
        }
    }

    class ContentHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvContent;
        public ContentHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
