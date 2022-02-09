// @ts-check
//
// The line above enables type checking for this file. Various IDEs interpret
// the @ts-check directive. It will give you helpful autocompletion when
// implementing this exercise.
const fruitDrinkPreparationTimes = {
  'Pure Strawberry Joy': 0.5,
  'Energizer': 1.5,
  'Green Garden': 1.5,
  'Tropical Island': 3,
  'All or Nothing': 5
};
/**
 * Determines how long it takes to prepare a certain juice.
 *
 * @param {string} name
 * @returns {number} time in minutes
 */
export function timeToMixJuice(name) {
  const fruitDrinks = Object.keys(fruitDrinkPreparationTimes);
  if (fruitDrinks.includes(name)) {
    return fruitDrinkPreparationTimes[name];
  } else {
    return 2.5;
  }
}

/**
 * Calculates the number of limes that need to be cut
 * to reach a certain supply.
 *
 * @param {number} wedgesNeeded
 * @param {string[]} limes
 * @returns {number} number of limes cut
 */
export function limesToCut(wedgesNeeded, limes) {
  const numberOfLimes = limes.length;
  let positionInLimeList = 0;
  let numberOfCuts = 0;

  while (wedgesNeeded > 0 && positionInLimeList < numberOfLimes) {
    let limeType = limes[positionInLimeList];
    switch (limeType) {
      case 'small': {
        wedgesNeeded -= 6;
        break;
      }
      case 'medium': {
        wedgesNeeded -= 8;
        break;
      }
      case 'large': {
        wedgesNeeded -= 10;
        break;
      }
    }
    positionInLimeList += 1;
    numberOfCuts += 1;
  }

  return numberOfCuts;
}
/*
  algorithm
  1.  use a while statement exit limes at end or wedgesNeeded = 0
  2.  set numberOfCuts = 0
  3.  for each lime through the array use a switch statement to update the cuts
  4.  increment numberOfCuts each time through the loop
*/

/**
 * Determines which juices still need to be prepared after the end of the shift.
 *
 * @param {number} timeLeft
 * @param {string[]} orders
 * @returns {string[]} remaining orders after the time is up
 */
export function remainingOrders(timeLeft, orders) {
  const currentOrder = 0;
  while (timeLeft > 0 && orders.length !== 0) {
    let preparationTime = timeToMixJuice(orders[currentOrder]);
    timeLeft -= preparationTime;
    orders.shift();
  }

  return orders;
}
/*
  use a while loop
  1.  exit condition timeLeft is less than or equal to zero or finish going through the array
  2.  Each time through the loop subtract out the time of the drink
  3.  when you subtract out the time of the drink shift the array.
*/
