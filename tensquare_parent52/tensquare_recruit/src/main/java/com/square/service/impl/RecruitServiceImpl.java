package com.square.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.square.dao.RecruitMapper;
import com.square.model.Recruit;
import com.square.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description:
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitMapper recruitMapper;

    @Override
    public PageInfo<Recruit> findRecruitList(Recruit recruit, int page, int size) {
        if (page < 1 || size < 0) {

        }
        PageHelper.startPage(page, size);
        List<Recruit> recruitList = recruitMapper.selectList(recruit);
        long total = ((Page) recruitList).getTotal();
        PageInfo<Recruit> recruitPageInfo = new PageInfo<>(recruitList);
        recruitPageInfo.setTotal(total);
        return recruitPageInfo;
    }

    @Override
    public Recruit findRecruitById(String id) {
        Recruit recruit = recruitMapper.selectById(id);
        return recruit;
    }

    @Override
    public int add(Recruit recruit) {
        int result = 0;
        result = recruitMapper.insert(recruit);
        return result;
    }

    @Override
    public int modify(Recruit recruit) {
        int result = 0;
        result = recruitMapper.update(recruit);
        return result;
    }

    @Override
    public int remove(String id) {
        int result = 0;
        result = recruitMapper.deleteById(id);
        return result;
    }

    @Override
    public List<Recruit> findTop(String state) {
        List<Recruit> recruits = recruitMapper.findTopBy(state);
        return recruits;
    }

    @Override
    public List<Recruit> findnewJod(String state) {
        List<Recruit> recruits = recruitMapper.selectnewJob(state);
        return recruits;
    }
}
