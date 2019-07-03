
public class Hotel {

	static final int DEFAULT_SIZE = 50;
	private Room[] rooms;
	private int count; 
	
	public Hotel(int numOfRoom) {
		if (numOfRoom <20 || numOfRoom > 100)
			rooms = new Room[DEFAULT_SIZE];
		else
			rooms = new Room[numOfRoom];
		task1();
		task2();
		task3();
	}
	
	private void task1(){
		count = 0;
		for(int i = 0; i< rooms.length; i++)
			rooms[i] = new Room();
	}
	
	private void task2(){
		rooms[0].setRoomTariff(15000.00);
		for (int i =0; i < rooms.length ; i++){
			if (i%2 == 0 && i != 0)
				rooms[i].setRoomTariff(150.00);
		}
	}
	
	private void task3(){
		for (int i =0; i < rooms.length ; i++)
			if( i== rooms.length -5 || i== rooms.length -4|| i== rooms.length -3|| i== rooms.length -2 ||i== rooms.length -1)
				rooms[i].setNumOfBed(1);
		for (int i =0; i < rooms.length ; i++)
			if( i==1 || i==2 || i==3 || i==4 || i==5)
				rooms[i].setNumOfBed(4);
		}
	
	

	public Room getRoom(int roomNo) {
		if (roomNo > rooms.length || roomNo < 0)
			return null;
		else
			return rooms[roomNo];
	}
	
	public int numOfBookedRooms(){
		count = 0;
		for (int i = 0; i < rooms.length; i++)
			if(rooms[i].isBooked() ==true){
				count ++;}
				
			return count;
		}
	
	public int numOfVacantRooms(){
		count = 0;
		for (int i = 0; i < rooms.length; i++)
			if(rooms[i].isBooked() ==false)
				count ++;
			return count;
		}	
	
	public double totalTariff(){
		double sum = 0.00;
		for (int i = 0; i<rooms.length; i++)
			if(rooms[i].isBooked() == true)
				sum = sum + rooms[i].getRoomTariff();
		return sum;
	}
	
	//B1402009 ,To calculate the bill with GST included
	public double GST(double sum){
		double total =0.00;
		total = sum*106/100;
		return total;
	}
	
	public String getAvailableRooms(int guestNum){
		String roomNo = "";
		for (int i = 0; i<rooms.length; i++)
			if(rooms[i].getNumOfBed() >= guestNum )
				if(rooms[i].isBooked() == false)
					roomNo = roomNo + i +" ";
		return roomNo;
	}
	
	public int findGuestRoomNumber(String guestName){
		for (int i = 0; i<rooms.length; i++)
			if(rooms[i].getGuestName().equalsIgnoreCase(guestName))
				return i;
		return -1;
	}
	
}

