package abcopendata

import org.bson.types.ObjectId
import abcopendata.Item;

class Tag {

	ObjectId id
	String name
	Set<Item> items
	
    static constraints = {
		name(blank:false)
    }
}
