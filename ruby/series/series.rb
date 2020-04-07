# frozen_string_literal: true

# Series converts numeric string into an array of numeric strings
class Series
  def initialize(number_string)
    @num_str = number_string
  end

  def slices(size)
    too_big?(size) ? raise(ArgumentError, 'Slice too big') : slice_str(size)
  end

  private

  attr_reader :num_str

  def slice_str(size)
    num_str.chars.each_cons(size).map(&:join)
  end

  def too_big?(size)
    size > num_str.length
  end
end
