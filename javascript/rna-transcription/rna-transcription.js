// Version 3
const DNA_TO_RNA = { G:'C', C:'G', T:'A', A:'U' };
const DNA_KEYS_REGEX = new RegExp(Object.keys(DNA_TO_RNA).join('|'), 'g');

export const toRna = (dnaStrand) => dnaStrand.replace(DNA_KEYS_REGEX, (match) => DNA_TO_RNA[match]);
