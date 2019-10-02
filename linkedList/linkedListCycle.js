const nodeFactory = function(value) {
    return {
        value: value,
        next: null
    }
}

let node2 = nodeFactory(2)
let node5 = nodeFactory(5)
let node6 = nodeFactory(6)
let node1 = nodeFactory(1)
let node3 = nodeFactory(3)
let node15 = nodeFactory(15)



node2.next = node5
node5.next = node6
node6.next = node1
node1.next = node3
node3.next = node2

console.log(node2)

const linkedList = function() {
    return {
        findCycle(node) {
            let slowRunner = node;
            let fastRunner = node;
            while(slowRunner && fastRunner.next) {
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next.next

                if(slowRunner.value === fastRunner.value) {
                    return true
                }
            }
            return false
        }
    }
}
console.log('*************')
console.log("cycle", linkedList().findCycle(node2))
console.log('---------------')