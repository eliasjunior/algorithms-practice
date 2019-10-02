const reverse = require('./reverseWords.v2');

describe("reverse words", () => {
  it("should reverse words in an array", () => {
    expect(reverse.reverseWords([ 'n', 'i', ' ', 'f', 'a', ' ','c', 'b' ]))
      .toEqual(['c', 'b', ' ', 'f', 'a', ' ','n', 'i']);
  });

  fit('should not convert str with one character', () => {
    expect(reverse.reverseWords(['a', ' ' ,'b', ' ', 'c'])).toEqual(['c',' ' ,'b', ' ' ,'a'])
  })

  it("should reverse a word in a list", () => {
    expect(reverse.reverseWord(0, 2, ["a", "b", "c"]))
      .toEqual(["c", "b", "a"]);
  });
});
