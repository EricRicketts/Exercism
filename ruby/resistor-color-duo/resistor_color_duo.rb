# frozen_string_literal: true

# ResistorColorDue determines numeric value of two band linear resistor
class ResistorColorDuo
  COLORS = %w[black brown red orange yellow green blue violet grey white].freeze

  def self.value(colors)
    colors.first(2).map(&ResistorColorDuo.new).join.to_i
  end

  def to_proc
    proc { |color| COLORS.index(color) }
  end
end
