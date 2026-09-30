import java.util.Scanner;

public class VoleiStatus {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual Jogador analisaremos??");
        String nomeJogador = scanner.nextLine();
        System.out.println("Quantos ataques fez??");
        int totalAtaques = scanner.nextInt();
        System.out.println("Quantos pontos marcou??");
        int pontosFeitos = scanner.nextInt();

        System.out.println("=== SISTEMA DE ANÁLISE TÉCNICA (VÔLEI) ===");
        System.out.println("Jogador analisado: " + nomeJogador);

        // Chama a função
        double eficienciaFinal = calcularEficiencia(pontosFeitos, totalAtaques);

        System.out.println("Eficiência real calculada: " + eficienciaFinal + "%");

        // --- 3. CASTING EXPLICÍTO (Para o relatório impresso) ---
        int eficienciaArredondada = (int) Math.round(eficienciaFinal);
        System.out.println("Eficiência para a prancheta (Inteiro): " + eficienciaArredondada + "%");

        // Decisão
        if (eficienciaFinal < 50.0) {
            System.out.println("Alerta! Substituição do atacante!");
        } else {
            System.out.println("Desempenho excelente! Manter em quadra.");
        }
    }

    /**
     * MÉTODO/FUNÇÃO: Isola a regra de negócio do cálculo de desempenho.
     * Recebe dois tipos primitivos (int) e retorna um tipo primitivo (double).
     */
    public static double calcularEficiencia(int pontos, int ataques) {
        if (ataques == 0) {
            return 0.0;
        }

        // ---CASTING---
        // Se fizermos apenas 'pontos / ataques', o Java faz divisão inteira: 6 / 15 vira 0.
        // Usamos o (double) para forçar o Java a considerar os números decimais antes de multiplicar por 100.
        double resultado = ((double) pontos / ataques) * 100;

        return resultado;
    }
}