function findDuplicates(arr1, arr2) {
  const result = [];
  // index 4
  // index2 1
  // result 3 6
  console.log('debug', arr1, arr1)


  let index1 = 0
  let index2 = 0;
  while(index1 < arr1.length && index2 < arr2.length) {
    const element = arr1[index1];
    const secondElement = arr2[index2];
     
    if(element === secondElement) {
       result.push(element)
       index1++
       index2++
    } else if(element < secondElement) {
      index1++
    
    } else if(element > secondElement) {
       index2++
    }
  }
  return result;
}

console.log(findDuplicates([1,3,5,9], [2,4,6,10]))


  // your code goes here
  
  // iterate throught array 1 
  // grab element and binary search in the arr 2
  // if I find it, I add it to the arr  output
  
  //hold on...
  // What is the time complexity of your approach ?
  //  what if the size of first array is n and second array is m ?
  // okay, that is correct, what if n >> m 
  // can you do it better than nlog(m) ?
  // O(n) x O Log
  // okay , if n and m are both very large, can we do it better than nlog(m)?
  //  you were doing the same thing earlier right > grabbing an element and binary searching on the other . 
  // can you repeat the approach ?
  // may be you can think somethin other than binary search ?
  // basically when you grab the first element do you really need to search on the entire second array ?
  //O(n+m), 
  // n log m
  // m log n
  // yeah , looks good to me .  okay, fine may be you can have a look later.
  
  
  // first iterate arr 1, 
  // iterate/search arr 2
  // if === add the result if is lesser I can gran another, otherwise if I find move the arr2 index
  
  //why are you have two loops, can we just keep pointers
