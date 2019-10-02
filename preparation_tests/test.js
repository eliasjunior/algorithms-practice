const collection = require('./collection.js');
const assert = require('assert');

describe('test collection', () => {

	it('should add an element in the array', () => {

		collection.add(1)

		assert.equal(1, collection.size());

	});

	it('should remove from the list', () => {

		collection.remove(0)

		assert.equal(0, collection.size());

	});
	
	// it('should read a file', () => {
	// 	return collection.readFile('customers.json').then((data) => {
	// 		assert.equal(12, data.user_id)
	// 	})
	// });

});











