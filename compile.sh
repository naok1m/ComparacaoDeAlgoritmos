#!/bin/bash

echo "====================================="
echo "Compilando Sistema de Comparacao de Algoritmos"
echo "====================================="
echo

cd src

echo "Compilando todas as classes..."
javac -encoding UTF-8 -d ../bin model/*.java algorithms/*.java generators/*.java benchmark/*.java analysis/*.java examples/*.java Main.java || { echo "ERRO na compilacao!"; exit 1; }

echo
echo "====================================="
echo "Compilacao concluida com sucesso!"
echo "====================================="
echo
echo "Para executar o programa:"
echo "  - Benchmark completo: ./run.sh"
echo "  - Demonstracao rapida: ./run-demo.sh"
echo

cd ..

