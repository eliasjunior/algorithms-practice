
const exportar = {}

exportar.reverseWords = (arrChar) => {
  //TODO edge cases function
  arrChar = exportar.reverseWord(0, arrChar.length - 1, arrChar);
  console.log('all ', arrChar)
  let slowRunner = 0;
  for (let fasterRunner = 0; fasterRunner < arrChar.length; fasterRunner++ ) {
    // I could use slice but the problem is that it would take O(N) space to realocate the new array, also O(N) to run the substring
    // TODO make sure strt greater then 2

    // next char rename
    let char = arrChar[fasterRunner];
    if (char === " " ) {
      arrChar = exportar.reverseWord(slowRunner, fasterRunner - 1, arrChar);
      console.log('partial ', arrChar)
      fasterRunner++;
      slowRunner = fasterRunner;
    } else if(fasterRunner === arrChar.length - 1) {
      arrChar = exportar.reverseWord(slowRunner, fasterRunner , arrChar);
    }
  }
  return arrChar;
}

exportar.reverseWord = (start, end, wordInChar) => {
  while (start < end) {
    wordInChar = swap(start, end, wordInChar);

    start = start + 1;
    end = end - 1;
  }
  return wordInChar;
}

function swap(start, end, wordInChar) {
  const temp = wordInChar[start];
  wordInChar[start] = wordInChar[end];
  wordInChar[end] = temp;

  return wordInChar;
}

module.exports = exportar