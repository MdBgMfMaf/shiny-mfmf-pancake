package com.gmail.tmorioka123.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.tmorioka123.PbSetting;

@Repository
public interface PbSettingRepository extends JpaRepository<PbSetting, Integer>{
	public Optional<PbSetting> findById(Integer n);
}
