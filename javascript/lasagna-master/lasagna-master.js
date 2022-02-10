/// <reference path="./global.d.ts" />
// @ts-check

/**
 * Implement the functions needed to solve the exercise here.
 * Do not forget to export them so they are available for the
 * tests. Here an example of the syntax as reminder:
 *
 * export function yourFunction(...) {
 *   ...
 * }
 */
export function cookingStatus(remainingTime) {
    if (!remainingTime && remainingTime !== 0) {
        return 'You forgot to set the timer.';
    } else if (remainingTime === 0) {
        return 'Lasagna is done.';
    } else {
        return 'Not done, please wait.';
    }
}

export function preparationTime(layers, averageTimePerLayer = 2) {
    return layers.length * averageTimePerLayer;
}

export function quantities(ingredients) {
    return ingredients.reduce(function(noodlesAndSauceQuantities, ingredient) {
        if (ingredient === 'noodles') {
            noodlesAndSauceQuantities.noodles += 50;
        } else if (ingredient === 'sauce') {
            noodlesAndSauceQuantities.sauce += 0.2;
        }
        return noodlesAndSauceQuantities;
    }, { noodles: 0, sauce: 0});
}

export function addSecretIngredient(friendsList, myList) {
    let lastIngredientPosition = friendsList.length - 1;
    myList.push(friendsList[lastIngredientPosition]);
}

export function scaleRecipe(recipe, scaleFactor) {
    let scaledRecipe = JSON.parse(JSON.stringify(recipe));
    Object.keys(scaledRecipe).forEach(ingredient => {
        scaledRecipe[ingredient] *= (scaleFactor/2);
    });
    return scaledRecipe;
}

