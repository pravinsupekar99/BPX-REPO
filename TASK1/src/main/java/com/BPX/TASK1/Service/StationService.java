package com.BPX.TASK1.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BPX.TASK1.DAO.StationClass;
import com.BPX.TASK1.Repository.StationRepository;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public StationClass addStation(StationClass station) {
        return stationRepository.save(station);
    }
 
    public void insertStationData() {
        // Create Station objects
        StationClass stationA = new StationClass("A", true, false, 0);
        StationClass stationB = new StationClass("B", false, false, 5);
        StationClass stationC = new StationClass("C", false, false, 15);
        StationClass stationD = new StationClass("D", false, false, 50);
        // Create more stations as needed
        
        stationRepository.save(stationA);
        stationRepository.save(stationB);
        stationRepository.save(stationC);
        stationRepository.save(stationD);
        
    }
 
    
    public void insertStations(Map<String, StationClass> stations) {
         
        stationRepository.saveAll(stations.values());
  
    }
}
