package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo seletivo");

        analisarCandidato(1400.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);
        
        System.out.println("-- Seleção de candidatos --");
        selecaoCandidatos();
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
        }else {
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
    }
    
    static void selecaoCandidatos() {
        String[] candidatos = {"Sofia", "Mateus", "Laura", "Thiago", "Beatriz", "Felipe", "Juliana", "Leonardo", "Manuela", "Rafael"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato: " + candidato + " solicitou esse valor de salário: " + String.format("%.2f", salarioPretendido));

            if(salarioBase >= salarioPretendido) {
                System.out.println(candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1500, 2500);
    }
}