// @ts-check

/**
 * Determine how many cards of a certain type there are in the deck
 *
 * @param {number[]} stack
 * @param {number} card
 *
 * @returns {number} number of cards of a single type there are in the deck
 */
export function cardTypeCheck(stack, card) {
  let cardCount = 0;
  stack.forEach((currentCard) => {
    if (currentCard === card) cardCount++;
  });
  return cardCount;
}

/**
 * Determine how many cards are odd or even
 *
 * @param {number[]} stack
 * @param {boolean} type the type of value to check for - odd or even
 * @returns {number} number of cards that are either odd or even (depending on `type`)
 */
export function determineOddEvenCards(stack, type) {
  let cardCount = 0;
  for (const card of stack) {
    if (type && card % 2 === 0) {
      cardCount ++;
    } else if (!type && card % 2 !== 0) {
      cardCount++
    }
  }
  return cardCount;
}
