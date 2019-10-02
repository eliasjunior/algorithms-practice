var addTwoNumbers = function (l1, l2) {
  const queueA = buildQueue(l1);
  const queueB = buildQueue(l2);
  let remainder = 0
  let sum = getSum(queueA, queueB, remainder);
  const makeSumDecimal = () => {
    if (sum >= 10) {
      sum = sum - 10;
      remainder = 1;
    } else {
      remainder = 0;
    }
  }
  makeSumDecimal();

  const linkedResult = create(sum);
  let current = linkedResult;
  while (queueA.length || queueB.length) {
    sum = getSum(queueA, queueB, remainder);

    makeSumDecimal();

    current.next = create(sum);
    current = current.next;
  }
  if (remainder > 0) {
    current.next = create(remainder);
  }

  return linkedResult;
};

function getSum(queueA, queueB, remainder) {
  const num1 = queueA.length > 0 ? queueA.shift() : 0;
  const num2 = queueB.length > 0 ? queueB.shift() : 0;
  let sum = 0;
  if (remainder > 0) {
    sum = remainder + num1 + num2;
  } else {
    sum = num1 + num2;
  }
  return sum;
}

function buildQueue(linkedList) {
  let stackNumber = [linkedList.val];

  let next = linkedList.next;

  while (next !== null) {
    stackNumber.push(next.val)
    next = next.next;
  }
  return stackNumber;
}
function create(val) {
  return new ListNode(parseInt(val, 10));
}


/// *************
const n1 = create(1)
const n3 = create(8)
n1.next = n3
// const n4 = create(4)
// n3.next = n4
// const n5 = create(0)
// n4.next = n5
// const n6 = create(1)
// n5.next = n6


const k1 = create(0)
// const k2 = create(8)
// k1.next = k2
// const k3 = create(0)
// k2.next = k3


const res = addTwoNumbers(n1, k1)
console.log(res)


function ListNode(val) {
  this.val = val;
  this.next = null;
}