package com.jiyun.net;

import com.jiyun.bean.GankItemBean;
import com.jiyun.bean.GankSearchItemBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 灵风 on 2019/4/22.
 */

public interface GankService {
    String baseUrl = "http://gank.io/api/";

    /**
     * 技术文章列表
     */
    @GET("data/{tech}/20/{page}")
    Observable<GankHttpResponse<List<GankItemBean>>> getTechList(@Path("tech") String tech,@Path("page")int page);

    /**
     * 妹纸列表
     */
    @GET("data/福利/20/{page}")
    Observable<GankHttpResponse<List<GankItemBean>>> getGirlList(@Path("page") int page);

    /**
     * 随机妹纸图
     */
    @GET("random/data/福利/3")
    Observable<GankHttpResponse<List<GankItemBean>>> getRandomGirl();

    /**
     * 搜索
     */
    @GET("search/query/{query}/category/Android/count/10/page/1")
    Observable<GankHttpResponse<List<GankSearchItemBean>>> getSearchList(@Path("query") String query);
}
