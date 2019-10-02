const m = {
  linha : [0, 1, 0, 0, 0],
  coluna: [1, 0, 0, 0, 0]
}

function diagonalLeftUp({x, y}) {
  let stack = []
  stack.push(`[${ x},${y}]`)
  let row = x - 1;
  let col = y - 1;
  

  while (col >= 0 && row >= 0) {
    
    let p = `[${row},${col}]`
    // stack.push(`[${row},${col}]`)
    if(m.coluna[col] === 1 && m.linha[row] === 1) {
      console.log(p + ' -> IS NOT SAFE!! MOVE AWAY')
    }  else {
      console.log(p)
    }
    col--
    row--
  }

}

diagonalLeftUp({ x: 3, y: 2 })

function diagonalRightUp(cols, {x, y}) {
  console.log(`diagonalRightUp from [${x},${y}]`)
  let row = x - 1;
  let col = y + 1;

  while (col <= cols && row >= 0) {
    console.log(`[${row},${col}]`)
    col++
    row--
  }
}

diagonalRightUp(4, { x: 3, y: 2 })