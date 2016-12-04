This is a C&C Pipe and Filter diagram that describes how information from a query is 
filtered, in order to properly populate a ListView module in our AmenityList Activity.

Collected information from the query is used to create Bathroom objects, which are 
stored in to an array list. Each Bathroom in the list has its "get" functions called 
to get Floor, Room, and Gender information on each bathroom, which is used to populate 
the ListView.
