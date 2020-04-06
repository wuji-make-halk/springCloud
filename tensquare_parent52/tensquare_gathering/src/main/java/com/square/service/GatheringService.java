package com.square.service;

import com.square.model.Gathering;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/29
 * Description:
 */
public interface GatheringService {
    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Gathering findById(String id);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int remove(String id);
}
