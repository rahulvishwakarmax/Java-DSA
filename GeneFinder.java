public class GeneFinder {

    public String findSimpleGene(String dna) {
        // Handle both lowercase and uppercase input by converting to uppercase
        String dnaUpper = dna.toUpperCase();
        int startIndex = dnaUpper.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }

        int stopIndex = dnaUpper.indexOf("TAA", startIndex + 3);
        if (stopIndex == -1) {
            return "";
        }

        String gene = dna.substring(startIndex, stopIndex + 3);
        if ((gene.length() - 3) % 3 == 0) {
            return gene;
        }

        return "";
    }

    public void testSimpleGene() {
        String[] testCases = {
            "ATGCCCTAA", // Valid gene
            "AATGCTAGGGTAAGC", // No "TAA" after "ATG"
            "AATGCCCTAGGTAAGC", // No "ATG" or "TAA"
            "ATGCTAGTAA", // Valid gene
            "atgctagtaacgacgctaa" // Lowercase test case
        };

        for (String dna : testCases) {
            System.out.println("DNA: " + dna);
            String gene = findSimpleGene(dna);
            System.out.println("Gene: " + gene);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GeneFinder geneFinder = new GeneFinder();
        geneFinder.testSimpleGene();
    }
}
