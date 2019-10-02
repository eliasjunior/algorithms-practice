// see notes
function maskify (creditCard) {
    if(isInputInvalid(creditCard)) {
        return creditCard;
    }
    return Array
            .from(creditCard)
            .map( (char, i) => getCorrectChar(i, creditCard.length, char))
            .join('');
}

const appContants = {
    CHAR_REPLACE: '#',
    INVALID_BEGIN_INDEX: 0,
    INVALID_LAST_4_INDEX: 4,
    MINIMUM_LENGHT: 5
}

function getCorrectChar(index, inputLength, char) {
    const isDigit = (character) => {
        const onlyDigits = /^\d+$/;
        return onlyDigits.test(character);
    };
    const limitRange = inputLength - appContants.INVALID_LAST_4_INDEX;
    
    if(isDigit(char) &&
        (index !== appContants.INVALID_BEGIN_INDEX && index < limitRange)) {
        return appContants.CHAR_REPLACE;
    } else {
        return char;
    }      
}

function isInputInvalid(creditCard) {
    if(typeof creditCard !== 'string') {
       return true;
    }
    return isEmpty(creditCard) || !isInputLengthValid(creditCard); 
}

function isEmpty(input) {
    return input === null ||
        input === undefined ||
        input === '' || input.trim() === '';
}

function isInputLengthValid(input) {
    return input.length > appContants.MINIMUM_LENGHT;
}


//let assert = require('chai').assert
const expect = require('chai').expect;

describe('Credit cards from test case', () => {
  it('should mask the digits of standard credit cards', () => {
    expect(maskify('5512103073210694')).to.equal('5###########0694');
    // assert.equal(maskify("5512103073210694"), "5###########0694")
  })

  it('should not mask the digits of short credit cards', () => {
    //assert.equal(maskify("54321"), "54321")
     expect(maskify('54321')).to.equal('54321');
  });
});

describe('Credit cards from the samples', () => {
  it('should mask the digits of only number', () => {
    expect(maskify('4556364607935616')).to.equal('4###########5616');
    expect(maskify('64607935616')).to.equal('6######5616');
  });
  it('should mask the digits of dash and numbers', () => {
    expect(maskify('4556-3646-0793-5616')).to.equal('4###-####-####-5616');
  });
  it('should not mask letters', () => {
    expect(maskify('ABCD-EFGH-IJKLM-NOPQ')).to.equal('ABCD-EFGH-IJKLM-NOPQ');
  });
  it('should mask valid digits in the correct index position ', () => {
    expect(maskify('A1234567BCDEFG89HI')).to.equal('A#######BCDEFG89HI');
  });
  it('should not mask input less than 6 characters', () => {
    expect(maskify('12345')).to.equal('12345');
  });
  it('should handle empty strings', () => {
    expect(maskify('')).to.equal('');
  });
  it('should skip words', () => {
    expect(maskify('Skippy')).to.equal('Skippy');
  });
});

describe('More Inputs', () => {
  it('should return null', () => {
    expect(maskify(null)).to.equal(null);
  });
  it('should return undefined', () => {
    expect(maskify(undefined)).to.equal(undefined);
  });
  it('should return undefined', () => {
    expect(maskify(' ')).to.equal(' ');
  });
  it('should skip input if is not a string', () => {
    expect(maskify(4556364607935616)).to.equal(4556364607935616);
    expect(maskify({})).to.eql({});
  });
});

describe('Functions from the service', () => {
  it('should return # for a number in the second index', () => {
    expect(getCorrectChar(1, 16, '1')).to.equal('#');
  });
  it('should return a number or char in the first index', () => {
    expect(getCorrectChar(0, 16, '1')).to.equal('1');
  });
  it('should return number if its in the last 4 digits', () => {
    expect(getCorrectChar(15, 16, '8')).to.equal('8');
  });
});

// ***************** numberToOrdinal

function numberToOrdinal(n) {
    if (isInvalidInput(n)) {
        return Number(n).toString();
    }
    return buildOrdinal(n);
}

const ORDINAL_SUFFIX = {
    '1': 'st',
    '2': 'nd',
    '3': 'rd'
};
const TEEN_NUMBERS = {
    '11' : true,
    '12' : true,
    '13' : true
};

const isTeenNumber = teen => TEEN_NUMBERS[teen];
const matchingSuffix = char => {
    const lastChar = char.charAt(char.length - 1);
    return ORDINAL_SUFFIX(lastChar) ? ORDINAL_SUFFIX(lastChar) : 'th';
}

const getOrdinalSuffix = c => {
    const lastTwo = c.slice(c.length - 2)
    if(isTeenNumber(lastTwo)) {
        return 'th';
    } else {
        return matchingSuffix(c);
    }
};


function buildOrdinal(num) {
    const box = [num];
    
    const result = box
        .map(n => Number(n).toString()) // 1111111 '111'
        .map(c => getOrdinalSuffix(c))
        .map(c => num + c)

    return result[0];
}

function isInvalidInput(num) {
    return num === 0
}


console.log(buildOrdinal(2), '2nd')
console.log(buildOrdinal(112), '112th')
console.log(buildOrdinal(111), '111th')
console.log(buildOrdinal(91), '91st')
console.log(buildOrdinal(911), '911th')