/**
 * Created by eliasmj on 13/04/2016.
 */

/* Monkey patching bad practice*/
var Castle = function(name) {

    this.name = name;

    this.build = function(){
        console.log(this.name)
    }

}


var instance1 = new Castle("WinterFell");

var instance2 = new Castle("Harrehal");

instance1.build = function(){
    console.log("Moat Caolin")
};

instance1.build();

instance2.build();

//Js Design Patterns
//should use prototype for functions, this is a js way to inherit,
// so all the objects that share the same prototype is going to have the same changes,
// if you change the prototype
//Good practices, using prototype

var Castle = function(name) {
    this.name = name;
}

Castle.prototype.build = function() {
    console.log(this.name);
}


var instance = new Castle("WinterHell");

instance.build();

//introduced ECSMAScript 5, antoher way to building OBJECTS!

var instance3 = Object.create(Castle.prototype, {
    name : {value : "Winterfell"}, writeble : false
});

instance3.build();

//MODULES

var Westeros = Westeros || {};

Westeros.Castle = function(name) {
    this.name = name;
}

Westeros.Castle.prototype.Build = function(){
    console.log("Castle built: " + this.name);
}

var instance = Westeros.Castle("WinterFell");

instance.build();
