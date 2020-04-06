package com.square.controller;

import com.github.pagehelper.PageInfo;
import com.square.model.Spit;
import com.square.service.SpitService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/4
 * Description:   用到了mongodb
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Spit> spits = spitService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", spits);
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String spitId) {
        Spit spit = spitService.findById(spitId);
        return new Result(true, StatusCode.OK, "查询成功", spit);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit) {
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
    public Result modify(@PathVariable String spitId, @RequestBody Spit spit) {
        spit.set_id(spitId);
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String spitId) {
        spitService.delete(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/{parentid}/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@PathVariable String parentid, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageInfo<Spit> spitPageInfo = spitService.findSpitList(parentid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", spitPageInfo);
    }

    @RequestMapping(value = "/thumbup/{spitId}", method = RequestMethod.PUT)
    public Result thumbup(@PathVariable String spitId) {
        // 判断当前用户是否已经点赞，但是没有做认真，暂时先把userId写死。
        String userid = "111";
        if (redisTemplate.opsForValue().get("thumbup_" + userid) != null) {
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        spitService.thumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_" + userid, 1);
        return new Result(true, StatusCode.OK, "点赞成功");
    }

}
