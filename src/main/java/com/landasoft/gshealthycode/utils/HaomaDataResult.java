package com.landasoft.gshealthycode.utils;

/**
 * 百度手机号码归属地查询api返回结果 data
 * "data": [
 *         {
 *             "StdStg": 6004,
 *             "StdStl": 8,
 *             "_update_time": "1577497892",
 *             "cambrian_appid": "0",
 *             "city": "南京",
 *             "key": "1510516",
 *             "prov": "江苏",
 *             "showurl": "http://haoma.baidu.com",
 *             "title": "XXX",
 *             "type": "中国移动",
 *             "url": "http://haoma.baidu.com",
 *             "loc": "https://dss1.baidu.com/8aQDcnSm2Q5IlBGlnYG/q?r=2002696&k=1510516",
 *             "SiteId": 2002696,
 *             "_version": 30208,
 *             "_select_time": 1577496596,
 *             "querytype": "手机号码",
 *             "phoneinfo": "手机号码&quot;15105166464&quot;",
 *             "phoneno": "15105166464",
 *             "origphoneno": "15105166464",
 *             "titlecont": "手机号码归属地查询",
 *             "showlamp": "1",
 *             "clickneed": "0",
 *             "ExtendedLocation": "",
 *             "OriginQuery": "15105166464",
 *             "tplt": "mobilephone",
 *             "resourceid": "6004",
 *             "fetchkey": "6004_1510516",
 *             "appinfo": "",
 *             "role_id": 1,
 *             "disp_type": 0
 *         }
 *     ]
 * @author zhaoyuan
 * @date 2020,March 30 9:31 pm
 */
public class HaomaDataResult {

    private String StdStg;
    private String _update_time;
    private String city;
    private String key;
    private String prov;
    private String showurl;

    public HaomaDataResult() {
    }

    public HaomaDataResult(String stdStg, String _update_time, String city, String key, String prov, String showurl) {
        StdStg = stdStg;
        this._update_time = _update_time;
        this.city = city;
        this.key = key;
        this.prov = prov;
        this.showurl = showurl;
    }

    public String getStdStg() {
        return StdStg;
    }

    public void setStdStg(String stdStg) {
        StdStg = stdStg;
    }

    public String get_update_time() {
        return _update_time;
    }

    public void set_update_time(String _update_time) {
        this._update_time = _update_time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getShowurl() {
        return showurl;
    }

    public void setShowurl(String showurl) {
        this.showurl = showurl;
    }
}
