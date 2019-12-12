# DungeonGame
This is a small console game. The player is lost in a dungeon and 
has to explore it and survive against enemies.
This project has started as an university development project.

## Contributors
Andreas G. | Moritz W. | Lara B. | Sascha W. | Micha H.
---------- | --------- | ------- | --------- | ---------

## Features
* Random level generator
* Based on rounds
* Different room types
* Items (with different buffs and debuffs)
* Transitions between rooms like doors, ledders or something like that
* Event rooms

## Syntax rules
* classes: PascalCase
* methods, variables: camelCase
* const: CAPITAL_LETTERS
* if(condition) {<br/>
	...<br/>
  } else if(condition) {<br/>
	...<br/>
  } else {<br/>
	...<br/>
  }
* switch(object) {<br/>
	case 1:<br/>
		statement;<br/>
		break;<br/>
  }<br/>
* ToDo-comments: //ToDo: The remaining things to to.

## Comments
Every file (class, pom.xml, .gitignore) should begin with a file description comment. 
It should contain the author, last edit timestamp and the last editors name.

## Git
* Methods with open changes or implementations should be commented before pushing 
the last commit.
* For every new functionality there should be a new branch to work on.

## Package structure
de.hdm_stuttgart.mi.DungeonGame
|
|---Graphics
|---Helper
|   |
|   |---Grapics
|   |---Logics
|       |
|       |---Actors
|       |---Stages
|
|---Logics
    |
    |---Actors
    |---Stages