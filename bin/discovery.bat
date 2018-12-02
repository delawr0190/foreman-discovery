@echo off

set DISCOVERY_HOME=%~dp0..

for %%i in ("%DISCOVERY_HOME%\lib\*.jar") do (
    call :concat "%%i"
)

java -cp %CLASSPATH% mn.foreman.discovery.Main

:concat
if not defined CLASSPATH (
    set CLASSPATH="%~1"
) else (
    set CLASSPATH=%CLASSPATH%;"%~1"
)
goto :eof

:end
endlocal