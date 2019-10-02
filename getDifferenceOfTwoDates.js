const getDifferenceInDaysTwoDates = (first, second) => {
    const milliSecondsPerDay = 1000 * 60 * 60 * 24;
    const millisBetween = second.getTime() - first.getTime();
    const days = millisBetween / milliSecondsPerDay;

    // Round down.
    return Math.floor(days);
}
