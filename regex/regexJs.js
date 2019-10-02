'use strict'

const output = (str, regex, target) => {
  target.innerHTML = 
    str.replace(regex, str => `<span>${str}</span>`);
}

var regex = /^http:\/\/10.157.193.200|^https:\/\/sandbox.qkr.mastercard.com/
//^https:\/\/sandbox.qkr.mastercard.com
//https://sandbox.qkr.mastercard.com 
var str = "https://sandbox.qkr.mastercard.com"

//console.log(regex.exec(str))

output(str, regex, document.querySelector('pre'))

 function isNotDevelopment(str) {
        //check if is stage, sandbox or prod
        var regex = /^http:\/\/10.157.193.200|^https:\/\/sandbox.qkr.mastercard.com|^https:\/\/qkr.mastercard.com/;
        return regex.test((str));
      }