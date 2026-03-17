
Input:  [1, 2, 3, 1]   → true
Input:  [1, 2, 3, 4]   → false
Input:  [1, 1, 1, 3, 3, 4, 3, 2, 4, 2] → true

//

public boolean sameIntegerFinder(int[] array) {


    HashSet<Integer> hashSet = new HashSet<>();

    for (int i = 0; i < array.length; i++) {
        if (hashSet.contains(array[i])) {
            return true;
        } else {
            hashSet.add(array[i]);
        }
    }

    return false;

}


// what could hashSet use to insert into the hashSet?
