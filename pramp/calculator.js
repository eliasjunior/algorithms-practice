
function main() {
    const boxes = Array.from(document.getElementsByClassName('box'))

    const OPERATOR = {
        '+': (op1, op2) => Number(op1) + Number(op2),
        '-': (op1, op2) => Number(op1) - Number(op2),
        '*': (op1, op2) => Number(op1) * Number(op2),
        '/': (op1, op2) => Number(op1) / Number(op2)
    };

    let second = false
    let operand2 = '';
    let operand1 = '';

    function isDigit(character) {
        const onlyDigits = /^\d+$/;
        return onlyDigits.test(character);
    }

    const addEventToEachElement = (box) => {
        box.addEventListener('click', function (event) {
            const print = document.querySelector('h4');
            if (isDigit(box.innerText)) {

                if (!second) {
                    operand1 += box.innerText
                } else {
                    operand2 += box.innerText
                }

                print.appendChild(document.createTextNode(box.innerText))

            } else if (OPERATOR[box.innerText]) {
                second = true;

                operator = OPERATOR[box.innerText];

                print.appendChild(document.createTextNode(box.innerText))

            } else if (box.innerText === 'Enter') {
                const res = operator(new Number(operand1), new Number(operand2))
                console.log(new Number(operand1), new Number(operand2))
                print.appendChild(document.createTextNode('=' + res))
            } else if (box.innerText === 'Reset') {
                print.innerText = ''
            }
        })
    }
    boxes.map(addEventToEachElement)
}
document.addEventListener('DOMContentLoaded', main)