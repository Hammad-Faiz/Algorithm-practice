//Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//Output: 6
/// / subarray [4, -1, 2, 1] has the largest sum = 6

//Input:  [1]
//Output: 1

//Input:  [-1, -2, -3]
//Output: -1
//// even all negatives — return the max single element



// Approach first:

// if the array has only one value then return that value
// if the value of all the arrays are negative then return the single lowest inetger


// check near the highest numer
// keep track of all the postive numbers and see which one are the closest to each other
// This has a flaw because if what it has a big negative value like {5, ,-20 ,10}
// Hard part is finding how and where to stop tracking

// Brute force way
// Track the literate value of each one combination and see what they all add up to?
// How to do this?
// You can either declare bunch of arrays where each one has all the combination
// or create a hashMap where it keep track of all the combination
// Basically will be like 0
//

public int largestSum(int[] array){
    int highestSum = array[0];
    for (int i = 0; i < array.length; i++) { // first loop now I need to check and add up all the combinatins with this index and keep track of the highest numbers
        int currentValue = array[i]; // want this here because you need it to get back to a number since
        if (currentValue > highestSum) {highestSum = currentValue};
        for (int j = i + 1; j < array.length; j++) {
            currentValue = currentValue + array[j];
            if (currentValue > highestSum) {
                highestSum = currentValue;
            }
        }
    }

    return highestSum;
};

public int oprimalLargestSum(int[] array){
    int highestSum = array[0];
    int currentSum = array[0];
    for (int i = 0; i < array.length; i++) {

        if (array[i] > highestSum) {
            highestSum = array[i];
        }

        if (array[i] > currentSum + array[i]) {
            currentSum = array[i];
        } else {
            currentSum = currentSum + array[i];
        }

        if (currentSum > highestSum) {
            highestSum = currentSum;
        }
    }

    return highestSum;
};






// what does this do?
// loops throught the first for loop and it will for each number see the combinaton of all the possible sums and teck it and see if its greater than the highestSum
// if not then it just keeps prov=cssing if so then it reassigns the highestSum to this new value because this is the hiighest value.
// currentValue is keeping track of all the possible value of combination that can happen with current array[i] value
// Could something go wrong if array[i] itself is greater than all its other combination?
// I think yes because if its largest value the next thing by it is a negative then you just missed out on the hughest value in the array
// and possibly what if this value is gonna be larger than any conbinations
// I added if (currentValue > highestSum) {highestSum = currentValue}; to preven this from happening now it will store this value as the highestSum if its greater than
// previus highestSum.

// put in the return highestSum after the for loops end, and since the array has ti always have at least one value it should return an int sumber no matter what.
// But this highestSum variable by the time of the return shoudl always have the highest value by now even if its only one element in the array.



// in the first loop you wanna do i < array.length - 1 because by the time it gets to the kast index in the first for loop this nuber would have had its every combination done to it already




