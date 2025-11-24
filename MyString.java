public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                ans += (char) (str.charAt(i) + 32);
            } else if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
                ans += str.charAt(i);
            } else if ((str.charAt(i) == ' ')) {
                ans += str.charAt(i);
            }
        }
        return ans;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return false;
        }
        if (str2.length() == 0) {
            return true;
        }
        if (str2.length() > str1.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if ((str1.charAt(i)) == str2.charAt(0)) {
                for (int j = 0; j < str2.length(); j++) {
                    if (i + j < str1.length()) {
                        if ((str1.charAt(i + j)) == str2.charAt(j)) {
                            count++;
                        }
                    }
                }
                if (count == str2.length()) {
                    return true;
                }
                count = 0;
            }

        }
        return false;
    }

}
