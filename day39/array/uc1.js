let n = new Array;
for (let i = 0; i < 10; i++) {
    n[i] = Math.floor(100 + Math.random() * 900);
}
console.log(n);

let sortArray = n.sort();
console.log("Second Largest number  : " + sortArray[sortArray.length-2]);
console.log("Second Smallest number : " + sortArray[1]);