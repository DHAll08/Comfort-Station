Iteration-2 ReadMe:

*********
* About *
*********
For the second iterations, we rewrote our database using sqlite and inserted 
and queried data contained in it. Upon selecting a building from the dropdown
menu, a new activity(page) begins, listing all bathrooms/computer-labs within 
that building. Specifically for bathrooms, among selecting one, more information 
about it will pop up. In Iteration 3 we hope to insert and query extra information 
on computer labs (the number of computers) as well.

This iteration was completed on 11/27/16.

****************************************
* Folder and Code Location/Information *
****************************************
Folder: 
	Name - bathroomAppIteration2
	Location - DMCM/iteration-2/bathroomAppIteration2
Java Code:
	Location - DMCM/iteration-2/bathroomApppIteration2/app/src/main/java/com/example/dwight/bathroomappv2/...
	Files - 
    AmenityList.java - lists rooms and info about them (third page)
    BasicBathroom.java - class for retrieving specific data from sqlite database
    Bathroom.java - class for creating Bathroom objects for sqlite database
    Building.java - class for creating Building objects for sqlite database
		BuildingSelection.java - building selection activity (second page)
    CompBasic.java - class for retrieving specific data from sqlite database
    CompLab.java - class for creating Computer Lab objects for sqlite database
    DBHandler.java - creates database
    ExtraBathroom.java - class for retrieving specific data from sqlite database
    Floor.java - class for creating Floor objects for sqlite database
		MainMenu.java - main menu activity (first page)
    Room.java - class for creating Room objects in for sqlite database

***************************
* Running the Application *
***************************
How to run:
- Download Android Studio
- Make sure emulator works 
   (might need to download an external one depending on CPU)
- Download our app's folder from github
- In Android Studio: File -> Open -> Select entire folder and click "Okay"
