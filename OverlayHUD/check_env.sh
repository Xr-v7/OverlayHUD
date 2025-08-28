#!/usr/bin/env bash
echo "Java version:"
java -version 2>&1 || true
echo "Gradle (global) version:"
gradle --version 2>&1 || true
echo "gradlew exists?"
ls -l ./gradlew
echo "wrapper properties:"
sed -n '1,120p' gradle/wrapper/gradle-wrapper.properties
echo "app module:"
ls -l app || true
