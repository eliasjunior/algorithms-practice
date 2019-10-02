/**
 * Created by eliasmj on 22/07/2016.
 */

(function () {
    'use strict'


    var orders = [
        {amount : 100},
        {amount : 200},
        {amount : 130},
        {amount : 80}
    ];


    var totalAmount = orders.reduce(function(sum, order){

        return sum + order.amount;


    }, 0);

    console.log("Total amount ",totalAmount)


})();
