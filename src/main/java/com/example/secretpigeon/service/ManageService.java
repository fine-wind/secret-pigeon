package com.example.secretpigeon.service;

import com.example.secretpigeon.dao.GroupDao;
import com.example.secretpigeon.dao.ManageDao;
import com.example.secretpigeon.entity.GroupEntity;
import com.example.secretpigeon.entity.ManageEntity;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Log4j2
@Service
public class ManageService {
    @Resource
    private ManageDao manageDao;
    @Resource
    private GroupDao groupDao;

    public List<ManageEntity> group(int page, String group, String myId) {
        /* todo jpa 打印日志 帮助处理sql*/
        return manageDao.findAll(Example.of(new ManageEntity().setG(group)), Sort.by(Sort.Direction.DESC, "toDt"));
    }

    @Transactional
    public void sendMsg(String me, String group, String msg) {

        Optional<GroupEntity> byId = groupDao.findById(group);
        GroupEntity groupEntity = byId.orElseGet(GroupEntity::new);
        groupDao.save(groupEntity.addVersion());

        ManageEntity entity = new ManageEntity();

        long count = manageDao.count(Example.of(new ManageEntity().setCome(me)));
        entity
                .setG(group)
                .setCome(me)
                .setMsg(msg)
                .setSort(count)
                .setSendDt(new Date())
                .setToDt(new Date());
        manageDao.save(entity);
    }

    /**
     * todo scan network
     */
    @Scheduled(cron = "* * * * * *")
    public void loadMsg() {

    }

    public Map<String, Date> getGroup(String[] groups) {
        HashMap<String, Date> rb = new HashMap<>(1);
        if (!CollectionUtils.isEmpty(List.of(groups))) {
            for (String group : groups) {
                Optional<GroupEntity> byId = groupDao.findById(group);
                byId.ifPresent(groupEntity -> rb.put(group, groupEntity.getVersion()));
            }
        } else
            groupDao.findAll().forEach(g -> {
                rb.put(g.getId(), g.getVersion());
            });
        return rb;
    }

    public List<GroupEntity> myGroupAll() {
        return groupDao.findAll();
    }
}
