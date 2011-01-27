package abcopendata
import org.bson.types.ObjectId

class Tagging {
	ObjectId id
	String tagName
	String itemName
	long tagged
	
    static constraints = {
    }
	
	static mapping = {
		tagName index:true
		itemName index:true
	}
}
