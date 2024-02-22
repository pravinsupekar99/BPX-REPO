package com.BPX.TASK1.DAO;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class StationClass {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private boolean startStation;
	    private boolean lastStation;
	    private int price;
	    
	 
		
		public StationClass( String name, boolean startStation, boolean lastStation, int price) {
			super();
 			this.name = name;
			this.startStation = startStation;
			this.lastStation = lastStation;
			this.price = price;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean isStartStation() {
			return startStation;
		}
		public void setStartStation(boolean startStation) {
			this.startStation = startStation;
		}
		public boolean isLastStation() {
			return lastStation;
		}
		public void setLastStation(boolean lastStation) {
			this.lastStation = lastStation;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}

	    
	}


