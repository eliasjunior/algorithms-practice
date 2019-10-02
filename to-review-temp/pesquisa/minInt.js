/**
 * Created by eliasmj on 20/07/2016.
 *
 * voce tem um array [2, 10, 1, 4, 5]
 14:06:54  voce tem que retornar a diferenca do maior numero pro menor numero
 14:07:05  mas o menor numero tem que estar num indice menor do que o indice do maior numero
 14:07:16  ou seja, naquele array ali em cima, o resultado seria 10 - 2 = 8

 */

(function () {
    'use strict'

    var matrix = [[2, 3, 10, 2, 4, 8, 1], [10, 10, 10, 2, 4, 8, 1], [11, 10, 10, 2, 4, 8, 1]];

    matrix.forEach(function(arr){

        var i ;
        var biggest = -1;
        var smallest = Infinity;
        var proBig, proSmall;

        for (i = arr.length - 1; i >= 0; i--) {
            proBig = arr[i];
            proSmall = arr[i-1];

            if(proBig > biggest) {
                biggest = proBig;

                //when finds the biggest reset the smallest because its in the left side
                smallest = Infinity;

                if (i === 0 ) {
                    //if the biggest is in the first pos there is no smallest
                    smallest = -1;
                }
            }

            if (proSmall < smallest) {
                smallest = proSmall
            }

        }

        console.log("ARRAY ", arr)
        console.log("Biggest", biggest, 'Smallest', smallest, "Difference", getDifference(biggest, smallest));
        console.log("================================================================")
    })

    function getDifference(max, min) {

        if(min > 0) {
            return max - min
        } else {
            return -1;
        }

    }

})();
