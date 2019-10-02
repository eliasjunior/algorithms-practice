

//module.exports = function(arr){
var test =  function(arr){

	return {

        permute : function() {

            //decrease, find the decrease number of the descending order,
            // e.g: 3,5,4,2,1 >> 3 is the decrease, 5,4,2,1 descending
            var decrease = arr.length - 2;

            //find the decrease
            while(arr[decrease] > arr[decrease + 1] && decrease >= 0) {

                if(decrease === 0) {

                    return;
                }

                decrease --;
                console.log("-Decrease-", decrease)
            }

            console.log("DECREASE=",decrease)
            console.log("Array state", arr)

            //find the larger number in the tail (descending order) bigger than decrease
            var larger = arr.length - 1;
            while(arr[larger] < arr[decrease]) {
                larger--;
            }
            //swap their position
            swap(arr, larger, decrease);
            console.log("SWAP Decrease", arr)

            //reverse the tail descending to ascending order
            return reverseDescToAscOrder(arr, decrease);
        }

	}

    function swap(arr, i1, i2) {

        var temp;

        temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;

        //console.log("*** swap", arr)

        return arr;
    }

    function reverseDescToAscOrder(arr, decrease) {

        var leftIndex = decrease + 1 ;

        var rightIndex = arr.length - 1;

        console.log("left", leftIndex, "right ="+ rightIndex)

        while(leftIndex <  rightIndex) {
            arr = swap(arr, leftIndex, rightIndex);

            leftIndex++;
            rightIndex--;
        }
        return arr;
    }
}


var array = [3,5,4,2,1]

console.log(test(array).permute())


