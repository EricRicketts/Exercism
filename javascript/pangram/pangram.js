//
// This is only a SKELETON file for the 'Pangram' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const isPangram = (str) => {
    const regExfilter = /[\d\s_."?!,;:]+/g;
    const alphabet = 'abcdefghijklmnopqrstuvwxyz';
    const alphabetSet = new Set(alphabet.split(""));
    const strLetters = str.toLowerCase().replaceAll(regExfilter,'');
    const strLettersSet = new Set(strLetters);

    const sameSize = alphabetSet.size === strLettersSet.size;
    const hasAllLetters = Array.from(strLettersSet).every(letter => alphabetSet.has(letter));

    return sameSize && hasAllLetters;
};
/*
    algorithm
    1.  create a const Set with all letters
    2.  take the string and create a set from it
    3.  test that the two sets are equal
*/
