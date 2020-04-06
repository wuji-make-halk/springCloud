package com.square.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.square.model.Spit;
import com.square.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/4
 * Description:
 */
@Service
public class SpitServiceImpl implements SpitService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Spit> findAll() {
        List<Spit> spits = mongoTemplate.findAll(Spit.class);
        return spits;
    }

    @Override
    public Spit findById(String id) {
        Spit spit = mongoTemplate.findById(id, Spit.class);
        return spit;
    }

    @Override
    public void save(Spit spit) {
        spit.setPublishTime(new Date());
        spit.setVisits(0);
        spit.setShare(0);
        spit.setThumbup(0);
        spit.setComment(0);
        spit.setState("1");
        // 如果当前添加的吐槽，有父节点，那么吐槽的的回复数要+1
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
        mongoTemplate.save(spit);
    }

    @Override
    public void modify(Spit spit) {
        mongoTemplate.update(spit.getClass());
    }

    @Override
    public int delete(String spitId) {
        int result = 0;
        Spit spit = findById(spitId);
        mongoTemplate.remove(spit);
        return result;
    }

    @Override
    public PageInfo<Spit> findSpitList(String parentId, int page, int size) {
        if (page < 1 || size < 0) {

        }
        PageHelper.startPage(page, size);
        Query query = new Query();
        Criteria criteria = Criteria.where("parentid").is(parentId);
        query.addCriteria(criteria);
        List<Spit> spits = mongoTemplate.find(query, Spit.class);
        for (Spit spit : spits) {
            System.out.println("测试看看:" + spit.get_id() + "\n" + spit.getParentid() + "\n" + spit.toString());
        }
        long total = ((Page) spits).getTotal();
        PageInfo<Spit> spitPageInfo = new PageInfo<>(spits);
        spitPageInfo.setTotal(total);
        return spitPageInfo;
    }

    @Override
    public void thumbup(String spitId) {
        // 方式一
        /*Spit spit = mongoTemplate.findById(spitId,Spit.class);
        spit.setThumbup((spit.getThumbup() == null ?0 :spit.getThumbup())+1);
        mongoTemplate.save(spit);*/
        // 方式二， 只操作了一次数据库，推荐这种 db.spit.update({"_id":1},{$inc:{thumbup:NumberInt(1)}})
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(spitId));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }
}
