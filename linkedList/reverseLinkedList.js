// O (N) ?
// is it linear ? is there a cycle ?
// 
// *** wrong soluction, not inplace
const nodeFactory = function(value) {
    return {
        value: value,
        next: null
    }
}

function reverserLinkedList(head) {
	let tempStack = [];
	
	let current = head;
	
	while(current) {
		tempStack.push(current.value)
		current = current.next
	}
	
	let reversed = nodeFactory(tempStack.pop())
	current = reversed
	
	while(tempStack.length) {
		let item = tempStack.pop();
		current.next = nodeFactory(item);
		current = current.next
		
		console.log('Cooreet ** ', reversed)
	}
	//current.next = null;
	
	return reversed;
}

let node5 = nodeFactory(5)
let node90 = nodeFactory(90)
let node1 = nodeFactory(1)
let node2 = nodeFactory(2)

node5.next = node90
node90.next = node1
node1.next = node2

console.log('HEad ** ', node5)

const result = reverserLinkedList(node5)
console.log("IM",result)