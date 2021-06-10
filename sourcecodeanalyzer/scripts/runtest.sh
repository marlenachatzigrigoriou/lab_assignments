#!/bin/bash

java -jar target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv

DIFF=$(diff metrics_results.csv scripts/metrics_results_test.csv) 
if [ "$DIFF" == "" ]; then
    printf "Passed\n"

else
    printf "Failed\n"
    sdiff "metrics_results.csv" "scripts/metrics_results_test.csv"
fi
