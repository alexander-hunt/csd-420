# Module 2: Random Data File I/O

This module contains two Java programs that demonstrate file input/output operations with random data generation and appending functionality.

## Files

### WriteData.java
Generates random data and writes it to a file.

**Features:**
- Generates an array of 5 random integers (1-100)
- Generates an array of 5 random doubles (0-100)
- Writes data to file named `AlexH datafile.dat`
- **Creates** the file if it doesn't exist
- **Appends** data if the file already exists
- Displays generated data to console

**How to Run:**
```bash
javac WriteData.java
java WriteData
```

### ReadData.java
Reads and displays the contents of the data file.

**Features:**
- Reads the `AlexH datafile.dat` file
- Displays all data in a formatted manner
- Handles file not found errors gracefully
- Shows complete history of all appended data

**How to Run:**
```bash
javac ReadData.java
java ReadData
```

## Usage Instructions

### Basic Workflow

1. **Generate initial data:**
   ```bash
   java WriteData
   ```
   This creates `AlexH datafile.dat` with the first set of random integers and doubles.

2. **Read the data:**
   ```bash
   java ReadData
   ```
   This displays the contents of the file.

3. **Append more data:**
   ```bash
   java WriteData
   ```
   Running WriteData again appends a new set of random data to the existing file.

4. **View all data:**
   ```bash
   java ReadData
   ```
   This will now display both the original data and the newly appended data.

## Compile All Files

To compile both programs at once:
```bash
javac WriteData.java ReadData.java
```

## Output Format

When you run WriteData, the console will display:
```
Random Integers: [5 comma-separated integers]
Random Doubles: [5 comma-separated doubles with 2 decimal places]
```

The data file stores all entries in a formatted structure with separators for easy reading.

## File Format

The `AlexH datafile.dat` file stores data in the following format:
```
========== Data Write Session ==========
Random Integers: [values]
Random Doubles: [values]
=======================================

```

Each time WriteData is run, a new session block is appended to the file.

## Testing

Both programs have been tested and verified to:
- ✅ Create the datafile on first run
- ✅ Write random integers and doubles correctly
- ✅ Append data on subsequent runs
- ✅ Read and display all data accurately
