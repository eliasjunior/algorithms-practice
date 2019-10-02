const assert = require('assert')

function breadthFirst(M , x, y) {
	let queueVisited = [];
    
	const getValidCell = (target, actualPoint, row) => {
		if(row) {
			return M[row][target] !== undefined ? target : actualPoint; 
		} else {
			return M[target] !== undefined ? target : actualPoint; 
		}
	}

	queueVisited.push({row: x, col: y});

	while(queueVisited.length > 0) {
		let cell  = queueVisited.shift();
		
		M[cell.row][cell.col] = -2
			
		let starRow =  getValidCell(cell.row - 1, cell.row); 
		let startCol = getValidCell(cell.col - 1, cell.col, starRow)
		let endRow = getValidCell(cell.row + 1, cell.row);
		let endCol = getValidCell(cell.col + 1, cell.col, endRow);
		for(let i = starRow; i <= endRow; i++) {
			for(let j = startCol; j <= endCol; j++) {
				if(M[i][j] === 0) {
					queueVisited.push({row: i, col: j})
				}
			}
		}
	}
	return M
}

 const param2 = [
	[0,0,0,0,0],
	[0,1,1,1,0],
	[0,1,-1,1, 0]
 ]
 
  const expected2 = [
	[-2,-2,-2,-2,-2],
	[-2,1,1,1,-2],
	[-2,1,-1,1,-2]
 ]
 
 assert.deepEqual(expected2, breadthFirst(param2, 0,1))
 
 
 const param3 = [
	[0,0,0,0,0],
	[0,1,1,1,1],
	[0,1,-1,1, 0]
 ]
 
  const expected3 = [
	[-2,-2,-2,-2,-2],
	[-2,1,1,1,1],
	[-2,1,-1,1,0]
 ]
 
 assert.deepEqual(expected3, breadthFirst(param3, 0,1))
 
  const param4 = [
	[-1,1,0,0],
	[1,1,0,0],
	[0,0,1,1],
	[0,0,1,-1]
 ]
 
  const expected4 = [
	[-1,1,-2,-2],
	[1,1,-2,-2],
	[-2,-2,1,1],
	[-2,-2,1,-1]
 ]

 assert.deepEqual(expected4, breadthFirst(param4, 1,2))
 
  console.log('Success')