// Im only using a stack, on your solution there 2 sets + an object
// Im not sure if I get the idea, but in my solution I wanted to use less memory as 
// possible or in this case you where focused on the readability ? 

function isValid(code) {
	let closersStack = [];
	
	for(let i = 0; i < code.length; i++) {
		let char = code[i];
		
		switch(char) {
			case '{' :
			   closersStack.push('}');
			   break;
			case '[' :
			 	closersStack.push(']');
			   break;
			case '(' :
			 	closersStack.push(')'); 
			   break;   
			default:
				if(char === '}' || char === ']' || char === ')') {
					
					if(closersStack.pop() !== char) {
						return false;
					}	
				}			       
		}
	}
	return closersStack.length === 0;
}

const param = process.argv.slice(2)[0]
console.log(isValid(param))