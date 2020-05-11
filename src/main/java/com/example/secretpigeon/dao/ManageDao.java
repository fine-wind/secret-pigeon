package com.example.secretpigeon.dao;

import com.example.secretpigeon.entity.ManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageDao extends JpaRepository<ManageEntity, String> {
}
