# Hamming difference between two DNA strands
class Hamming
  def self.compute(strand1, strand2)
    if strand1.length != strand2.length
      raise ArgumentError, 'unequal strand lengths'
    end

    strand1.chars.zip(strand2.chars).count { |first, second| first != second }
  end

end
