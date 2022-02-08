// @ts-check
//
// The line above enables type checking for this file. Various IDEs interpret
// the @ts-check directive. It will give you helpful autocompletion when
// implementing this exercise.

/**
 * Determines whether or not you need a licence to operate a certain kind of vehicle.
 *
 * @param {string} kind
 * @returns {boolean} whether a license is required
 */
export function needsLicense(kind) {
  return kind === 'car' || kind === 'truck';
}

/**
 * Helps choosing between two options by recommending the one that
 * comes first in dictionary order.
 *
 * @param {string} option1
 * @param {string} option2
 * @returns {string} a sentence of advice which option to choose
 */
export function chooseVehicle(option1, option2) {
  const SUFFIX = ' is clearly the better choice.';
  const DIGITS = /\d+/;
  const vehicleFilter = str => str.split(/\s+/).filter(word => !word.match(DIGITS));
  const filteredOption1 = vehicleFilter(option1).join(" ");
  const filteredOption2 = vehicleFilter(option2).join(" ");

  if (filteredOption1[0] <= filteredOption2[0]) {
    return option1 + SUFFIX;
  } else {
    return option2 + SUFFIX;
  }
}

/**
 * Calculates an estimate for the price of a used vehicle in the dealership
 * based on the original price and the age of the vehicle.
 *
 * @param {number} originalPrice
 * @param {number} age
 * @returns expected resell price in the dealership
 */
export function calculateResellPrice(originalPrice, age) {
  let discountPrice;
  if (age < 3) {
    discountPrice = 0.8*originalPrice;
  } else if (age >= 3 && age <= 10) {
    discountPrice = 0.7*originalPrice;
  } else {
    discountPrice = 0.5*originalPrice;
  }

  return discountPrice;
}
