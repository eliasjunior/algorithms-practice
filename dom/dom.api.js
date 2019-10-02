function main() {
    const elements = document.querySelectorAll('#test-1 > ul')
    const result = countLevel(elements)
    console.assert(result === 7, {message: 'invalid result ' + result})
}

function countLevel(element) {
    let maxLevel = -Infinity;
    const cost = 1;

    Object
        .entries(element)
        .forEach(([key, node]) => {
            if(node.children && node.children.length === 0) { // base case
               // another way node.setAttribute('class', 'botton') but there are performance issues, better bellow
                node.classList.add('botton')
                maxLevel = Math.max(0, maxLevel) 

              // node.innerHTML = '<ul><li>New Child</li></ul>';

            } else {
                const temp = countLevel(node.children)
                maxLevel = Math.max(temp, maxLevel)
            }
        })
    return maxLevel + cost
}

main()