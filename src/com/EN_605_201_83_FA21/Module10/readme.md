If this file does not load correctly, please go to https://dillinger.io/ and paste the content of this file into the website for proper formatting

# Overview:

This project Reads from a txt file that contains population data, and then outputs into a destination file, and then is output onto the console.


## Files:

1. Assignment10_Write - This file should be run first. It has run time parameters passed in this order: Source, Destination and Line Number


2. Assignment10_Read - This file should be run second. It outputs the Destination file from part 1, onto the console


3. FileException - Supporting file to handle exceptions


4. SmallAreaIncomePovertyEstData.txt - Provides data in a table format consisting of the population, children population, and children population in poverty of different districts in the 50 states.

## How to Run The Program:

1. Compile 1st program -
```bash
javac Assignment10_Write.java
```

2. Run Assignment10_Write.java program with proper Run Time Parameters -

   - [Source] - Absolute Path of Source .txt File (Location of SmallAreaIncomePovertyEstData.txt)
   - [Destination] - Absolute Path of Destination .txt File 
```bash
java Assignment10_Write [Source] [Destination] 
```
3. Compile 2nd program - 
```bash
javac Assignment10_Read.java
```
4. Run Assignment10_Read.java program with proper Run Time parameters
    - [Source] - Absolute Path of Source .txt File (This will be the same file as the Destination File from Step 2)
    - [Line] - Integer from 1-51

```bash
java Assignment10_Read [Source] [Line] 
```

## Example:

1. Compile and Run first file
```bash
javac Assignment10_Write.java
java Assignment10_Write "/Users/jeremytouch/IdeaProjects/Intro_To_Programming/src/com/EN_605_201_83_FA21/Module10/SmallAreaIncomePovertyEstData.txt" "/Users/jeremytouch/IdeaProjects/Intro_To_Programming/src/com/EN_605_201_83_FA21/Module10/output.txt" 
```

2. Compile and Run second file
```bash
javac Assignment10_Read.java
java Assignment10_Read "/Users/jeremytouch/IdeaProjects/Intro_To_Programming/src/com/EN_605_201_83_FA21/Module10/output.txt" "51"
```



