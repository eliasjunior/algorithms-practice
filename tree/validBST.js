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

function isCurrentNodeValid(value, lowerRange, upperRange) {
    return value > lowerRange && value < upperRange;
}
function isValidBST(node, minRange, maxRange) {
    if(!node) {
        return true;
    }
    if(isCurrentNodeValid(node.value, minRange, maxRange)) {
        return isValidBST(node.left, minRange, node.value) &&
            isValidBST(node.right, node.value, maxRange)
    } else {
        return false;
    }
}

function main() {
    // create nodes
    let root = new BinaryTreeNode(50)
    let node30 = root.insertLeft(30)
    let node80 = root.insertRight(80)
    node30.insertLeft(20).insertLeft(10)
    node30.insertRight(40).insertRight(45)
    
    node80.insertLeft(70).insertLeft(60)
    let node90 = node80.insertRight(90)
    node90.insertLeft(85)
    node90.insertRight(100)

    //right
    return isValidBST(root, -Infinity, Infinity);
}

console.log('main', main()) 

