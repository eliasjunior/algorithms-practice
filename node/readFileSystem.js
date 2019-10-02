function fileUtils () {
	const fs = require('fs');

	return {
		main(currentFolder) {
			let path = currentFolder || '/Users/eliasmj/WebstormProjects/test-code/node';
            let fileDuplicateMap = {};
            let result = [];

			if(process.argv[2]) {
				path = process.argv[2];
			}
            const files = this.readAllDirAndFilesFromAPath(path);

            for(let i = 0; i < files.length; i++) {
                let filePath = files[i];
                let fileBytes = fs.readFileSync(filePath);

                if(fileDuplicateMap[fileBytes.length]) {
                    let fileBytesTemp = fs.readFileSync(fileDuplicateMap[fileBytes.length]);
                    if(this.isFileEqual(fileBytes, fileBytesTemp)) {
                         const names = this.getOlderFileBaseOnTimeEdited(fileDuplicateMap[fileBytes.length], filePath);
                         result = result.concat(names);
                    }
                } else {
                    fileDuplicateMap[fileBytes.length] = filePath;
                }
            }
            console.log('result',result)
		},
        readAllDirAndFilesFromAPath(path) {
            let fileNames = [];

            let items = fs.readdirSync( path);

            items.forEach(item => {
                let stats = fs.statSync(path + '/' +item);
                if(!stats.isFile()) {
                    let temp = this.readAllDirAndFilesFromAPath(path + '/' +item)
                    fileNames = fileNames.concat(temp);
                } else {
                    fileNames.push(path + '/' +item)
                }
            });

            return fileNames;
        },
        isFileEqual(fileA, fileB) {
            if(fileA.length !== fileB.length) {
                return false;
            }
            for(let i = 0; i < fileA.length; i++) {
                let byteA = fileA[i];
                let byteB = fileB[i];

                if(byteA !== byteB) {
                    return false;
                }
            }
            return true;
        },
        getOlderFileBaseOnTimeEdited(fileA, fileB){
            let fileInfoA = fs.statSync(fileA);
            let fileInfoB = fs.statSync(fileB);
            if(fileInfoA.mtime > fileInfoB.mtime) {
                return [fileA, fileB]
            } else {
                return [fileB, fileA]
            }
        }
	}
}


fileUtils().main();

