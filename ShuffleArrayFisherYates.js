/**
 * Shuffles the array of numbers. Employs the Fisher-Yates shuffle algorithm.
 * Walks the array in reverse order and swap each element with a random one
 * before it. Modifies the array itself.
 * @param {number[]} array of numbers to shuffle
 */
function shuffle(array){
    // walk the array in reverse order
    for (let i = array.length -1; i > 0; i--){
         // Get a random index from 0 to i
        let j = Math.floor(Math.random() * (i + 1));

        // swap elements array[i] and array[j]
        // we use "destructuring assignment" syntax to achieve that
        [array[i], array[j]] = [array[j], array[i]]; 
    }
}

/* Test Code runs shuffle() 1,000,000 times and counts appearances of all
possible results */

// counts of appearances for all possible permutations
let count = {
    '123': 0,
    '132': 0,
    '213': 0,
    '231': 0,
    '321': 0,
    '312': 0
};

for (let i = 0; i < 1000000; i++) {
    let array = [1, 2, 3];
    shuffle(array);
    count[array.join('')]++;
}

// show counts of all possible permutations
for (let key in count) {
    console.log(`${key}: ${count[key]}`);
}
/* Example Output 
123: 166159
132: 166400
213: 166889
231: 166832
312: 167124
321: 166596

123: 166693
132: 166647
213: 166628
231: 167517
312: 166199
321: 166316

Looks good, all permutations appear with roughly the same probability.
Performance-wise the Fisher-Yates algorithm is much better, 
there's no sorting overhead.
*/