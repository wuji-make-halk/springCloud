package com.square.service;

import com.github.pagehelper.PageInfo;
import com.square.model.Recruit;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description:
 */
public interface RecruitService {
    /**
     * 按照条件分页查询
     *
     * @param page
     * @param size
     * @return
     */
    PageInfo<Recruit> findRecruitList(Recruit recruit, int page, int size);

    /**
     * 通过ID进行查询
     *
     * @param id
     * @return
     */
    Recruit findRecruitById(String id);

    /**
     * 新增
     *
     * @param
     * @return
     */
    int add(Recruit recruit);

    /**
     * 更新
     *
     * @param recruit
     * @return
     */
    int modify(Recruit recruit);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int remove(String id);

    /**
     * 推荐职位
     *
     * @param state
     * @return
     */
    List<Recruit> findTop(String state);

    /**
     * 最新职位
     *
     * @param state
     * @return
     */
    List<Recruit> findnewJod(String state);
}
