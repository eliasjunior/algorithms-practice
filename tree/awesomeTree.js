const AwesomeTree = {
    add,
    contains,
    min,
    remove
}

function contains(node, value) {
    if(node === null) {
        return false
    } else if(node.data === value) {
        return true
    } else {
        return contains(node.left, value) ||
            contains(node.right, value)
    }
}

function add(node, value) {
    if(node === null) {
        node = createNode(value)
    } else if(node.data > value) {
        add(node.left, value)
    } else if(node.data < value){
        add(node.right, value)
    }
}

function min(node) {
    if(node === null) {
        throw new Error('Invalid node')
    }
    return minHelper(node)
}
function minHelper(node) {
    if(node.left === null) {
        return node.data;
    } else {
        return minHelper(node.left)
    }
}


function remove(node, value) {
    removeHelper(node, value)
}
function removeHelper(node, value) {
    if(node === null) {
        return false;
    }
    if(node.data > value) {
        removeHelper(node.left)
    } else if(node.data < value){
        removeHelper(node.right)
    } else {
        // node.data === value
        // Im the node to remove
        if(node.left === null && node.right === null) {
            // case 1 : leaf
            node = null
        } else if(node.right === null) {
            // case 2: left child only
            node = node.left
        } else if(node.left === null) {
            // case 3: right child only
            node = node.right
        } else {
            // case 4: L & R subrees, more complicated one
            const newData = getMin(node.right)
            node.data = newData;
            remove(node.right, newData)
        }
    }
}
module.exports = AwesomeTree;