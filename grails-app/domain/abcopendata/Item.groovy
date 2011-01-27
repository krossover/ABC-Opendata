package abcopendata

import org.bson.types.ObjectId

class Item {

	ObjectId id
	String name
	String twitter
	String wikipedia
	String page
	boolean person
	boolean datasource
	int votes
	
	boolean show
	
	
    static constraints = {
		name(blank:false)
		twitter(nullable:true)
		wikipedia(nullable:true)
		page(nullable:true)
    }
}
