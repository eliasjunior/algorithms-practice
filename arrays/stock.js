function getMaxProfitStock(A) {
    let min = Math.min(A[0], A[1])
    
    let maxProf = A[1] - A[0];
    let prev = A[0]
    for(let i = 1; i < A.length; i++) {
        let cur = A[i];

        min = Math.min(min, cur)

        if(prev > cur) {
            maxProf = Math.max(maxProf,  cur - prev)
    
        } else {
            maxProf = Math.max(maxProf,  cur - min)
        }

       prev = cur

    } 	
    console.log('result' , maxProf)
}   

getMaxProfitStock([10, 7, 5, 8, 11, 9]);


getMaxProfitStock([ 11, 5, 7, 2,  8, 9] );

getMaxProfitStock([11, 10, 9, 3])