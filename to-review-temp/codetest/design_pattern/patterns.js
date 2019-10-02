/**
 * Created by eliasmj on 05/05/2015.
 */

 'use strict'

var Westeros = Westeros || {};

var spec = function(name) {
	this.name = name;
}

Westeros.Castle = function(spec){

	return {

		build : function() {
			console.log("Castle built " + spec.name);
		},

		setName : function(name) {
			spec.name = name;
		}

	}


};


//var instance = new Westeros.Castle("WinterFell");
var instance = Westeros.Castle({name: "WinterFell"})

instance.name = "Moat Coalin";

instance.setName("Harenhal")

//instance.name = "WinterFell";


instance.build();


