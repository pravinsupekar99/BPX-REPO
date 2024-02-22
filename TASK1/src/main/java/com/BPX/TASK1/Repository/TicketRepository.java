package com.BPX.TASK1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BPX.TASK1.DAO.TicketClass;

public interface TicketRepository extends JpaRepository<TicketClass, Long> {
	
}
