
const arr = [100, 200, 300, 400]
const k = 3;
const n = arr.length;
let max_sum = 0;
const size =  n - k + 1;
for (let i = 0; i < size; i++) {
  let current_sum = 0;

  for (let j = 0; j < k; j++) {
    console.log(arr[i + j])
    current_sum = current_sum + arr[i + j];
  }
  max_sum = Math.max(current_sum, max_sum);    // pick maximum sum 
}

console.log(max_sum)