//https://www.youtube.com/watch?v=WshpHyZIWRE

function helper(v, chosen) {
    console.log(`${indent(chosen)} helper([${v}], '${chosen}')`) 
    if (v.length === 0) {
        // base case
        console.log(`${indent(chosen)} print -> ${chosen}`);
    } else {
        const s = v[0];
        // choose
        chosen.push(s);

        // explore, insert or not
        // yes, insert first element to chosen
        helper(v.filter(e => e !== s), chosen)
        // no, remove this element
        helper(v.filter(e => e !== s), chosen.filter(n => n !== s))
        // unchoose 
        chosen.pop();
    }
}

function indent(c) {
    let result = ''
    for (let index = 0; index < c.length; index++) {
        result += '  ';
    }
    return result
}

helper(['Jane', 'Bob', 'Matt', 'Sara'], [])