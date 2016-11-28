package com.example.dwight.bathroomappv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/*
Created by Cameron Shively
Date: 11-14-2016
Updated by Mike Tjoelker
Date: 11-18-2016
*/

public class DBHandler extends SQLiteOpenHelper
{
    //Version
    private static final int DATABASE_VERSION = 43;

    //Name
    private static final String DATABASE_NAME = "hsuCampus";

    //building table
    private static final String TABLE_BUILDINGS = "buildings";
    private static final String BUILD_ID = "build_id";
    private static final String BUILD_NAME = "build_name";

    //floor table
    private static final String TABLE_FLOORS = "floors";
    private static final String FLOOR_ID = "floor_id";
    private static final String FLOOR_NUM = "floor_num";

    //room table
    private static final String TABLE_ROOMS = "rooms";
    private static final String ROOM_ID = "room_id";
    private static final String ROOM_NUM = "room_num";
    private static final String ROOM_TYPE = "room_type";
    private static final String ROOM_HAS_CHARGE = "room_has_charge";

    //bathroom table
    private static final String TABLE_BATHROOMS = "bathrooms";
    private static final String BATH_ID = "bath_id";
    private static final String BATH_GEND = "bath_gend";
    private static final String BATH_HANDI_ACCESS = "bath_handi_access";
    private static final String BATH_SINGLE = "bath_single";
    private static final String BATH_CHANGE_TABLE = "bath_change_table";
    private static final String BATH_LOCKERS = "bath_lockers";
    private static final String BATH_SHOWERS = "bath_showers";
    private static final String BATH_ROOM_ID = "room_id";

    //complabs table
    private static final String TABLE_COMPLABS = "complabs";
    private static final String COMP_ID = "comp_id";
    private static final String COMP_NUM = "comp_num";


    public DBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_BUILDINGS_TABLE = "CREATE TABLE " + TABLE_BUILDINGS + "("
                + BUILD_ID + " INTEGER PRIMARY KEY," + BUILD_NAME + " TEXT" + ")";
        db.execSQL(CREATE_BUILDINGS_TABLE);

        String CREATE_FLOORS_TABLE = "CREATE TABLE " + TABLE_FLOORS+ "("
                + FLOOR_ID + " INTEGER PRIMARY KEY,"
                + FLOOR_NUM + " TEXT,"
                + BUILD_ID + " INTEGER,"
                + " FOREIGN KEY (" + BUILD_ID+ ") REFERENCES " + TABLE_BUILDINGS + "(" + BUILD_ID + "));";
        db.execSQL(CREATE_FLOORS_TABLE);

        String CREATE_ROOMS_TABLE = "CREATE TABLE " + TABLE_ROOMS+ "("
                + ROOM_ID + " INTEGER PRIMARY KEY,"
                + ROOM_NUM + " TEXT,"
                + ROOM_TYPE + " TEXT,"
                + ROOM_HAS_CHARGE + " TEXT,"
                + FLOOR_ID + " INTEGER,"
                + " FOREIGN KEY (" + FLOOR_ID + ") REFERENCES " + TABLE_FLOORS + "(" + FLOOR_ID + "));";
        db.execSQL(CREATE_ROOMS_TABLE);

        String CREATE_BATHROOMS_TABLE = "CREATE TABLE " + TABLE_BATHROOMS+ "("
                + BATH_ID + " INTEGER PRIMARY KEY,"
                + BATH_GEND + " TEXT,"
                + BATH_HANDI_ACCESS + " TEXT,"
                + BATH_SINGLE + " TEXT,"
                + BATH_CHANGE_TABLE + " TEXT,"
                + BATH_LOCKERS + " TEXT,"
                + BATH_SHOWERS + " TEXT,"
                + BATH_ROOM_ID + " INTEGER,"
                + " FOREIGN KEY (" + BATH_ROOM_ID + ") REFERENCES " + TABLE_ROOMS + "(" + ROOM_ID + "));";
        db.execSQL(CREATE_BATHROOMS_TABLE);

