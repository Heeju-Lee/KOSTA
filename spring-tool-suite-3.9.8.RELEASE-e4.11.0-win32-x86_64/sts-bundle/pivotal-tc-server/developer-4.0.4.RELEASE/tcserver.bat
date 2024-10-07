@echo off
rem ---------------------------------------------------------------------------
rem tc Server Script
rem
rem Copyright (c) 2017-2018 Pivotal Software, Inc.  All rights reserved.
rem ---------------------------------------------------------------------------
rem version: 4.0.4.RELEASE
rem build date: 20181128221035

IF "%OS%" == "Windows_NT" SETLOCAL

IF NOT "%JAVA_HOME%" == "" goto JavaHomeSet
echo No JAVA_HOME environment variable set, attempting to locate java >&2
FOR /f "delims=" %%a in ('where java') do @set JAVA_BIN=%%a
FOR %%i IN ("%JAVA_BIN%\..") DO SET JAVA_HOME=%%~dpi

IF NOT EXIST "%JAVA_HOME%bin\java.exe" (
    echo Couldn't discover JAVA_HOME automatically, please set the JAVA_HOME environment variable. >&2
    GOTO:EOF
)

:JavaHomeSet
IF NOT EXIST "%JAVA_HOME%\bin\java.exe" (
  echo "%JAVA_HOME%\bin\java.exe doesn't exist" >&2
  GOTO:EOF
)

SET SCRIPT_DIR=%~dp0%

set INSTALLATION_DIR=%SCRIPT_DIR:~0,-1%
set INSTANCE_DIR=%INSTALLATION_DIR%\..\instances
set RUNTIME_DIR=%INSTALLATION_DIR%\..\runtimes

set CLASSPATH=

PUSHD "%SCRIPT_DIR%lib"
FOR %%G IN (*.*) DO CALL:APPEND_TO_CLASSPATH lib %%G
POPD
GOTO Continue

: APPEND_TO_CLASSPATH
set filename=%~2
set suffix=%filename:~-4%
if %suffix% equ .jar set CLASSPATH=%CLASSPATH%;"%SCRIPT_DIR%%~1\%filename%"
GOTO:EOF

:Continue
rem If there is a trailing back slash, strip if off
IF %INSTANCE_DIR:~-1%==\ SET INSTANCE_DIR=%INSTANCE_DIR:~0,-1%

FOR /F "tokens=2 delims=: " %%i IN ('MODE CON ^| FINDSTR "Columns:"') DO (
  SET COLUMNS=%%i
)

"%JAVA_HOME%\bin\java" -Djava.util.logging.config.file="%SCRIPT_DIR%\conf\commons-logging.properties" -Dtcs.terminal.columns="%COLUMNS%" %JAVA_OPTS% -Dtcs.version=4.0.4.RELEASE -Dtcs.edition=@edition@ -Druntimes.directory="%RUNTIME_DIR%" -Ddefault.instances.directory="%INSTANCE_DIR%" -Dinstallation.directory="%INSTALLATION_DIR%" -classpath %CLASSPATH% com.springsource.tcruntime.instance.TcServer %*
SET _RET=%ERRORLEVEL%
IF %_RET% EQU 1 (
    IF "%1"=="" (
        pause
    )
)

exit /b %_RET%
