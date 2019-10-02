function findHigghestProdOf3(arrayInput) {

	let highest1 = Math.max(arrayInput[0], arrayInput[1]);
	let highest2 = Math.min(arrayInput[0], arrayInput[1]);
	
	let highestProd = -Infinity;
	
	let lowest1 = Math.min(arrayInput[0], arrayInput[1]);;
	let lowest2 = Math.max(arrayInput[0], arrayInput[1]);;
	
	for(let i = 2; i < arrayInput.length; i++) {
		let current = arrayInput[i];
		
		highestProd = Math.max(highestProd, highest1 * highest2 * current);
		
		if(current > highest1) {
			highest2 = highest1;
			highest1 = current

		} else if(current > highest2){
			highest2 = current;
		}
		
		if(current < lowest1) {
			lowest2 = lowest1
			lowest1 = current
		} else if(current < lowest2){
			lowest2 = current;
		}		
		
		highestProd = Math.max(highestProd, lowest1 * lowest2 * highest1);
	}

	return highestProd;
}

let res = findHigghestProdOf3([1,-10, 4, 5, -100]);
console.log(res === 5000 ? 'Sucess' : 'FAILURE ' + res)

res = findHigghestProdOf3([1, 10, 4, 5, 2]);
console.log(res === 200 ? 'Sucess' : 'FAILURE' + res)


res = findHigghestProdOf3([-10,-10,1,3,2]);
console.log(res === 300 ? 'Sucess' : 'FAILURE' + res)