        String CREATE_COMPLABS_TABLE = "CREATE TABLE " + TABLE_COMPLABS+ "("
                + COMP_ID + " INTEGER PRIMARY KEY,"
                + COMP_NUM + " INTEGER,"
                + ROOM_ID + " INTEGER,"
                + " FOREIGN KEY (" + ROOM_ID + ") REFERENCES " + TABLE_ROOMS + "(" + ROOM_ID + "));";
        db.execSQL(CREATE_COMPLABS_TABLE);

    }

    //drop and create tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUILDINGS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FLOORS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BATHROOMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPLABS);
        onCreate(db);
    }

    /*
        ****************
            BUILDINGS
        ***************
    */

    //add a new building
    public void addBuilding(Building building)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BUILD_ID, building.getID());
        values.put(BUILD_NAME, building.getName());

        //insert row
        db.insert(TABLE_BUILDINGS, null, values);

        //close database
        db.close();
    }

    //get all buildings
    public List<Building> getAllBuildings()
    {
        List<Building> buildingList = new ArrayList<Building>();

        String selectQuery = "SELECT * FROM " + TABLE_BUILDINGS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do {
                Building building = new Building();
                building.setID(Integer.parseInt(cursor.getString(0)));
                building.setName(cursor.getString(1));

                buildingList.add(building);
            }

            while (cursor.moveToNext());

        }
        cursor.close();
        return buildingList;
    }


    //get all buildings
    public List<Building> getAllCompLabBuildings()
    {
        List<Building> buildingList = new ArrayList<Building>();

        //" + BUILD_ID + ", " + BUILD_NAME + ", " + ROOM_TYPE + "
        //String selectQuery = "SELECT * FROM " + TABLE_BUILDINGS + "WHERE " + ;
        String selectQuery = "SELECT DISTINCT " + BUILD_NAME + " FROM " + TABLE_ROOMS + "," + TABLE_FLOORS + "," + TABLE_BUILDINGS +
                " WHERE " + TABLE_ROOMS + "." + FLOOR_ID + " = " + TABLE_FLOORS + "." + FLOOR_ID + " AND " +
                TABLE_FLOORS + "." + BUILD_ID + " = " + TABLE_BUILDINGS + "." + BUILD_ID + " AND "
                + TABLE_ROOMS + "." + ROOM_TYPE + " LIKE '" + "L" + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do {
                //compLabs 3 - numComputers is 2nd
                //rooms 5 - roomNum is 2nd
                //floors 3 - floorNum is 2nd
                //buildings 2 -
                Building building = new Building();
                //building.setID(Integer.parseInt(cursor.getString(0)));
                building.setName(cursor.getString(0));

                buildingList.add(building);
            }

            while (cursor.moveToNext());

        }
        cursor.close();
        return buildingList;
    }


    //get building
    public Building getBuilding(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BUILDINGS, new String[] {BUILD_ID, BUILD_NAME}, BUILD_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
            Building contact = new Building(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1));

            cursor.close();
            return contact;

        }

        //return building
        return null;
    }

    /*
        ****************
            FLOORS
        ***************
    */
    //add a new floor
    public void addFloor(Floor floor)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FLOOR_ID, floor.getFloorId());
        values.put(FLOOR_NUM, floor.getFloorNum());
        values.put(BUILD_ID, floor.getBuildID());

        //insert row
        db.insert(TABLE_FLOORS, null, values);

        //close database
        db.close();
    }

    //get all floors
    public List<Floor> getAllFloors()
    {
        List<Floor> floorList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_FLOORS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do {
                Floor floor = new Floor();
                floor.setFloorId(Integer.parseInt(cursor.getString(0)));
                floor.setFloorNum(cursor.getString(1));
                floor.setBuildID(Integer.parseInt(cursor.getString(2)));
                floorList.add(floor);
            }

            while (cursor.moveToNext());

        }
        cursor.close();
        return floorList;
    }


    //get floor
    public Floor getFloor(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FLOORS, new String[] {FLOOR_ID, FLOOR_NUM}, FLOOR_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
            Floor contact = new Floor(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),Integer.parseInt(cursor.getString(2)));
            cursor.close();
            return contact;
        }

        //return building
        return null;
    }




    /*
       ****************
            ROOMS
       ***************
   */
    //add a new room
    public void addRoom(Room room)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ROOM_ID, room.getID());
        values.put(ROOM_NUM, room.getNum());
        values.put(ROOM_TYPE, room.getType());
        values.put(ROOM_HAS_CHARGE, room.getHasCharge());
        values.put(FLOOR_ID, room.getFloorID());

        //insert row
        db.insert(TABLE_ROOMS, null, values);

        //close database
        db.close();
    }

    //get all rooms
    public List<Room> getAllRooms()
    {
        List<Room> roomList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ROOMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do {
                Room room = new Room();
                room.setID(Integer.parseInt(cursor.getString(0)));
                room.setNum(cursor.getString(1));
                room.setType(cursor.getString(2));
                room.setHasCharge(cursor.getString(3));
                room.setFloorID(Integer.parseInt(cursor.getString(4)));
                roomList.add(room);
            }

            while (cursor.moveToNext());

        }
        cursor.close();
        return roomList;
    }


    //get room
    public Room getRoom(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ROOMS, new String[] {ROOM_ID, ROOM_NUM}, ROOM_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
            Room contact = new Room(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),Integer.parseInt(cursor.getString(4)));
            cursor.close();
            return contact;
        }
        return null;
    }



    /*
     ****************
        BATHROOMS
     ***************
    */
    //add a new bathroom
    public void addBathroom(Bathroom room)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BATH_ID, room.getID());
        values.put(BATH_GEND, room.getGender());
        values.put(BATH_HANDI_ACCESS, room.getHandiAccess());
        values.put(BATH_SINGLE, room.getSingle());
        values.put(BATH_CHANGE_TABLE, room.getChangeTable());
        values.put(BATH_LOCKERS, room.getLockers());
        values.put(BATH_SHOWERS, room.getShowers());
        values.put(ROOM_ID, room.getRoomID());

        //insert row
        db.insert(TABLE_BATHROOMS, null, values);

        //close database
        db.close();
    }

    //get all rooms
    public List<Bathroom> getAllBathrooms()
    {
        List<Bathroom> bathroomList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_BATHROOMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do {
                Bathroom room = new Bathroom();
                room.setID(Integer.parseInt(cursor.getString(0)));
                room.setGender(cursor.getString(1));
                room.setHandiAccess(cursor.getString(2));
                room.setSingle(cursor.getString(3));
                room.setChangeTable(cursor.getString(4));
                room.setLockers(cursor.getString(5));
                room.setShowers(cursor.getString(6));
                room.setRoomID(Integer.parseInt(cursor.getString(7)));
                bathroomList.add(room);
            }

            while (cursor.moveToNext());

        }
        cursor.close();
        return bathroomList;
    }


    //get room
    public Bathroom getBathroom(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BATHROOMS, new String[] {BATH_ID}, BATH_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
            Bathroom contact = new Bathroom(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),Integer.parseInt(cursor.getString(7)));
            cursor.close();
            return contact;
        }
        return null;
    }


    //get the count
    public int getBathroomCount(String build_name)
    {
        String countQuery = "SELECT DISTINCT * FROM " + TABLE_BATHROOMS + "," + TABLE_ROOMS  + "," + TABLE_FLOORS + "," + TABLE_BUILDINGS +

                " WHERE " + TABLE_BATHROOMS+"."+BATH_ROOM_ID + " = " +  TABLE_ROOMS+"."+ROOM_ID + " AND "
                + TABLE_ROOMS+"."+FLOOR_ID + " = " +  TABLE_FLOORS+"."+FLOOR_ID + " AND " +
                TABLE_FLOORS+"."+BUILD_ID + " = " +  TABLE_BUILDINGS+"."+BUILD_ID + " AND "
                + TABLE_BUILDINGS+"."+BUILD_NAME +  " LIKE '" + build_name + "'";



                /*+ ", " + TABLE_ROOMS + " WHERE " + TABLE_BATHROOMS.ROOM_ID =  + " IN (SELECT "
                + ROOM_ID + " FROM " + TABLE_ROOMS + ", " + TABLE_FLOORS + " WHERE " + FLOOR_ID + " IN (SELECT " + FLOOR_ID
                + " FROM " + TABLE_FLOORS + ", " + TABLE_BUILDINGS + " WHERE " + BUILD_ID + " IN (SELECT " + BUILD_ID + " FROM "
                + TABLE_BUILDINGS + " WHERE " + BUILD_NAME + " IN '" + build_name + "')))";*/



        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        //return count of bathrooms in chosen building
        return count;

    }

    //get basic bathroom info (floor, gender)
    public String[] getBathroomBasics(String build_name)
    {
        List<BasicBathroom> bathroomList = new ArrayList<>();
        String selectQuery = "SELECT DISTINCT " + FLOOR_NUM + ", " + BATH_GEND + " FROM  " + TABLE_BATHROOMS + "," + TABLE_ROOMS + "," + TABLE_FLOORS + "," + TABLE_BUILDINGS +
                " WHERE " + TABLE_BATHROOMS + "." + BATH_ROOM_ID + " = " + TABLE_ROOMS + "." + ROOM_ID + " AND "
                + TABLE_ROOMS + "." + FLOOR_ID + " = " + TABLE_FLOORS + "." + FLOOR_ID + " AND " +
                TABLE_FLOORS + "." + BUILD_ID + " = " + TABLE_BUILDINGS + "." + BUILD_ID + " AND "
                + TABLE_BUILDINGS + "." + BUILD_NAME + " LIKE '" + build_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                BasicBathroom room = new BasicBathroom(cursor.getString(0),cursor.getString(1));
                bathroomList.add(room);
            }
            while (cursor.moveToNext());
        }
        cursor.close();

        String[] bathList = new String[bathroomList.size()];
        for(int counter=0; counter < bathroomList.size(); counter++)
        {
            String info = bathroomList.get(counter).getFloorNum() + ", " + bathroomList.get(counter).getGender();
            bathList[counter]= info;
        }

        return bathList;
    }

    //get extra bathroom info (handicap accessible, single, change table, lockers, showers)
    public String[] getBathroomExtras(String build_name)
    {
        List<ExtraBathroom> bathroomList = new ArrayList<>();
        String selectQuery = "SELECT DISTINCT " + FLOOR_NUM + ", " + BATH_GEND + ", " + BATH_HANDI_ACCESS + ", " + BATH_SINGLE + ", " + BATH_CHANGE_TABLE + ", " + BATH_LOCKERS + ", " + BATH_SHOWERS + " FROM  " + TABLE_BATHROOMS + "," + TABLE_ROOMS + "," + TABLE_FLOORS + "," + TABLE_BUILDINGS +
                " WHERE " + TABLE_BATHROOMS + "." + BATH_ROOM_ID + " = " + TABLE_ROOMS + "." + ROOM_ID + " AND "
                + TABLE_ROOMS + "." + FLOOR_ID + " = " + TABLE_FLOORS + "." + FLOOR_ID + " AND " +
                TABLE_FLOORS + "." + BUILD_ID + " = " + TABLE_BUILDINGS + "." + BUILD_ID + " AND "
                + TABLE_BUILDINGS + "." + BUILD_NAME + " LIKE '" + build_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                ExtraBathroom room = new ExtraBathroom(cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
                bathroomList.add(room);
            }
            while (cursor.moveToNext());
        }
        cursor.close();

        String[] bathList = new String[bathroomList.size()];
        for(int counter=0; counter < bathroomList.size(); counter++)
        {
            String info = bathroomList.get(counter).getHandi() + ", " + bathroomList.get(counter).getSingle()+ ", " + bathroomList.get(counter).getChange()+ ", " + bathroomList.get(counter).getLockers() + ", " + bathroomList.get(counter).getShowers();
            bathList[counter]= info;
        }

        return bathList;
        /*
        String[] itemList =
                {
                        "accesible, single, lockers",
                        "showers",
                        "nothing",
                        "nothing",
                        "nothing"
                };
        return itemList;
        */

    }








    /*
      ****************
         COMPLABS
      ***************
    */
    //add a new computer lab
    public void addCompLab(CompLab room)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COMP_ID, room.getID());
        values.put(COMP_NUM, room.getCompNum());
        values.put(ROOM_ID, room.getRoomID());

        //insert row
        db.insert(TABLE_COMPLABS, null, values);

        //close database
        db.close();
    }

    //get all computer labs
    public List<CompLab> getAllCompLabs()
    {
        List<CompLab> compLabList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_COMPLABS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do {
                CompLab room = new CompLab();
                room.setID(Integer.parseInt(cursor.getString(0)));
                room.setNum(Integer.parseInt(cursor.getString(1)));
                compLabList.add(room);

            }

            while (cursor.moveToNext());

        }
        cursor.close();
        return compLabList;
    }

    //get computer lab
    public CompLab getCompRoom(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_COMPLABS, new String[] {COMP_ID, COMP_NUM}, COMP_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
            CompLab contact = new CompLab(Integer.parseInt(cursor.getString(0)),
                    Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2)));
            cursor.close();
            return contact;
        }
        return null;
    }
    //get basic bathroom info (floor, gender)
    public String[] getCompBasics(String build_name)
    {
        List<CompBasic> compList = new ArrayList<>();
        String selectQuery = "SELECT DISTINCT " + FLOOR_NUM + ", " + ROOM_NUM + " FROM  " + TABLE_COMPLABS + "," + TABLE_ROOMS + "," + TABLE_FLOORS + "," + TABLE_BUILDINGS +
                " WHERE " + TABLE_COMPLABS + "." + ROOM_ID + " = " + TABLE_ROOMS + "." + ROOM_ID + " AND "
                + TABLE_ROOMS + "." + FLOOR_ID + " = " + TABLE_FLOORS + "." + FLOOR_ID + " AND " +
                TABLE_FLOORS + "." + BUILD_ID + " = " + TABLE_BUILDINGS + "." + BUILD_ID + " AND "
                + TABLE_BUILDINGS + "." + BUILD_NAME + " LIKE '" + build_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                CompBasic room = new CompBasic(cursor.getString(0),cursor.getString(1));
                compList.add(room);
            }
            while (cursor.moveToNext());
        }
        cursor.close();

        String[] computerList = new String[compList.size()];
        for(int counter=0; counter < compList.size(); counter++)
        {
            String info = compList.get(counter).getFloorNum() + ", " + compList.get(counter).getRoomNum();
            computerList[counter]= info;
        }

        return computerList;
    }

}
