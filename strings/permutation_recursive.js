function permutation(str) {
	 
	if(str.length <= 1) {
		return str 
	} 
	
	var allCharExpectLast = str.slice(0, -1)
	
	var lastChar = str.slice(str.length - 1)
	
	console.log('allCharExpectLast-' , allCharExpectLast)
	var permutationAllCharExceptLast = permutation(allCharExpectLast)
	
	console.log('AllPermutations=', permutationAllCharExceptLast)
	
	
	for(let i = 0; i < permutationAllCharExceptLast.length; i++) {
		let c = permutationAllCharExceptLast.charAt(i)
		console.log('char', c, lastChar)
	}
	
	//return result
}


const param = process.argv.slice(2)[0]
 const r = permutation(param, 0)
console.log('RESULT', r)
