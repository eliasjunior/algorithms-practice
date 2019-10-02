'use strict'

document.addEventListener('DOMContentLoaded', function () {
    const matrix = [
        ['blue', 'red', 'red'], 
        ['blue', 'gray', 'red'], ['blue', 'red', 'red']
    ];    
    createMatrix(matrix);
});

function createMatrix(colors) {
    const elementGrip = document.createElement('div');
    elementGrip.classList.add('matrix');

    colors.forEach( (row, i) => {
        row.forEach( (col, j) => {
            const element = document.createElement('div');
            element.appendChild(document.createTextNode(col +' '+i +','+j));
            element.classList.add('cell');
            element.classList.add(col);
            elementGrip.appendChild(element);
        });
    });
    console.log(elementGrip)
    document.body.appendChild(elementGrip);
    mainBfs(colors);
}

