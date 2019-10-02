function findX(A, target) {
    if(typeof target !== 'number') {
    	throw new Error('Invalid inpur')
    }
     
	let start = 0
	let end = A.length
	
	while(start < end) {
		let dist = end - start;
		let mid = Math.floor(dist/2) + start
		if(A[mid] === target) {
			console.log('found!!', A[mid])
			start = end
		} else if(A[mid] > target) {
			end = mid
		} else {
			start = mid
		}
	}
		
}
const param = process.argv[2]
findX([1,2,3,4,5], parseInt(param,10))


// another one
// if incre/decre works for array size 2, and the above solution maybe not, TODO TEST this
// there is a problem when the middle is 0 index 

function bsearch(list, target) {
    console.log('#Target', target)
    let floor = 0;
    let ceil = list.length - 1;
   
    while(floor <= ceil) {
        let diff = ceil - floor;
        let middle =  Math.floor(diff / 2) + floor;

        if(list[middle] === target) {
            return middle
        } else if(list[middle] > target){
            // go left
            ceil = middle - 1;
        } else {
            // go right
            floor = middle + 1;
        }
    }
}

function fillArray(end) {
    let result = [];
    let index = 0;
    while(index < end) {
        result[index] = index;
        index++;
    }

    return result;
}

console.assert(13 === fillArray(13).length, {message: 'problem create array'})

const array13 = fillArray(13);
console.assert(bsearch(array13, 11) === 11, {message: 'search failure'})
console.assert(bsearch(array13, 9) === 9, {message: 'search failure'})

const array7 = fillArray(7);
console.assert(bsearch(array7, 6) === 6, {message: 'search failure'})
console.assert(bsearch(array7, 5) === 5, {message: 'search failure'})
console.assert(bsearch(array7, 4) === 4, {message: 'search failure'})
console.assert(bsearch(array7, 1) === 1, {message: 'search failure'})
console.assert(bsearch(array7, 0) === 0, {message: 'search failure'})