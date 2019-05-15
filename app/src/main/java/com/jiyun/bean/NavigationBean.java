package com.jiyun.bean;

import java.util.ArrayList;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class NavigationBean {
    private String title;
    private ArrayList<String> headers;
    private ArrayList<String> links;

    public NavigationBean(String title, ArrayList<String> headers, ArrayList<String> links) {
        this.title = title;
        this.headers = headers;
        this.links = links;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<String> headers) {
        this.headers = headers;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "NavigationBean{" +
                "title='" + title + '\'' +
                ", headers=" + headers +
                ", links=" + links +
                '}';
    }
}
