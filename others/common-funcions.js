//TODO spec for the functions
//Data and Time
const getDifferenceInDaysTwoDates = (first, second) => {
  const milliSecondsPerDay = 1000 * 60 * 60 * 24;
  const millisBetween = second.getTime() - first.getTime();
  const days = millisBetween / milliSecondsPerDay;

  // Round down.
  return Math.floor(days);
}
const isNumber = (character) => {

  const reg = /^\d+$/;

  return reg.test(character);
}

const isInTheAlphabet = (str) => {

  const reg = /[a-z]/;

  return reg.test(str.toLowerCase());
}

const swap = (arr, indexA, indexB) => {
  const newArray = arr.slice(0);
  const temp = newArray[indexA];
  newArray[indexA] = newArray[indexB];
  newArray[indexB] = temp;
  return newArray;
};


const returnCharCodeFromStr = (word, index) => {
  return word.charCodeAt(index);
}

const returnStringFromCharCode = (code) => {
  return String.fromCharCode(code);
}

const readFile = (fileName) => {
  const reading = (resolve, reject, err, contents) => {
    if (err) {
      reject(err);
    } else {
      resolve(JSON.parse(contents))
    }
  }

  return new Promise((resolve, reject) => {
    fs.readFile(fileName, 'utf-8', reading.bind(null, resolve, reject));
  });
}

module.exports = {
  getDifferenceInDaysTwoDates,
  isNumber,
  isInTheAlphabet,
  swap,
  returnCharCodeFromStr,
  returnStringFromCharCode,
  readFile
};
