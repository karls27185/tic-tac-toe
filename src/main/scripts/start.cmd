@echo off

setlocal
@rem -------------------------------------------------------------------------------------------------------------------

@rem Попытка использовать `java.exe` из `%JAVA_HOME%`, если эта переменная среды установлена правильно
if "%JAVA_HOME%" neq "" (
if exist %JAVA_HOME%\bin\java.exe (
set JAVA_CMD=%JAVA_HOME%\bin\java
)
)
@rem -------------------------------------------------------------------------------------------------------------------
@rem Попытка использовать `java.exe`, используя переменную среды `PATH`
where /Q java
if %ERRORLEVEL% == 0 (
set JAVA_CMD=java
)
@rem -------------------------------------------------------------------------------------------------------------------
@rem Попытка использовать `java.exe` из JRE, если существует `jre\bin\java.exe`
if exist jre\bin\java.exe (
set JAVA_CMD=jre\bin\java
)
@rem -------------------------------------------------------------------------------------------------------------------
if not defined JAVA_CMD (
@rem Выдать ошибку, если `java.exe` не настроен
echo -------------------------------------------------------------------------- >&2
echo `java.exe` not defined! Install or configure JVM before using this script! >&2
echo -------------------------------------------------------------------------- >&2
set RETURN_COD=1
) else (
@rem Запустить игру tic-tac-toe
%JAVA_CMD% -jar ${project.build.finalName}-release.jar
set RETURN_CODE=0
)
@rem -------------------------------------------------------------------------------------------------------------------
pause
@rem -------------------------------------------------------------------------------------------------------------------
exit /b %RETURN_CODE%
