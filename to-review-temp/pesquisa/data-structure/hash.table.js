/**
 * Created by eliasmj on 27/05/2016.
 */

(function () {
    'use strict'

    var M = 1000;

    var R = 31;

    function generateHashCode(key) {

        var hash = key % M;

      //  console.log(M % key)




        return hash;

    }

    var hash = generateHashCode(234456444)

    console.log("HASH", hash)


})();
