package com.jiyun.day03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.adapter.RecNavigationAdapter;
import com.jiyun.bean.NavigationBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import qdx.stickyheaderdecoration.NormalDecoration;

public class NavigationActivity extends AppCompatActivity {

    private String mUrl = "https://www.v2ex.com/";
    private ArrayList<NavigationBean> list;
    private String channel;
    private RecyclerView mRecView;
    private RecNavigationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initView();
        list = new ArrayList<>();
        initData();
    }

    private static final String TAG = "NavigationActivity";

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(mUrl).get();
                    Elements select = doc.select("div#Main");
                    final Element last = select.select("div.box").last();
                    Elements divs = last.select("div");
                    for (int i = 0; i < divs.size(); i++) {
                        if (i != 0) {
                            ArrayList<String> headers = new ArrayList<>();
                            ArrayList<String> links = new ArrayList<>();
                            Element element = divs.get(i);
                            Element fade = element.select("table tbody tr td > span.fade").first();
                            if (fade != null) {
                                channel = fade.text();
                                Log.e(TAG, "类别: " + channel);
                            }

                            Elements titles = element.select("table tbody tr td > a");
                            for (Element title : titles) {
                                String href = title.attr("href");
                                links.add(href);
                                String text = title.text();
                                headers.add(text);
                                Log.e(TAG, "标题: " + text + ", 链接:" + href);

                            }
                            if (channel != null){
                                list.add(new NavigationBean(channel, headers, links));
                            }
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "run: "+list.toString());
                            NormalDecoration decoration = new NormalDecoration() {
                                @Override
                                public String getHeaderName(int pos) {
                                    return list.get(pos).getTitle();
                                }
                            };
                            decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
                                @Override
                                public View getHeaderView(int pos) {
                                    View view = View.inflate(NavigationActivity.this, R.layout.item_header, null);
                                    ((TextView)view.findViewById(R.id.tv)).setText(list.get(pos).getTitle());
                                    return view;
                                }
                            });
                            adapter = new RecNavigationAdapter(NavigationActivity.this, list);
                            mRecView.setLayoutManager(new LinearLayoutManager(NavigationActivity.this));
                            mRecView.addItemDecoration(decoration);
                            mRecView.setAdapter(adapter);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView() {
        mRecView = (RecyclerView) findViewById(R.id.recView);
    }
}
