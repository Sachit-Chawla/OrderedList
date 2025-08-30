# OrderedList

This Java program takes two input files containing ordered lists and performs three main operations:

- **Merge**: Merges both lists into a single ordered list and writes the result to `merged.txt`.
- **Difference**: Creates an ordered list of the items in the first list that are not in the second, and writes the result to `diff.txt`.
- **Common**: Creates an ordered list of the items that appear in both lists and writes the result to `common.txt`.

All results are written into separate text files for easy inspection.

## Features

- Reads two text files containing lists of words or names
- Maintains alphabetical order by inserting into an ordered list
- Implements three list-processing methods:
  - `merge()`
  - `difference()`
  - `common()`
- Writes outputs to `merged.txt`, `diff.txt`, and `common.txt`

## How It Works

1. The program prompts the user to enter the names of two input files.
2. Each file is read into an `OrderedList` (alphabetically ordered structure).
3. The program applies:
   - `merge()` to combine both lists
   - `difference()` to find items unique to the first list
   - `common()` to find items shared by both lists
4. The results are saved into separate `.txt` files.

## Example

**Input files**

`list1.txt`
