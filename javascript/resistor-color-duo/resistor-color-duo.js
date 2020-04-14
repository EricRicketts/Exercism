//
// This is only a SKELETON file for the 'Resistor Color Duo' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
const findColorValue = (desiredColor) => {
  return COLORS.findIndex(color => color === desiredColor)
}

export const decodedValue = (colors) => {
  let [colorOne, colorTwo, ...rest] = colors;
  let colorDuo = [colorOne, colorTwo];

  return colorDuo.reverse().reduce((sumOfColors, color, colorPowerOfTen) => {
    let coefficient = findColorValue(color);
    let colorNumericValue = coefficient * Math.pow(10, colorPowerOfTen);
    sumOfColors += colorNumericValue;
    return sumOfColors;
  }, 0);
};
