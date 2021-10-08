/*
4 main scopes

-global scope; accessible anywhere

-functuional/local: in a function

-block: those in things like loops

-lexical: nested function
*/

//global
let name = "Chuck"

function funScope() {

    let x = 100;
    console.log(x);
}

let x;
console.log(x);

funScope();

const d = "dolphin";

function blockScope() {
    const c = "cat";
    var m = "bill";

    if (true) {
        console.log(c);
        console.log(m);

        let d = "dog";

        if (true) {
            console.log(d);
        }
    }

    console.log(d);
}

blockScope();