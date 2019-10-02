
const result = []

function indent(n) {
    let str = ''
    for (let i = 0; i < n; i++) {
            str += '....'
    }
    return str;
}

function permute(str, chosen) {
    const indentS = indent(chosen.length)
    if(indentS.length === 12)
        console.log(`${indentS}permute(${str}, ${chosen})`)
    
    if(str.length === 0) {
       // console.log(chosen)
        result.push(chosen)
        return;
    }

    for(let i = 0; i < str.length; i++) {
        const current = str.charAt(i);
        chosen += current;
        permute(erase(str, current), chosen)

        // un-choose
        chosen = chosen.replace(current, '')
        const indentS = indent(chosen.length)
       // console.log(`${indentS}un-choose ${current}`)
    }
}

function erase(str, except) {
    return str
        .split('')
        .filter(char => char !== except)
        .join('')
}

//console.log(filterStr('bc', 'b'))
//DANI
// DAN - IAN - ANI - ELIAS => DANIELS
 console.log(permute('DANIELS', ''))
//permute('ABSG', '')
//console.log(result)