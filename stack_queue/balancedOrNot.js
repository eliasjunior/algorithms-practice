function isBalanced(exps, maxRepl) {
	let result = [];

	for(let i = 0; i < exps.length; i++) {
        const partialResult = expressionMatcher(exps[i], maxRepl[i]);
        result.push(partialResult)
	}

	console.log('result', result)
	console.log('=====================')

}

function expressionMatcher(expression, maxReplacement) {
    let openedSymbol = 0;

    for(let j = 0; j < expression.length; j++) {
        let char = expression.charAt(j);
        if(char === '<') {
            openedSymbol += 1;
        } if(char === '>') {
            if(openedSymbol === 0) {
                if(maxReplacement === 0) {
                    return 0;
                } else {
                    maxReplacement -= 1;
                }
            } else {
                openedSymbol -= 1;
            }

        }
    }
    if(openedSymbol === 0) {
        return 1
    } else {
        return 0
    }
}


isBalanced(['<>>>','<>>>>'], [2,2]) 

isBalanced(['<<>', '>>', '><><'], [2,2,2])
