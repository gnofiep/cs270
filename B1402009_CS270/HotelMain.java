import java.util.Scanner;

public class HotelMain {

	static Scanner kbd;
	static Hotel hotel;
	
	public static void displayMenu(){
		System.out.println("What would you like to do?");
		System.out.println("Press 1 to check any room available for the guests");
		System.out.println("Press 2 to book a room.");
		System.out.println("Press 3 to unbook a room.");
		System.out.println("Press 4 to find guest's room number.");
		System.out.println("Press 5 to print a report.");
		System.out.println("Press 6 to find the total bill with 6% GST included.");
		System.out.println("Press 7 to quit."); 
	}
	
	public static void report(){
		System.out.println("The number of booked rooms is "+hotel.numOfBookedRooms()+" .");
		System.out.println("The number of empty rooms is "+hotel.numOfVacantRooms()+ " .");
		System.out.println("The total tariff of all booked rooms is $"+hotel.totalTariff()+" .\n");
	}
	
	public static void main(String[] args) {

		kbd = new Scanner(System.in);
		System.out.println("Please enter the size of the hotel: ");
		int size = kbd.nextInt();
		hotel = new Hotel(size);
		int choice;
		do {
		displayMenu();
		choice = kbd.nextInt();
		switch (choice){
		case 1 ://B1402009 ,find room avaialble
			System.out.println("Enter number of guests: ");
			int guestNo = kbd.nextInt();
			System.out.println(hotel.getAvailableRooms(guestNo)+"\n");
			break;
		case 2 ://B1402009 ,book a room
			System.out.print("Enter a room number: ");
			int roomNo = kbd.nextInt();
			Room fRoom = hotel.getRoom(roomNo);
			if (fRoom.isBooked() )
				System.out.println("The room is not available.\n");
			else
			{
				System.out.println("Enter guest name: ");
				kbd.nextLine().trim();
				String guestName = kbd.nextLine();
				fRoom.book(guestName);
				System.out.println("");
			}
			break;
		case 3 ://B1402009 ,unbook a room
			System.out.print("Enter a room number: ");
			roomNo = kbd.nextInt();
			fRoom = hotel.getRoom(roomNo);
			if (fRoom.isBooked()){
				fRoom.unbook();
				System.out.println("");
				}
			else
				System.out.println("The room is not occupied.");
			break;
		case 4 ://B1402009 ,search room of the guest
			System.out.println("Enter guest name: ");
			kbd.nextLine().trim();
			String searchGuestName = kbd.nextLine();
			int guestRoom = hotel.findGuestRoomNumber(searchGuestName);
			if (guestRoom != -1)
				System.out.println("The guest is in room number " + guestRoom+".\n");
			else
				System.out.println("The guest is not found.\n");
			break;
		case 5 ://B1402009 ,print report
			report();
			break;
		case 6 ://B1402009 ,find the total bill with 6% GST
			double sum = hotel.totalTariff();
			System.out.println("The total bill with 6% GST is "+hotel.GST(sum));
			break;
		case 7 ://B1402009 ,quit the program
			System.out.println("The hotel is closed, please come again tomorrow!");
			break;
		}}
		while(choice != 7);
	}


}
