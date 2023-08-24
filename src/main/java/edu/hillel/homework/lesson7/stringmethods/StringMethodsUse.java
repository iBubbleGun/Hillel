package edu.hillel.homework.lesson7.stringmethods;

public class StringMethodsUse {

    public int findSymbolOccurance(String str, char ch) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                result++;
            }
        }
        return result;
    }

    public int findWordPosition(String source, String target) {
        int result = -1;
        if (source.contains(target)) {
            for (int i = 0; i < source.length(); i++) {
                if (target.charAt(0) == source.charAt(i)) {
                    result = i;
                }
            }
        }
        return result;
    }

    public String stringReverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void delimiter(int homeworkPart) {
        System.out.println("\n".concat("-".repeat(60)).concat(" part ").concat(String.valueOf(homeworkPart)));
    }
}
