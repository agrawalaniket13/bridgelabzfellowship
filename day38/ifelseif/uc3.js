"use strict";
const ps= require("prompt-sync");
const prompt = ps();
let number = prompt("Enter a number to know units: ");
if(number>=1 && number<=9){
    console.log("ones");
}
else if(number>=10 && number<=99){
    console.log("Tens");
}
else if(number>=100 && number<=999){
    console.log("Hundreds");
}
else if(number>=1000 && number<=9999){
    console.log("Thousands");
}