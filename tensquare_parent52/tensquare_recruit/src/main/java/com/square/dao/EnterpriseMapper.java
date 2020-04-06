package com.square.dao;

import com.square.model.Enterprise;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description: 企业接口
 */
public interface EnterpriseMapper {
    /**
     * 分页查询所有的
     *
     * @param enterprise
     * @return
     */
    List<Enterprise> selectList(Enterprise enterprise);

    /**
     * 通过ID 查询
     *
     * @param id
     * @return
     */
    Enterprise selectById(String id);

    /**
     * 插入
     *
     * @param enterprise
     * @return
     */
    int insert(Enterprise enterprise);

    /**
     * 更新
     *
     * @param enterprise
     * @return
     */
    int update(Enterprise enterprise);

    /**
     * 通过ID删除
     *
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 是否是热门企业
     *
     * @param ishot
     * @return
     */
    List<Enterprise> findByIshot(String ishot);

}
