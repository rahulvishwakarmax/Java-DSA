public class AdditionalTests {

    public static void main(String[] args) {
        // Example DNA sequences
        String dna1 = "ATGCCCTAAATGCTAGTAA";
        String dna2 = "ATGCCCTAGTAAATGCTAG";
        String dna3 = "AATGCCCTAAATGCTAA";
        String dna4 = "ATGCCCTTAGATGTTAA";
        String dna5 = "ATGAAATGCCCTAGTAA";

        // Initialize classes
        GeneFinder geneFinder = new GeneFinder();
        GeneFinderAdvanced geneFinderAdvanced = new GeneFinderAdvanced();
        StringAnalyzer stringAnalyzer = new StringAnalyzer();

        // Test GeneFinder
        System.out.println("GeneFinder Results:");
        testGeneFinder(geneFinder, dna1);
        testGeneFinder(geneFinder, dna2);
        testGeneFinder(geneFinder, dna3);
        testGeneFinder(geneFinder, dna4);
        testGeneFinder(geneFinder, dna5);

        // Test GeneFinderAdvanced
        System.out.println("\nGeneFinderAdvanced Results:");
        testGeneFinderAdvanced(geneFinderAdvanced, dna1, "ATG", "TAA");
        testGeneFinderAdvanced(geneFinderAdvanced, dna2, "ATG", "TAG");
        testGeneFinderAdvanced(geneFinderAdvanced, dna3, "ATG", "TAA");
        testGeneFinderAdvanced(geneFinderAdvanced, dna4, "ATG", "TAA");
        testGeneFinderAdvanced(geneFinderAdvanced, dna5, "ATG", "TAA");

        // Test StringAnalyzer
        System.out.println("\nStringAnalyzer Results:");
        testStringAnalyzer(stringAnalyzer, "ATG", dna1);
        testStringAnalyzer(stringAnalyzer, "TAA", dna2);
        testStringAnalyzer(stringAnalyzer, "TAG", dna3);
        testStringAnalyzer(stringAnalyzer, "ATG", dna4);
        testStringAnalyzer(stringAnalyzer, "TAA", dna5);

        // Additional tests for StringAnalyzer
        System.out.println("\nAdditional StringAnalyzer Tests:");
        testLastPart(stringAnalyzer, "ATG", dna1);
        testLastPart(stringAnalyzer, "TAA", dna2);
        testLastPart(stringAnalyzer, "TAG", dna3);
        testLastPart(stringAnalyzer, "ATG", dna4);
        testLastPart(stringAnalyzer, "TAA", dna5);
    }

    private static void testGeneFinder(GeneFinder geneFinder, String dna) {
        String gene = geneFinder.findSimpleGene(dna);
        System.out.println("DNA: " + dna);
        System.out.println("Gene found using GeneFinder: " + gene);
        System.out.println();
    }

    private static void testGeneFinderAdvanced(GeneFinderAdvanced geneFinderAdvanced, String dna, String startCodon, String stopCodon) {
        String gene = geneFinderAdvanced.findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("DNA: " + dna);
        System.out.println("Gene found using GeneFinderAdvanced: " + gene);
        System.out.println();
    }

    private static void testStringAnalyzer(StringAnalyzer stringAnalyzer, String stringa, String stringb) {
        boolean result = stringAnalyzer.twoOccurrences(stringa, stringb);
        System.out.println("The call twoOccurrences(\"" + stringa + "\", \"" + stringb + "\") returns " + result);
    }

    private static void testLastPart(StringAnalyzer stringAnalyzer, String stringa, String stringb) {
        String result = stringAnalyzer.lastPart(stringa, stringb);
        System.out.println("The part of the string after \"" + stringa + "\" in \"" + stringb + "\" is \"" + result + "\".");
    }
}
