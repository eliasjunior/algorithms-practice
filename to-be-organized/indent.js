 /**
   * @param {string} chosen the parameter thats acummalates 
   */
 function indent(chosen) {
    let newCopy = Object.freeze(chosen)
    if(Array.isArray(newCopy)) {
      newCopy = newCopy.join('')
    }
    let result = ''
    for (let index = 0; index < newCopy.length; index++) {
      result += '  ';
    }
    return result
  }

module.exports = indent;
 