package com.jiyun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.jiyun.bean.NavigationBean;
import com.jiyun.day03.R;
import com.jiyun.widget.FlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class RecNavigationAdapter extends RecyclerView.Adapter<RecNavigationAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NavigationBean> list;

    public RecNavigationAdapter(Context context, ArrayList<NavigationBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecNavigationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.item_flow,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecNavigationAdapter.ViewHolder holder, int position) {
        ArrayList<String> headers = list.get(position).getHeaders();
        holder.flow.removeAllViews();
        for (String s : headers) {
            TextView label = (TextView) View.inflate(context, R.layout.item_label, null);
            label.setText(s);
            holder.flow.addView(label);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.flow)
        FlowLayout flow;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
