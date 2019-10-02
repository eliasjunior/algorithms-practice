function convertBinary(n) {
    n = new Number(n)
    let temp = []

    if (n > 0) {
        temp = ['0']

        for (let i = 1; i <= n; i++) {
            let carryOver = [1];

            let index = temp.length - 1;
            while (carryOver.length) {
                const bitN = new Number(temp[index])
                // console.log(`bitN=${bitN} `)
                if (temp[index]) {
                    const sum = bitN + carryOver.pop();
                    if (sum > 1) {
                        temp[index] = '0';
                        //is the overflwos pass the extra
                        carryOver.push(1)

                    } else if (sum === 1) {
                        // increment 1
                        temp[index] = '1';
                    }
                } else {
                    temp = [carryOver.pop()].concat(temp)
                }
                index--;
            }
        }
    }
    return temp.join('')
}

const input = process.argv.slice(2)[0]

console.log('result', convertBinary(input))