package com.gmail.tmorioka123.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.tmorioka123.ETypeSetting;

@Repository
public interface ETypeSettingRepository extends JpaRepository<ETypeSetting, Integer>{
	public Optional<ETypeSetting> findById(Integer n);
}
