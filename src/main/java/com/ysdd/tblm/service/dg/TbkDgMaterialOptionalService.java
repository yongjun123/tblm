package com.ysdd.tblm.service.dg;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.ysdd.tblm.config.TbkConfig;
import org.springframework.stereotype.Service;

/**
 * 淘宝客物料搜索API
 *
 * @author chenfa
 * @version 1.0
 * @className TbkDgMaterialOptional
 * @date 2019/6/1 9:48
 */
@Service
public class TbkDgMaterialOptionalService {

    /**
     * 物料搜索示例
     *
     * @return materialOptionalResponse
     * @throws ApiException exception
     */
    public TbkDgMaterialOptionalResponse getExample() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(TbkConfig.SERVER, TbkConfig.APPKEY, TbkConfig.SECRET);
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
//        req.setStartDsr(10L);
//        req.setPageSize(20L);
//        req.setPageNo(1L);
//        req.setPlatform(1L);
//        req.setEndTkRate(1234L);
//        req.setStartTkRate(1234L);
//        req.setEndPrice(10L);
//        req.setStartPrice(10L);
//        req.setIsOverseas(false);
//        req.setIsTmall(false);
//        req.setSort("tk_rate_des");
//        req.setItemloc("杭州");
        req.setCat("16,18");
        req.setQ("女装");
//        req.setMaterialId(2836L);
//        req.setHasCoupon(false);
//        req.setIp("13.2.33.4");
        req.setAdzoneId(108920800177L);
       /* req.setNeedFreeShipment(true);
        req.setNeedPrepay(true);
        req.setIncludePayRate30(true);
        req.setIncludeGoodRate(true);
        req.setIncludeRfdRate(true);
        req.setNpxLevel(2L);
        req.setEndKaTkRate(1234L);
        req.setStartKaTkRate(1234L);
        req.setDeviceEncrypt("MD5");
        req.setDeviceValue("xxx");
        req.setDeviceType("IMEI");*/
        TbkDgMaterialOptionalResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
        return rsp;
    }

}
