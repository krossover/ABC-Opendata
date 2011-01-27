package abcopendata
import org.bson.types.ObjectId

/**
 * Ara per ara el plugin de mongodb no permet tenir llistes ni conjunts dins un objecte, tot i que la base de dades en si sí que pot. 
 * El que he fet per sortir del pas és crear aquesta classe que és bàsicament una taula amb una unió. 
 */
class Tagging {
	// TODO 
	// - no hi poden haver dos objectes tagging amb el mateix <tagName - itemName> en cas de que algú apliqui el mateix tag al mateix 
	// item s'ha d'actualitzar el contador tagged.
	// - tagged ha de ser 0 o més.

	// id
	ObjectId id
	// tag utilitzat en aquesta acció de taggejar algo.
	String tagName
	// objecte utilitzant en aquesta acció de taggejar algo.
	String itemName
	// número de vegades que s'ha aplicat aquest tag
	long tagged
	
    static constraints = {
    }
	
	static mapping = {
		tagName index:true
		itemName index:true
	}
}
