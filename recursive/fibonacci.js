const indent = require("../indent");

function fibonacciIneficient(i) {
  if (i === 0 || i === 1) {
    console.log(`${indent(memo)} print -> ${memo}`);
    return i;
  }
  fibonacciIneficient(n, []);
}

function fibonacci(n) {
  let arr = [];
  return fibonacciHelper(n, arr);
}

function fibonacciHelper(i, memo) {
  console.log(`${indent(memo)} fibonacciHelper(${i}, [${memo}])`);
  if (i === 0 || i === 1) {
    console.log(`${indent(memo)} print -> ${memo}`);
    return i;
  }
  console.log(memo[i], 0);
  if (!memo[i]) {
    memo[i] = fibonacciHelper(i - 1, memo) + fibonacciHelper(i - 2, memo);
  }

  return memo[i];
}

console.log(fibonacci(4));
