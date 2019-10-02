const fs = require('fs');

const collection = () => {

	let items = [];
	
	return {

		add: (item) => {
			items.push(item);
		},

		size: () => {
			return items.length;
		},

		remove: (index) => {
			if(index < 0 || 
				index === undefined || 
				index >= items.length) {
				throw new Error('Invalid index');
			}

			items.splice(index, 1);
		},

		readFile: (fileName) => {
			const reading = (resolve, reject, err, contents) => {

				if(err) {
					reject(err);
				} else {
					resolve(JSON.parse(contents))
				}
			}

			return new Promise( (resolve, reject) => {
				fs.readFile(fileName, 'utf-8', reading.bind(null, resolve, reject));
			});
		}
	}
}

const foo = collection();

// foo.readFile('customers.json').then((data) => {
// 	console.log('cooool', data)
// })

module.exports = foo;