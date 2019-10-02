function isPalindromeAnyPermutationMap(input) {
    
    //isValid, s > 1
	
	let palindromeMap = {};
	
	for(let i = 0; i < input.length; i++) {
		let char = input.charAt(i);
		
		if(palindromeMap[char]) {
			palindromeMap[char] = false
		} else {
			palindromeMap[char] = true
		}
	}
	
	let countOddChar = 0;
		
	Object.keys(palindromeMap).forEach( key => { 
	    if(palindromeMap[key]) {
	    	countOddChar ++
	    }
	})
	//console.log('palindromMap', palindromeMap)
	
	return countOddChar <= 1
}

console.log( isPalindromeAnyPermutation('civic') === true ? 'Success civic' : 'FAILED')
console.log( isPalindromeAnyPermutation('ivicc') === true ? 'Success ivicc' : 'FAILED')
console.log( isPalindromeAnyPermutation('civil') === false ? 'Success civil' : 'FAILED')
console.log( isPalindromeAnyPermutation('livci') === false ? 'Success livci' : 'FAILED')
