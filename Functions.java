import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Functions{

    public static void main(String[] args){

    }

    // Function 1: Add Two Numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Function 2: Subtract Two Numbers
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Function 3: Multiply Two Numbers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Function 4: Divide Two Numbers
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a / b;
    }

    // Function 5: Calculate Factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Function 6: Check Even or Odd
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Function 7: Check Prime Number
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function 8: Calculate Fibonacci Number
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // Function 9: Calculate Square Root
    public static double squareRoot(double n) {
        return Math.sqrt(n);
    }

    // Function 10: Calculate Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Function 11: Reverse a String
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Function 12: Check for Palindrome
    public static boolean isPalindrome(String input) {
        return input.equals(reverseString(input));
    }

    // Function 13: Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Function 14: Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    // Function 15: Calculate Area of a Circle
    public static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // Function 16: Calculate Area of a Rectangle
    public static double rectangleArea(double length, double width) {
        return length * width;
    }

    // Function 17: Calculate Area of a Triangle
    public static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    // Function 18: Find the Maximum of Three Numbers
    public static int maxOfThree(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    // Function 19: Find the Minimum of Three Numbers
    public static int minOfThree(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    // Function 20: Find the Length of a String
    public static int stringLength(String input) {
        return input.length();
    }

    // Function 21: Convert a String to Uppercase
    public static String toUpperCase(String input) {
        return input.toUpperCase();
    }

    // Function 22: Convert a String to Lowercase
    public static String toLowerCase(String input) {
        return input.toLowerCase();
    }

    // Function 23: Count Vowels in a String
    public static int countVowels(String input) {
        String vowels = "AEIOUaeiou";
        int count = 0;
        for (char c : input.toCharArray()) {
            if (vowels.indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }

    // Function 24: Count Consonants in a String
    public static int countConsonants(String input) {
        String consonants = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
        int count = 0;
        for (char c : input.toCharArray()) {
            if (consonants.indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }

    // Function 25: Check for a Leap Year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function 26: Generate a Random Number between a Range
    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    // Function 27: Calculate the Sum of Digits in a Number
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Function 28: Check if a Number is Armstrong Number
    public static boolean isArmstrong(int number) {
        int original = number;
        int sum = 0;
        int digits = (int) Math.floor(Math.log10(number)) + 1;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        return sum == original;
    }

    // Function 29: Calculate the GCD (Greatest Common Divisor) of Two Numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Function 30: Calculate the LCM (Least Common Multiple) of Two Numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Function 31: Check for a Perfect Number
    public static boolean isPerfectNumber(int number) {
        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i * i != number) {
                    sum += number / i;
                }
            }
        }
        return sum == number && number != 1;
    }

    // Function 32: Calculate the Nth Fibonacci Number using Recursion
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Function 33: Calculate the Nth Fibonacci Number using Iteration
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // Function 34: Generate a Random Password
    public static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    // Function 35: Find the Sum of an Array of Integers
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Function 36: Find the Average of an Array of Integers
    public static double averageArray(int[] arr) {
        if (arr.length == 0) {
            return 0.0;
        }
        return (double) sumArray(arr) / arr.length;
    }

    // Function 37: Reverse an Array
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Function 38: Check if an Array is Palindromic
    public static boolean isPalindromeArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Function 39: Remove Duplicates from an Array
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    // Function 40: Count Occurrences of an Element in an Array
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    // Function 41: Find the Maximum Value in an Array
    public static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Function 42: Find the Minimum Value in an Array
    public static int findMinValue(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Function 43: Sort an Array in Ascending Order
    public static void sortAscending(int[] arr) {
        Arrays.sort(arr);
    }

    // Function 44: Sort an Array in Descending Order
    public static void sortDescending(int[] arr) {
        Arrays.sort(arr);
        reverseArray(arr);
    }

    // Function 45: Find the Index of an Element in an Array
    public static int findElementIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Function 46: Check if an Array is Sorted in Ascending Order
    public static boolean isSortedAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Function 47: Check if an Array is Sorted in Descending Order
    public static boolean isSortedDescending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Function 48: Reverse a Linked List
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Function 49: Check if a String Contains a Substring
    public static boolean containsSubstring(String str, String substring) {
        return str.contains(substring);
    }

    // Function 50: Count Words in a String
    public static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }
}
