/**
 * A library of operations on arrays of characters (char values).
 * The library also features a string comparison method.
 */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = { 'c', 'l', 'e', 'a', 'r', 'l', 'y' };
        char[] arr2 = { 'U', 'n', 'd', 'e', 'r', 's', 't', 'o', 'o', 'd' };
        System.out.println(str); // Prints the string
        println(arr1); // Prints an array of characters
        System.out.println(charAt(arr1, 2));
        System.out.println(indexOf(arr1, 'l'));
        System.out.println(indexOf(arr1, 'l', 3));
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /**
     * Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /**
     * Returns the char value at the specified index. Assume that the array is
     * non-empty.
     */
    public static char charAt(char[] arr, int index) {
        return arr[index];
    }

    /**
     * If the two arrays have the same value in every index,
     * returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length == 0 && arr2.length == 0) {
            return true;
        } else if (arr1.length != arr2.length) {
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i])
                    return false;
            }
            return true;
        }
    }

    /**
     * Returns the index within the given array of the first occurrence of the given
     * character.
     * If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        // FIXED: This now calls the detailed version starting at 0
        return indexOf(arr, ch, 0);
    }

    /**
     * Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == ch)
                return i;
        }
        return -1;
    }

    /**
     * Returns the index within the given arr of the last occurrence of the given
     * character.
     * If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ch) {
                // FIXED: Changed "return (arr.length - i)" to just "return i"
                return i;
            }
        }
        return -1;
    }

    /*
     * Returns an array which is the concatanation of the two given arrays.
     */
    public static char[] concat(char[] arr1, char[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        char[] result = new char[len1 + len2];

        for (int i = 0; i < len1; i++) {
            result[i] = arr1[i];
        }

        for (int i = 0; i < len2; i++) {
            result[len1 + i] = arr2[i];
        }

        return result;
    }

    /**
     * Returns a new array that can be described as a sub-array of this array.
     * The sub-array begins at the specified beginIndex and extends to the character
     * at index endIndex - 1.
     * For example, if arr contains the characters "hamburger", then subArray(4, 8)
     * returns an array of
     * characters containing the characters "urge".
     */
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] result = new char[endIndex - beginIndex];

        // FIXED: Loop condition is now "i < endIndex" (removed the -1)
        for (int i = beginIndex; i < endIndex; i++) {
            result[i - beginIndex] = arr[i];
        }
        // FIXED: Now returns the array instead of null
        return result;
    }

    /**
     * Returns a single integer that represents the given array. This integer is
     * sometimes referred to as the array's "hash code".
     * The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... +
     * arr[n-2]*7 + arr[n-1]
     * where arr[i] is the i'th character of the array, and n is the array's length.
     * The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        long hash = 0;
        if (arr.length == 0)
            return 0;
        else {
            // FIXED: Loop now goes up to "i < arr.length" (removed the -1)
            for (int i = 0; i < arr.length; i++) {
                // FIXED: Used Math.pow instead of ^
                long power = (long) Math.pow(7, arr.length - (i + 1));
                hash += arr[i] * power;
            }
            return hash;
        }
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * * @return -1 if str1 is lexicographically less than str2,
     * zero if they are equal, and 1 if str1 is
     * lexicographically greater than str2.
     * return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        // FIXED: added checks for empty strings (length == 0)
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return -2;
        }

        int len1 = str1.length();
        int len2 = str2.length();
        int limit = Math.min(len1, len2);

        for (int i = 0; i < limit; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 != c2) {
                if (c1 < c2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }

        if (len1 < len2) {
            return -1;
        } else if (len1 > len2) {
            return 1;
        } else {
            return 0;
        }
    }
}