package com.square.service;

import com.github.pagehelper.PageInfo;
import com.square.model.Problem;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/27
 * Description:问答
 */
public interface ProblemService {

    PageInfo<Problem> findProblemList(String labelId, int page, int size);

    PageInfo<Problem> findHotListProblem(String labelId, int page, int size);

    PageInfo<Problem> findWaitListProblem(String labelId, int page, int size);

    void add(Problem problem);
}
