// print a binary tree
function print(node) {
    if(node !== null) {
        console.log(node.value)
        print(node.left)
        print(node.right)
    }
}

// count the size of the binary tree
function countSize(node, count) {
    if(node === null) {
        return 0
    } else {
        return 1 + print(node.left) + print(node.right)
    }
}


/**
            7
          /  \
        41    9  
       /  \   / \
     29    6 81  40
       \
         7
*/