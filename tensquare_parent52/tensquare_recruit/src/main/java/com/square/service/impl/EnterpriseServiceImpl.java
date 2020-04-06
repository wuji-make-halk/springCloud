package com.square.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.square.dao.EnterpriseMapper;
import com.square.model.Enterprise;
import com.square.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/21
 * Description:
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public PageInfo<Enterprise> findEnterpriseList(Enterprise enterprise, int page, int size) {
        if (page < 1 || size < 0) {

        }
        PageHelper.startPage(page, size);
        List<Enterprise> enterpriseList = enterpriseMapper.selectList(enterprise);
        Long total = ((Page) enterpriseList).getTotal();
        PageInfo<Enterprise> pageResult = new PageInfo<>(enterpriseList);
        pageResult.setTotal(total);
        return pageResult;
    }

    @Override
    public Enterprise findEnterpriseById(String id) {
        Enterprise enterprise = enterpriseMapper.selectById(id);
        return enterprise;
    }

    @Override
    public int add(Enterprise enterprise) {
        int result = 0;
        result = enterpriseMapper.insert(enterprise);
        return result;
    }

    @Override
    public int modify(Enterprise enterprise) {
        int result = 0;
        result = enterpriseMapper.update(enterprise);
        return result;
    }

    @Override
    public int remove(String id) {
        int result = 0;
        result = enterpriseMapper.deleteById(id);
        return result;
    }

    @Override
    public List<Enterprise> listIsHot(String ishot) {
        List<Enterprise> enterprises = enterpriseMapper.findByIshot(ishot);
        return enterprises;
    }
}
