# Isogram Kata
class Isogram
  def self.isogram?(text)
    letters = text.downcase.scan(/[[:alpha:]]/)
    letters.all? { |letter| letters.count(letter) == 1 }
  end
end
