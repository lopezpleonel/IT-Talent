package com.it_talent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it_talent.model.Phones;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, String> {

}
