rm -f *.class && rm -f *.jar && javac $1.java && jar cvfe $1.jar $1 *.class
rm -f *.class
