function findSecondLargestBST(node) {
    const findLargestNode = (node) => {
        if(!node) {
            throw new Error('Should have at least one node');
        }
        if(node.right) {
            return findLargestNode(node.right);
        } 
        return node;
    };
    
    const findSecondLargestBST = (node) => {
        largestNode = findLargestNode(node);
        if(largestNode.left) {
            findSecondLargestBST(largestNode.left);
        }
        return largestNode.value;
    }

    return findSecondLargestBST(node);
}

// ***************************************
// strucs for testing
function BinaryTreeNode(value) {
    this.value = value;
    this.left  = null;
    this.right = null;
}

BinaryTreeNode.prototype.insertLeft = function(value) {
    this.left = new BinaryTreeNode(value);
    return this.left;
};

BinaryTreeNode.prototype.insertRight = function(value) {
    this.right = new BinaryTreeNode(value);
    return this.right;
};

//let root = new BinaryTreeNode(100);

// root.insertRight(120)
//     .insertLeft(115)
//     .insertRight(119);

//    console.log('Tree', root);

// let node80 = root.insertLeft(80)
// node80.insertLeft(75)
// node80.insertRight(90)
    
let root = new BinaryTreeNode(5);
let node3 = root.insertLeft(3)
node3.insertLeft(1)
node3.insertRight(4)

let node8 = root.insertRight(8)
node8.insertLeft(7)

let node12 = node8.insertRight(12)

let node10 = node12.insertLeft(10)

node10.insertLeft(9)
node10.insertRight(11)

const res = findSecondLargestBST(root);
console.log('Restul', res);