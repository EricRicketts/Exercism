export const gigasecond = (dateObj) => {
  const gigaSecondInMilliSeconds = Math.pow(10, 9) * Math.pow(10, 3);
  let dateInMilliSeconds = dateObj.getTime();

  return new Date(dateInMilliSeconds + gigaSecondInMilliSeconds);
};
