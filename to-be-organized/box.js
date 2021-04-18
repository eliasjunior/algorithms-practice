const Box = x => ({
    map: callback => Box(callback(x)),
    fold: callback => callback(x)
})



const result = Box('2')
    .map(i => i + 'nd')
    .fold(n => n)

console.log(result)