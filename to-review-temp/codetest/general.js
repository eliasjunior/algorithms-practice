/**
 * Created by eliasmj on 02/04/2015.
 */

'use strict'
//its not
var palindronme = function() {
               //A man, a plan, a canal: Panama
    var phase = "A man, a plan, a canal Panama".split("")

    var reverse = phase.reverse()
   // log(reverse)
   // log(phase)

    //check array against array, but check false first, faster
    for(var i = 0; i < phase.length - 1; i++) {

    }

    log("amor ola test!".replace(/\W/g, ''))

    document.body.innerHTML = ""

}

//curry
var sum = function(a, b) {

    if (arguments.length === 2) {
        return a + b;
    } else if(arguments.length === 1) {
        return function(c){
            return a + c;
        }
    }

}

var myObj = {

    foo:"bar",

    myMethod : function(){
        var self = this;

        log("this:",this.foo)
        log("self:" + self.foo)


        (function() {
            console.log("inner func:  this.foo = " + this.foo);
            console.log("inner func:  self.foo = " + self.foo);


        }());

    }

}

function foo1()
{
    return {
        bar: "hello"
    };
}

function foo2()
{
    return
    {
        bar: "hello"
    };
}

//log(100 === 1e2) //1e2 == 1 x 10 elevado 2

(function t() {

    console.log("normal")
    setTimeout(function(){
        console.log("BIG")
    },1000)

    setTimeout(function(){
        console.log("ZERO")
    },0)
    console.log("final")

})

var add = (function () {
    var counter = 0;
    return function () {return counter += 1;}
})();


//log(add())


var ob = {
    status : false
}





