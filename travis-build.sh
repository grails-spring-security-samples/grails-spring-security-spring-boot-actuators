#!/bin/bash
set -e
./gradlew check || EXIT_STATUS=$?
exit $EXIT_STATUS
