#!/bin/bash


FILE_LOC="/home/tshull226/Documents/school/cs598GA/repo/truffleProlog/examples/foo.prolog"
FILE_LOC="/home/tshull226/Documents/school/cs598GA/repo/truffleProlog/examples/another.prolog"

#java -cp target/truffle-prolog-1.0-jar-with-dependencies.jar cs598ga.shull.prolog.truffle.launcher.TruffleMain ${FILE_LOC}

java -ea -cp target/truffle-prolog-1.0-jar-with-dependencies.jar cs598ga.shull.prolog.runner.App
