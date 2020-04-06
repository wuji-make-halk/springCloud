package com.square.controller;

import com.square.service.GatheringService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/29
 * Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/gathering")
public class GatheringController {
    @Autowired
    private GatheringService gatheringService;

    @RequestMapping(value = "/{gatheringId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("gatheringId") String gatheringId) {
        return new Result(true, StatusCode.OK, "查询成功", gatheringService.findById(gatheringId));
    }

}
