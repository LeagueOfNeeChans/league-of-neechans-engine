# Scripting example
	
	def start():
		return "scene1"
	
	def scene1():
		scene.move("school_room1")
		narrator.say("You see flowers on the table")
		choice("Take the flowers!", "scene2")
		choice("Hmmm...better not...", "scene3")
		return "_wait"
		
	def scene2():
		narrator.say("You take the flowers.")
		player.receive("flowers")
		return "scene3"
		
	def scene3():
		narrator.say("You see Yumi...what is she doing here?")
		scene.add_actor(yumi, "left")
		yumi.say("Um..." + player.name + "-kun?")
		if player.has("flowers"):
			narrator.say("You look at her and blush...she notices the flowers in your hand")
			yumi.say("Oh..." + player.name + "...are those for me?")
			choice("Um...yes...I...", "confession")
			choice("No...they are for Miku.", "sad_scene")
		else:
			yumi.say("Would you like to go to a movie with me?")
			choice("Yes", "movie")
			choice("No thanks", "sad_scene")
		
		return "_wait"
		
	def movie():
		yumi.say("Okay =).  Pick me up at 8pm?")
		return "_end"
		
	def sad_scene():
		yumi.say(player.name + " I HATE YOU!")
		return "_end"
		
	def confession():
		yumi.say("Oh " + player.name + "...I love you!")
		return "_end"