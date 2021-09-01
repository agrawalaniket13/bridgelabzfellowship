"use strict";

const ps=require("prompt-sync");
const prompt=ps();

let a=prompt("Enter the value of a: ");
let b=prompt("Enter the value of b: ");
let c=prompt("Enter the value of c: ");

let x = a+b*c;
let y = a%b+c;
let z = c+a/b;
let w = a*b+c;

console.log("Maximum number: ");
if(x>y && x>z && x>w){
    console.log("x is greater");
}
else if(y>x && y>z && y>w){
    console.log("y is greater");
}
else if(z>x && z>y && z>w){
    console.log("z is greater");
}
else if(w>x && w>y && w>z){
    console.log("w is greater");
}

console.log("Minimum number: ");
if(x<y && x<z && x<w){
    console.log("x is smaller");
}
else if(y<x && y<z && y<w){
    console.log("y is smaller");
}
else if(z<x && z<y && z<w){
    console.log("z is smaller");
}
else if(w<x && w<y && w<z){
    console.log("w is smaller");
}