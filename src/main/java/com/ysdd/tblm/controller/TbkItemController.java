package com.ysdd.tblm.controller;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.response.TbkItemGetResponse;
import com.ysdd.tblm.common.web.AjaxResult;
import com.ysdd.tblm.service.item.TbkItemService;
import com.ysdd.tblm.taobaoAppliction.TBKApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 淘宝客商品类Controller
 *
 * @author chenfa
 * @version 1.0
 * @className TbkItemController
 * @date 2019/6/1 9:32
 */
@Controller
@RequestMapping("/tbk/item")
public class TbkItemController {

    /**
     * 商品类服务
     */
    @Autowired
    TbkItemService tbkItemService;

    /**
     * 返回商品查询样例数据
     *
     * @return json
     */
    @ResponseBody
    @RequestMapping("/getExample")
    private AjaxResult getExample() throws ApiException {

        return AjaxResult.success(TBKApi.ItemGet.getItemInfo("11","A"));
    }
}
