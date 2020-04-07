# frozen_string_literal: true

# HighScores select or sort a given number of high scores
class HighScores
  attr_reader :scores

  def initialize(scores)
    @scores = scores
  end

  def latest
    scores.last
  end

  def latest_is_personal_best?
    latest == personal_best
  end

  def personal_best
    scores.max
  end

  def personal_top_three
    scores.max(3)
  end
end
