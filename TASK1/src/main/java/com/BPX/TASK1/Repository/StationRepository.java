package com.BPX.TASK1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BPX.TASK1.DAO.StationClass;

public interface StationRepository extends JpaRepository<StationClass, Long> {
	
}

