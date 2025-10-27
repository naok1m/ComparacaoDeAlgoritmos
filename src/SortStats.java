// Crie este arquivo: SortStats.java
public class SortStats {
    long comparacoes;
    long trocas;
    long tempoExecucao; // em nanossegundos

    // Construtor
    public SortStats(long comparacoes, long trocas, long tempoExecucao) {
        this.comparacoes = comparacoes;
        this.trocas = trocas;
        this.tempoExecucao = tempoExecucao;
    }
}