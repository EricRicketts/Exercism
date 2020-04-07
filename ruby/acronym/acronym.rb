# frozen_string_literal: true

# Acronym takes a phrase and makes an acronym
class Acronym
  def self.abbreviate(phrase)
    phrase.scan(/\b[[:alpha:]]/).join.upcase
  end
end
