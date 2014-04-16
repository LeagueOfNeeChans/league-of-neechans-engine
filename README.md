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
			choice("No...they are for Miku.", "choose_miku")
		else:
			yumi.say("Would you like to go to a movie with me?")
			choice("Yes", "movie")
			choice("No thanks", "sad_scene")
		
		return "_wait"
		
	def choose_miku():
		player.set("chose_miku")
		return "sad_scene"
		
	def movie():
		yumi.say("Okay =).  Pick me up at 8pm?")
		return "_end"
		
	def sad_scene():
		yumi.say(player.name + " I HATE YOU!")
		if player.is_set("chose_miku"):
			narrator.say("As Yumi runs away you feel the presence of someone behind you.")
			narrator.say("You turn around and see Miku.")
			miku.say("I heard what you said...")
			narrator.say("With that Miku took your face in her hands and kissed you.")
			miku.say("Don't worry, Yumi will be alright.")
		return "_end"
		
	def confession():
		player.give(yumi, "flowers")
		yumi.say("Oh " + player.name + "...I love you!")
		return "_end"
		
# Pyst Engine Command Syntax

The following is the format of a Pyst Engine command.  The first element is the core, which represents what subsystem processes this command.  The second is the asset, which is what set of assets does this command effect.  And lastly the function which is what function the core should perform on this asset or asset group.

	[core].[asset].[function]
	
## Commands
### GFX Core

The graphics core is responsible for rendering graphical content like images, text, textboxes, menus, and movies.  As each command is received on the bus, it is processed and the graphical command is run.

#### gfx.actor.say

Renders dialogue to the textbox.

Arguments:
+ actor
+ text

#### gfx.actor.change

Changes actors mood (displayed image).

Arguments:
+ actor
+ transition

#### gfx.narrator.say

Renders narrator or inner monologue to the textbox.

Arguments:
+ text

#### gfx.scene.change

Changes the current scene location (background).

Arguments:
+ location
+ time

#### gfx.scene.add

Adds an additional actor to the scene stack and chooses a side of the screen for them.

Arguments:
+ actor
+ side

#### gfx.scene.display

Renders a screen filling image.

Arguments:
+ asset name

#### gfx.choice.prompt

Renders a player choice to the screen.

Arguments:
+ text

### SFX Core

### BGM Core

### IO Core

The IO core is responsible for getting player input.  Prompts will add to the number of choices the user has to make and a request will request an answer from them using whatever input method the core is using.

#### io.choice.prompt

Adds a choice to the local choicestore.

Arguments:
+ text
+ next scene

#### io.choice.request

Requests the player to indicate which choice they want.

Arguments:

### Other Commands

Some of the features of the Pyst system will monitor the queue as well.  Especially the Script Engine, as it needs to be able to relay information back to the script once choices are made.

#### se.choice.response

Notify the Script Engine of a choice the player has made.

Arguments:
+ choice