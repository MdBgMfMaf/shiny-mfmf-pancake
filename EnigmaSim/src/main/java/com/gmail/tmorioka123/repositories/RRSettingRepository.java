package com.gmail.tmorioka123.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.tmorioka123.RRSetting;

@Repository
public interface RRSettingRepository extends JpaRepository<RRSetting, Integer>{
	public Optional<RRSetting> findById(Integer n);
}
