function mergeArrays(arrayA, arrayB) {
    let result = []
    while(arrayA.length || arrayB.length ) {
        if(!arrayB[0] || (arrayA[0] < arrayB[0])) {
            result.push(arrayA.shift())
        } else {
            result.push(arrayB.shift())
        }
    }
    return result;
}

module.exports = {
    mergeArrays
}