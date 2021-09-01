"use strict";

const ps = require("prompt-sync");
const prompt = ps();

let year = prompt("Enter Year");

let A=year%4;
let B=year%100;
let C=year%400;

if(B==0 && C==0)
{
    console.log(year+"is leap year");
}
else if(A==0)
{
    console.log(year+"is leap year");
}
else
{
    console.log(year+"is not a leap year");
}