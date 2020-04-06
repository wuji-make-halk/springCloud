package com.square.controller;

import com.github.pagehelper.PageInfo;
import com.square.model.Label;
import com.square.service.LabelService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/18
 * Description:
 */
@RestController
@CrossOrigin
@RefreshScope
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result test() {
        return new Result(true, StatusCode.OK, "测试成功");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId) {
        // int i = 1/0;
        //获取头信息
        String head = request.getHeader("Authorization");
        System.out.println(head);
        return new Result(true, StatusCode.OK, "查询成功", labelService.getById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        return new Result(true, StatusCode.OK, "添加成功", labelService.insert(label));
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@RequestBody Label label, @PathVariable("labelId") String labelId) {
        label.setId(labelId);
        return new Result(true, StatusCode.OK, "修改成功", labelService.update(label));
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId) {
        return new Result(true, StatusCode.OK, "删除成功", labelService.delete(labelId));
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> labels = labelService.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", labels);
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageInfo<Label> labels = labelService.pageQuery(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", labels);
    }


}
