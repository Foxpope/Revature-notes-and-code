const immuteable = "never";
let muteable = 'maybe';

console.log(immuteable + " " +muteable);

let templateLiteral = ``;

templateLiteral = `this is multi line

whitespace


printing this`

console.log(templateLiteral);

let age = 97;
let sentence = "Hello, I am " + age + " years old"

console.log(sentence);

templateLiteral = `Now I am ${age + 1} years old`;

console.log(templateLiteral);

console.log(`${400 * 3}`);