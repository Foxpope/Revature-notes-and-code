//js is single threaded

/**
 * js engine executees from the top of the file
 * 
 * creates the 
 */



function task(message) {
    //emulate a time consuming task
    let n = 100000000;
    while (n>0) {
        n--;
    }
    //when it finishes we'll log a message
    console.log(message);
}

//this would take a while (thus blocking the code)
// console.log("start")
// task("complete")
// console.log("done")


//callbacks to the rescue

console.log("start");

setTimeout(() => {
    task("task complete");
}, 1000);

console.log("done");


console.log("hello");

setTimeout(() => {
    console.log("execute immediately");
}, 1000);

console.log("bye")















