/**
 * Created by eliasmj on 19/06/2015.
 */

/**
 *
 * {
 * 1 : {init : a, end:b},
 * 2 : b-d,
 * 3 : c-d
 * }
 *
 * abc-bdd
 * abc,abd,acc,acd,adc,add,bbc,bbd,bcc,bcd,bdc,bdd
 *
 * ab-be
 * ab,ac,ad,ae,bb,bc,bd,be,cb,cc,cd,ce,db,dc,dd,de
 *
 * a1-d7
 * a1,a2,a3,a4,a5,a6,a7,b1,b2,b3,b4,b5,b6,b7,c1,c2,c3,c4,c5,c6,c7,d1,d2,d3,d4,d5,d6,d7
 *
  * @type {string}
 */

    //TODO comment all code

var start = "aa" , end="zz";

var map = [];
var combination = [];

//build the map, with init/end/current eg: a1-c7 this create a obj with 2 keys, key 0 : { init: 'a', end: 'c', current: 'a' }, key 1 { init: '1', end: '7', current: '1' }
function build() {

    var thereIsNumber = {};
    for (var i = 0; i < start.length; i++) {

        if (!isNaN(start.charAt(i))) {
            thereIsNumber.found = true;
            thereIsNumber.index = i;
        }

    }

    if (thereIsNumber.found ) {

        //support only the same letter in a range with number e.g: a1-a10, but not a1-b10

        map[0] = {"init" : start.slice(0, thereIsNumber.index ) , "end" : end.slice(0, thereIsNumber.index ), "current" :  start.slice(0, thereIsNumber.index)};
        map[1] = {"init" : start.slice(thereIsNumber.index) , "end" : end.slice(thereIsNumber.index), "current" : start.charAt(thereIsNumber.index) };


    } else {

        for (var i = 0; i < start.length; i++) {


            map[i] = {"init" : start.charAt(i) , "end" :end.charAt(i), "current" :  start.charAt(i)};

        }
    }


    console.log(map);

}

build();

increment("0", map["0"].init)


function increment(key, char) {

    var currentChar = char;

    //get init and end of key
    var end = map[key].end;

    console.log("key "+ key , "char " + char, "End " + end);

    //check if is the bottom
    if (checkBottom(key)) {
        //antes estava currentChar !== end

        if (currentCharIsEnd(key, currentChar)) {

            //key - 1, chama increParent

            console.log("IS THE END", currentChar)

            var parentKey = getPreviousKey(key);

            if (parseInt(parentKey, 10) !== -1) {

                incrementParent(parentKey, map[parentKey].current);
            } else {
                console.log("DONE", combination.join(",") );
            }


        } else {
            //show a combination e reset

            printCurrentMap();

            //step, 1 : increment current, set current in the map for this key
            currentChar = nextCharOrNumber(key, currentChar);

            if (parseInt(currentChar, 10) !== -1) {
                map[key].current = currentChar;
            }

            increment(key,currentChar);

        }


    } else {

        var nextKey = getNextKey(key);

        increment(nextKey, map[nextKey].init);

    }
}


function incrementParent(key, char) {

    var currentChar = char;

    //srtCombination += char;

    console.log("Parent key "+ key , "char " + char);

    //if !== -1 there is a parent
  if (currentCharIsEnd(key, currentChar)){

        var parentKey = getPreviousKey(key)
        if (parentKey === -1) {
            console.log("DONE", combination.join(",") );

        } else {
            incrementParent(parentKey, map[parentKey].current);
        }


    } else {

        //step incremtn current char, 2 set current map for this key, 3 quando increment o pai, need reset all child
        currentChar = nextCharOrNumber(key,currentChar);

        console.log("NEXT in PAI", currentChar)

        if (parseInt(currentChar, 10) !== -1) {
            map[key].current = currentChar;

            //reset all child, for new combinations of current parent
            resetAllCurrentChild(key);

            increment(key, currentChar);

        } else {

            var parentKey = getPreviousKey(key);

            if (parentKey === -1) {
                console.log("DONE", combination.join(",") );

            } else {
                incrementParent(parentKey, map[parentKey].current);
            }
        }

    }


    //se a key corrent for o fim
    // for true >> verifica se tem pai,
    //for true >>  ele passa key - 1, chama p incrParent
    //for false >> DONE
    //for false >> increment o char, set o current and call increment



}


//key is a number
function checkBottom(key) {

    var result = true;

    for (var level in map) {

        if (parseInt(key, 10) < parseInt(level, 10) ) {
            //is not the bottom
            result = false;
        }

    }

    return result;
}

function getNextKey(key) {

    var next = parseInt(key, 10) + 1;

    return map[next] !== undefined ? next : -1;

}

function getPreviousKey(key) {

    return map[key - 1] !== undefined ? parseInt(key - 1) : -1;

}

function resetAllCurrentChild(key) {

    for (var level in map) {
        // 0 > 1, 1 > 1, 2 > 1
        if ( parseInt(level, 10) > parseInt(key, 10) ) {
            map[level].current = map[level].init;
        }

    }
}



function printCurrentMap() {

    var result = '';


    for (var level in map) {

        result += map[level].current;

    }

    combination.push(result);

  //  console.log("print the current map", result);

}


function nextCharOrNumber(key, c) {
    if (isNaN(c)) {

        var nextNumber = c.charCodeAt(0) + 1;
        var end = map[key].end.charCodeAt(0);

        if (nextNumber > end) {
            return -1;
        } else {
            return String.fromCharCode(nextNumber);
        }


    } else {

        var nextNumber = parseInt(c, 10) + 1;
        var end = parseInt( map[key].end.charCodeAt(0), 10);

        if (nextNumber > end) {
            return -1;
        } else {
            return nextNumber;
        }
    }

}






function currentCharIsEnd(key, currentChar) {

    if (parseInt(currentChar, 10) === -1) return true;

    if (isNaN(currentChar)) {
        return currentChar.charCodeAt(0) > map[key].end.charCodeAt(0) ? true : false;
    } else {
        return parseInt(currentChar, 10) >  parseInt(map[key].end, 10) ? true : false;
    }

}



//
//function printAll(arr) {
//
//    console.log("new pos")
//    for (var i = 0; i < arr.length; i++) {
//
//        if (Array.isArray(arr[i])) {
//
//            printAll(arr[i])
//
//        } else {
//
//            console.log(arr[i])
//
//            //
//            //interar denovo com todos
//
//        }
//    }
//}



