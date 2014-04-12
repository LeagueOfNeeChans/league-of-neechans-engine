from com.trinary.vnjy.se import ScriptEngine, StringFormatter

def setup(ns):
	ScriptEngine.inject(ns)

class Actor:
	def __init__(self, name):
		self.name = name
		self.switches = []
		self.inventory = []
		
	def set(self, name):
		if not name in self.switches:
			self.switches.append(name)
			
	def give(self, target, item):
		if self.has(item):
			target.receive(item)
			return True
		else:
			return False
			
	def receive(self, name):
		self.inventory.append(name)
		
	def is_set(self, switch):
		return switch in switches
		
	def has(self, item):
		return item in self.inventory
		
	def say(self, dialogue):
		ScriptEngine.addCommand("say", (self.name, StringFormatter.format(dialogue)))

	def change(self, mood):
		ScriptEngine.addCommand("change", (self.name, mood))
		
class Player(Actor):
	def __init__(self, name):
		self.name = name
		self.switches = []
		self.inventory = []
		
class Narrator(Actor):
	def __init__(self):
		self.switches = []
		self.inventory = []
		
	def say(self, dialogue):
		ScriptEngine.addCommand("nsay", (StringFormatter.format(dialogue), ""))
	
class Scene:
	def __init__(self):
		pass
		
	def move(self, location):
		ScriptEngine.addCommand("move", (location, ""))
		
	def add_actor(self, actor, side):
		ScriptEngine.addCommand("add_actor", (actor.name, side))
		
	def display_image(self, resource):
		ScriptEngine.addCommand("display_image", (resource, ""))
		
def choice(text, next):
	ScriptEngine.addCommand("choice", (text, next))