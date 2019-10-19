/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 *
 * https://leetcode.com/problems/compare-version-numbers/description/
 *
 * algorithms
 * Medium (24.95%)
 * Likes:    345
 * Dislikes: 1219
 * Total Accepted:    153.5K
 * Total Submissions: 615K
 * Testcase Example:  '"0.1"\n"1.1"'
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise
 * return 0.
 * 
 * You may assume that the version strings are non-empty and contain only
 * digits and the . character.
 * The . character does not represent a decimal point and is used to separate
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 * You may assume the default revision number for each level of a version
 * number to be 0. For example, version number 3.4 has a revision number of 3
 * and 4 for its first and second level revision number. Its third and fourth
 * level revision number are both 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * 
 * Example 2:
 * 
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * 
 * Example 4:
 * 
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same
 * number “1”
 * 
 * Example 5:
 * 
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision
 * number, which means its third level revision number is default to "0"
 * 
 * 
 * 
 * Note:
 * 
 * Version strings are composed of numeric strings separated by dots . and this
 * numeric strings may have leading zeroes. 
 * Version strings do not start or end with dots, and they will not be two
 * consecutive dots.
 * 
 */

// @lc code=start
// class Solution {
//     public int compareVersion(String version1, String version2) {
//         if (version1 == null || version2 == null) return 0;
//         String[] ver1Arr = version1.split("\\.");
//         String[] ver2Arr = version2.split("\\.");
//         int i = 0, j = 0;
//         while (i < ver1Arr.length || j < ver2Arr.length) {
//             int ver1 = i < ver1Arr.length ? Integer.valueOf(ver1Arr[i]) : 0;
//             int ver2 = j < ver2Arr.length ? Integer.valueOf(ver2Arr[j]) : 0;

//             if (ver1 < ver2) {
//                 return -1;
//             } else if (ver1 > ver2) {
//                 return 1;
//             } else {
//                 i++;
//                 j++;
//             }
//         }

//         return 0;
//     }
// }


class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        int ver1 = 0, ver2 = 0;
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            while (i < version1.length() && version1.charAt(i) != '.') {
                ver1 = ver1 * 10 + version1.charAt(i) - '0';
                i += 1;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                ver2 = ver2 * 10 + version2.charAt(j) - '0';
                j += 1;
            }

            if (ver1 < ver2) {
                return -1;
            } else if (ver1 > ver2) {
                return 1;
            } else {
                ver1 = 0;
                ver2 = 0;
                i += 1;
                j += 1;
            }
        }

        return 0;
    }
}

// @lc code=end

