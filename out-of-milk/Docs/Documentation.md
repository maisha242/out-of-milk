Guide for the various requests you can do with the api.


`GET http://localhost:8080/kitchen/{kid}`
Returns an array of items (in JSON format) that are inside of a kitchen with id kid. ex. localhost:8080/kitchen/1 returns all of the items associated with kitchen 1.

`POST http://localhost:8080/kitchen/{kid}/item`
Adds a new item (put in the body of the request)to an associated kitchen. \
Ex. `curl -i -X POST -H 'Content-Type:application/json' 'http://localhost:8080/kitchen/1/item' -d '{"id": 5, "name": "mangoes", "quantity": 100, "date": "2022-05-06"}'`
will put a new item called mangoes with a quantity of 100 into the kitchen with a kitchenid of 1. PLEASE NOTE: the id you put in is NOT what will be put into the database - the database puts in the next integer after the highest id of an existing item.

`POST http://localhost:8080/kitchen/{kid}/item/update` will update an existing item in a kitchen with kitchenid kid.
EX. `curl -i -X POST -H 'Content-Type:application/json' 'http://localhost:8080/kitchen/1/item/update' -d '{"id": 5, "name": "mangoes", "quantity": 200, "date": "2022-05-06"}'` will change 
the quantity of mangoes from 100 to 200. Also note, whatever you put in for the id will NOT MATTER, as it instead updates the item with the same NAME.


