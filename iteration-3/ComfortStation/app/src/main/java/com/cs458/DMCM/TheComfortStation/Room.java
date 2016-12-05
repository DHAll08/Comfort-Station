package com.cs458.DMCM.TheComfortStation;

/**
 *  Created by Mike on 11/16/2016.
 */

/*
	About:  Room has an ID, room number, room type (bathroom or complab), whether or not it
		has a charging station, and the floor ID of the specific floor it is on.
		
	For:  For use in accessing Room information from the SQLite databse
*/

public class Room
{
	private int room_id;
	private String room_num;	//String in case there is 150A, for example
	private String room_type;
	private String room_has_charge;
	private int floor_id;
	
	public Room()
	{
		
	}
	
	public Room(int id, String num, String type, String has_charge, int floor_id)
	{
		this.room_id=id;
		this.room_num=num;
		this.room_type=type;
		this.room_has_charge=has_charge;
		this.floor_id=floor_id;
		
	}

	/* 
		Set methods:
			 setID - for setting the ID 
			 setNum - for setting room number
			 setType - for setting type (bathroom or complab)
			 setHasCharge - for setting if it has a charging station
			 setFloorID - for setting floor ID that it is connected to
	*/
	
	public void setID(int id) 
	{
		this.room_id = id;
	}
	
	public void setNum(String roomNum)
	{
		this.room_num = roomNum;
	}

	public void setType(String type)
	{
		this.room_type = type;
	}

	public void setHasCharge(String has_charge)
	{
		this.room_has_charge = has_charge;
	}

	public void setFloorID(int floor_id)
	{
		this.floor_id = floor_id;
	}


	/* 
		Get methods:
			 getID - for getting the ID 
			 getNum - for getting room number
			 getType - for getting type (bathroom or complab)
			 getHasCharge - for getting if it has a charging station
			 getFloorID - for getting floor ID that it is connected to
	*/
	
	public int getID()
	{
		return room_id;
	}
	
	public String getNum()
	{
		return room_num;
	}

	public String getType()
	{
		return room_type;
	}

	public String getHasCharge()
	{
		return room_has_charge;
	}

	public int getFloorID()
	{
		return floor_id;
	}

}
	
