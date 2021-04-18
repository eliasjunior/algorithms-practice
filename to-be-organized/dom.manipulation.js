const $ = (selector, context = document) => context.querySelector(selector)
const $$ = (selector, context = document) => context.querySelectorAll(selector)
const add = (type, content) => {
    const element = document.createElement(type)
    if(content) { 
        element.appendChild(document.createTextNode(content))
    }
    return element;
}

const html = (nodeList, newHtml) => {
    Array.from(nodeList).forEach(element => {
        element.innerHTML = newHtml
    })
}

