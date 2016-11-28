package com.example.dwight.bathroomappv2;

/**
 *  Created by Mike on 11/16/2016.
 */

public class Bathroom
{
	private int bath_id;
	private String bath_gend; // M(ale), F(emale), or A(ll)
	private String bath_handi_access;
	private String bath_single;
	private String bath_change_table;
	private String bath_lockers;
	private String bath_showers;
	private int bath_room_id;
	
	public Bathroom()
	{
		
	}
	
	// Set gender with M, F, or A
	// Other chars set with Y or N
	public Bathroom(int id, String gender, String handicap, String single, String change_table, String lockers, String showers, int bath_room_id)
	{
		this.bath_id=id;
		this.bath_gend=gender;
		this.bath_handi_access=handicap;
		this.bath_single=single;
		this.bath_change_table=change_table;
		this.bath_lockers=lockers;
		this.bath_showers=showers;
		this.bath_room_id=bath_room_id;
	}

	/* Set */
	
	public void setID(int id) 
	{
		this.bath_id=id;
	}

	// Set gender with M, F, or A	
	public void setGender(String gender)
	{
		this.bath_gend=gender;
	}
	
	//set with Y or N
	public void setHandiAccess(String handicap)
	{
		this.bath_handi_access = handicap;
	}

	public void setSingle(String single)
	{
		this.bath_single=single;
	}

	public void setChangeTable(String change_table)
	{
		this.bath_change_table=change_table;
	}

	public void setLockers(String lockers)
	{
		this.bath_lockers=lockers;
	}

	public void setShowers(String showers)
	{
		this.bath_showers=showers;
	}

	public void setRoomID(int room_id)
	{
		this.bath_room_id = room_id;
	}


	/* Get */
	
	public int getID()
	{
		return bath_id;
	}
	
	public String getGender()
	{
		return bath_gend;
	}

	public String getHandiAccess()
	{
		return bath_handi_access;
	}

	public String getSingle()
	{
		return bath_single;
	}

	public String getChangeTable()
	{
		return bath_change_table;
	}

	public String getLockers()
	{
		return bath_lockers;
	}

	public String getShowers()
	{
		return bath_showers;
	}

	public int getRoomID()
	{
		return bath_room_id;
	}

}
	