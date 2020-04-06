package com.square.controller;

import com.square.model.Article;
import com.square.service.ArticleService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/27
 * Description:  使用Redis
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/examine/{articleId}", method = RequestMethod.PUT)
    public Result update(@PathVariable("articleId") String articleId) {
        return new Result(true, StatusCode.OK, "审核成功", articleService.update(articleId));
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("articleId") String articleId) {
        return new Result(true, StatusCode.OK, "查询成功", articleService.findById(articleId));
    }

    @RequestMapping(value = "/thumbup/{articleId}", method = RequestMethod.PUT)
    public Result addThumbup(@PathVariable("articleId") String articleId) {
        return new Result(true, StatusCode.OK, "点赞成功", articleService.addThumbup(articleId));
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.PUT)
    public Result update(@RequestBody Article article, @PathVariable("articleId") String articleId) {
        article.setId(articleId);
        return new Result(true, StatusCode.OK, "修改成功", articleService.modify(article));
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("articleId") String articleId) {
        return new Result(true, StatusCode.OK, "删除成功", articleService.remove(articleId));
    }

}
