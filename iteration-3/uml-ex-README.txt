This is a UML Activity Diagram. 
When the user opens the app, the MainMenu Activity page opens, while concurrently 
populating the database.
From here, the user can select a button. If the Bathrooms button is selected,
the BuildingSelection Activity page opens, which calls getAllBuildings, accessing
the database to get all buildings. This information is used to populate the spinner
module on this page.
The user can select a building from the spinner module, which opens up the
AmenityList Activity page. This page calls getBathroomBasics which gathers
a list of general bathroom information for all rooms in the selected building.
This list is used to populate the ListView module on this page.
If the user clicks on one of these rooms, getBathroomExtras is called which
accesses the database for more specific amenity information. This populates the 
Toast module (popup text) with extra info on the selected bathroom.
