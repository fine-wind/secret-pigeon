package com.example.secretpigeon.service;

import com.example.secretpigeon.config.AppConfig;
import com.example.secretpigeon.dao.AccountDao;
import com.example.secretpigeon.entity.KeyPairEntity;
import com.example.secretpigeon.unit.KeyPairUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AccountService {
    @Resource
    private AccountDao accountDao;

    private final String ACCOUNT_ID = "ACCOUNT_ID";

    @Transactional
    public void create(int keySize, KeyPairEntity keyPair) {
        AtomicReference<String> hash = new AtomicReference<>();
        accountDao.findAll().forEach(e -> hash.set(e.getHash()));
        if (Objects.isNull(hash.get())) {
            hash.set(UUID.randomUUID().toString());
            KeyPairEntity account = KeyPairUtil.create(keySize);
            String name = StringUtils.hasLength(keyPair.getName()) ? keyPair.getName() : hash.get();
            accountDao.save(account.setId(ACCOUNT_ID).setName(name).setHash(hash.get()));
        }
        AppConfig.setHash(hash.get());
    }


    @Transactional
    public void update(String name) {
        Optional<KeyPairEntity> byId = accountDao.findById(ACCOUNT_ID);
        byId.ifPresent(keyPairEntity -> keyPairEntity.setName(name));
    }

    public KeyPairEntity my() {
        Optional<KeyPairEntity> byId = accountDao.findById(ACCOUNT_ID);
        return byId.orElse(null);
    }

    public void delete(String id) {
        accountDao.deleteById(id);
    }
}
