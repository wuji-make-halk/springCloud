package com.square.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.square.dao.ProblemMapper;
import com.square.model.Problem;
import com.square.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/27
 * Description:
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public PageInfo<Problem> findProblemList(String labelId, int page, int size) {
        if (page < 1 || size < 0) {

        }
        PageHelper.startPage(page, size);
        List<Problem> problems = problemMapper.newList(labelId);
        Long total = ((Page) problems).getTotal();
        PageInfo<Problem> pageResult = new PageInfo<>(problems);
        pageResult.setTotal(total);
        return pageResult;

    }

    @Override
    public PageInfo<Problem> findHotListProblem(String labelId, int page, int size) {
        if (page < 1 || size < 0) {

        }
        PageHelper.startPage(page, size);
        List<Problem> problems = problemMapper.hotList(labelId);
        Long total = ((Page) problems).getTotal();
        PageInfo<Problem> pageResult = new PageInfo<>(problems);
        pageResult.setTotal(total);
        return pageResult;
    }

    @Override
    public PageInfo<Problem> findWaitListProblem(String labelId, int page, int size) {
        if (page < 1 || size < 0) {

        }
        PageHelper.startPage(page, size);
        List<Problem> problems = problemMapper.waitList(labelId);
        Long total = ((Page) problems).getTotal();
        PageInfo<Problem> pageResult = new PageInfo<>(problems);
        pageResult.setTotal(total);
        return pageResult;
    }

    @Override
    public void add(Problem problem) {
        String token = (String) request.getAttribute("calims_user");
        if (token == null || "".equals(token)) {
            throw new RuntimeException("权限不足!");
        }
        problemMapper.insertSelective(problem);
    }
}
