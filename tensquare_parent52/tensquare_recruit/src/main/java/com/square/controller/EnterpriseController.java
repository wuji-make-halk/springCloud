package com.square.controller;

import com.github.pagehelper.PageInfo;
import com.square.model.Enterprise;
import com.square.service.EnterpriseService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description: 分页查询
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Enterprise enterprise, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageInfo<Enterprise> enterprisePageInfo = enterpriseService.findEnterpriseList(enterprise, page, size);
        return new Result(true, StatusCode.OK, "查询成功", enterprisePageInfo);
    }

    @RequestMapping(value = "/{enterpriseId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("enterpriseId") String enterpriseId) {
        return new Result(true, StatusCode.OK, "查询成功", enterpriseService.findEnterpriseById(enterpriseId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Enterprise enterprise) {
        return new Result(true, StatusCode.OK, "添加成功", enterpriseService.add(enterprise));
    }

    @RequestMapping(value = "/{enterpriseId}", method = RequestMethod.PUT)
    public Result update(@RequestBody Enterprise enterprise, @PathVariable("enterpriseId") String enterpriseId) {
        enterprise.setId(enterpriseId);
        return new Result(true, StatusCode.OK, "修改成功", enterpriseService.modify(enterprise));
    }

    @RequestMapping(value = "/{enterpriseId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("enterpriseId") String enterpriseId) {
        return new Result(true, StatusCode.OK, "删除成功", enterpriseService.remove(enterpriseId));
    }

    @RequestMapping(value = "/search/ishot", method = RequestMethod.GET)
    public Result findIsHot() {

        return new Result(true, StatusCode.OK, "是热门", enterpriseService.listIsHot("1"));
    }

}
