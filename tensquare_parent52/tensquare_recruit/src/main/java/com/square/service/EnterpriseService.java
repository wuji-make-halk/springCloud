package com.square.service;

import com.github.pagehelper.PageInfo;
import com.square.model.Enterprise;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description:
 */
public interface EnterpriseService {
    /**
     * 按照条件分页查询
     *
     * @param page
     * @param size
     * @return
     */
    PageInfo<Enterprise> findEnterpriseList(Enterprise enterprise, int page, int size);

    /**
     * 通过ID进行查询
     *
     * @param id
     * @return
     */
    Enterprise findEnterpriseById(String id);

    /**
     * 新增
     *
     * @param enterprise
     * @return
     */
    int add(Enterprise enterprise);

    /**
     * 更新
     *
     * @param enterprise
     * @return
     */
    int modify(Enterprise enterprise);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int remove(String id);

    /**
     * 是否是热门企业
     *
     * @param ishot
     * @return
     */
    List<Enterprise> listIsHot(String ishot);
}
