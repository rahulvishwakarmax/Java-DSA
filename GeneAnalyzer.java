public class GeneAnalyzer {

    // Method to find a simple gene with fixed start and stop codons
    public String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }

        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }

        String gene = dna.substring(startIndex, stopIndex + 3);
        if ((gene.length() - 3) % 3 == 0) {
            return gene;
        }

        return "";
    }

    // Method to find a gene with custom start and stop codons
    public String findGene(String dna, String startCodon, String stopCodon) {
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return "";
        }

        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }

        String gene = dna.substring(startIndex, stopIndex + 3);
        if ((gene.length() - 3) % 3 == 0) {
            if (Character.isUpperCase(dna.charAt(0))) {
                return gene;
            } else {
                return gene.toLowerCase();
            }
        }

        return "";
    }

    // Method to check if a substring occurs at least twice
    public boolean twoOccurrences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        if (firstIndex != -1) {
            int secondIndex = stringb.indexOf(stringa, firstIndex + stringa.length());
            return secondIndex != -1;
        }
        return false;
    }

    // Method to find the part of stringb after the first occurrence of stringa
    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        if (index != -1) {
            return stringb.substring(index + stringa.length());
        }
        return stringb;
    }

    // Method to find a gene with multiple stop codons
    public String findGeneWithMultipleStops(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = -1;
        if (taaIndex != -1) minIndex = taaIndex;
        if (tagIndex != -1 && (minIndex == -1 || tagIndex < minIndex)) minIndex = tagIndex;
        if (tgaIndex != -1 && (minIndex == -1 || tgaIndex < minIndex)) minIndex = tgaIndex;

        if (minIndex == -1) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }

    // Method to find the index of a stop codon in frame
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;  
            } else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }
        return -1;
    }

    // Test method for findSimpleGene with more comprehensive test cases
    public void testSimpleGene() {
        String[] testCases = {
            "ATGCCCTAA", // Valid gene
            "AATGCTAGGGTAAGC", // No "TAA" after "ATG"
            "AATGCCCTAGGTAAGC", // No "ATG" or "TAA"
            "ATGCTAGTAA", // Valid gene
            "ATGCTAGTAACGACGCTAA", // "ATG" and "TAA" but not a gene
            "ATGCCCTAATAA", // Edge case: "TAA" immediately after "ATG"
            "ATGCTAGTAAAGTAA", // Multiple stop codons
            "ATGCTAAATGTTTAA" // Nested genes
        };

        for (String dna : testCases) {
            System.out.println("DNA: " + dna);
            String gene = findSimpleGene(dna);
            System.out.println("Gene: " + gene);
            System.out.println();
        }
    }

    // Test method for findGene with custom start and stop codons
    public void testGene() {
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String[] testCases = {
            "ATGCCCTAA", // Valid gene
            "AATGCTAGGGTAAGC", // No "TAA" after "ATG"
            "AATGCCCTAGGTAAGC", // No "ATG" or "TAA"
            "ATGCTAGTAA", // Valid gene
            "atgctagtaacgacgctaa", // Valid gene but in lowercase
            "ATGCCCTTAG", // No proper stop codon
            "ATGCTAGTAGTAA" // Multiple stop codons
        };

        for (String dna : testCases) {
            System.out.println("DNA: " + dna);
            String gene = findGene(dna, startCodon, stopCodon);
            System.out.println("Gene: " + gene);
            System.out.println();
        }
    }

    // Test method for twoOccurrences
    public void testTwoOccurrences() {
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

    // Test method for lastPart
    public void testLastPart() {
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
            String result = lastPart(stringa, stringb);
            System.out.println("The part of the string after \"" + stringa + "\" in \"" + stringb + "\" is \"" + result + "\".");
        }
    }

    // Main method to run all tests
    public static void main(String[] args) {
        GeneAnalyzer analyzer = new GeneAnalyzer();
        System.out.println("Testing findSimpleGene:");
        analyzer.testSimpleGene();
        System.out.println("Testing findGene:");
        analyzer.testGene();
        System.out.println("Testing twoOccurrences:");
        analyzer.testTwoOccurrences();
        System.out.println("Testing lastPart:");
        analyzer.testLastPart();
    }
}
