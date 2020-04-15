//
// This is only a SKELETON file for the 'Resistor Color Duo' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
const findColorValue = (color) => {
  return COLORS.indexOf(color);
}

export const decodedValue = ([colorOne, colorTwo, ...rest]) => {
  return findColorValue(colorOne) * 10 + findColorValue(colorTwo);
};
