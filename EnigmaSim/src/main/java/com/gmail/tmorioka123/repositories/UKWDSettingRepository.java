package com.gmail.tmorioka123.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.tmorioka123.UKWDSetting;

@Repository
public interface UKWDSettingRepository extends JpaRepository<UKWDSetting, Integer>{
	public Optional<UKWDSetting> findById(Integer n);
}
