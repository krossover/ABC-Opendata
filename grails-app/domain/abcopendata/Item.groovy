package abcopendata

import org.bson.types.ObjectId

/**
 * Aquesta es la classe que representa una pàgina web, un blog, o algo relacionat amb opendata
 * Té el seu propi id i una sèrie de camps, a més l'item pot ser una persona O una font de dades O alguna altre cosa
 * per implementar això el més senzill era tenir dos camps booleans que diuen què és.
 */
class Item {
	// TODO 
	// - només pot ser person O datasource O cap dels dos.
	// - els noms són únics, no poden haver-hi dos objectes amb el mateix nom, i que sigui vàlid (que no sigui sql injection)
	// - el camp wikipedia ha de ser un link (mirar que no sigui sql injection)
	// - el camp twitter ha de ser un camp valid (mirar que no sigui sql injection)
	// - votes ha de ser 0 o més.


	// id (utilitzat per mongodb)
	ObjectId id
	String name
	// nom de l'usuari de twitter 
	String twitter
	// pagina a wikipedia si n'hi ha 
	String wikipedia
	// pagina web si n'hi ha
	String page
	// es una persona
	boolean person
	// es un lloc d'on es poden obtenir dades
	boolean datasource
	// quants vots te
	int votes

	// ha sigut filtrat? 
	// quan es crea un item esta a fals, llavors els admins hem de mirar si la info és correcte o es spam i habilitar el camp.	
	boolean show
	
	
    static constraints = {
		name(blank:false)
		twitter(nullable:true)
		wikipedia(nullable:true)
		page(nullable:true)
    }
}
