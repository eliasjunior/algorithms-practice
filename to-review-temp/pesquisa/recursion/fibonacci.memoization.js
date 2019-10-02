/**
 * Created by eliasmj on 12/05/2016.
 */
function main(n) {

    console.log("N *** " , n)

    var memo = {};

    (function fibonacci() {


        if (n in memo) {
            return memo[n];
        } else {

            if (n === 0 || n === 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }


    })()

}

main(8)
