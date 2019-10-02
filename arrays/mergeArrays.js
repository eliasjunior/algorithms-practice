function mergeArrays(A, B) {
    let result = [];
    
    while(A.length && B.length){
        let left = A[0];
        let right = B[0];
       
        if(left < right) {
            result.push(A.shift());
        } else {
            result.push(B.shift());
        }      
    }

    while(A.length) {
        result.push(A.shift());
    }
    while(B.length) {
        result.push(B.shift());
    }

    console.log(result);
    return result;	
}

mergeArrays([1,4], [2, 3])

mergeArrays([1,4, 6], [2, 3, 5, 7])


    