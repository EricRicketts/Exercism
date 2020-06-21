# Scrabble Score kata
class Scrabble
  LETTER_VALUES = {
    'a' => 1, 'e' => 1, 'i' => 1, 'o' => 1, 'u' => 1, 'l' => 1, 'n' => 1, 'r' => 1, 's' => 1, 't' => 1,
    'd' => 2, 'g' => 2,
    'b' => 3, 'c' => 3, 'm' => 3, 'p' => 3,
    'f' => 4, 'h' => 4, 'v' => 4, 'w' => 4, 'y' => 4,
    'k' => 5,
    'j' => 8, 'x' => 8,
    'q' => 10, 'z' => 10
  }
  attr_reader :word

  def self.score(word)
    new(word).score
  end

  def initialize(word)
    @word = word
  end

  def score
    valid_word? ? compute_score : 0
  end

  private

  def compute_score
    word.downcase.chars.sum { |letter| LETTER_VALUES[letter] }
  end

  def valid_word?
    word.to_s.match?(/\A[[:alpha:]]+\Z/)
  end
end
