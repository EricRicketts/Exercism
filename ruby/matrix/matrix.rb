# frozen_string_literal: true

# Matrix composes a matrix of integers for a string input
class Matrix
  def initialize(string)
    @string = string
  end

  def columns
    rows.transpose
  end

  def rows
    string.each_line.map(&:split).map { |arr| arr.map(&:to_i) }
  end

  private

  attr_reader :string
end
