package com.everywhere.trip.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 灵风 on 2019/5/17.
 */

public class CityBean {

    /**
     * result : {"china":{"cities":[{"timezone":"Asia/Shanghai","latitude":39.90657,"name":"北京","id":10,"countryID":1,"longitude":116.3876},{"timezone":"Asia/Shanghai","latitude":39.08349,"name":"天津","id":16,"countryID":1,"longitude":117.2008},{"timezone":"Asia/Shanghai","latitude":31.139071,"name":"苏州","id":27,"countryID":1,"longitude":120.645134},{"timezone":"Asia/Shanghai","latitude":30.25262,"name":"杭州","id":26,"countryID":1,"longitude":120.1651},{"timezone":"Asia/Shanghai","latitude":30.6719,"name":"成都","id":13,"countryID":1,"longitude":104.0758},{"timezone":"Asia/Shanghai","latitude":25.03739,"name":"台北","id":18,"countryID":1,"longitude":121.5635},{"timezone":"Asia/Shanghai","latitude":22.27981,"name":"香港","id":25,"countryID":1,"longitude":114.1618},{"timezone":"Asia/Shanghai","latitude":23.66635,"name":"潮汕","id":14,"countryID":1,"longitude":116.6396},{"timezone":"Asia/Shanghai","latitude":24.479834,"name":"厦门","id":31,"countryID":1,"longitude":118.089424},{"timezone":"Asia/Shanghai","latitude":40.855281,"name":"内蒙古","id":52,"countryID":1,"longitude":111.821733},{"timezone":"Asia/Shanghai","latitude":22.9833294,"name":"台南","id":50,"countryID":1,"longitude":120.1833326},{"timezone":"Asia/XinJiang","latitude":43.90749,"name":"新疆","id":51,"countryID":1,"longitude":87.47915},{"timezone":"Asia/Shanghai","latitude":38.962648,"name":"大连","id":60,"countryID":1,"longitude":121.541747},{"timezone":"Asia/Shanghai","latitude":31.239886,"name":"上海","id":61,"countryID":1,"longitude":121.501606},{"timezone":"Asia/Shanghai","latitude":22.15783,"name":"澳门","id":74,"countryID":1,"longitude":113.57641},{"timezone":"Asia/Shanghai","latitude":23.12908,"name":"广州","id":39,"countryID":1,"longitude":113.26436},{"timezone":"Asia/Shanghai","latitude":34.341568,"name":"西安","id":36,"countryID":1,"longitude":108.940178},{"timezone":"Asia/Shanghai","latitude":32.06167,"name":"南京","id":35,"countryID":1,"longitude":118.77778},{"timezone":"Asia/Shanghai","latitude":29.5573,"name":"重庆","id":47,"countryID":1,"longitude":106.57715},{"timezone":"Asia/Shanghai","latitude":28.22806,"name":"长沙","id":48,"countryID":1,"longitude":112.93892},{"timezone":"Asia/Shanghai","latitude":22.54368,"name":"深圳","id":44,"countryID":1,"longitude":114.05791},{"timezone":"Asia/Shanghai","latitude":36.06712,"name":"青岛","id":42,"countryID":1,"longitude":120.38267}],"name":"中国","id":1,"topCities":[{"timezone":"Asia/Shanghai","latitude":39.90657,"name":"北京","id":10,"countryID":1,"longitude":116.3876},{"timezone":"Asia/Shanghai","latitude":39.08349,"name":"天津","id":16,"countryID":1,"longitude":117.2008},{"timezone":"Asia/Shanghai","latitude":31.139071,"name":"苏州","id":27,"countryID":1,"longitude":120.645134},{"timezone":"Asia/Shanghai","latitude":30.25262,"name":"杭州","id":26,"countryID":1,"longitude":120.1651},{"timezone":"Asia/Shanghai","latitude":30.6719,"name":"成都","id":13,"countryID":1,"longitude":104.0758},{"timezone":"Asia/Shanghai","latitude":25.03739,"name":"台北","id":18,"countryID":1,"longitude":121.5635}]},"countries":[{"cities":[{"timezone":"America/New_York","latitude":40.73061,"name":"纽约","id":28,"countryID":2,"longitude":-73.935242},{"timezone":"Europe/Moscow","latitude":55.751244,"name":"莫斯科","id":30,"countryID":3,"longitude":37.618423},{"timezone":"Africa/Casablanca","latitude":31.92569,"name":"摩洛哥","id":11,"countryID":7,"longitude":-6.229583},{"timezone":"Australia/Perth","latitude":-31.95264,"name":"珀斯","id":19,"countryID":8,"longitude":115.8574},{"timezone":"Asia/Tokyo","latitude":35.68321,"name":"东京","id":1,"countryID":4,"longitude":139.8089},{"timezone":"Asia/Tokyo","latitude":34.68714,"name":"大阪","id":3,"countryID":4,"longitude":135.5016}],"name":"推荐","id":0},{"cities":[{"timezone":"Asia/Bangkok","latitude":18.767,"name":"清迈","id":22,"countryID":9,"longitude":99.02616},{"timezone":"Asia/Bangkok","latitude":7.984641,"name":"普吉岛","id":55,"countryID":9,"longitude":98.330664},{"timezone":"Asia/Bangkok","latitude":13.750525,"name":"曼谷","id":43,"countryID":9,"longitude":100.491702}],"name":"泰国","id":9},{"cities":[{"timezone":"Australia/Perth","latitude":-31.95264,"name":"珀斯","id":19,"countryID":8,"longitude":115.8574}],"name":"澳大利亚","id":8},{"cities":[{"timezone":"Africa/Casablanca","latitude":31.92569,"name":"摩洛哥","id":11,"countryID":7,"longitude":-6.229583}],"name":"摩洛哥","id":7},{"cities":[{"timezone":"Asia/Singapore","latitude":1.364419,"name":"新加坡","id":32,"countryID":6,"longitude":103.991526}],"name":"新加坡","id":6},{"cities":[{"timezone":"Asia/Seoul","latitude":37.558927,"name":"首尔","id":33,"countryID":5,"longitude":126.794495}],"name":"韩国","id":5},{"cities":[{"timezone":"Asia/Tokyo","latitude":35.68321,"name":"东京","id":1,"countryID":4,"longitude":139.8089},{"timezone":"Asia/Tokyo","latitude":34.68714,"name":"大阪","id":3,"countryID":4,"longitude":135.5016},{"timezone":"Asia/Tokyo","latitude":35.00026,"name":"京都","id":6,"countryID":4,"longitude":135.7524},{"timezone":"Asia/Tokyo","latitude":34.67581,"name":"奈良","id":4,"countryID":4,"longitude":135.8333},{"timezone":"Asia/Tokyo","latitude":32.65014,"name":"九州","id":9,"countryID":4,"longitude":130.8514},{"timezone":"Asia/Tokyo","latitude":43.19769,"name":"小樽","id":20,"countryID":4,"longitude":140.99369},{"timezone":"Asia/Tokyo","latitude":43.05801,"name":"札幌","id":5,"countryID":4,"longitude":141.3502},{"timezone":"Asia/Tokyo","latitude":34.98311,"name":"静冈","id":12,"countryID":4,"longitude":138.3922},{"timezone":"Asia/Tokyo","latitude":36.5946816,"name":"石川","id":15,"countryID":4,"longitude":136.6255726},{"timezone":"Asia/Tokyo","latitude":35.239197,"name":"箱根","id":58,"countryID":4,"longitude":139.012902},{"timezone":"Asia/Tokyo","latitude":36.242751,"name":"茨城","id":53,"countryID":4,"longitude":140.103094},{"timezone":"Asia/Tokyo","latitude":36.344451,"name":"轻井泽","id":59,"countryID":4,"longitude":138.635715},{"timezone":"Asia/Tokyo","latitude":41.77326,"name":"函馆","id":76,"countryID":4,"longitude":140.72769},{"timezone":"Asia/Tokyo","latitude":35.44349,"name":"横滨","id":57,"countryID":4,"longitude":139.646418},{"timezone":"Asia/Tokyo","latitude":35.325058,"name":"镰仓","id":56,"countryID":4,"longitude":139.546319},{"timezone":"Asia/Tokyo","latitude":35.25389,"name":"名古屋","id":72,"countryID":4,"longitude":136.91974},{"timezone":"Asia/Tokyo","latitude":36.3665,"name":"水户市","id":69,"countryID":4,"longitude":140.47099},{"timezone":"Asia/Tokyo","latitude":35.33917,"name":"藤泽市","id":70,"countryID":4,"longitude":139.49003},{"timezone":"Asia/Tokyo","latitude":36.39661,"name":"常陆那珂市","id":68,"countryID":4,"longitude":140.53467},{"timezone":"Asia/Tokyo","latitude":35.33384,"name":"茅崎市","id":67,"countryID":4,"longitude":139.40363},{"timezone":"Asia/Tokyo","latitude":35.2956,"name":"逗子市","id":66,"countryID":4,"longitude":139.58042},{"timezone":"Asia/Tokyo","latitude":36.31344,"name":"大洗町","id":65,"countryID":4,"longitude":140.57497},{"timezone":"Asia/Tokyo","latitude":35.28134,"name":"横须贺","id":64,"countryID":4,"longitude":139.6722},{"timezone":"Asia/Tokyo","latitude":34.45696,"name":"濑户内海","id":54,"countryID":4,"longitude":133.97461},{"timezone":"Asia/Tokyo","latitude":31.58361,"name":"鹿儿岛","id":38,"countryID":4,"longitude":130.54456},{"timezone":"Asia/Tokyo","latitude":26.2064,"name":"冲绳","id":37,"countryID":4,"longitude":127.64654}],"name":"日本","id":4},{"cities":[{"timezone":"Europe/Moscow","latitude":55.751244,"name":"莫斯科","id":30,"countryID":3,"longitude":37.618423}],"name":"俄罗斯","id":3},{"cities":[{"timezone":"America/New_York","latitude":40.73061,"name":"纽约","id":28,"countryID":2,"longitude":-73.935242},{"timezone":"America/Los_Angeles","latitude":37.756322,"name":"旧金山","id":41,"countryID":2,"longitude":-122.447903},{"timezone":"America/Los_Angeles","latitude":33.94158,"name":"洛杉矶","id":40,"countryID":2,"longitude":-118.40852}],"name":"美国","id":2},{"cities":[{"timezone":"Asia/Dubai","latitude":25.276987,"name":"迪拜","id":34,"countryID":10,"longitude":55.296249}],"name":"阿联酋","id":10}],"others":[{"timezone":"America/New_York","latitude":40.73061,"name":"纽约","id":28,"countryID":2,"longitude":-73.935242},{"timezone":"Europe/Moscow","latitude":55.751244,"name":"莫斯科","id":30,"countryID":3,"longitude":37.618423},{"timezone":"Africa/Casablanca","latitude":31.92569,"name":"摩洛哥","id":11,"countryID":7,"longitude":-6.229583},{"timezone":"Australia/Perth","latitude":-31.95264,"name":"珀斯","id":19,"countryID":8,"longitude":115.8574},{"timezone":"Asia/Tokyo","latitude":35.68321,"name":"东京","id":1,"countryID":4,"longitude":139.8089},{"timezone":"Asia/Tokyo","latitude":34.68714,"name":"大阪","id":3,"countryID":4,"longitude":135.5016},{"timezone":"Asia/Tokyo","latitude":35.00026,"name":"京都","id":6,"countryID":4,"longitude":135.7524},{"timezone":"Asia/Tokyo","latitude":34.67581,"name":"奈良","id":4,"countryID":4,"longitude":135.8333},{"timezone":"Asia/Bangkok","latitude":18.767,"name":"清迈","id":22,"countryID":9,"longitude":99.02616},{"timezone":"Asia/Tokyo","latitude":32.65014,"name":"九州","id":9,"countryID":4,"longitude":130.8514},{"timezone":"Asia/Tokyo","latitude":43.19769,"name":"小樽","id":20,"countryID":4,"longitude":140.99369},{"timezone":"Asia/Tokyo","latitude":43.05801,"name":"札幌","id":5,"countryID":4,"longitude":141.3502},{"timezone":"Asia/Tokyo","latitude":34.98311,"name":"静冈","id":12,"countryID":4,"longitude":138.3922},{"timezone":"Asia/Tokyo","latitude":36.5946816,"name":"石川","id":15,"countryID":4,"longitude":136.6255726},{"timezone":"America/Los_Angeles","latitude":37.756322,"name":"旧金山","id":41,"countryID":2,"longitude":-122.447903},{"timezone":"Asia/Tokyo","latitude":35.239197,"name":"箱根","id":58,"countryID":4,"longitude":139.012902},{"timezone":"Asia/Tokyo","latitude":36.242751,"name":"茨城","id":53,"countryID":4,"longitude":140.103094},{"timezone":"Europe/Spain","latitude":36.679113,"name":"西班牙小镇","id":62,"countryID":0,"longitude":-4.494423},{"timezone":"Asia/Tokyo","latitude":36.344451,"name":"轻井泽","id":59,"countryID":4,"longitude":138.635715},{"timezone":"Asia/Tokyo","latitude":41.77326,"name":"函馆","id":76,"countryID":4,"longitude":140.72769},{"timezone":"Asia/Tokyo","latitude":35.44349,"name":"横滨","id":57,"countryID":4,"longitude":139.646418},{"timezone":"Asia/Tokyo","latitude":35.325058,"name":"镰仓","id":56,"countryID":4,"longitude":139.546319},{"timezone":"Pacific/Auckland","latitude":-37.00824,"name":"新西兰北岛","id":75,"countryID":0,"longitude":174.78503},{"timezone":"Asia/Bangkok","latitude":7.984641,"name":"普吉岛","id":55,"countryID":9,"longitude":98.330664},{"timezone":"Asia/Tokyo","latitude":35.25389,"name":"名古屋","id":72,"countryID":4,"longitude":136.91974},{"timezone":"Asia/Tokyo","latitude":36.3665,"name":"水户市","id":69,"countryID":4,"longitude":140.47099},{"timezone":"Asia/Tokyo","latitude":35.33917,"name":"藤泽市","id":70,"countryID":4,"longitude":139.49003},{"timezone":"Asia/Tokyo","latitude":36.39661,"name":"常陆那珂市","id":68,"countryID":4,"longitude":140.53467},{"timezone":"Asia/Tokyo","latitude":35.33384,"name":"茅崎市","id":67,"countryID":4,"longitude":139.40363},{"timezone":"Asia/Tokyo","latitude":35.2956,"name":"逗子市","id":66,"countryID":4,"longitude":139.58042},{"timezone":"Asia/Tokyo","latitude":36.31344,"name":"大洗町","id":65,"countryID":4,"longitude":140.57497},{"timezone":"Asia/Tokyo","latitude":35.28134,"name":"横须贺","id":64,"countryID":4,"longitude":139.6722},{"timezone":"Asia/Tokyo","latitude":34.45696,"name":"濑户内海","id":54,"countryID":4,"longitude":133.97461},{"timezone":"Europe/London","latitude":51.519483,"name":"伦敦","id":49,"countryID":0,"longitude":-0.126953},{"timezone":"Europe/Italy","latitude":44.32543,"name":"意大利热那亚","id":73,"countryID":0,"longitude":9.19544},{"timezone":"Europe/Spain","latitude":36.717713,"name":"马拉加","id":63,"countryID":0,"longitude":-4.420579},{"timezone":"Asia/Seoul","latitude":37.558927,"name":"首尔","id":33,"countryID":5,"longitude":126.794495},{"timezone":"Asia/Dubai","latitude":25.276987,"name":"迪拜","id":34,"countryID":10,"longitude":55.296249},{"timezone":"Europe/Paris","latitude":48.858384,"name":"巴黎","id":45,"countryID":0,"longitude":2.294482},{"timezone":"Asia/Singapore","latitude":1.364419,"name":"新加坡","id":32,"countryID":6,"longitude":103.991526},{"timezone":"Asia/Bangkok","latitude":13.750525,"name":"曼谷","id":43,"countryID":9,"longitude":100.491702},{"timezone":"America/Los_Angeles","latitude":33.94158,"name":"洛杉矶","id":40,"countryID":2,"longitude":-118.40852},{"timezone":"Asia/Tokyo","latitude":31.58361,"name":"鹿儿岛","id":38,"countryID":4,"longitude":130.54456},{"timezone":"Asia/Tokyo","latitude":26.2064,"name":"冲绳","id":37,"countryID":4,"longitude":127.64654}]}
     * code : 0
     * error :
     */
    private ResultEntity result;
    private int code;
    private String error;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public class ResultEntity implements Serializable{
        /**
         * china : {"cities":[{"timezone":"Asia/Shanghai","latitude":39.90657,"name":"北京","id":10,"countryID":1,"longitude":116.3876},{"timezone":"Asia/Shanghai","latitude":39.08349,"name":"天津","id":16,"countryID":1,"longitude":117.2008},{"timezone":"Asia/Shanghai","latitude":31.139071,"name":"苏州","id":27,"countryID":1,"longitude":120.645134},{"timezone":"Asia/Shanghai","latitude":30.25262,"name":"杭州","id":26,"countryID":1,"longitude":120.1651},{"timezone":"Asia/Shanghai","latitude":30.6719,"name":"成都","id":13,"countryID":1,"longitude":104.0758},{"timezone":"Asia/Shanghai","latitude":25.03739,"name":"台北","id":18,"countryID":1,"longitude":121.5635},{"timezone":"Asia/Shanghai","latitude":22.27981,"name":"香港","id":25,"countryID":1,"longitude":114.1618},{"timezone":"Asia/Shanghai","latitude":23.66635,"name":"潮汕","id":14,"countryID":1,"longitude":116.6396},{"timezone":"Asia/Shanghai","latitude":24.479834,"name":"厦门","id":31,"countryID":1,"longitude":118.089424},{"timezone":"Asia/Shanghai","latitude":40.855281,"name":"内蒙古","id":52,"countryID":1,"longitude":111.821733},{"timezone":"Asia/Shanghai","latitude":22.9833294,"name":"台南","id":50,"countryID":1,"longitude":120.1833326},{"timezone":"Asia/XinJiang","latitude":43.90749,"name":"新疆","id":51,"countryID":1,"longitude":87.47915},{"timezone":"Asia/Shanghai","latitude":38.962648,"name":"大连","id":60,"countryID":1,"longitude":121.541747},{"timezone":"Asia/Shanghai","latitude":31.239886,"name":"上海","id":61,"countryID":1,"longitude":121.501606},{"timezone":"Asia/Shanghai","latitude":22.15783,"name":"澳门","id":74,"countryID":1,"longitude":113.57641},{"timezone":"Asia/Shanghai","latitude":23.12908,"name":"广州","id":39,"countryID":1,"longitude":113.26436},{"timezone":"Asia/Shanghai","latitude":34.341568,"name":"西安","id":36,"countryID":1,"longitude":108.940178},{"timezone":"Asia/Shanghai","latitude":32.06167,"name":"南京","id":35,"countryID":1,"longitude":118.77778},{"timezone":"Asia/Shanghai","latitude":29.5573,"name":"重庆","id":47,"countryID":1,"longitude":106.57715},{"timezone":"Asia/Shanghai","latitude":28.22806,"name":"长沙","id":48,"countryID":1,"longitude":112.93892},{"timezone":"Asia/Shanghai","latitude":22.54368,"name":"深圳","id":44,"countryID":1,"longitude":114.05791},{"timezone":"Asia/Shanghai","latitude":36.06712,"name":"青岛","id":42,"countryID":1,"longitude":120.38267}],"name":"中国","id":1,"topCities":[{"timezone":"Asia/Shanghai","latitude":39.90657,"name":"北京","id":10,"countryID":1,"longitude":116.3876},{"timezone":"Asia/Shanghai","latitude":39.08349,"name":"天津","id":16,"countryID":1,"longitude":117.2008},{"timezone":"Asia/Shanghai","latitude":31.139071,"name":"苏州","id":27,"countryID":1,"longitude":120.645134},{"timezone":"Asia/Shanghai","latitude":30.25262,"name":"杭州","id":26,"countryID":1,"longitude":120.1651},{"timezone":"Asia/Shanghai","latitude":30.6719,"name":"成都","id":13,"countryID":1,"longitude":104.0758},{"timezone":"Asia/Shanghai","latitude":25.03739,"name":"台北","id":18,"countryID":1,"longitude":121.5635}]}
         * countries : [{"cities":[{"timezone":"America/New_York","latitude":40.73061,"name":"纽约","id":28,"countryID":2,"longitude":-73.935242},{"timezone":"Europe/Moscow","latitude":55.751244,"name":"莫斯科","id":30,"countryID":3,"longitude":37.618423},{"timezone":"Africa/Casablanca","latitude":31.92569,"name":"摩洛哥","id":11,"countryID":7,"longitude":-6.229583},{"timezone":"Australia/Perth","latitude":-31.95264,"name":"珀斯","id":19,"countryID":8,"longitude":115.8574},{"timezone":"Asia/Tokyo","latitude":35.68321,"name":"东京","id":1,"countryID":4,"longitude":139.8089},{"timezone":"Asia/Tokyo","latitude":34.68714,"name":"大阪","id":3,"countryID":4,"longitude":135.5016}],"name":"推荐","id":0},{"cities":[{"timezone":"Asia/Bangkok","latitude":18.767,"name":"清迈","id":22,"countryID":9,"longitude":99.02616},{"timezone":"Asia/Bangkok","latitude":7.984641,"name":"普吉岛","id":55,"countryID":9,"longitude":98.330664},{"timezone":"Asia/Bangkok","latitude":13.750525,"name":"曼谷","id":43,"countryID":9,"longitude":100.491702}],"name":"泰国","id":9},{"cities":[{"timezone":"Australia/Perth","latitude":-31.95264,"name":"珀斯","id":19,"countryID":8,"longitude":115.8574}],"name":"澳大利亚","id":8},{"cities":[{"timezone":"Africa/Casablanca","latitude":31.92569,"name":"摩洛哥","id":11,"countryID":7,"longitude":-6.229583}],"name":"摩洛哥","id":7},{"cities":[{"timezone":"Asia/Singapore","latitude":1.364419,"name":"新加坡","id":32,"countryID":6,"longitude":103.991526}],"name":"新加坡","id":6},{"cities":[{"timezone":"Asia/Seoul","latitude":37.558927,"name":"首尔","id":33,"countryID":5,"longitude":126.794495}],"name":"韩国","id":5},{"cities":[{"timezone":"Asia/Tokyo","latitude":35.68321,"name":"东京","id":1,"countryID":4,"longitude":139.8089},{"timezone":"Asia/Tokyo","latitude":34.68714,"name":"大阪","id":3,"countryID":4,"longitude":135.5016},{"timezone":"Asia/Tokyo","latitude":35.00026,"name":"京都","id":6,"countryID":4,"longitude":135.7524},{"timezone":"Asia/Tokyo","latitude":34.67581,"name":"奈良","id":4,"countryID":4,"longitude":135.8333},{"timezone":"Asia/Tokyo","latitude":32.65014,"name":"九州","id":9,"countryID":4,"longitude":130.8514},{"timezone":"Asia/Tokyo","latitude":43.19769,"name":"小樽","id":20,"countryID":4,"longitude":140.99369},{"timezone":"Asia/Tokyo","latitude":43.05801,"name":"札幌","id":5,"countryID":4,"longitude":141.3502},{"timezone":"Asia/Tokyo","latitude":34.98311,"name":"静冈","id":12,"countryID":4,"longitude":138.3922},{"timezone":"Asia/Tokyo","latitude":36.5946816,"name":"石川","id":15,"countryID":4,"longitude":136.6255726},{"timezone":"Asia/Tokyo","latitude":35.239197,"name":"箱根","id":58,"countryID":4,"longitude":139.012902},{"timezone":"Asia/Tokyo","latitude":36.242751,"name":"茨城","id":53,"countryID":4,"longitude":140.103094},{"timezone":"Asia/Tokyo","latitude":36.344451,"name":"轻井泽","id":59,"countryID":4,"longitude":138.635715},{"timezone":"Asia/Tokyo","latitude":41.77326,"name":"函馆","id":76,"countryID":4,"longitude":140.72769},{"timezone":"Asia/Tokyo","latitude":35.44349,"name":"横滨","id":57,"countryID":4,"longitude":139.646418},{"timezone":"Asia/Tokyo","latitude":35.325058,"name":"镰仓","id":56,"countryID":4,"longitude":139.546319},{"timezone":"Asia/Tokyo","latitude":35.25389,"name":"名古屋","id":72,"countryID":4,"longitude":136.91974},{"timezone":"Asia/Tokyo","latitude":36.3665,"name":"水户市","id":69,"countryID":4,"longitude":140.47099},{"timezone":"Asia/Tokyo","latitude":35.33917,"name":"藤泽市","id":70,"countryID":4,"longitude":139.49003},{"timezone":"Asia/Tokyo","latitude":36.39661,"name":"常陆那珂市","id":68,"countryID":4,"longitude":140.53467},{"timezone":"Asia/Tokyo","latitude":35.33384,"name":"茅崎市","id":67,"countryID":4,"longitude":139.40363},{"timezone":"Asia/Tokyo","latitude":35.2956,"name":"逗子市","id":66,"countryID":4,"longitude":139.58042},{"timezone":"Asia/Tokyo","latitude":36.31344,"name":"大洗町","id":65,"countryID":4,"longitude":140.57497},{"timezone":"Asia/Tokyo","latitude":35.28134,"name":"横须贺","id":64,"countryID":4,"longitude":139.6722},{"timezone":"Asia/Tokyo","latitude":34.45696,"name":"濑户内海","id":54,"countryID":4,"longitude":133.97461},{"timezone":"Asia/Tokyo","latitude":31.58361,"name":"鹿儿岛","id":38,"countryID":4,"longitude":130.54456},{"timezone":"Asia/Tokyo","latitude":26.2064,"name":"冲绳","id":37,"countryID":4,"longitude":127.64654}],"name":"日本","id":4},{"cities":[{"timezone":"Europe/Moscow","latitude":55.751244,"name":"莫斯科","id":30,"countryID":3,"longitude":37.618423}],"name":"俄罗斯","id":3},{"cities":[{"timezone":"America/New_York","latitude":40.73061,"name":"纽约","id":28,"countryID":2,"longitude":-73.935242},{"timezone":"America/Los_Angeles","latitude":37.756322,"name":"旧金山","id":41,"countryID":2,"longitude":-122.447903},{"timezone":"America/Los_Angeles","latitude":33.94158,"name":"洛杉矶","id":40,"countryID":2,"longitude":-118.40852}],"name":"美国","id":2},{"cities":[{"timezone":"Asia/Dubai","latitude":25.276987,"name":"迪拜","id":34,"countryID":10,"longitude":55.296249}],"name":"阿联酋","id":10}]
         * others : [{"timezone":"America/New_York","latitude":40.73061,"name":"纽约","id":28,"countryID":2,"longitude":-73.935242},{"timezone":"Europe/Moscow","latitude":55.751244,"name":"莫斯科","id":30,"countryID":3,"longitude":37.618423},{"timezone":"Africa/Casablanca","latitude":31.92569,"name":"摩洛哥","id":11,"countryID":7,"longitude":-6.229583},{"timezone":"Australia/Perth","latitude":-31.95264,"name":"珀斯","id":19,"countryID":8,"longitude":115.8574},{"timezone":"Asia/Tokyo","latitude":35.68321,"name":"东京","id":1,"countryID":4,"longitude":139.8089},{"timezone":"Asia/Tokyo","latitude":34.68714,"name":"大阪","id":3,"countryID":4,"longitude":135.5016},{"timezone":"Asia/Tokyo","latitude":35.00026,"name":"京都","id":6,"countryID":4,"longitude":135.7524},{"timezone":"Asia/Tokyo","latitude":34.67581,"name":"奈良","id":4,"countryID":4,"longitude":135.8333},{"timezone":"Asia/Bangkok","latitude":18.767,"name":"清迈","id":22,"countryID":9,"longitude":99.02616},{"timezone":"Asia/Tokyo","latitude":32.65014,"name":"九州","id":9,"countryID":4,"longitude":130.8514},{"timezone":"Asia/Tokyo","latitude":43.19769,"name":"小樽","id":20,"countryID":4,"longitude":140.99369},{"timezone":"Asia/Tokyo","latitude":43.05801,"name":"札幌","id":5,"countryID":4,"longitude":141.3502},{"timezone":"Asia/Tokyo","latitude":34.98311,"name":"静冈","id":12,"countryID":4,"longitude":138.3922},{"timezone":"Asia/Tokyo","latitude":36.5946816,"name":"石川","id":15,"countryID":4,"longitude":136.6255726},{"timezone":"America/Los_Angeles","latitude":37.756322,"name":"旧金山","id":41,"countryID":2,"longitude":-122.447903},{"timezone":"Asia/Tokyo","latitude":35.239197,"name":"箱根","id":58,"countryID":4,"longitude":139.012902},{"timezone":"Asia/Tokyo","latitude":36.242751,"name":"茨城","id":53,"countryID":4,"longitude":140.103094},{"timezone":"Europe/Spain","latitude":36.679113,"name":"西班牙小镇","id":62,"countryID":0,"longitude":-4.494423},{"timezone":"Asia/Tokyo","latitude":36.344451,"name":"轻井泽","id":59,"countryID":4,"longitude":138.635715},{"timezone":"Asia/Tokyo","latitude":41.77326,"name":"函馆","id":76,"countryID":4,"longitude":140.72769},{"timezone":"Asia/Tokyo","latitude":35.44349,"name":"横滨","id":57,"countryID":4,"longitude":139.646418},{"timezone":"Asia/Tokyo","latitude":35.325058,"name":"镰仓","id":56,"countryID":4,"longitude":139.546319},{"timezone":"Pacific/Auckland","latitude":-37.00824,"name":"新西兰北岛","id":75,"countryID":0,"longitude":174.78503},{"timezone":"Asia/Bangkok","latitude":7.984641,"name":"普吉岛","id":55,"countryID":9,"longitude":98.330664},{"timezone":"Asia/Tokyo","latitude":35.25389,"name":"名古屋","id":72,"countryID":4,"longitude":136.91974},{"timezone":"Asia/Tokyo","latitude":36.3665,"name":"水户市","id":69,"countryID":4,"longitude":140.47099},{"timezone":"Asia/Tokyo","latitude":35.33917,"name":"藤泽市","id":70,"countryID":4,"longitude":139.49003},{"timezone":"Asia/Tokyo","latitude":36.39661,"name":"常陆那珂市","id":68,"countryID":4,"longitude":140.53467},{"timezone":"Asia/Tokyo","latitude":35.33384,"name":"茅崎市","id":67,"countryID":4,"longitude":139.40363},{"timezone":"Asia/Tokyo","latitude":35.2956,"name":"逗子市","id":66,"countryID":4,"longitude":139.58042},{"timezone":"Asia/Tokyo","latitude":36.31344,"name":"大洗町","id":65,"countryID":4,"longitude":140.57497},{"timezone":"Asia/Tokyo","latitude":35.28134,"name":"横须贺","id":64,"countryID":4,"longitude":139.6722},{"timezone":"Asia/Tokyo","latitude":34.45696,"name":"濑户内海","id":54,"countryID":4,"longitude":133.97461},{"timezone":"Europe/London","latitude":51.519483,"name":"伦敦","id":49,"countryID":0,"longitude":-0.126953},{"timezone":"Europe/Italy","latitude":44.32543,"name":"意大利热那亚","id":73,"countryID":0,"longitude":9.19544},{"timezone":"Europe/Spain","latitude":36.717713,"name":"马拉加","id":63,"countryID":0,"longitude":-4.420579},{"timezone":"Asia/Seoul","latitude":37.558927,"name":"首尔","id":33,"countryID":5,"longitude":126.794495},{"timezone":"Asia/Dubai","latitude":25.276987,"name":"迪拜","id":34,"countryID":10,"longitude":55.296249},{"timezone":"Europe/Paris","latitude":48.858384,"name":"巴黎","id":45,"countryID":0,"longitude":2.294482},{"timezone":"Asia/Singapore","latitude":1.364419,"name":"新加坡","id":32,"countryID":6,"longitude":103.991526},{"timezone":"Asia/Bangkok","latitude":13.750525,"name":"曼谷","id":43,"countryID":9,"longitude":100.491702},{"timezone":"America/Los_Angeles","latitude":33.94158,"name":"洛杉矶","id":40,"countryID":2,"longitude":-118.40852},{"timezone":"Asia/Tokyo","latitude":31.58361,"name":"鹿儿岛","id":38,"countryID":4,"longitude":130.54456},{"timezone":"Asia/Tokyo","latitude":26.2064,"name":"冲绳","id":37,"countryID":4,"longitude":127.64654}]
         */
        private ChinaEntity china;
        private List<CountriesEntity> countries;
        private List<OthersEntity> others;

        public void setChina(ChinaEntity china) {
            this.china = china;
        }

        public void setCountries(List<CountriesEntity> countries) {
            this.countries = countries;
        }

        public void setOthers(List<OthersEntity> others) {
            this.others = others;
        }

        public ChinaEntity getChina() {
            return china;
        }

        public List<CountriesEntity> getCountries() {
            return countries;
        }

        public List<OthersEntity> getOthers() {
            return others;
        }

        public class ChinaEntity implements Serializable{
            /**
             * cities : [{"timezone":"Asia/Shanghai","latitude":39.90657,"name":"北京","id":10,"countryID":1,"longitude":116.3876},{"timezone":"Asia/Shanghai","latitude":39.08349,"name":"天津","id":16,"countryID":1,"longitude":117.2008},{"timezone":"Asia/Shanghai","latitude":31.139071,"name":"苏州","id":27,"countryID":1,"longitude":120.645134},{"timezone":"Asia/Shanghai","latitude":30.25262,"name":"杭州","id":26,"countryID":1,"longitude":120.1651},{"timezone":"Asia/Shanghai","latitude":30.6719,"name":"成都","id":13,"countryID":1,"longitude":104.0758},{"timezone":"Asia/Shanghai","latitude":25.03739,"name":"台北","id":18,"countryID":1,"longitude":121.5635},{"timezone":"Asia/Shanghai","latitude":22.27981,"name":"香港","id":25,"countryID":1,"longitude":114.1618},{"timezone":"Asia/Shanghai","latitude":23.66635,"name":"潮汕","id":14,"countryID":1,"longitude":116.6396},{"timezone":"Asia/Shanghai","latitude":24.479834,"name":"厦门","id":31,"countryID":1,"longitude":118.089424},{"timezone":"Asia/Shanghai","latitude":40.855281,"name":"内蒙古","id":52,"countryID":1,"longitude":111.821733},{"timezone":"Asia/Shanghai","latitude":22.9833294,"name":"台南","id":50,"countryID":1,"longitude":120.1833326},{"timezone":"Asia/XinJiang","latitude":43.90749,"name":"新疆","id":51,"countryID":1,"longitude":87.47915},{"timezone":"Asia/Shanghai","latitude":38.962648,"name":"大连","id":60,"countryID":1,"longitude":121.541747},{"timezone":"Asia/Shanghai","latitude":31.239886,"name":"上海","id":61,"countryID":1,"longitude":121.501606},{"timezone":"Asia/Shanghai","latitude":22.15783,"name":"澳门","id":74,"countryID":1,"longitude":113.57641},{"timezone":"Asia/Shanghai","latitude":23.12908,"name":"广州","id":39,"countryID":1,"longitude":113.26436},{"timezone":"Asia/Shanghai","latitude":34.341568,"name":"西安","id":36,"countryID":1,"longitude":108.940178},{"timezone":"Asia/Shanghai","latitude":32.06167,"name":"南京","id":35,"countryID":1,"longitude":118.77778},{"timezone":"Asia/Shanghai","latitude":29.5573,"name":"重庆","id":47,"countryID":1,"longitude":106.57715},{"timezone":"Asia/Shanghai","latitude":28.22806,"name":"长沙","id":48,"countryID":1,"longitude":112.93892},{"timezone":"Asia/Shanghai","latitude":22.54368,"name":"深圳","id":44,"countryID":1,"longitude":114.05791},{"timezone":"Asia/Shanghai","latitude":36.06712,"name":"青岛","id":42,"countryID":1,"longitude":120.38267}]
             * name : 中国
             * id : 1
             * topCities : [{"timezone":"Asia/Shanghai","latitude":39.90657,"name":"北京","id":10,"countryID":1,"longitude":116.3876},{"timezone":"Asia/Shanghai","latitude":39.08349,"name":"天津","id":16,"countryID":1,"longitude":117.2008},{"timezone":"Asia/Shanghai","latitude":31.139071,"name":"苏州","id":27,"countryID":1,"longitude":120.645134},{"timezone":"Asia/Shanghai","latitude":30.25262,"name":"杭州","id":26,"countryID":1,"longitude":120.1651},{"timezone":"Asia/Shanghai","latitude":30.6719,"name":"成都","id":13,"countryID":1,"longitude":104.0758},{"timezone":"Asia/Shanghai","latitude":25.03739,"name":"台北","id":18,"countryID":1,"longitude":121.5635}]
             */
            private List<CitiesEntity> cities;
            private String name;
            private int id;
            private List<TopCitiesEntity> topCities;

            public void setCities(List<CitiesEntity> cities) {
                this.cities = cities;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setTopCities(List<TopCitiesEntity> topCities) {
                this.topCities = topCities;
            }

            public List<CitiesEntity> getCities() {
                return cities;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }

            public List<TopCitiesEntity> getTopCities() {
                return topCities;
            }

            public class CitiesEntity implements Serializable{
                /**
                 * timezone : Asia/Shanghai
                 * latitude : 39.90657
                 * name : 北京
                 * id : 10
                 * countryID : 1
                 * longitude : 116.3876
                 */
                private String timezone;
                private double latitude;
                private String name;
                private int id;
                private int countryID;
                private double longitude;

                public void setTimezone(String timezone) {
                    this.timezone = timezone;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setCountryID(int countryID) {
                    this.countryID = countryID;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public String getTimezone() {
                    return timezone;
                }

                public double getLatitude() {
                    return latitude;
                }

                public String getName() {
                    return name;
                }

                public int getId() {
                    return id;
                }

                public int getCountryID() {
                    return countryID;
                }

                public double getLongitude() {
                    return longitude;
                }
            }

            public class TopCitiesEntity implements Serializable{
                /**
                 * timezone : Asia/Shanghai
                 * latitude : 39.90657
                 * name : 北京
                 * id : 10
                 * countryID : 1
                 * longitude : 116.3876
                 */
                private String timezone;
                private double latitude;
                private String name;
                private int id;
                private int countryID;
                private double longitude;

                public void setTimezone(String timezone) {
                    this.timezone = timezone;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setCountryID(int countryID) {
                    this.countryID = countryID;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public String getTimezone() {
                    return timezone;
                }

                public double getLatitude() {
                    return latitude;
                }

                public String getName() {
                    return name;
                }

                public int getId() {
                    return id;
                }

                public int getCountryID() {
                    return countryID;
                }

                public double getLongitude() {
                    return longitude;
                }
            }
        }

        public class CountriesEntity implements Serializable{
            /**
             * cities : [{"timezone":"America/New_York","latitude":40.73061,"name":"纽约","id":28,"countryID":2,"longitude":-73.935242},{"timezone":"Europe/Moscow","latitude":55.751244,"name":"莫斯科","id":30,"countryID":3,"longitude":37.618423},{"timezone":"Africa/Casablanca","latitude":31.92569,"name":"摩洛哥","id":11,"countryID":7,"longitude":-6.229583},{"timezone":"Australia/Perth","latitude":-31.95264,"name":"珀斯","id":19,"countryID":8,"longitude":115.8574},{"timezone":"Asia/Tokyo","latitude":35.68321,"name":"东京","id":1,"countryID":4,"longitude":139.8089},{"timezone":"Asia/Tokyo","latitude":34.68714,"name":"大阪","id":3,"countryID":4,"longitude":135.5016}]
             * name : 推荐
             * id : 0
             */
            private List<CitiesEntity> cities;
            private String name;
            private int id;

            public void setCities(List<CitiesEntity> cities) {
                this.cities = cities;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<CitiesEntity> getCities() {
                return cities;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }

            public class CitiesEntity implements Serializable{
                /**
                 * timezone : America/New_York
                 * latitude : 40.73061
                 * name : 纽约
                 * id : 28
                 * countryID : 2
                 * longitude : -73.935242
                 */
                private String timezone;
                private double latitude;
                private String name;
                private int id;
                private int countryID;
                private double longitude;

                public void setTimezone(String timezone) {
                    this.timezone = timezone;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setCountryID(int countryID) {
                    this.countryID = countryID;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public String getTimezone() {
                    return timezone;
                }

                public double getLatitude() {
                    return latitude;
                }

                public String getName() {
                    return name;
                }

                public int getId() {
                    return id;
                }

                public int getCountryID() {
                    return countryID;
                }

                public double getLongitude() {
                    return longitude;
                }
            }
        }

        public class OthersEntity implements Serializable{
            /**
             * timezone : America/New_York
             * latitude : 40.73061
             * name : 纽约
             * id : 28
             * countryID : 2
             * longitude : -73.935242
             */
            private String timezone;
            private double latitude;
            private String name;
            private int id;
            private int countryID;
            private double longitude;

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setCountryID(int countryID) {
                this.countryID = countryID;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getTimezone() {
                return timezone;
            }

            public double getLatitude() {
                return latitude;
            }

            public String getName() {
                return name;
            }

            public int getId() {
                return id;
            }

            public int getCountryID() {
                return countryID;
            }

            public double getLongitude() {
                return longitude;
            }
        }
    }
}
