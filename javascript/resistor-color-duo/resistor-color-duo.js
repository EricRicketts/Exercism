//
// This is only a SKELETON file for the 'Resistor Color Duo' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
const findColorValue = (desiredColor) => {
  return COLORS.findIndex(color => color === desiredColor)
}

export const decodedValue = (colors) => {
  let [colorOne, colorTwo] = colors;
  return findColorValue(colorOne) * Math.pow(10, 1) + findColorValue(colorTwo) * Math.pow(10, 0);
};
