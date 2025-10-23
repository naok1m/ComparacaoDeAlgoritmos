@echo off
echo =====================================
echo Compilando Sistema de Comparacao de Algoritmos
echo =====================================
echo.

cd src

echo Compilando todas as classes...
javac -encoding UTF-8 -d ..\bin model\*.java algorithms\*.java generators\*.java benchmark\*.java analysis\*.java examples\*.java Main.java
if errorlevel 1 goto error

echo.
echo =====================================
echo Compilacao concluida com sucesso!
echo =====================================
echo.
echo Para executar o programa:
echo   - Benchmark completo: run.bat
echo   - Demonstracao rapida: run-demo.bat
echo.
goto end

:error
echo.
echo =====================================
echo ERRO na compilacao!
echo =====================================
echo.

:end
cd ..

