
const expect = require("chai").expect;

var myFactory = function  () {

	return {
		getMinHorizontal : (arr) => {

			let diffCurrPrev = 0;
			let totalStrokes = 0;
			let previous = -1;	
			
            arr.forEach((item, i) => {
            	
            	//console.log('index='+i, item);

            	if (previous === -1) {
            		totalStrokes += item;

            	} else {

            		if(item > previous) {

            			diffCurrPrev = item - previous;
            			totalStrokes += diffCurrPrev;

            		}	
            	}	
            	previous = item;

            });    				

            return totalStrokes;
		}
	}
}


describe("-----------", () => {

	it("should return 9", () => {

		const list = [1,3,2,1,2,1,5,3,3,4,2];
		
		expect(myFactory().getMinHorizontal(list)).to.equal(9);
	});

	it("should return 8", () => {

		const list = [5,8];

		expect(myFactory().getMinHorizontal(list)).to.equal(8);
	});

	it("should return 1", () => {

		const list = [1,1,1,1];

		expect(myFactory().getMinHorizontal(list)).to.equal(1);
	});
});

module.exports = myFactory();

