package src.com.stay.vo;

import com.stay.vo.Room;

import java.util.ArrayList;

public class GuestHouse {
	String id;
	String name;
	String address;
	
	ArrayList<Room> rooms = new ArrayList<>();

	public GuestHouse() {}
	
	public GuestHouse(String id, String name, String address, ArrayList<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rooms = rooms;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	@Override
	public String toString() {
		return "GuestHouse [id=" + id + ", name=" + name + ", address=" + address + ", rooms=" + rooms + "]";
	}

}
