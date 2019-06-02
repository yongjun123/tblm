package com.ysdd.tblm.taobaoAppliction;


import com.alibaba.fastjson.JSONObject;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import com.ysdd.tblm.taobaoAppliction.exception.TBKApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class TBKApi {
    private static String url;
    private static String appkey;
    private static String secret;

    @Value("${TAOBAO.APPLICATION.URL}")
    public void setUrl(String url) {
        TBKApi.url = url;
    }

    @Value("${TAOBAO.APPLICATION.APPKEY}")
    public void setCpbm(String appkey) {
        TBKApi.appkey = appkey;
    }

    @Value("${TAOBAO.APPLICATION.SECRET}")
    public void setAreaCode(String secret) {
        TBKApi.secret = secret;
    }


    /**
     * 淘宝客商品查询接口 itemGet
     */
    public static class ItemGet {
        /**
         * 获取商品信息
         *
         * @return
         */
        public static String getItemInfo(String Q, String cat) {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            TbkItemGetRequest req = new TbkItemGetRequest();
            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
            req.setQ("女装");
            req.setCat("16,18");
            TbkItemGetResponse rsp = null;
            try {
                rsp = client.execute(req);
                if ("".equals(rsp.getCode())) {
                    log.debug("调用淘宝客itemGet接口获取商品信息失败,失败原因:{}", rsp.getSubMsg());
                    throw new TBKApiException("获取商品信息失败");
                }
                return rsp.getBody();
            } catch (ApiException e) {
                log.debug("调用淘宝客itemGet接口获取商品信息失败，失败原因:{}", rsp.getSubMsg());
                throw new TBKApiException("获取商品信息失败");
            }
        }
    }


}
