package abcopendata

import abcopendata.Item;

// TODO provar d'alguna manera que no es pugui fer el .save i controlar
// l'exepcio i el que surt a la pˆgina segŸent.
class SendController {

	// va a la pˆgina web amb el formulari.
    def index = { }
	
	def send = {
		// llista de tags que posarem al Item
		def tags
		
		Item aCrear = new Item()
		if (params.nameField) {
			aCrear.name = params.nameField	
		}
		if (params.wikiField) {
			aCrear.wikipedia = params.nameField
		}
		if (params.pageField) {
			aCrear.page = params.page	
		}
		if (params.tagsField) {
			tags = params.tagsField.split(",")
			//aCrear.tags = [] as Set
			tags.each { tagName ->
				tagName = tagName.trim()
				def tag = Tag.findByName(tagName)
				if (!tag) {
					tag = new Tag()
					tag.name = tagName
					tag.save()
				}
				def tagging = Tagging.findByTagNameAndItemName(tagName, aCrear.name)
				if (!tagging) {
					tagging = new Tagging()
					tagging.tagName = tagName
					tagging.itemName = aCrear.name
					tagging.tagged = 1	
				} else {
					tagging.tagged++;
				}
				tagging.save()
			}
		}
		if (params.typeField) {
			if (params.typeField == 2) {
				aCrear.person = true;	
			} else if (params.typeField == 3) {
				aCrear.datasource = true;
			}
		}
		
		// l'ha creat l'usuari per˜ no ens en fiem, primer s'ha de moderar.
		aCrear.show = false;
		
		try {
			aCrear.save()
			println "Nou Item Creat"
			// un cop tenim creat l'item afegim els tags a la llista de tags.
			/*tags.each { tagName ->
				println "Tag Name: ${tagName}"
				def tag = Tag.findByName(tagName)
				if (!tag) {
					// el tag no existeix, el creem.
					tag = new Tag()
					tag.name = tagName
					//tag.items = new HashSet<Item>()
					//tag.items.add(aCrear)
					println "Afegint ${aCrear.name} al tag ${tag.name}"
					println "Creant el tag"
				} else {
					// el tag existeix, posem el nou recurs.
					//tag.items.add(aCrear)
					println "Afegint ${aCrear.name} al tag ${tag.name}"
				}
				tag.save()
			}*/
		}
		catch(Exception e) {
			flash.message = "Could not save the new resource! reason: ${e.getMessage()}"
			redirect(action:index)
		}
	}
}
