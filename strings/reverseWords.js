//can I use an API
//is there numers ?
// special charactrres
// spaces ?
// only alphabet chars ?
const swap = (right, left, inputArray) => {
		let temp = inputArray[left]
		inputArray[left] = inputArray[right];
		inputArray[right] = temp;
		return inputArray
	}
	
function isValid(input) {
	if(Array.isArray(input) || input.length === 0) {
	   throw new Error('invalid type')
	}
	
}
function reverseString(inputArray, leftSide, rightSide) {
	for(let i = leftSide  - 1, j = rightSide; i > j; i--, j++) {
		inputArray = swap(j,i, inputArray)
	}
	return inputArray;
}
function reverseMe(inputArray) {
//	console.log('Original:', inputArray)
   // isValid(inputArray)
   
    // reverse the whole array
    inputArray = reverseString(inputArray, inputArray.length, 0) 
    console.log('All Reversed:', inputArray)
    let left = 0;
    let right = 0;
	while( left < inputArray.length) {
	    1
		while(inputArray[left] !== ' ' && left < inputArray.length){
			left++;
		}
		reverseString(inputArray, left, right)	
		left++; // skip space
		right = left
	}
	
	return inputArray.join('')
}
var message = [ 'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l' ];

console.log('Reversed:', reverseMe(message))

message = ['t', 'h', 'e', ' ', 'e', 'a', 'g', 'l', 'e', ' ',
  'h', 'a', 's', ' ', 'l', 'a', 'n', 'd', 'e', 'd']
  //console.log('Reversed:', reverseMe(message))