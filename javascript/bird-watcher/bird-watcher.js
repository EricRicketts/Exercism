// @ts-check
//
// The line above enables type checking for this file. Various IDEs interpret
// the @ts-check directive. It will give you helpful autocompletion when
// implementing this exercise.

/**
 * Calculates the total bird count.
 *
 * @param {number[]} birdsPerDay
 * @returns {number} total bird count
 */
export function totalBirdCount(birdsPerDay) {
  return birdsPerDay.reduce((sum, number) => sum + number, 0);
}

/**
 * Calculates the total number of birds seen in a specific week.
 *
 * @param {number[]} birdsPerDay
 * @param {number} week
 * @returns {number} birds counted in the given week
 */
export function birdsInWeek(birdsPerDay, week) {
  const DAYS_IN_WEEK = 7;
  const startIndexBasedOnWeekNumber = weekNumber => (weekNumber - 1)*DAYS_IN_WEEK;
  const startIndex = startIndexBasedOnWeekNumber(week);
  let sum = 0;
  for (let index = startIndex; index < startIndex + DAYS_IN_WEEK; index++) {
    sum += birdsPerDay[index];
  }

  return sum;
}

/**
 * Fixes the counting mistake by increasing the bird count
 * by one for every second day.
 *
 * @param {number[]} birdsPerDay
 * @returns {number[]} corrected bird count data
 */
export function fixBirdCountLog(birdsPerDay) {
  const numberOfDays = birdsPerDay.length;
  for (let index = 0; index < numberOfDays; index++) {
    if (index % 2 === 0) { birdsPerDay[index] += 1; }
  }
  return birdsPerDay;
}
