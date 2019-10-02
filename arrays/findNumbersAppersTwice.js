// 1 ...n and 
// array length n + 1 
function findNumberAppersTwice(numbers) {
	sortInteger(numbers);
	console.log('sorted', numbers)
	let hasBeenSeen = false;
	for(let j = 0; j < numbers.length - 1; j++) {
		let number = numbers[j];
		let nextNumber = numbers[j + 1 ];
		if(number === nextNumber) {
			return number;
		}
	};
	throw new Error('There is no duplication');
}

function findNumberAppersTwiceNSquare(numbers) {
	for(let i = 1; i < numbers.length; i++) {
		let hasBeenSeen = false;
		for(let j = 0; j < numbers.length; j++) {
			let number = numbers[j]
			if(i === number) {
				if(hasBeenSeen) {
					return number;
				}
				hasBeenSeen = true;
			}
		};
	} 
	throw new Error('There is no duplication');
}

function sortInteger(numbers) {
	return numbers.sort((n1,n2) => {
		let a = parseInt(n1, 10);
		let b = parseInt(n2, 10);
		if( a > b) {
			return 1;
		} else if(b > a) {
			return -1;
		} else {
			return 0;
		}
	});
}

console.log('Result ',findNumberAppersTwice([3,2,6,2,7,10,9,8,4,1,5]))
console.log('Result',findNumberAppersTwice([5,4,3,3,2,1]))
console.log('Result',findNumberAppersTwice([5,4,3,10,2,10,9,10]))