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
	Set<Tag> tags
	
    static constraints = {
		name(blank:false)
		twitter(nullable:true)
		wikipedia(nullable:true)
		page(nullable:true)
    }
}
