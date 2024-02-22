package com.BPX.TASK1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BPX.TASK1.DAO.TicketClass;
import com.BPX.TASK1.Repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class TicketService {
	

    @Autowired
    private TicketRepository ticketRepository;

    public TicketClass bookTicket(String startStation, String endStation) {
    	TicketClass ticket = new TicketClass();
        ticket.setStartStation(startStation);
        ticket.setEndStation(endStation);
        ticket.setExpiryTime(LocalDateTime.now().plusHours(18));
        ticket.setUsageCount(0);
        return ticketRepository.save(ticket);
    }

    public boolean validateTicket(Long ticketId, String station, boolean entering) {
    	TicketClass ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null && ticket.getExpiryTime().isAfter(LocalDateTime.now())) {
            if (entering) {
                if (ticket.getStartStation().equals(station) && ticket.getUsageCount() < 1) {
                    ticket.setUsageCount(ticket.getUsageCount() + 1);
                    ticketRepository.save(ticket);
                    return true;
                }
            } else {
                if (ticket.getEndStation().equals(station) && ticket.getUsageCount() == 1) {
                    ticket.setUsageCount(ticket.getUsageCount() + 1);
                    ticketRepository.save(ticket);
                    return true;
                }
            }
        }
        return false;
    }
	
}

