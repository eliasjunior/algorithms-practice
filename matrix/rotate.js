function rotate(matrix) {
    const n = matrix.length
    console.log('original')
    console.log(matrix)

    for(let layer = 0; layer < n/2 ; layer++) {
        const first = layer;
        const last = n - 1 - layer;

        for (let i = first; i < last; i++) {
            const offset = i - first;

            const top = matrix[first][i];

            //top <- left
            matrix[first][i] = matrix[last-offset][first];
            // left <- botton 
            matrix[last-offset][first] = matrix[last][last-offset];

            // botton <- right
            matrix[last][last-offset] = matrix[i][last]
            // right <- top 
            matrix[i][last] = top
        }
        console.log('partial', first)
        console.log(matrix)
    }
}