// 165. Compare Version Numbers

// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

// Here is an example of version numbers ordering:

// 0.1 < 1.1 < 1.2 < 13.37

// use regex to split by "."

public class Solution {
    public int compareVersion(String version1, String version2) {
        int longer = Math.max(version1.length(),version2.length());
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0;i<longer;i++){
            int ver1 = i<v1.length? Integer.valueOf(v1[i]):0;
            int ver2 = i<v2.length? Integer.valueOf(v2[i]):0;
            if(ver1>ver2) return 1;
            if(ver1<ver2) return -1;
        }
        return 0;
    }
}


// need to learn how to explain to other people