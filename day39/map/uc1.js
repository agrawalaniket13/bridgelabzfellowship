let map = new Map();
while (true) {
    let dice = Math.floor(Math.random() * 6 + 1);
    if (!map.has(dice)) {
        map.set(dice, 1);
    } else {
        let freq = map.get(dice);
        if (freq >= 10) {
            break;
        } else {
            map.set(dice, freq + 1);
        }
    }
}
console.log(map);
function getKey(val) {
    return [...map].find(([key, value]) => val === value)[0];
}
let minRollValue = Math.min(...map.values());
let maxRollValue = Math.max(...map.values());
console.log(getKey(minRollValue) + " is minimum rolled value for  " + minRollValue + " times");
console.log(getKey(maxRollValue) + " maximum rolled value for " + maxRollValue + " times");