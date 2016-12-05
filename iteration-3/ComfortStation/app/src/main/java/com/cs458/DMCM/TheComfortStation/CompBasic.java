package com.cs458.DMCM.TheComfortStation;

/**
 * Created by Michael on 11/27/2016.
 */

public class CompBasic
{
     /**
     * Created by Michael on 11/27/2016.
     */
        private String floor_num;
        private String room_num;
        private String comp_num;

        public CompBasic(String floorNum, String roomNum, String compNum)
        {
            this.floor_num = floorNum;
            this.room_num = roomNum;
            this.comp_num = compNum;
        }

        public void setFloorNum(String floor_num)
        {
            this.floor_num = floor_num;
        }

        public void setRoomNum(String room_num)
        {
            this.room_num = room_num;
        }

        public void setcompNum(String num)
    {
        this.comp_num = num;
    }

        public String getFloorNum()
        {
            return "Floor " + this.floor_num;
        }

        public String getRoomNum()
        {
            return "Room " + this.room_num;
        }

        public String getCompNum()
        {
            return this.comp_num + " Computers";
        }

    }


