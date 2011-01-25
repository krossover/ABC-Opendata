package abcopendata

import abcopendata.Item;

class ListController {

    def index = {
		
	}
	
	def listpeople = {
		def persones = Item.findByPerson(true)
		println "persones" + persones
		[persones:persones]
	}
	
	def listdatasources = {}
	
	def listother = {}
}
