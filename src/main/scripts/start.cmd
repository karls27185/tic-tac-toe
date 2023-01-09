@echo off

%~dp0jre\bin\java -jar ${project.build.finalName}.jar
pause