const assert = require('assert')

function clickField(M,x, y) {

	const getValidRangeForColumn = (target, validPostion, row) => {
		return M[row][target] !== undefined ? target : actualPoint; 
	}
	const getValidRangeForRow = (target, validPostion) => {
		return M[target] !== undefined ? target : validPostion; 
	}

	const findAreaForAClick = (rowPos, colPos) => {
		M[rowPos][colPos] = -2
		
		let starRow =  getValidRangeForRow(rowPos - 1, rowPos); 
		let endRow = getValidRangeForRow(rowPos + 1, rowPos);
		
		let startCol = getValidRangeForColumn(colPos - 1, colPos, starRow)
		let endCol = getValidRangeForColumn(colPos + 1, colPos, endRow);
		
		for(let i = starRow; i <= endRow; i++) {
			for(let j = startCol; j <= endCol; j++) {
				if(M[i][j] === 0) {
					findArea(i, j)
				}
			}
		}
	}
	findAreaForAClick(x,y)
	
	return M
}

const param1 = [
	[0,1,0,0],
	[0,0,0,1],
	[0,0,1,0],
	[1,0,1,1]
 ]
 
 const expected = [
	[-2,1,-2,-2],
	[-2,-2,-2,1],
	[-2,-2,1,-2],
	[1,-2,1,1]
 ]
 
 assert.deepEqual(expected, clickField(param1, 1,1))
 
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
 
 assert.deepEqual(expected2, clickField(param2, 0,1))
 
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
 
 assert.deepEqual(expected3, clickField(param3, 0,1))
 
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

 assert.deepEqual(expected4, clickField(param4, 1,2))
 
 console.log('Success')