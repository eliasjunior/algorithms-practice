// https://youtu.be/Frr8U5_TTtg?t=2090

// to be continued

// what can previous/output can be
let output = []
function dicesSumHelper(dicesQtd, sum) {
    //console.log('SUM ' + sum , 'Dices ' + dicesQtd, output)
    if(dicesQtd === 0 ) { // sum can be checked here, stackoverflow
        if(sum === 0) {
            console.log(output);
        } 
    } else if(sum >= dicesQtd && sum <= dicesQtd * 6){
        for(let i = 1; i <= 6; i++) {
            output.push(i);
            dicesSumHelper(dicesQtd - 1, sum - i);
            output.pop();
        }
    }
}

function dicesSum(dicesQtd, sum) {
    dicesSumHelper(dicesQtd, sum, [])
}

dicesSum(2, 9);