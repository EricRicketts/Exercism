# frozen_string_literal: true

# Phrase counts words in a phrase
class Phrase
  def initialize(str)
    @str = str
  end

  def word_count
    all_words = str.scan(/\b[[:alnum:]]*'?[[:alnum:]]+\b/).map(&:downcase)
    all_words.group_by(&:itself).to_h.transform_values(&:count)
  end

  private

  attr_reader :str
end
