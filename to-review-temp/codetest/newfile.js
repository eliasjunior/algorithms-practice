/**
 * Created by eliasmj on 02/06/2015.
 */

var alpha = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];

var digit = ["0","1","2","3","4","5","6","7","8","9"];

var result = "";

var comb = "a1" ;

if (comb.length === 3) {

} else if (comb.length === 2) {

} else {

}

//the combination need to be the range

var combination = [ ["a", "b", "c"], ["1", "2"] ];


var keep = '', deep = comb.length;

if(isNaN(comb.charAt(0)) ) {
    loopAllArray(combination[0], 0, null);
} else {
    loopAllArray(combination[1], 0, null);
}

function loopAllArray(arrayToLoop, n) {

    for(var k = 0; k < arrayToLoop.length; k++) {

            if (n + 1 < comb.length) {

                //if the NEXT level is a letter, not a number
                if(isNaN(comb.charAt(n + 1)) ) {

                    //save first level, until print the last level loop
                    keep += arrayToLoop[k]

                    console.log("next letra keep",   keep );

                    loopAllArray(combination[0], n + 1);


                } else {


                    keep += arrayToLoop[k]

                    console.log("next number keep",   keep );

                    loopAllArray(combination[1], n + 1);

                }

            } else {

                //reach the end of the level, print the ancestor more the current loop index
                console.log(">>>>>>>>>>>>>>>>>>",keep + arrayToLoop[k]);


                //got in the end of the current loop
                if (arrayToLoop.length - 1 === k) {

//                    deep--;
//
//                    if (deep === 0) {
//                        //for more then 3 level need change comb.length - 1
//                        deep = comb.length - 1;
//                        console.log("-",  keep === '', '-'+keep)
//                    }


                    keep = keep.substr(0, 1 );

                    console.log("END LEVEL",  keep)


                } else {

                    //remove the current index, is going to concac the next more it ancestor
                    keep = keep.substr(0, keep.length);

                    console.log("current loop",   arrayToLoop[k])
                }


            }
    }
}


function testNada(){

    var arr = [{salary : 100}]

    arr.map(person => person.salary * 2)

}



//
//    var firstPos = 0; //comb.charAt(i)
//    var lastPos =  4;//comb.charAt(i + 1)
//
//    if (isNaN(comb.charAt(i))) {
//
//        for (var j = firstPos; j < lastPos; j++) {
//
//            for (var k = firstPos; k < lastPos; k++) {
//                result += alpha[j] + alpha[k] + ", "
//            }
//            result += "\n"
//        }
//    } else {
//
//        for (var j = firstPos; j < lastPos; j++) {
//
//            for (var k = firstPos; k < lastPos; k++) {
//                result += alpha[j] + alpha[k] + ", "
//            }
//            result += "\n"
//        }
//
//
//    }




