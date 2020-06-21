# Raindrops Kata
class Raindrops
  DROP_SOUNDS = {3 => 'Pling', 5 => 'Plang', 7 => 'Plong'}.freeze
  def self.convert(int)
    sounds = DROP_SOUNDS.keys.inject('') do |string, n|
      (int % n).zero? ? string << DROP_SOUNDS[n] : string
    end
    sounds.empty? ? int.to_s : sounds
  end
end
