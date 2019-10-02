function getCheapestCost(rootNode) {
  let current = rootNode;

  if (current.children.length === 0) {
    return current.cost;
  }

  let minSalesPath = Infinity;

  for (let i = 0; i < current.children.length; i++) {
    let currentChildNode = current.children[i];

    let salesPathSum = getCheapestCost(currentChildNode);

    minSalesPath = Math.min(minSalesPath, salesPathSum);
  }
  console.log('Current min + current cost=', minSalesPath + current.cost)
  // console.log('all siblings path value '  , siblingsCount, childrenVal)
  return minSalesPath + current.cost;
}

let root = new Node(0)

// child 
let node5 = new Node(5);
let node5childA = new Node(4)
node5.children.push(node5childA)

let node3 = new Node(3)

let node3childA = new Node(2)
// gran child of 3
let node3GrandChildA = new Node(1)
node3childA.children.push(node3GrandChildA)
// gran gran child of 3
let node3GrangranChildA = new Node(2)
node3GrandChildA.children.push(node3GrangranChildA)

// 0 child of 3
let node3childB = new Node(0)
let node3GrandChildB = new Node(10)
node3childB.children.push(node3GrandChildB)

node3.children.push(node3childA)
node3.children.push(node3childB)

// 6 child
let node6 = new Node(6)
// 0 child of 6
let node6childA = new Node(1)
let node6childB = new Node(5)

node6.children.push(node6childA)
node6.children.push(node6childB)


root.children.push(node5)
root.children.push(node3)
root.children.push(node6)

console.log('Final ', getCheapestCost(root));
/******************************************
 * Use the helper code below to implement *
 * and test your function above           *
 ******************************************/

// Constructor to create a new Node
function Node(cost) {
  this.cost = cost;
  this.children = [];
}
