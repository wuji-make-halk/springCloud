package com.square.controller;

import com.github.pagehelper.PageInfo;
import com.square.client.BaseClient;
import com.square.model.Problem;
import com.square.service.ProblemService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/27
 * Description:  使用PageHelper分页
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;
    @Autowired
    private BaseClient baseClient;

    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
    public Result findByLableId(@PathVariable("labelId") String labelId) {
        Result result = baseClient.findById(labelId);
        return result;
    }

    @RequestMapping(value = "/searchNewList/{labelId}/{page}/{size}", method = RequestMethod.POST)
    public Result newListQuery(@PathVariable String labelId, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageInfo<Problem> problemPageInfo = problemService.findProblemList(labelId, page, size);
        return new Result(true, StatusCode.OK, "查询成功", problemPageInfo);
    }

    @RequestMapping(value = "/searchHotList/{labelId}/{page}/{size}", method = RequestMethod.POST)
    public Result hotListQuery(@PathVariable String labelId, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageInfo<Problem> problemPageInfo = problemService.findHotListProblem(labelId, page, size);
        return new Result(true, StatusCode.OK, "查询成功", problemPageInfo);
    }

    @RequestMapping(value = "/searchWaitList/{labelId}/{page}/{size}", method = RequestMethod.POST)
    public Result waitListQuery(@PathVariable String labelId, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageInfo<Problem> problemPageInfo = problemService.findProblemList(labelId, page, size);
        return new Result(true, StatusCode.OK, "查询成功", problemPageInfo);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Problem problem) {
        problemService.add(problem);
        return new Result(true, StatusCode.OK, "新增成功");
    }
}
