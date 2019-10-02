function productExceptIndex(A) {
	let before = []
	let after = []
	let prodBefore = 1;
	let prodAfter = 1;
	let result = []
	
	// before index
	before.push(1);
	for(let i = 1; i < A.length; i++) {
	    prodBefore *= A[i - 1];
		before.push(prodBefore);
	}
	//console.log(before)
	after.push(1)
	for(let j = A.length - 2 ; j >= 0; j--) {
		prodAfter *= A[j + 1]
		after.push(prodAfter);
	}
	//console.log(after)

	for(let i = 0, j = A.length - 1; i < A.length; i++, j--) {
	  // console.log(before[i], after[j])
	   result.push(before[i] * after[j])
	}
	console.log(result)
}
 productExceptIndex([3,1,2,5,6,4])
 productExceptIndex([1, 7, 3, 4])

console.log('-------------------')

function productExceptIndex2(A) {
	if(A.length < 2) {
		throw new Error('Invalid input')
	}
	let result = []
	let prodBefore = 1;
	let prodAfter = 1;
	
	// before index
	for(let i = 0; i < A.length; i++) {
	    result.push(prodBefore);
		prodBefore *= A[i];
	}
	//console.log(result)
	for(let j = A.length - 1; j >= 0; j--) {
	   result[ j ] *= prodAfter
	   prodAfter *= A[j]
	}
	
	console.log(result)
}

productExceptIndex2([3,1,2,5,6,4]) 
//[ 240, 720, 360, 144, 120, 180 ] 

productExceptIndex2([1, 7, 3, 4]) 
//[84, 12, 28, 21] 

productExceptIndex2([8,9,0]) 

