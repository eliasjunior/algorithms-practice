var convert = function (s, numRows) {
  //edge cases here
  if (numRows === 1) {
    return s
  }

  const sArrays = [];
  let j = 0;
  let isIncrease = true;
  for (let i = 0; i < s.length; i++) {
    const char = s.charAt(i);

    sArrays[j] = sArrays[j] ? sArrays[j].concat(char) : char;
    if (isIncrease) {
      if (j < numRows - 1) {
        j++
      } else {
        j--
        isIncrease = false
      }
    } else {
      if (j > 0) {
        j--
      } else {
        j++
        isIncrease = true
      }
    }
  }
  const makeOne = (prev, current) => prev.concat(current);
  return sArrays.reduce(makeOne, '');
};

function runTest(s, numRows, expected) {
  const res = convert(s, numRows)
  console.assert(res === expected, `Opps I got ${res} but expected ${expected}`);
}

runTest('PAYPALISHIRING', 3, 'PAHNAPLSIIGYIR')
runTest('PAYPALISHIRING', 4, 'PINALSIGYAHRPI')
runTest('', 4, '')
runTest('A', 4, 'A')
runTest('AAA', 4, 'AAA')
runTest('ABC', 1, 'ABC')
runTest('ABC', 2, 'ACB')