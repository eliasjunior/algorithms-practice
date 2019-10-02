/**
 * Created by eliasmj on 17/12/2016.
 */
//TODO write any pre-function that could be needed for a test

function countStopElevator(elevatorInput) {


    var stackPeople = elevatorInput.listPeopleWeight;

    var i = 0, totalStop = 0;
    var roundMaxWeight = 0, roundMaxPeople = 0;
    var stackFloorTarget = [];
    var isElevatorFull = false, noMorePeople = false;

    while(stackPeople.length > 0) {

        roundMaxPeople++;

        roundMaxWeight += elevatorInput.listPeopleWeight[i];

        if (roundMaxWeight <= elevatorInput.peopleWeightLimit
            &&  roundMaxPeople <= elevatorInput.peopleLimit) {


            var fellaShifted = stackPeople.shift();

           // console.log('fellaShifted=',fellaShifted)

            stackFloorTarget.push( fellaShifted );


        } else {

            roundMaxPeople = 0;
            roundMaxWeight = 0;

            isElevatorFull = true;

        }

        noMorePeople = stackPeople.length === 0;

        //when elevator should move
        if(isElevatorFull || noMorePeople) {
            moveElevator();
            isElevatorFull = false;
        }


    }

    function moveElevator() {


        //console.log("new round", stackFloorTarget)
        var temp = null, current = null;
        while(stackFloorTarget.length > 0) {

            //first time, tem contain the previous and we will compare with the current
            if(!temp) {
                temp =  stackFloorTarget.shift();
                current = temp;

                totalStop += 1;

            } else {

                current =  stackFloorTarget.shift();

                if(current === temp) {
                    current = temp;
                } else {
                    totalStop += 1;
                }
            }
           // console.log('shift', current);
            //totalStop += 1;
        }

        //go back to the ground
        totalStop += 1;
        //console.log('end 1 round', totalStop);

    }

    return totalStop;

}

const assert = require("assert");


function test1() {
    const arr = {
        listPeopleWeight : [60,80,40],
        listPeopleFloorTarget : [2,3,5],
        floorSize : 5,
        peopleLimit: 2,
        peopleWeightLimit: 200
    }


    //should return 5 people
    const numberOfStops = countStopElevator(arr);
     assert.equal(numberOfStops, 5);

    console.log("Elevator stopped", numberOfStops);
}

function test2() {
    const arr = {
        listPeopleWeight : [40, 40, 100, 80, 20],
        listPeopleFloorTarget : [3,3,2,2,3],
        floorSize : 3,
        peopleLimit: 5,
        peopleWeightLimit: 200
    }

    //should return 6
    const numberOfStops = countStopElevator(arr);
    assert.equal(numberOfStops, 6)
    console.log("Elevator stopped", numberOfStops);
}

//main function
(function () {
    test1();
    test2();
})();

