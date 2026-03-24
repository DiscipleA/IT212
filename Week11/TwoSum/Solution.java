// Import HashMap from Java's utility package
// HashMap allows us to store key-value pairs (number -> index)
import java.util.HashMap;
import java.util.Arrays;

// Main class required by LeetCode (must be named "Solution")
class Solution {

    /**
     * Method: twoSum
     * ----------------
     * This method finds two indices in the array such that:
     * nums[index1] + nums[index2] == target
     *
     * @param nums   - input array of integers
     * @param target - the target sum we want to achieve
     * @return       - an array containing the two indices
     */
    public int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store numbers and their indices
        // Key   = number from the array
        // Value = index of that number in the array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array once (this ensures O(n) time complexity)
        for (int i = 0; i < nums.length; i++) {

            // Calculate the complement:
            // The number we need to add to nums[i] to reach the target
            // Example: if target = 9 and nums[i] = 2, complement = 7
            int complement = target - nums[i];

            // Check if the complement already exists in the HashMap
            // This means we have already seen a number that can pair
            // with the current number to make the target sum
            if (map.containsKey(complement)) {

                // If found:
                // - map.get(complement) gives the index of the earlier number
                // - i is the current index
                // Return both indices as the result
                return new int[] { map.get(complement), i };
            }

            // If the complement is NOT found:
            // Store the current number and its index in the map
            // This allows future elements to find it as a complement
            map.put(nums[i], i);
        }

        // This return statement is required by Java
        // According to the problem, this line should never be reached
        // because there is always exactly one valid solution
        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums1, target1)));

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(solution.twoSum(nums2, target2)));

        int[] nums3 = {3, 0, 5, 5, 0};
        int target3 = 10;
        System.out.println(Arrays.toString(solution.twoSum(nums3, target3)));
    }
}