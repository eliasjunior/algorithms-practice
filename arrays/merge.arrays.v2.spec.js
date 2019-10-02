const arrayMerger = require('./merge.arrays.v2')

describe('merge arrays', () => {
    it('should merge array b and c', () => {
        const arrayB = [3, 4, 6, 10, 11, 15];
        const arrayA = [1, 5, 8, 12, 14, 19];
        const expected = [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]

        expect(arrayMerger.mergeArrays(arrayA, arrayB)).toEqual(expected)
    })
    it('test b', () => {
        const arrayB = [3];
        const arrayA = [1];
        const expected = [1, 3]

        expect(arrayMerger.mergeArrays(arrayA, arrayB)).toEqual(expected)
    })
    it('test c', () => {
        const arrayB = [3, 3];
        const arrayA = [0, 1];
        const expected = [0, 1, 3, 3]

        expect(arrayMerger.mergeArrays(arrayA, arrayB)).toEqual(expected)
    })

})