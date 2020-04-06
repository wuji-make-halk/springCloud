package com.square.dao;

import com.square.model.Label;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/18
 * Description:
 */
public interface LabelMapper {

    /**
     * 查找所有的
     *
     * @return
     */
    List<Label> getLabelList();

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Label selectByPrimaryKey(String id);

    /**
     * 新增
     *
     * @param label
     * @return
     */
    int saveLabel(Label label);

    /**
     * 修改
     *
     * @param label
     * @return
     */
    int updateLabel(Label label);


    /**
     * 删除
     *
     * @param labelId
     * @return
     */

    int deleteByPrimaryKey(String labelId);

    /**
     * 按照条件查询所有的
     *
     * @param label
     * @return
     */
    List<Label> LabelList(Label label);

    /**
     * 按条件分页查询
     *
     * @param label
     * @return
     */
    List<Label> pageQueryLabel(Label label);
}
