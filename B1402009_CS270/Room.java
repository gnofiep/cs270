
public class Room {

	private int numOfBed;
	private String guestName;
	private boolean statusRoom;
	private double roomTariff;
	
	public Room (){
		numOfBed = 2;
		guestName = "Nobody";
		statusRoom = false;
		roomTariff = 100.00;
	}
	
	public void setNumOfBed (int numOfBedIn)
	{
		if (numOfBed >=1 && numOfBed<=4)
			numOfBed = numOfBedIn;
	}
	
	public void setRoomTariff (double roomTariffIn)
	{
		if(roomTariff <0)
		roomTariff = -roomTariffIn;
		else
			roomTariff = roomTariffIn;
	}

	public void book (String guestNameIn)
	{
		statusRoom = true;
		guestName = guestNameIn;
	}

	public void unbook(){
		statusRoom = false;
		guestName = "Nobody";
	}
	
	public int getNumOfBed() {
		return numOfBed;
	}

	public String getGuestName() {
		return guestName;
	}

	public double getRoomTariff() {
		return roomTariff;
	}
	
	public boolean isBooked(){
		return statusRoom;
	}
	
	public String toString(){
		if (!guestName.equals("Nobody"))
		return "Room with "+numOfBed+" beds, tariff "+roomTariff +", and guest"
				+ " name "+guestName+".";
		else
			return "Room with "+numOfBed+" beds, tariff "+ roomTariff+", and is"
			+" vacant.";
				
	}
	
}
