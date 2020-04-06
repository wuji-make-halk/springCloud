package com.square.service.impl;

import com.square.dao.GatheringMapper;
import com.square.model.Gathering;
import com.square.service.GatheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/29
 * Description:
 */
@Service
public class GatheringServiceImpl implements GatheringService {
    @Autowired
    private GatheringMapper gatheringMapper;

    @Override
    @Cacheable(value = "Gathering", key = "#id")
    public Gathering findById(String id) {
        Gathering gathering = gatheringMapper.selectByPrimaryKey(id);
        return gathering;
    }

    @Override
    @CacheEvict(value = "Gathering", key = "#id")
    public int remove(String id) {
        int result = 0;
        result = gatheringMapper.deleteByPrimaryKey(id);
        return result;
    }


}
