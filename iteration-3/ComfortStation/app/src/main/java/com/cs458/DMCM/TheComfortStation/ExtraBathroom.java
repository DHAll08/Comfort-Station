package com.cs458.DMCM.TheComfortStation;

/**
 * Created by Michael on 11/27/2016.
 */

/*
     About: ExtraBathroom contains a Bathroom's handicap access, whether or not it's a single room, has change tables,
            has lockers, and has showers
     For: For accessing specific info from the SQLite database about bathrooms, to show in a Toast (popup) module open selection
          of a Bathroom in the ListView module of the AmenityList activity page.
*/

public class ExtraBathroom
{
    private String bath_handi_access;
    private String bath_single;
    private String bath_change_table;
    private String bath_lockers;
    private String bath_showers;

    //create new BasicBathroom
    public ExtraBathroom(String handi,String single, String change, String lockers, String showers)
    {
        this.bath_handi_access = handi;
        this.bath_single = single;
        this.bath_change_table = change;
        this.bath_lockers = lockers;
        this.bath_showers = showers;
    }
    
    /* 
        Set methods
    */

    public void setHandi(String handi)
    {
        this.bath_handi_access = handi;
    }

    public void setSingle(String single)
    {
        this.bath_single = single;
    }

    public void setChange(String change)
    {
        this.bath_change_table = change;
    }

    public void setLockers(String lockers)
    {
        this.bath_lockers = lockers;
    }

    public void setShowers(String showers)
    {
        this.bath_showers = showers;
    }
    
    
    /* 
        Get functions
    */

    public String getHandi()
    {
        String info = this.bath_handi_access;
        if(info.equals("1"))
        {
            info="Handicap accessible";
        }
        else if(info.equals("0"))
        {
            info="Not handicap accessible";
        }
        else
        {
            info="[Handicap accessible?]";
        }
        return info;
    }

    public String getSingle()
    {
        String info = this.bath_single;
        if(info.equals("1"))
        {
            info="Not single";
        }
        else if(info.equals("0"))
        {
            info="Single";
        }
        else
        {
            info="[Single?]";
        }
        return info;
    }

    public String getChange()
    {
        String info = this.bath_change_table;
        if(info.equals("1"))
        {
            info="Change table";
        }
        else if(info.equals("0"))
        {
            info="No change table";
        }
        else
        {
            info="[Change table?]";
        }
        return info;
    }

    public String getLockers()
    {
        String info = this.bath_lockers;
        if(info.equals("1"))
        {
            info="Lockers";
        }
        else if(info.equals("0"))
        {
            info="No lockers";
        }
        else
        {
            info="[Lockers?]";
        }
        return info;
    }

    public String getShowers()
    {
        String info = this.bath_showers;
        if(info.equals("1"))
        {
            info="Showers";
        }
        else if(info.equals("0"))
        {
            info="No showers";
        }
        else
        {
            info="[Showers?]";
        }
        return info;
    }
}
