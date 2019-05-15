package com.jiyun.bean;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/23.
 */

public class GrilBean {

    /**
     * error : false
     * results : [{"createdAt":"2019-02-18T06:04:25.571Z","publishedAt":"2019-02-18T06:05:41.975Z","_id":"5c6a4ae99d212226776d3256","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg","desc":"2019-02-18","who":"lijinshanmx"},{"createdAt":"2019-02-13T02:49:23.946Z","publishedAt":"2019-02-13T02:49:33.16Z","_id":"5c6385b39d21225dd7a417ce","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg","desc":"2019-02-13","who":"lijinshanmx"},{"createdAt":"2019-01-21T07:46:35.304Z","publishedAt":"2019-01-21T00:00:00.0Z","_id":"5c4578db9d212264d4501d40","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fze94uew3jj30qo10cdka.jpg","desc":"2019-01-21","who":"lijinshanmx"},{"createdAt":"2019-01-03T06:29:47.895Z","publishedAt":"2019-01-03T00:00:00.0Z","_id":"5c2dabdb9d21226e068debf9","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg","desc":"2019-01-03","who":"lijinshanmx"},{"createdAt":"2018-12-28T08:13:12.688Z","publishedAt":"2018-12-28T00:00:00.0Z","_id":"5c25db189d21221e8ada8664","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg","desc":"2018-12-28","who":"lijinshanmx"},{"createdAt":"2018-12-13T09:07:57.2Z","publishedAt":"2018-12-13T00:00:00.0Z","_id":"5c12216d9d21223f5a2baea2","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg","desc":"2018-12-13","who":"lijinshanmx"},{"createdAt":"2018-11-28T04:32:27.338Z","publishedAt":"2018-11-28T00:00:00.0Z","_id":"5bfe1a5b9d2122309624cbb7","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg","desc":"2018-11-28","who":"lijinshanmx"},{"createdAt":"2018-11-19T03:36:54.950Z","publishedAt":"2018-11-19T00:00:00.0Z","_id":"5bf22fd69d21223ddba8ca25","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg","desc":"2018-11-19","who":"lijinshanmx"},{"createdAt":"2018-11-06T08:20:43.656Z","publishedAt":"2018-11-06T00:00:00.0Z","_id":"5be14edb9d21223dd50660f8","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg","desc":"2018-11-06","who":"lijinshanmx"},{"createdAt":"2018-10-22T06:43:35.440Z","publishedAt":"2018-10-22T00:00:00.0Z","_id":"5bcd71979d21220315c663fc","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg","desc":"2018-10-22","who":"lijinshanmx"}]
     */
    private boolean error;
    private List<ResultsEntity> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public class ResultsEntity {
        /**
         * createdAt : 2019-02-18T06:04:25.571Z
         * publishedAt : 2019-02-18T06:05:41.975Z
         * _id : 5c6a4ae99d212226776d3256
         * source : web
         * used : true
         * type : 福利
         * url : https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg
         * desc : 2019-02-18
         * who : lijinshanmx
         */
        private String createdAt;
        private String publishedAt;
        private String _id;
        private String source;
        private boolean used;
        private String type;
        private String url;
        private String desc;
        private String who;

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String get_id() {
            return _id;
        }

        public String getSource() {
            return source;
        }

        public boolean isUsed() {
            return used;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public String getDesc() {
            return desc;
        }

        public String getWho() {
            return who;
        }
    }
}
