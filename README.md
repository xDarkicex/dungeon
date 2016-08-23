# Dungeon
This is a text based adventure from the minds that brought about the end of your boredom.

## Getting Started
Fun fact! We use a bash function to build and run this project.
```bash
function grande() {
	# Build to Jar
	rm -f *.class && rm -f *.jar && javac $1.java && jar cvfe $1.jar $1 *.class
	# Remove stray classes
	rm -f *.class;
}
# build and run
function venti() { grande $1 && java -jar $1.jar; }
`
