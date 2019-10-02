const nodeFactory = function(value) {
    return {
        value: value,
        next: null
    }
}

function reverse(node) {
	if(node.next === null) {
		return node
	}
	
	let newHead = reverse(node.next)
	
	let current = newHead

	node.next = null

	while(current.next) {
		current = current.next
	}
	current.next = node
	
	return newHead
}

let node2 = nodeFactory(2)
let node5 = nodeFactory(5)
let node9 = nodeFactory(9)

node2.next = node5
node5.next = node9
//console.log('head', node2)
const result = reverse(node2)
console.log("result",result)
