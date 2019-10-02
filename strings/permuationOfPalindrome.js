function isPalindrome(input) {
	let i = 0;
	let j = input.length - 1;
	while(i < j && input[i] === input[j]) {
		i++;
		j--;
	}
	
	return i === j || i > j;
}

function isPermutationPalindrome(input) {
	let map = new Map();
	
	let i = 0;
	let j = input.length - 1;
	
	for(let i = 0; i < input.length; i++) {
		if(!map.get(input[i])) {
			map.set(input[i], 1);
		} else {
			map.set(input[i], map.get(input[i]) + 1);
		}

	}
	//console.log(map)
	// think better nanem
	let odds = 0;
	for (var [key, value] of map) {
  		// console.log(key + ' = ' + value);
		if(value % 2 !== 0) {
			odds = odds + 1;
		}
	}

	return odds <= 1;
}


function permutation() {
	return ["civic","ivicc", "civil", "livci"];
}

function main(input) {
	
	// api	
	const permutes = permutation(input);	
	
	for(let i = 0; i < permutes.length; i++) {
		const permute = permutes[i];
		console.log(isPermutationPalindrome(permute));
	}
	
}

main()