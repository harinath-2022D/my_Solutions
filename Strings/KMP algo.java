public class KMPAlgorithm {

    public static int[] buildPartialMatchTable(String pattern) {
        int length = pattern.length();
        int[] partialMatchTable = new int[length];
        int j = 0;

        for (int i = 1; i < length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = partialMatchTable[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            partialMatchTable[i] = j;
        }

        return partialMatchTable;
    }

    public static void kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] partialMatchTable = buildPartialMatchTable(pattern);
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = partialMatchTable[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index: " + (i - m + 1));
                j = partialMatchTable[j - 1];
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        kmpSearch(text, pattern);
    }
}
