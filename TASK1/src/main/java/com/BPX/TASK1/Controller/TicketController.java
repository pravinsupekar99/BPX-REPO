package com.BPX.TASK1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BPX.TASK1.DAO.StationClass;
import com.BPX.TASK1.DAO.TicketClass;
import com.BPX.TASK1.RequestMapping.TicketRequest;
import com.BPX.TASK1.RequestMapping.ValidationRequest;
import com.BPX.TASK1.Service.StationService;
import com.BPX.TASK1.Service.TicketService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private StationService stationService;

    @PostMapping("/bookTicket")
    public TicketClass bookTicket(@RequestBody TicketRequest request) {
        return ticketService.bookTicket(request.getStartStation(), request.getEndStation());
    }

    @PostMapping("/validateTicket")
    public boolean validateTicket(@RequestBody ValidationRequest request) {
        return ticketService.validateTicket(request.getTicketId(), request.getStation(), request.isEntering());
    }
    
    @PostMapping("/stations")
    public ResponseEntity<String> addStations(@RequestBody Map<String, StationClass> stations) {
      //  stationRepository.saveAll(stations.values());
        try {
            stationService.insertStations(stations);
            return ResponseEntity.ok("Stations inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting stations: " + e.getMessage());
        }
    }
    
    @PostMapping("/insert")
    public ResponseEntity<String> insertStations(@RequestBody StationClass request) {
        try {
        	stationService.insertStationData();
            return ResponseEntity.ok("Stations inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting stations: " + e.getMessage());
        }
    }
}

