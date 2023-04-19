package com.gmail.tmorioka123.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.tmorioka123.RRTypeSetting;

@Repository
public interface RRTypeSettingRepository extends JpaRepository<RRTypeSetting, Integer>{
	public Optional<RRTypeSetting> findById(Integer n);
}
