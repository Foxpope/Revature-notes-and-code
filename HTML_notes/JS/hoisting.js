//notes

let x = 10;

function timesTen(a) {
    return a*10;
}

let y = timesTen(x);

console.log(y);

//CREATION PHASE
//1. create the global object

//2. bind "this" to the global object

//3. set up memory heap for storing vars and function references

//4.store the func declarations in the heap...

//EXECUTION PHASE
//js executes line by line

//VARIABLE HOISTING
//happens during the creation phase
//effectively like moving variables to the top of the script

console.log(a); //this will return undefined
var a = 1;

console.log(b);
let b = 1;

//all declarations are hoisted in js, but var variables are initialized (though undefined)
//let and const are initialized (so the above throws an error)








