const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
const findColorValue = color => COLORS.indexOf(color)

export const decodedValue = ([colorOne, colorTwo]) => {
  return findColorValue(colorOne) * 10 + findColorValue(colorTwo);
};
