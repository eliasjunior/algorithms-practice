/**
 * Created by eliasmj on 08/06/2016.
 */

(function () {
    'use strict'


    function getPersonName(people) {

        return people.map(function(person){
            return person.name;
        })

    }

    function filterPeople(people) {


        return people.filter(function(person){

            return person.age > 20;

        });


    }

    Array.prototype.map = function(callback) {

        var results = [];

        this.forEach(function(item){
            results.push(callback(item));
        })

        return results;
    }


    Array.prototype.filter = function(callback) {

        var results = [];

        this.forEach(function(item){

            if(callback(item)) {
                results.push(item)
            }

        })

        return results;


    }

    var people = [{name : "elias", age : "35"}, {name : "ian", age: 2}, {name : "Ani" , age : 26}];


    //console.log(getPersonName(people))
    
    console.log(filterPeople(people))

})();
