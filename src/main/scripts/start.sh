#!/usr/bin/env sh

# Попытка использовать `java` из `%JAVA_HOME%`, если эта переменная среды установлена правильно
if [ -n "$JAVA_HOME" ] && [ -x "$JAVA_HOME/bin/java" ] ; then
  JAVA_CMD="$JAVA_HOME/bin/java"
fi
# -------------------------------------------------------------------------------------------------------------------
# Попытка использовать `java`, используя переменную среды `PATH`
WHICH_JAVA=$(which java)
if [ -x "$WHICH_JAVA" ]; then
  JAVA_CMD="java"
  unset WHICH_JAVA
fi
# -------------------------------------------------------------------------------------------------------------------
# Попытка использовать `java` из JRE, если существует `jre\bin\java`
if [ -x "jre/bin/java" ]; then
  JAVA_CMD="jre/bin/java"
fi
# -------------------------------------------------------------------------------------------------------------------
if [ -z ${JAVA_CMD+x} ]; then
# Выдать ошибку, если `java` не настроен
echo "------------------------------------------------------------------------" >&2
echo "\`java\` not defined! Install or configure JVM before using this script!" >&2
echo "------------------------------------------------------------------------" >&2
RETURN_CODE=1
else
cd "$(dirname "$0")" || exit
# Запустить игру tic-tac-toe
$JAVA_CMD -jar ${project.build.finalName}-release.jar
RETURN_CODE=0
fi
# ----------------------------------------------------------------------------------------------------------------------
echo "Press enter to continue . . ."
read -r test
# ----------------------------------------------------------------------------------------------------------------------
exit $RETURN_CODE