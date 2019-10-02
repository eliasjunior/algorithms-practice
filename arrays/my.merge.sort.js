function partialMerge(leftArray, rightArray) {
    let indexLeft = 0;
    let indexRight = 0;
    let result = [];
    while(indexLeft < leftArray.length || indexRight < rightArray.length) {
        if(!leftArray[indexLeft]) {
            result.push(rightArray[indexRight]);
            indexRight++;
        } else if(!rightArray[indexRight]) {
            result.push(leftArray[indexLeft]);    
            indexLeft++;
        } else {
            if(leftArray[indexLeft] < rightArray[indexRight]) {
                result.push(leftArray[indexLeft]);
                indexLeft++;
            } else {
                result.push(rightArray[indexRight]);
                indexRight++;
            }
        }
    }
    return result;
}

function breakArray(arr) {
    if(arr.length === 1) {
        return [arr];
    }
    let mid = Math.floor(arr.length/2);

    let floor = arr.slice(0, mid);
    let ceil = arr.slice(mid);

    return [floor,ceil];
}
// TODO check every pos is === 1 ?
function toDivide(divided) {
    let botton = divided.every(item => item.length === 1);
    if(botton) {
        //console.log('base', divided)
        return divided;
    }
    let result = [];
    if(!Array.isArray(divided[0]) ) {
        divided = breakArray(divided);
    }

    for (let i = 0; i < divided.length; i++) {
        const childArr = divided[i];
        let parcial = toDivide(breakArray(childArr));
        result.push(parcial);
    }
    return result.reduce((acc,item) => acc.concat(item), []);
}

function fullMerge(arr) {
    if(arr.length === 1) {
        return arr[0];
    }
    let half = [];
    for(let i = 0; i < arr.length; i = i + 2) {
        const currentArray = arr[i];
        const nextArray = arr[i + 1];
        if(!nextArray) {
            half.push(currentArray);
        } else {
            half.push(partialMerge(currentArray, nextArray));
        }
    }
    return fullMerge(half);
}

//console.log(partialMerge([2,6], [1,3]));
//console.log(partialMerge([4], [2]));
//console.log(toDivide([1,2,3,4,5]))

//console.log(partialMerge([1,4,5,6], [2,3]));
//console.log(partialMerge([ 1, 2, 3, 4 ], [ 5, 7 ]))

//console.log('Result',fullMerge([ [3], [1], [4], [2], [7] , [5]]));

function mergeSort(arr){
    const halves = toDivide(arr);

    return fullMerge(halves);
}

//console.log('Yeah',mergeSort([3,1,4,2]))
console.log('Yeah',mergeSort([3,6,4,2, 8, 7, 1]))