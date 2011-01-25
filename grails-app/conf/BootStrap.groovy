import abcopendata.*;

class BootStrap {

    def init = { servletContext ->
		Tag tag3 = new Tag(name:"tag3")
		tag3.save()
		
		Tag tag1 = new Tag(name:"tag1")
		tag1.save()
		
		Item item1 = new Item(name:"persona1", person:true, twitter:"bla")
		item1.save()
		
		// creem uns tags d'exemple.
		if (!Tag.count()) {
			new Tag(name:"tag1").save(failOnError:true)
			new Tag( name:"tag2").save(failOnError:true)
			new Tag( name:"tag3").save(failOnError:true)
		}
		
		// creem uns items d'exemple
		if (!Item.count()) {
			new Item(name:"pesona1", person:true, twitter:"bla").save(failOnError:true)	
			new Item( name:"pesona2", person:true, twitter:"bla").save(failOnError:true)
			new Item( name:"item1", datasource:true, twitter:"bla").save(failOnError:true)
			new Item( name:"item2", twitter:"bla").save(failOnError:true)
			Item item5 = new Item(id:5, name:"item3", twitter:"item3")
			///item5.tags = [tag3]
			
		}
    }
    def destroy = {
    }
}
