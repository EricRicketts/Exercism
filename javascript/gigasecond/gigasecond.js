export const gigasecond = (dateObj) => {
  const gigaSecondInMilliSeconds = 1e9 * 1e3;
  let dateInMilliSeconds = dateObj.getTime();

  return new Date(dateInMilliSeconds + gigaSecondInMilliSeconds);
};
