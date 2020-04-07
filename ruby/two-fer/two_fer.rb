# frozen_string_literal: true

# TwoFer simple string response based on incoming argument
class TwoFer
  def self.two_fer(name = 'you')
    "One for #{name}, one for me."
  end
end
