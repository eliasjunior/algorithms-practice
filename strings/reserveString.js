//can I use an API
//is there numers ?
// special charactrres
// spaces ?
// only alphabet chars ?

function reverseMe(input) {
	console.log('Original:', input)
    if(typeof input !== "string" || input.length === 0) {
	   return 'invalid type'
	}

	//elias
	//juninho
	//Im your father
	// number
	
	const inputArray = input.split('');
	
	const swap = (j, i) => {
		let temp = inputArray[i]
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}
	
	for(let i = inputArray.length - 1, j = 0; i > j; i--, j++) {
		swap(j,i)
		
	}
	return inputArray.join('')
}
const parameter = process.argv.slice(2)[0];
console.log('Reversed:', reverseMe(parameter))