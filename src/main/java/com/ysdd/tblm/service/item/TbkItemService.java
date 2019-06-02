package com.ysdd.tblm.service.item;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import com.ysdd.tblm.config.TbkConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 淘宝商品查询
 *
 * @author chenfa
 * @version 1.0
 * @className TbkGet
 * @date 2019/6/1 6:35
 */
@Service
public class TbkItemService {

    @Value("${TAOBAO.APPLICATION.APPKEY}")
    private String appkey;
    @Value("${TAOBAO.APPLICATION.SECRET}")
    private String secret;
    @Value("${TAOBAO.APPLICATION.URL}")
    private String url;
    /**
     * 商品查询示例
     *
     * @return itemResponse
     * @throws ApiException exception
     */
    public TbkItemGetResponse getExample() throws ApiException {
        /*正式环境中应使用单例模式减少资源占用*/
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ("女装");
        req.setCat("16,18");

//        req.setItemloc("杭州");
//        req.setSort("tk_rate_des");
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);
//        req.setPageNo(123L);
//        req.setPageSize(20L);
        TbkItemGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
        return rsp;
    }
}
