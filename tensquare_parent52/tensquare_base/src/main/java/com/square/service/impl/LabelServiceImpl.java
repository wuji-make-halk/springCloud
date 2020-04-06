package com.square.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.square.dao.LabelMapper;
import com.square.model.Label;
import com.square.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/18
 * Description:
 */
@Service
@Transactional
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;

    /* @Autowired
     private IdWorker  idWorker;*/
    @Override
    public List<Label> findAll() {
        List<Label> labels = labelMapper.getLabelList();
        return labels;
        //return  null;
    }

    @Override
    public Label getById(String id) {
        Label label = labelMapper.selectByPrimaryKey(id);
        return label;
        // return null;
    }

    @Override
    public int insert(Label label) {
        //  label.setId(idWorker.nextId()+"");
        int result = labelMapper.saveLabel(label);
        return result;
        // return 0;
    }

    @Override
    public int update(Label label) {
        int result = labelMapper.updateLabel(label);
        return result;
        //return  0;
    }

    @Override
    public int delete(String id) {
        int result = labelMapper.deleteByPrimaryKey(id);
        return result;
        // return 0;
    }

    @Override
    public List<Label> findSearch(Label label) {
        return labelMapper.LabelList(label);
    }

    @Override
    public PageInfo<Label> pageQuery(Label label, int page, int size) {
        if (page < 1 || size < 0) {

        }
        PageHelper.startPage(page, size);
        List<Label> labels = labelMapper.pageQueryLabel(label);
        long total = ((Page) labels).getTotal();
        PageInfo<Label> pageResult = new PageInfo<>(labels);
        pageResult.setTotal(total);
        return pageResult;
    }
}
