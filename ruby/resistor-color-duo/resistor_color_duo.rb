# frozen_string_literal: true

# ResistorColorDue determines numeric value of two band linear resistor
class ResistorColorDuo
  BANDS_AND_VALUES = {
    'black' => '0', 'brown' => '1', 'red' => '2', 'orange' => '3',
    'yellow' => '4', 'green' => '5', 'blue' => '6', 'violet' => '7',
    'grey' => '8', 'white' => '9'
  }.freeze

  NUMBER_OF_BANDS = 2

  def self.value(colors)
    colors.first(NUMBER_OF_BANDS).map(&BANDS_AND_VALUES).join.to_i
  end
end
