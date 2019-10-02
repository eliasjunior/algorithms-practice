function findX(x, n) {
    
    const LIMIT_REMAINDER = 0.001;
     
	let start = 0
	let end = x
	
	while(start < end) {
		let dist = end - start;
		let mid = dist/2 + start
		
		let powerOfN = Math.pow(mid, n)
		let remainder = powerOfN - x;
		console.log(n , powerOfN)
		if( remainder > 0 && remainder < LIMIT_REMAINDER) {
			console.log('found!!', mid)
			return Math.round(mid * 1000 ) / 1000
		} else if(powerOfN > x) {
       		end = mid;
    	} else {
       		start = mid;
    	}
  	}
}
const param = process.argv.slice(2)

console.log('result',findX(parseInt(param[0]), parseInt(param[1])))