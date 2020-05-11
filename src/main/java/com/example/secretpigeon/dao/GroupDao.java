package com.example.secretpigeon.dao;

import com.example.secretpigeon.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<GroupEntity, String> {
}
