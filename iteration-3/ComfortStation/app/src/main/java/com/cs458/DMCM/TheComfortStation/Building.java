package com.cs458.DMCM.TheComfortStation;

/**
 *  Created by Cameron on 11/15/2016   
 */

/*
	About: Building's have a unique ID and a name
	For: For acessing Building info from the SQLite database
*/

public class Building 
{
	private int build_id;
	private String build_name;
	
	public Building()
	{
		
	}
	
	public Building(int id, String name)
	{
		this.build_id=id;
		this.build_name=name;
	}
	
	/* Set methods */
	
	public void setID(int id) 
	{
		this.build_id = id;
	}
	
	public void setName(String name)
	{
		this.build_name = name;
	}
	
	/* Get functions */
	
	public int getID()
	{
		return build_id;
	}
	
	public String getName()
	{
		return build_name;
	}
}
		
