/**
 * Created by eliasmj on 04/04/2015.
 */


//taking prototype off , now you can just Function.method..
Function.prototype.method = function (name, func) {
    this.prototype[name] = func;
    return this;
};


//
//Array.prototype.method = function(name, func) {
//    this.prototype[name] = func
//    return this
//}
//
//
//Array.method('anii', function (  ) {
//    return this.splice(this.length - 1, 1)[0];
//});
//

String.prototype.method = function(name, func) {
    this.prototype[name] = func
    return this
}

Object.prototype.log = function() {

    console.log(arguments[0])



}

String.method('charAt', function (pos) {
    return this.slice(pos, pos + 1);
});

