# Dungeon
This is a text based adventure from the minds that brought about the end of your boredom.

## Getting Started
Fun fact! We use a bash function to build and run this project.

You can use this by simply running venti and it'll compile and run the game.

```bash
function grande() {
	# Build to Jar
	rm -f *.class && rm -f *.jar && javac $1.java && jar cvfe $1.jar $1 *.class
	# Remove stray classes
	rm -f *.class;
}
# build and run
function venti() {
	#capture current directory if no arguments given
	if (( $# !=1 )); then
		current_dir=${PWD##*/} &&
		foo=`echo ${current_dir:0:1} | tr  '[a-z]' '[A-Z]'`${current_dir:1}
		grande $foo &&
		java -jar $foo.jar
	else
		grande $1 &&
		java -jar $1.jar;
	fi
}
`

## TODO
- [ ] Name yourself.
- [ ] Re-enable resting
- [ ] Dynamic items
- [ ] Inventory system
- [ ] Dungeon stairs
- [ ] Save/Load features
- [ ] Save death points
- [ ] Monster appearances based on depth
- [ ] Wizards
- [ ] Pets?
- [ ] Dynamic player classes
- [x] Remove herobrine
