/* I was expecting that I should print all possible results as you can see in the comments, for example var A = [30, 20, 10] it should print 0, 1, 2 , I thought the compiler wasn't working properly because I tested on jsfiddle.net and it was ok, Unfortunately when I understood why was compiling it was too late */

//var arr = [2,2,2,2,1,2,-1,2,1,3] // 4, 6, 8
// var arr = [1,2,3, -1,2,2, 1] //0, 3, 6
var arr = [30, 20, 10] //0, 1, 2
//var arr = [-1, -1, 2] //1
var result = []
var j = 0


var solution = function(a) {
  
  for (var i = 0; i < a.length; i++) {
    
    firstPosition(i, a)
    
    checkSliceAsceding(i, a)
    
    checkLastPosition(i, a)
    
  }
  console.log(result)
}

//check the first position, if the next position is greater or lesser 
var firstPosition  = function(index, array) {
   if (index === 0 && (array[index] < array[index + 1] || array[index] > array[index + 1]))  {
        result[j] = 0
        j++
    }
}

//current position is greater, the next starts the new ascending slice, 
// or in case it's equal and starts to increase e.g: [-1, -1, 2] //2
var checkSliceAsceding = function(index, array) {
  
    if (array[index] > array[index + 1] ) {
     
       result[j] =  index + 1
       j++
   
    } else if (array[index] < array[index + 1] && array[index] === array[index - 1] ) {
       result[j] = index
    }
}

//get the last position if is asceding
var checkLastPosition = function(index, array) {
  
    if (index === array.length && array[index] < array[index - 1]) {
       result[j] = index
       j++
    }
}

solution(arr)
