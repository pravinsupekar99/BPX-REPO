package com.BPX.TASK1.DAO;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class TicketClass {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String startStation;
	    private String endStation;
	    private LocalDateTime expiryTime;
	    private int usageCount;
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getStartStation() {
			return startStation;
		}
		public void setStartStation(String startStation) {
			this.startStation = startStation;
		}
		public String getEndStation() {
			return endStation;
		}
		public void setEndStation(String endStation) {
			this.endStation = endStation;
		}
		public LocalDateTime getExpiryTime() {
			return expiryTime;
		}
		public void setExpiryTime(LocalDateTime expiryTime) {
			this.expiryTime = expiryTime;
		}
		public int getUsageCount() {
			return usageCount;
		}
		public void setUsageCount(int usageCount) {
			this.usageCount = usageCount;
		}
	    
	    
	    
}


