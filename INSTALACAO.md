# Guia de Instalação e Execução

## 📋 Pré-requisitos

- **Java JDK 8 ou superior** instalado
- Variável de ambiente `JAVA_HOME` configurada (opcional, mas recomendado)
- Terminal/Prompt de Comando

### Verificar instalação do Java

```bash
java -version
javac -version
```

Ambos os comandos devem retornar a versão instalada.

---

## 🚀 Instalação Rápida

### No Windows

1. **Abra o Prompt de Comando** na pasta do projeto:
   ```cmd
   cd C:\Users\thiago\eclipse-workspace\AV2Algoritmos
   ```

2. **Compile o projeto**:
   ```cmd
   compile.bat
   ```

3. **Execute**:
   - Benchmark completo: `run.bat`
   - Demonstração rápida: `run-demo.bat`

### No Linux/Mac

1. **Abra o Terminal** na pasta do projeto:
   ```bash
   cd /caminho/para/AV2Algoritmos
   ```

2. **Torne os scripts executáveis**:
   ```bash
   chmod +x compile.sh run.sh run-demo.sh
   ```

3. **Compile o projeto**:
   ```bash
   ./compile.sh
   ```

4. **Execute**:
   - Benchmark completo: `./run.sh`
   - Demonstração rápida: `./run-demo.sh`

---

## 🔧 Compilação Manual

Se preferir compilar manualmente:

```bash
cd src
javac -encoding UTF-8 -d ../bin model/*.java algorithms/*.java generators/*.java benchmark/*.java analysis/*.java examples/*.java Main.java
```

### Executar após compilação manual:

```bash
cd bin
java Main
```

Ou para a demonstração:

```bash
cd bin
java examples.QuickDemo
```

---

## 📊 Usando no Eclipse

1. **Abra o Eclipse**

2. **Importe o projeto**:
   - File → Open Projects from File System
   - Navegue até a pasta `AV2Algoritmos`
   - Clique em Finish

3. **Configure a codificação** (se necessário):
   - Botão direito no projeto → Properties
   - Resource → Text file encoding
   - Selecione UTF-8

4. **Execute**:
   - Botão direito em `Main.java` → Run As → Java Application
   - Ou em `QuickDemo.java` para demonstração rápida

---

## ⚙️ Configurações

### Ajustar tamanhos de array testados

Edite `src/Main.java`:

```java
private static final int[] ARRAY_SIZES = {1000, 10000, 50000, 100000};
```

### Ajustar número de repetições

Edite `src/Main.java`:

```java
private static final int REPETITIONS = 5;
```

### Para testes mais rápidos

Use configuração reduzida:

```java
private static final int[] ARRAY_SIZES = {1000, 5000};
private static final int REPETITIONS = 3;
```

---

## 🐛 Solução de Problemas

### Erro: "javac não é reconhecido"

**Solução**: Java não está instalado ou não está no PATH.

1. Instale o JDK
2. Adicione ao PATH:
   - Windows: `C:\Program Files\Java\jdk-XX\bin`
   - Linux/Mac: Geralmente já está configurado

### Erro: "unmappable character for encoding"

**Solução**: Use o parâmetro `-encoding UTF-8` na compilação.

Isso já está incluído nos scripts `compile.bat` e `compile.sh`.

### Erro: "OutOfMemoryError"

**Solução**: Aumente a memória heap da JVM:

```bash
java -Xmx2g Main
```

Ou edite os scripts `run.bat`/`run.sh` e adicione `-Xmx2g` após `java`.

### Programa muito lento

**Solução**: 

1. Reduza os tamanhos de array em `Main.java`
2. Reduza o número de repetições
3. Comente alguns algoritmos ou distribuições

---

## 📁 Estrutura de Diretórios

```
AV2Algoritmos/
├── src/                    # Código fonte
│   ├── model/             # Classes de modelo
│   ├── algorithms/        # Algoritmos de ordenação
│   ├── generators/        # Geradores de dados
│   ├── benchmark/         # Sistema de benchmark
│   ├── analysis/          # Análise e formatação
│   ├── examples/          # Exemplos de uso
│   └── Main.java          # Programa principal
├── bin/                    # Arquivos compilados (.class)
├── compile.bat            # Script de compilação (Windows)
├── compile.sh             # Script de compilação (Linux/Mac)
├── run.bat                # Script de execução (Windows)
├── run.sh                 # Script de execução (Linux/Mac)
├── run-demo.bat           # Demonstração rápida (Windows)
├── run-demo.sh            # Demonstração rápida (Linux/Mac)
├── README.md              # Documentação principal
├── USAGE.md               # Guia de uso detalhado
├── INSTALACAO.md          # Este arquivo
└── EXEMPLO_SAIDA.md       # Exemplos de saída
```

---

## ✅ Teste de Instalação

Para verificar se tudo está funcionando:

1. **Compile o projeto**:
   ```bash
   compile.bat  # Windows
   ./compile.sh # Linux/Mac
   ```

2. **Execute a demonstração**:
   ```bash
   run-demo.bat  # Windows
   ./run-demo.sh # Linux/Mac
   ```

Se você ver arrays sendo ordenados e métricas sendo exibidas, tudo está funcionando! ✅

---

## 🎯 Próximos Passos

Após a instalação:

1. **Execute a demonstração rápida** para ver o sistema em ação
2. **Leia o README.md** para entender a arquitetura
3. **Leia o USAGE.md** para exemplos de uso
4. **Execute o benchmark completo** para análise detalhada
5. **Veja EXEMPLO_SAIDA.md** para saber o que esperar

---

## 📞 Suporte

Se encontrar problemas:

1. Verifique os pré-requisitos
2. Confira a seção de Solução de Problemas
3. Revise a documentação no README.md
4. Verifique se a compilação foi bem-sucedida

---

## 🎓 Para Uso Acadêmico

Se estiver usando para trabalho acadêmico:

1. **Compile e execute** o benchmark completo
2. **Capture as tabelas** de resultados
3. **Leia a análise comportamental** gerada
4. **Compare com a teoria** apresentada
5. **Use os gráficos e tabelas** no seu relatório

O sistema gera automaticamente:
- ✅ Tabelas formatadas prontas para relatórios
- ✅ Análise teórica de complexidade
- ✅ Análise prática com métricas
- ✅ Observações comportamentais
- ✅ Comparações e conclusões

---

**Pronto para começar!** 🚀

Execute `compile.bat` (Windows) ou `./compile.sh` (Linux/Mac) e depois `run-demo.bat` ou `./run-demo.sh`.

