#!/bin/bash

java -jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv

DIFF=$(diff sourcecodeanalyzer/metrics_results.csv sourcecodeanalyzer/scripts/metrics_results_test.csv) 
if [ "$DIFF" == "" ]; then
    printf "Passed\n"

else
    printf "Failed\n"
    sdiff "sourcecodeanalyzer/metrics_results.csv" "sourcecodeanalyzer/scripts/metrics_results_test.csv"
fi
