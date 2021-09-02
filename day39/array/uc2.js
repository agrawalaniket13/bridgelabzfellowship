let number = new Array;
for (let i = 0; i < 10; i++) {
    number[i] = Math.floor(100 + Math.random() * 900);
}
console.log(number);
let largest = number[0];
let smallest = number[0];
let secondLarge = 0 , secondSmall = 0;
for(let i=0 ; i<number.length ; i++){
    if(number[i] > largest){
        secondLarge = largest;
        largest = number[i];
    }
    else if(number[i] < smallest){
        secondSmall = smallest;
        smallest = number[i];
    }
}
console.log("Second Largest : " + secondLarge);
console.log("Second Smallest : " + secondSmall);