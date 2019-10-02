(function(){
	'use strict'

	const myFactory = () => {

		const getDifference = (first, second) => {
			    var millisecondsPerDay = 1000 * 60 * 60 * 24;
			    var millisBetween = second.getTime() - first.getTime();
			    var days = millisBetween / millisecondsPerDay;

			    // Round down.
			    return Math.floor(days);
			}

		return {

			checkAvaiableDate : (dates) => {
				var i = 0;
				var currentDate;
				var result = null;
				
				while(dates.length > i && result === null) {
					
					var firstDate = new Date(dates[i]);
					var secondDate = new Date(dates[i + 1]);
					
					if(getDifference(firstDate, secondDate) === 1) {

						result = firstDate.getFullYear() + "-" + (firstDate.getMonth() + 1 )+ "-"+ firstDate.getDate();
					}

					i++;
				}

				return result;		
			},

			getEarlistAttendee: (country, email, startDate) => {

				var newAttendees = [];

				console.log("date", country.startDate, startDate, new Date(country.startDate).getTime() === new Date(startDate).getTime(), email)

				if(new Date(startDate) < new Date(country.startDate)) {
					//if got a earlier date, new attendee list

					newAttendees.push(email);
					country.attendees  = newAttendees;
					country.startDate = startDate;

					country.attendeeCount = 1;

				} else if(new Date(country.startDate).getTime() === new Date(startDate).getTime()){
					

					newAttendees = country.attendees;
					newAttendees.push(email);

					country.attendees = newAttendees;
					country.attendeeCount += 1;

					console.log("IM EQUALLLLL"+country.attendeeCount, newAttendees)

				} 

				return country;
			},

			updateAttendee: (countryAttendeed, startDate, partner) => {

				//var country = Object.assign({}, countryAttendeed);
				var country = countryAttendeed;
				var attendees = [];
				var hashDate = {};

				if(country) {

	      			if(startDate) {

						country = factory.getEarlistAttendee(country, partner.email, startDate)
						//countriesHash[partner.country] = country;

						return country
					} 

					return country;

	     		} else {
	     			//initizalize 
					attendees = [];
					country = {}
	     			
	     			if(startDate) {
						
						country.attendees = attendees;

						country.attendees.push(partner.email)
						country.startDate = startDate;
						country.name = partner.country;

						country.attendeeCount = 1;
						//console.log("First time " + partner.country, startDate)	

					} else {
							

						country.attendees = attendees

						country.attendeeCount = 0;
						country.startDate = startDate;
						country.name = partner.country;

						//console.log("no in hash and no date", country)	
					}

					return country;
	     		}

			},

			buildJsonToSend : (countriesHash) => {
				var result = {countries : []}

				var key;
				//build json to send
				for(key in countriesHash) {

				  var country = countriesHash[key];

				  country.attendeeCount = country.attendees.length;

				  result.countries.push(country)
				  
				}

				return result;
			},

			getJsonFile : (callback) => {

				const fs = require('fs');

				fs.readFile('partners_hubspot2.json', 'utf8', callback);
			}

		}

	}

//Tests
	const factory = myFactory();

	function testReadJson() {
     
		var callback = function (err, data) {

			if (err) {
				return console.log(err);
			}

			const responseJson = JSON.parse(data)

			loopOverPartners(responseJson.partners);
		}

		const data = factory.getJsonFile(callback);
	}

	function loopOverPartners(partners) {
		console.log(partners.length)
		var i ;
      	var startDate
      	var country = {	}
      	var partner = {	}
      	var countriesHash = {};

		for (i = 0; partners.length > i; i++) {
	      		
	      		//current partner loop
	      		partner = partners[i];

	      		//returns the earliest date from the array
	      		startDate = factory.checkAvaiableDate(partner.availableDates);

	      		console.log(">>>>", partner.country)

	      		countriesHash[partner.country] = 
	      			factory.updateAttendee(countriesHash[partner.country], startDate, partner);

		}
		console.log("**** RESULT *****")	
		console.log(countriesHash)
	}

	(function() {
		
		testReadJson();

	})()

})();

