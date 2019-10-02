function printAllBinaryHelper(digits, prev) {
  //console.log(`print helper ${digits}, ${prev}`)
  if (digits === 0) {
    console.log(prev)
  } else {
    printAllBinaryHelper(digits - 1, prev + '0')
    printAllBinaryHelper(digits - 1, prev + '1')
  }

}

function printAllBinary(digits) {
  printAllBinaryHelper(digits, '');
}

printAllBinary(4);