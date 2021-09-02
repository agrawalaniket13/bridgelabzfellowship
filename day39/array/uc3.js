let number = Math.floor(Math.random() *100);
console.log(number);
let primeArr = new Array();
for (i=2; i<=number; i++) {
    while (number%i==0){
        primeArr.push(i);
        number = number/i;
    }
}
console.log("Prime Factors are : "+primeArr);
