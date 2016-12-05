package com.cs458.DMCM.TheComfortStation;

/**
 * Created by Michael on 11/27/2016.
 */

/*
     About: BasicBathroom contains a Bathroom's gender and floor number only
     For: For accessing specific info from the SQLite database about bathrooms, to show in the ListView module
          of the AmenityList 
*/

public class BasicBathroom
{
    private String bath_gend; // M(ale), F(emale), or A(ll)
    private String floor_num;

    //create new BasicBathroom
    public BasicBathroom(String number,String gender)
    {
        this.floor_num = number;
        this.bath_gend = gender;
    }
    
    /* 
        Set methods 
    */
    
    //set floor number
    public void setFloorNum(String floor_num)
    {
        this.floor_num = floor_num;
    }

    //set bathroom gender
    public void setGender(String gender)
    {
        this.floor_num = gender;
    }
    
    
    /* 
        Get functions 
    */

    //get bathroom gender
    public String getGender()
    {
        // switch single character values to longer String here if we want
        //   ex  if U, return Unisex
        String info;
        if(this.bath_gend.equals("M"))
        {
            info = "Men";
        }
        else if(this.bath_gend.equals("W"))
        {
            info = "Women";
        }
        else
        {
            info = "Unisex";
        }
        return info;
    }

    //get floor num
    public String getFloorNum()
    {
        // switch single character values to longer String?
        // ex 1 = Floor 1 ?
        return "Floor " + this.floor_num;
    }

}
