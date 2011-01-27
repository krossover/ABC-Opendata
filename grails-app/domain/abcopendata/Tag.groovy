package abcopendata

import org.bson.types.ObjectId
import abcopendata.Item;

/**
 * Un tag, és una cosa simple
 */
class Tag {

	// TODO 
	// - no hi poden haver dos tags amb el mateix nom.
	// - el nom del tag ha de ser vàlid (que no sigui sql injection)

	ObjectId id
	String name
	
    static constraints = {
		name(blank:false)
    }
}
