# Module 5 - WordOrchestrator

This module reads words from a text file and displays them in both ascending and descending alphabetical order.

# run-wordorchestrator-tests.ps1
PowerShell script that compiles and executes both the unit tests and the main application. (Runs through all the code in the assignment.)

**What it does:**
1. Compiles both Java files
2. Runs `UnitTestWordOrchestrator` to validate functionality
3. Runs `WordOrchestrator` to display the final results

**How to Run:**
```powershell
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
.\run-wordorchestrator-tests.ps1
```

# WordOrchestrator.java
The main application class that orchestrates the word processing workflow.

**Features:**
- Reads words from `collection_of_words.txt`
- Stores unique words in a `TreeSet` for automatic sorting
- Displays words in ascending order (alphabetical)
- Displays words in descending order (reverse alphabetical)

**How to Run:**
```bash
javac WordOrchestrator.java
java WordOrchestrator
```

# UnitTestWordOrchestrator.java
Comprehensive unit test suite for `WordOrchestrator`.

**Tests:**
- `testMain()` - Verifies the complete program output matches expected results
- `testGatherWords()` - Confirms all 14 unique words are correctly read and stored
- `testDisplayWords()` - Validates both ascending and descending output formatting

**How to Run:**
```bash
javac WordOrchestrator.java UnitTestWordOrchestrator.java
java UnitTestWordOrchestrator
```

# collection_of_words.txt
Input data file containing words to be sorted. Words can appear multiple times; duplicates are automatically removed.

# Expected Output

```
Ascending Order:
algorithm
cloud
computer
computing
data
database
development
java
network
programming
science
security
software
structure

Descending Order:
structure
software
security
science
programming
network
java
development
database
data
computing
computer
cloud
algorithm
```
