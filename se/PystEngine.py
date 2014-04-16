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
		return switch in self.switches
		
	def has(self, item):
		return item in self.inventory
		
	def say(self, dialogue):
		ScriptEngine.addCommand("gfx.actor.say", (self.name, StringFormatter.format(dialogue)))

	def change(self, mood):
		ScriptEngine.addCommand("gfx.actor.change", (self.name, mood))
		
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
		ScriptEngine.addCommand("gfx.narrator.say", (StringFormatter.format(dialogue), ""))
	
class Scene:
	def __init__(self):
		pass
		
	def move(self, location):
		ScriptEngine.addCommand("gfx.scene.move", (location, ""))
		
	def add_actor(self, actor, side):
		ScriptEngine.addCommand("gfx.scene.actor.add", (actor.name, side))
		
	def display_image(self, resource):
		ScriptEngine.addCommand("gfx.scene.display", (resource, ""))
		
def choice(text, next):
	ScriptEngine.addCommand("io.choice.request", (text, next))