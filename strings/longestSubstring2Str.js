// Write a function that takes two strings, s1 and s2 and returns
// the longest common subsequence of s1 and s2, it can have something between like below
// 'ABAZDC', 'BACBAD' => 'ABAD'
// 'AGGTAB', 'GXTXAYB' => 'GTAB' 
// https://www.youtube.com/watch?v=10WnvBk9sZc&t=70s

function indent() {
    
}

function logenstSubSeq(s1, s2, s1StartIndex = 0, s2StartIndex = 0) {
    //console.log(s1StartIndex, s2StartIndex)
    const results = [];

    for (let s1Index = s1StartIndex; s1Index < s1.length; s1Index++) {
        const s1Char = s1[s1Index];
        const s2Index = s2.indexOf(s1Char, s2StartIndex);

        let result = []
        if(s2Index !== -1) {
            result.push(s1Char, ...logenstSubSeq(s1, s2, s1Index + 1, s2Index + 1))
        }

        results.push(result)
    }
    const longest = findLongest(results)
    return longest.join('')
}
function findLongest(arr) {
    let longest = [];
    for(let candidade of arr) {
        if(candidade.length > longest.length) {
            longest = candidade;
        }
    }
    return longest;
}

console.log(`result`, logenstSubSeq('ABAZDC', 'BACBAD'));


// function getLongestSubString(s1, s2) {
//     //TODO:  edge cases function goes here
//     let maxSubString = '';
//     let j = 0;
//     for(let i = 0; i < s1.length; i++) {
//         let notFound = true;
//         let charS1 = s1.charAt(i);
//         let s1Sub = maxSubString.concat(charS1);
//         //TODO: change to while, because if I find I should stop
       
//          // base case
//         while(notFound || j < s2.length) {
//             let charS2 = s2.charAt(j);

//             let s2Sub = maxSubString.concat(charS2);

//             if(s1Sub === s2Sub) {
//                 const temp = s1Sub.concat(s2Sub);
//                 if(temp.length >= maxSubString.length) {
//                     maxSubString = temp;
//                 }
//                 notFound = false;
//                 j++; // not Sure yet
//             }

//         }
//         j = 0;
//     }

// }