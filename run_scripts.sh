#!/bin/bash


FILE_LOC="$PWD/applications/tutorial/rules.pl"
FILE_LOC="$PWD/applications/vanRoy/queens_8.pl"

#Note I have enabled assertions in this commmand
java -ea -cp target/prolog-interpreter-1.0-jar-with-dependencies.jar cs598ga.shull.prolog.runner.App ${FILE_LOC}
