/**
 * Created by eliasmj on 16/04/2015.
 */

'use strict'

function out(i) {

    var faze =   function(i){

        btn.appendChild(document.createTextNode('button ' + i))

        btn.addEventListener("click", function(){
            console.log(i)
        })

    }(i)



}

for(var i = 0; i < 5; i++){

    var btn = document.createElement("button")

    out(i)

    document.body.appendChild(btn)

}



//GCD

function GCD(a, b) {

    while (b !== 0) {

        var reminder = a % b;
        console.log("reminder", reminder)

        a = b;

        b = reminder;
    }

    return a;
}

//primes

function findFactors(number) {

    var factors = [];

    //pull out factors of 2
    while(number % 2 === 0) {
        factors.push(2);
        number = number / 2;
    }

    var i = 3;

    var max_factor = Math.sqrt(number);

    while(i <= max_factor) {

        //pull out factors of i
        while(number % i === 0) {
            factors.push(i);
            number = number / i;

            //set a new upper bound = limit

            max_factor = Math.sqrt(number)
        }

        i = i + 2;

        if (number > 1 ) {
            factors.push(number)
        }
        return factors;
    }


}


var obj = {
    x : "Arm",
    b : "Yoo"
}
//console.log(">>>>> ", delete obj["x"])
//console.log(obj["b"] = undefined)



var t  = {

    a : {
        b : {
            name : "Elias"
        }
    }

}



