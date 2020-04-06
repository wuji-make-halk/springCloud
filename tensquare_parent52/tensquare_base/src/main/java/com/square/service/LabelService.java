package com.square.service;

import com.github.pagehelper.PageInfo;
import com.square.model.Label;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/18
 * Description:
 */
public interface LabelService {

    /**
     * 查找所有的
     *
     * @return
     */
    List<Label> findAll();

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    Label getById(String id);

    /**
     * 新增
     *
     * @param label
     * @return
     */
    int insert(Label label);

    /**
     * 修改
     *
     * @param label
     * @return
     */
    int update(Label label);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 按条件查询
     *
     * @param label
     * @return
     */
    List<Label> findSearch(Label label);

    /**
     * 按条件分页查询
     *
     * @param label
     * @param page
     * @param size
     * @return
     */
    PageInfo<Label> pageQuery(Label label, int page, int size);

}
