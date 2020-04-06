package com.square.service;

import com.github.pagehelper.PageInfo;
import com.square.model.Spit;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/4
 * Description:
 */
public interface SpitService {

    List<Spit> findAll();

    Spit findById(String id);

    void save(Spit spit);

    void modify(Spit spit);

    int delete(String spitId);

    PageInfo<Spit> findSpitList(String parentId, int page, int size);

    void thumbup(String spitId);
}
