package com.square.dao;

import com.square.model.Recruit;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description:
 */
public interface RecruitMapper {
    /**
     * 分页查询所有的
     *
     * @param
     * @return
     */
    List<Recruit> selectList(Recruit recruit);

    /**
     * 通过ID 查询
     *
     * @param id
     * @return
     */
    Recruit selectById(String id);

    /**
     * 插入
     *
     * @param recruit
     * @return
     */
    int insert(Recruit recruit);

    /**
     * 更新
     *
     * @param recruit
     * @return
     */
    int update(Recruit recruit);

    /**
     * 通过ID删除
     *
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 推荐的职位
     *
     * @param state 2
     * @return
     */
    List<Recruit> findTopBy(String state);


    /**
     * 查找最新职位
     *
     * @param state
     * @return
     */
    List<Recruit> selectnewJob(String state);
}
