package com.it_talent.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it_talent.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
