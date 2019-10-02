function findRotationPoint(words) {
    // Find the rotation point in the vector
     const begin = words[0];
     
     let floor = 0;
     let ceil = words.length ;
     
     // cape, cake
    
     while(floor <= ceil) {
       let diff = ceil - floor;
       
       let targetIndex = Math.floor(diff/2) + floor;
      
       let current = words[targetIndex];
       let previous = null
       if(targetIndex > 0) {
         previous = words[targetIndex - 1]
       
       }
       
       
       // rotation check
       if(previous && current < previous) {
         // found for now
         return targetIndex;
         
       } else if(current >= begin) {
   
           floor = targetIndex + 1;
        
       } else {
           ceil = targetIndex - 1;
       }
    }
   
     return -1;
   }
   
   
   
   
   
   
   
   
   
   
   
   // Tests
   
   let desc = 'small array';
   let actual = findRotationPoint(['cape', 'cake']);
   let expected = 1;
   assertEquals(actual, expected, desc);
   
   desc = 'medium array';
   actual = findRotationPoint(['grape', 'orange', 'plum', 'radish', 'apple']);
   expected = 4;
   assertEquals(actual, expected, desc);
   
   desc = 'large array';
   actual = findRotationPoint(['ptolemaic', 'retrograde', 'supplant',
     'undulate', 'xenoepist', 'asymptote',
     'babka', 'banoffee', 'engender',
     'karpatka', 'othellolagkage']);
   expected = 5;
   assertEquals(actual, expected, desc);
   
   function assertEquals(a, b, desc) {
     if (a === b) {
       console.log(`${desc} ... PASS`);
     } else {
       console.log(`${desc} ... FAIL: ${a} != ${b}`);
     }
   }