const countWords = () => {

	const isLetter = (letter) => {
		return 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'.indexOf(letter) !== -1
	}

	return {
		countWords(str) {
			let wordsInfo = new Map()
	
			let startWordIndex = 0;
			let endWordIndex = 0;
	
			for(let i = 0; i < str.length; i++) {
				char = str.charAt(i);
			
				// build the word
				if(isLetter(char)) {
					endWordIndex += 1;
				} else {
					//console.log(startWordIndex, endWordIndex)
					let word = str.slice(startWordIndex, endWordIndex).toLowerCase();
					
					if(wordsInfo.has(word)) {
						let counter = wordsInfo.get(word)
						wordsInfo.set(word, counter + 1)
					} else {
						wordsInfo.set(word, 1)
					}

					startWordIndex = i + 1
					endWordIndex += 1;
				}
			}
			return wordsInfo
		}
	}
}





const prsase = 'After beating the eggs, Dana read the next step: ' +
 'Add milk and eggs, then add flour and sugar.';
const result = countWords().countWords(prsase)

console.log(result)
