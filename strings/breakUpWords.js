function breakUpWords(words) {
  if(!words) {
  	return 'invalid input'
  }
  
  const convertFirstToCapital = (word) => {
   //  console.log('Transform', word.charAt(0)) 
    return word
    	.charAt(0)
    	.toUpperCase()
    	.concat(word.slice(1))
  	}
  
  const dictionary = ['Fast', 'Man', 'I', 'am', 'doing', 'well', 'apple', 'sauce', 'man' ]
  
  let word = ''; 
  let result = '';
  for (let i = 0; i < words.length; i++) {
    let letter = words.charAt(i);	
     word = word.concat(letter);
       // check in the word is in the dictionary
    //console.log('current word ', word)
    
   	if(dictionary.includes(word) || dictionary.includes(convertFirstToCapital(word))) {
   	  if(i < words.length - 1 ) {
   	      word = word.concat(' ');
   	  }
  	  result = result.concat(word);
  	   word = '';
   	}

  }
  return result;
}

const parameter = process.argv.slice(2)[0]

console.log('param', parameter)

console.log('RESULT', breakUpWords(parameter))

