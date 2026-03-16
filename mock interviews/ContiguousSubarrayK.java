public int returnSubarrayOfK(int[] array, int k) {


// Input:  array = [2, 1, 5, 1, 3, 2], k = 3
// Output: 9
//// subarray [5, 1, 3] has the largest sum = 9

// Input:  array = [2, 3, 4, 1, 5], k = 2
// Output: 7
//// subarray [3, 4] has the largest sum = 7

    // loop through the array and check if the added value is bigger than your highestSum.
    // If so then update your highestSum
    // alway keep track of how many index you did to add up this number.

//    int highestSum = array[0];
    // the problem here is that if I assign this value what if this is the biggest value array
    // and the next number is a - negative integer
    // there is a chance you could loop through the enitre array without finding a bigger number
    // woudl give you the wrong answer because it needs added sum of substrings of K so i cannot makw this int highestSum = array[0]; variable.

    // Now to make the added value I can make this if statment
    if (array.length == 1) {
        return array[i];
    }

    int SumOfKValue = 0;

    int keepTrackOfK = 0;


    int highestSum = 0

    // use thsi variable to keep track of K as long as it is <= to k you can keep adding to your sumValue.
    // As soon as it becomes equal what do you do?
    // You make that the current sun value and keep adding on to it.
    // I think the key here is if you come across a number thats graater than your current sum value then just drop the last ones
    // new this index is most likley the answer.

    // there is 2 if statments one is variable to keep track of K as long as it is <= to k you can keep adding to your sumValue
    // second one is arra[i] greater than SumOfKValue if so then start again the keepTrackOfK from there.

    for (int i = 0; i < array.length; i++) {

        keepTrackOfK += 1;

        if (array[i] > SumOfKValue) {
            SumOfKValue = array[i];
            keepTrackOfK = 1;
        } else if(keepTrackOfK <= k){
            sumOfKValue += array[i];
        } else {
            keepTrackOfK = 1;
            if(SumOfKValue > highestSum) {highestSum = SumOfKValue;}
            SumOfKValue = array[i];
        }
    }

    return highestSum;
}

// Input:  array = [2, 1, 5, 1, 3, 2], k = 3


// How to implement this?
// I can count i + up until the k value allows and then in the next iteraton do the same thing
// this way I will have what all windows allow and I need to make sure I keep track of the largest sum.





public int returnSubarrayOfK2(int[] array, int k) {

    if (array.length == 1) {
        return array[0];
    }

    int highestSum = [0];

    for (int i = 0; i < array.length; i++) {
        int trackCount = 1;
        int arrayLookUp = i;
        int currentSum = array[i];

        while(trackCount < k) {
            trackCount += 1;
            arrayLookUp += 1;
            if (arrayLookUp >= array.length) {
                return highestSum;
            } else {
                currentSum += array[arrayLookUp];
            }
        }
        if (currentSum > highestSum) {
            highestSum = currentSum;
        }

    }

    return highestSum;
}



public int returnSubarrayOfK2(int[] array, int k) {

    int getSum = 0;


    for (int i = 0; i < k; i++){
        getSum += array[i];
    }

    int highestSum = getSum;

    for (int i = k; i < array.length; i++) {
        getSum = getSum - array[i - k] + array[i];
        if (getSum > highestSum) {
            highestSum = getSum;
        }
    }



    return highestSum;
}
