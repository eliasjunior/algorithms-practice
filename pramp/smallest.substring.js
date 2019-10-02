 // check temp x y y z y z y x

 //  x y y z y z y x
 function getShortestUniqueSubstring(arr, str) {
    // your code goes here
    let result;
    for(let i = 0; i < str.length; i++) {
        let subStart = i;
        for(let j = i; j < str.length; j++) {
            let temp = str.slice(subStart, j + 1);
            let isThere = containAll(arr, temp);
            if(isThere) {
                if(!result || result.length > temp.length) {
                    result = temp;
                } 
                subStart = j;
            }
        }
    }
    console.log('result',result);

    return result !== undefined ? result : '';
}
 
function getShortestUniqueSubstringBF(arr, str) {
    // your code goes here
    let result;
    for(let i = 0; i < str.length; i++) {
        let subStart = i;
        for(let j = i; j < str.length; j++) {
            let temp = str.slice(subStart, j + 1);
            let isThere = containAll(arr, temp);
            if(isThere) {
                if(!result || result.length > temp.length) {
                    result = temp;
                } 
                subStart = j;
            }
        }
    }
    console.log('result',result);

    return result !== undefined ? result : '';
}

function containAll(arr, str) {
    let mapString = {};
    let length = arr.length;
    for(let i = 0; i < arr.length; i++) {
        mapString[arr[i]] = true;
    }
    
    for (let i = 0; i < str.length; i++) {
        if(mapString[str.charAt(i)]) {
            mapString[str.charAt(i)] = false;
            length--;
            if(length === 0) {
                break;
            } 
        }
    }

    return length === 0;
}    
getShortestUniqueSubstring(['x','y','z'], 'xyyzyzyx')

getShortestUniqueSubstring(['A'], 'A')

//["x","y","z","r"], "xyyzyzyx"

//console.log('>>',containAll(['x', 'y', 'z'], 'xaaym'))