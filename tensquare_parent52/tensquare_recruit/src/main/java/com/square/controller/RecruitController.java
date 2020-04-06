package com.square.controller;

import com.github.pagehelper.PageInfo;
import com.square.model.Recruit;
import com.square.service.RecruitService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Recruit recruit, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageInfo<Recruit> recruitPageInfo = recruitService.findRecruitList(recruit, page, size);
        return new Result(true, StatusCode.OK, "查询成功", recruitPageInfo);
    }

    @RequestMapping(value = "/{recruitId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("recruitId") String recruitId) {
        return new Result(true, StatusCode.OK, "查询成功", recruitService.findRecruitById(recruitId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Recruit recruit) {
        return new Result(true, StatusCode.OK, "添加成功", recruitService.add(recruit));
    }

    @RequestMapping(value = "/{recruitId}", method = RequestMethod.PUT)
    public Result update(@RequestBody Recruit recruit, @PathVariable("recruitId") String recruitId) {
        recruit.setId(recruitId);
        return new Result(true, StatusCode.OK, "修改成功", recruitService.modify(recruit));
    }

    @RequestMapping(value = "/{recruitId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("recruitId") String recruitId) {
        return new Result(true, StatusCode.OK, "删除成功", recruitService.remove(recruitId));
    }

    @RequestMapping(value = "/search/top", method = RequestMethod.GET)
    public Result findTop() {
        return new Result(true, StatusCode.OK, "推荐职位", recruitService.findTop("2"));
    }

    @RequestMapping(value = "/search/new", method = RequestMethod.GET)
    public Result findNew() {
        return new Result(true, StatusCode.OK, "最新职位", recruitService.findnewJod("0"));
    }


}
