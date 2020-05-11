package com.example.secretpigeon.dao;

import com.example.secretpigeon.entity.FriendAddressEntity;
import com.example.secretpigeon.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendAddressDao extends JpaRepository<FriendAddressEntity, String> {
}
