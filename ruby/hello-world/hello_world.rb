# frozen_string_literal: true

# HelloWorld simple greeting with parameter
class HelloWorld
  def self.hello(who = 'World')
    "Hello, #{who}!"
  end
end
