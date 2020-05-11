package com.example.secretpigeon.dao;

import com.example.secretpigeon.entity.FriendEntity;
import com.example.secretpigeon.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendDao extends JpaRepository<FriendEntity, String> {
}
