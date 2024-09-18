public class GeneFinderAdvanced {

    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
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

    public void testSimpleGene() {
        String[] testCases = {
            "ATGCCCTAA", // Valid gene
            "AATGCTAGGGTAAGC", // No "TAA" after "ATG"
            "AATGCCCTAGGTAAGC", // No "ATG" or "TAA"
            "ATGCTAGTAA", // Valid gene
            "atgctagtaacgacgctaa" // Valid gene but in lowercase
        };

        String startCodon = "ATG";
        String stopCodon = "TAA";

        for (String dna : testCases) {
            System.out.println("DNA: " + dna);
            String gene = findSimpleGene(dna, startCodon, stopCodon);
            System.out.println("Gene: " + gene);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GeneFinderAdvanced geneFinderAdvanced = new GeneFinderAdvanced();
        geneFinderAdvanced.testSimpleGene();
    }
}
