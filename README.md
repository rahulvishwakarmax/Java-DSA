# Java Data Structures and Algorithms (DSA)

This repository contains Java programs that demonstrate various data structures and algorithms, with a focus on gene analysis and string manipulation. The programs include functionality for finding genes within DNA sequences, performing string operations, and running additional tests.

## Files

### GeneAnalyzer.java
This class provides methods for:
- Finding simple genes with fixed start (`ATG`) and stop (`TAA`) codons.
- Finding genes with custom start and stop codons.
- Checking if a substring occurs at least twice in a string.
- Extracting the part of a string after the first occurrence of another substring.
- Finding genes with multiple stop codons (`TAA`, `TAG`, `TGA`).

#### Methods
- `findSimpleGene(String dna)`: Finds a simple gene with fixed start and stop codons.
- `findGene(String dna, String startCodon, String stopCodon)`: Finds a gene with custom start and stop codons.
- `twoOccurrences(String stringa, String stringb)`: Checks if `stringa` occurs at least twice in `stringb`.
- `lastPart(String stringa, String stringb)`: Returns the part of `stringb` after the first occurrence of `stringa`.
- `findGeneWithMultipleStops(String dna)`: Finds a gene with multiple stop codons.
- `findStopCodon(String dnaStr, int startIndex, String stopCodon)`: Finds the index of a stop codon in frame.

### GeneFinder.java
This class focuses on finding simple genes with a fixed start codon (`ATG`) and stop codon (`TAA`). It handles both uppercase and lowercase DNA sequences.

#### Method
- `findSimpleGene(String dna)`: Finds a simple gene, converting input to uppercase for consistency.

### GeneFinderAdvanced.java
This class extends gene finding capabilities by allowing custom start and stop codons. It also handles both uppercase and lowercase input sequences.

#### Method
- `findSimpleGene(String dna, String startCodon, String stopCodon)`: Finds a gene with custom start and stop codons, adjusting the case of the output based on the input.

### AdditionalTests.java
This class provides additional tests for the functionalities of `GeneFinder` and `GeneFinderAdvanced`, as well as methods from `StringAnalyzer`.

### StringAnalyzer.java
This class includes methods to:
- `twoOccurrences(String stringa, String stringb)`: Checks if `stringa` appears at least twice in `stringb`.
- `lastPart(String stringa, String stringb)`: Returns the part of `stringb` that comes after the first occurrence of `stringa`.
- `testing()`: Contains several test cases to verify the functionality of the `twoOccurrences` method.

### LinkExtractor.java
This class extracts YouTube links from a given URL. It performs the following tasks:
- `findYoutubeLinks(String urlString)`: Reads the content from the provided URL and searches for YouTube links.

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/java-dsa-repo.git
   ```

2. **Navigate to the directory:**
   ```bash
   cd java-dsa-repo
   ```

3. **Compile the Java Files:**
   ```bash
   javac *.java
   ```

4. **Run the main class of the desired program:**
   ```bash
   java GeneAnalyzer
   java GeneFinder
   java GeneFinderAdvanced
   java AdditionalTests
   java StringAnalyzer
   java LinkExtractor
   ```

## Contribution

Feel free to contribute to this repository by submitting pull requests or opening issues for any improvements or bugs.

## License

This repository is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
