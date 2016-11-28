package com.example.dwight.bathroomappv2;

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

        public CompBasic(String floorNum, String roomNum)
        {
            this.floor_num = floorNum;
            this.room_num = roomNum;
        }

        public void setFloorNum(String floor_num)
        {
            this.floor_num = floor_num;
        }

        public void setGender(String room_num)
        {
            this.room_num = room_num;
        }

        public String getFloorNum()
        {
            return "Floor " + this.floor_num;
        }

        public String getRoomNum()
        {
            return "Room " + this.room_num;
        }

    }


