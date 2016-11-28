package com.example.dwight.bathroomappv2;

/**
 *  Created by Mike on 11/16/2016.
 */

public class CompLab
{
	private int comp_id;
	private int comp_num; 
	private int room_id;
	
	public CompLab()
	{
		
	}

	public CompLab(int id, int numberOfComputers, int room_id)
	{
		this.comp_id=id;
		this.comp_num=numberOfComputers;
		this.room_id=room_id;
	}

	/* Set */
	
	public void setID(int id) 
	{
		this.comp_id=id;
	}

	public void setNum(int numberOfComputers) 
	{
		this.comp_num=numberOfComputers;
	}

	public void setRoomID(int room_id)
	{
		this.room_id = room_id;
	}


	/* Get */
	
	public int getID()
	{
		return comp_id;
	}

	public int getCompNum()
	{
		return comp_num;
	}
	
	public int getRoomID()
	{
		return room_id;
	}

}
	