package com.ysdd.tblm.controller;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.ysdd.tblm.service.dg.TbkDgMaterialOptionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 淘宝客导购类Controller
 *
 * @author chenfa
 * @version 1.0
 * @className TbkDgController
 * @date 2019/6/1 9:53
 */
@Controller
@RequestMapping("/tbk/dg")
@Api("淘宝客导购类API")
public class TbkDgController {
    /**
     * 导购类服务
     */
    private final TbkDgMaterialOptionalService dgMaterialOptionalService;

    public TbkDgController(TbkDgMaterialOptionalService dgMaterialOptionalService) {
        this.dgMaterialOptionalService = dgMaterialOptionalService;
    }

    /**
     * 返回物料搜索样例数据
     *
     * @return json
     */
    @ResponseBody
    @RequestMapping("/getExample")
    @ApiOperation(value = "获取物料搜索的样例数据")
    public String getExample() throws ApiException {
        TbkDgMaterialOptionalResponse example = dgMaterialOptionalService.getExample();
        return JSONObject.toJSONString(example);
    }
}
