const factory = require('./simple.test.js');

const expect = require("chai").expect;

describe("main test", () => {

	const list = [1,2,3,42,1,-10];

	it("should min be -10", ()=> {
		
		expect(factory.getMin(list)).to.equal(-10);

	});

});
