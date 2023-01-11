@echo off

%~dp0jre\bin\java -jar ${project.build.finalName}-release.jar
pause