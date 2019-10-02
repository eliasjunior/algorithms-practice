function permute(str) {
	console.log('------------------------------')
	console.log('str', str)
	
	
	if(str.length === 1) {
		return str.charAt(0)
	}

	let result = str.charAt(0)
	
	for(let i = 0; i < str.length; i++) {
		let char = str.charAt(i);
		console.log('char', char)
		console.log('with', str.slice(i + 1))
		for(let j = 0; j < str.length; j++) {
			let cur = str.charAt(j);
			if(char !== cur && str.length > i) {
				
				const temp = permute(str.slice(i + 1))
				result = result.concat(temp)
			}
		}
		
	}
	console.log('*------------------------------')
	return result + ', '

}

const param = process.argv.slice(2)[0]

console.log('>>', permute(param, param.charAt(0)))