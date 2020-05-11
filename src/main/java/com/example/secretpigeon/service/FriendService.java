package com.example.secretpigeon.service;

import com.example.secretpigeon.SecretPigeonApplication;
import com.example.secretpigeon.dao.FriendAddressDao;
import com.example.secretpigeon.dao.FriendDao;
import com.example.secretpigeon.entity.FriendAddressEntity;
import com.example.secretpigeon.entity.FriendEntity;
import com.example.secretpigeon.unit.IpUtil;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class FriendService {
    @Resource
    @Getter
    private FriendDao friendDao;
    @Resource
    private FriendAddressDao friendAddressDao;


    public void add(String hash) {
        FriendEntity entity = new FriendEntity();
        entity.setId(hash);
        entity.setVersion(new Date());
        friendDao.save(entity);
    }

    public void address(String hash, FriendAddressEntity address) {
        address.setFid(hash);
        friendAddressDao.save(address);
    }

    public Page<FriendEntity> list(int page, int size, String name) {
        return friendDao.findAll(PageRequest.of(page, size));
    }

    /**
     * 查找id，并记录他的连接
     *
     * @param id .
     */
    public void connect(String id) {
        ServerProperties bean = SecretPigeonApplication.getRun().getBean(ServerProperties.class);
        bean.getPort();

        List<String> myAllIp = IpUtil.getMyAllIp();
        // todo 向一个公共地址发送本机的连接方式
    }
}
