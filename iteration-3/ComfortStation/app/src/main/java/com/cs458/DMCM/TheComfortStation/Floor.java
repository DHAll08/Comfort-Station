package com.cs458.DMCM.TheComfortStation;

/**
 * Created by Cameron on 11/15/2016.
 *  Updated by Mike on 11/16/2016.
 */

/*
    About: Floor has an unique ID, a floor number, and the building ID of the building it is within
    For:  For accessing Floor information from the SQLite database
*/

public class Floor
{
    private int floor_id;
    private String floor_num;
    private int build_id;

    public Floor()
    {

    }

    //create new floor
    public Floor(int floor_id,String floor_num,int build_id)
    {
        this.floor_id = floor_id;
        this.floor_num = floor_num;
        this.build_id = build_id;
    }
    
    /*
        Set methods
        - for setting information on Floor
    */

    //set floor id
    public void setFloorId(int floor_id)
    {
        this.floor_id = floor_id;
    }

    //set floor number
    public void setFloorNum(String floor_num)
    {
        this.floor_num = floor_num;
    }

    //set building floor belongs too
    public void setBuildID(int build_id)
    {
        this.build_id = build_id;
    }
    
    
    /* 
        Get functions 
        - for returning information about Floors
    */

    //get floor id
    public int getFloorId()
    {
        return floor_id;
    }

    //get floor number
    public String getFloorNum()
    {
        return floor_num;
    }

    //get building that floor belongs too
    public int getBuildID()
    {
        return build_id;
    }
}
