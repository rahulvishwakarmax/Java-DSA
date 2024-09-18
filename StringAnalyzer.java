public class StringAnalyzer {

    public boolean twoOccurrences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        if (firstIndex != -1) {
            int secondIndex = stringb.indexOf(stringa, firstIndex + stringa.length());
            return secondIndex != -1;
        }
        return false;
    }

    public void testing() {
        String[][] testCases = {
            {"by", "A story by Abby Long"},
            {"a", "banana"},
            {"atg", "ctgtatgta"},
            {"an", "banana"},
            {"zoo", "forest"}
        };

        for (String[] testCase : testCases) {
            String stringa = testCase[0];
            String stringb = testCase[1];
            boolean result = twoOccurrences(stringa, stringb);
            System.out.println("The call twoOccurrences(\"" + stringa + "\", \"" + stringb + "\") returns " + result);
        }
    }

    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        if (index != -1) {
            return stringb.substring(index + stringa.length());
        }
        return stringb;
    }

    public static void main(String[] args) {
        StringAnalyzer stringAnalyzer = new StringAnalyzer();
        stringAnalyzer.testing();

        String stringa = "an";
        String stringb = "banana";
        String result = stringAnalyzer.lastPart(stringa, stringb);
        System.out.println("The part of the string after \"" + stringa + "\" in \"" + stringb + "\" is \"" + result + "\".");
    }
}
