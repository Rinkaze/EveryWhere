package com.jiyun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.base.BaseApp;
import com.jiyun.bean.DailyNewsBean;
import com.jiyun.bean.StoriesEntity;
import com.jiyun.dao.DaoSession;
import com.jiyun.dao.StoriesEntityDao;
import com.jiyun.day03.R;
import com.jiyun.day03.ZhihuDetailActivity;
import com.jiyun.fragment.DailyNewsFragment;
import com.jiyun.widget.TouchCallback;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class RecLikeAdapter extends RecyclerView.Adapter implements TouchCallback {
    private Context context;
    private ArrayList<StoriesEntity> stories;
    private DaoSession daoSession;

    public RecLikeAdapter(Context context, ArrayList<StoriesEntity> stories) {
        this.context = context;
        this.stories = stories;
        daoSession = BaseApp.getDaoSession();
    }

    public void setStories(ArrayList<StoriesEntity> stories) {
        this.stories = stories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsHolder(View.inflate(context, R.layout.dailynews_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsHolder newsHolder = (NewsHolder) holder;
        final StoriesEntity entity = stories.get(position);
        Glide.with(context)
                .load(entity.getImages().get(0))
                .into(newsHolder.img);
        newsHolder.title.setText(entity.getTitle());
        newsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(entity.getId() + "", entity);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        daoSession.clear();
        Collections.swap(stories, fromPosition, toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        daoSession.delete(stories.get(position));
        stories.remove(position);
        notifyItemRemoved(position);
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;

        public NewsHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(String url, StoriesEntity s);
    }
}
