package com.cs458.DMCM.TheComfortStation;

/**
 *  Created by     
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
	
	public void setID(int id) 
	{
		this.build_id = id;
	}
	
	public void setName(String name)
	{
		this.build_name = name;
	}
	
	public int getID()
	{
		return build_id;
	}
	
	public String getName()
	{
		return build_name;
	}
}
		