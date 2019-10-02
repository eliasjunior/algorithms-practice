const mastifyFactory = require('./quick.test');

console.log(mastifyFactory.maskify('A1234567BCDEFG89HI'), '=>','A#######BCDEFG89HI' );

console.log(mastifyFactory.maskify('4556364607935616'), '=>', '4###########5616');

console.log(mastifyFactory.maskify('4556-3646-0793-5616'), '=>', '4###-####-####-5616');

console.log(mastifyFactory.maskify('4556-3646-0793-5616'), '=>', '4###-####-####-5616');

console.log(mastifyFactory.maskify('64607935616'), '=>', '6######5616');

// Input	Output	Comments
// "4556364607935616"	"4###########5616"	
// "4556-3646-0793-5616"	"4###-####-####-5616"	
// "64607935616"	"6######5616"	
// ABCD-EFGH-IJKLM-NOPQ	ABCD-EFGH-IJKLM-NOPQ	
// A1234567BCDEFG89HI	A#######BCDEFG89HI	
// "12345"	"12345"	No #s if less than 6 characters
// ""	""	Make sure to handle empty strings
// "Skippy"	"Skippy"	 

