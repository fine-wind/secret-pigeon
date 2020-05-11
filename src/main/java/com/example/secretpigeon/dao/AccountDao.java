package com.example.secretpigeon.dao;

import com.example.secretpigeon.entity.KeyPairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<KeyPairEntity, String> {
}
