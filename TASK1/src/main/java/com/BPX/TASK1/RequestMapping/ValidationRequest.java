package com.BPX.TASK1.RequestMapping;

public class ValidationRequest {
	 private Long ticketId;
	    private String station;
	    private boolean entering;
	    
	    
		public Long getTicketId() {
			return ticketId;
		}
		public void setTicketId(Long ticketId) {
			this.ticketId = ticketId;
		}
		public String getStation() {
			return station;
		}
		public void setStation(String station) {
			this.station = station;
		}
		public boolean isEntering() {
			return entering;
		}
		public void setEntering(boolean entering) {
			this.entering = entering;
		}
	    
	    
	    
}
