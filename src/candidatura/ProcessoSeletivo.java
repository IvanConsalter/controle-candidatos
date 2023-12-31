package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	
	private static String[] arrayCandidatos = {"Sofia", "Mateus", "Laura", "Thiago", "Beatriz", "Felipe", "Juliana", "Leonardo", "Manuela", "Rafael"};
	static String [] arrayCandidatosSelecionados = new String[5];
	
    public static void main(String[] args) {	
        System.out.println("Processo seletivo");

        analisarCandidato(1400.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);
        
        System.out.println("-- Sele��o de candidatos --");
        selecaoCandidatos();
        
        System.out.println("\n-- Imprimir Selecionados --");
        imprimirSelecionados();
        
        System.out.println("\n-- Ligando para os Selecionados --");
        for (String candidato : arrayCandidatosSelecionados) {
            entrandoEmContato(candidato);
        }

    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2200.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
        }else {
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
    }
    
    static void selecaoCandidatos() {
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 1600.0;

        while(candidatosSelecionados < 5 && candidatosAtual < arrayCandidatos.length) {
            String candidato = arrayCandidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato: " + candidato + " solicitou esse valor de sal�rio: " + String.format("%.2f", salarioPretendido));

            if(salarioBase >= salarioPretendido) {
                System.out.println(candidato + " foi selecionado para a vaga");
                arrayCandidatosSelecionados[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1500, 2500);
    }

    static void imprimirSelecionados() {
        System.out.println("Imprimindo a lista de candidatos");

        for (String candidato : arrayCandidatosSelecionados) {
        	if(candidato == null) return;
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }
    
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void entrandoEmContato(String candidato) {
    	if(candidato == null) return;
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if(continuaTentando) {
                tentativasRealizadas++;
            }else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while(continuaTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.println("Conseguimos o contato com " + candidato + " com " + tentativasRealizadas + " tentativas!");
        }else {
            System.out.println("N�o conseguimos o contato com " + candidato + " com " + tentativasRealizadas + " tentativas!");
        }
    }

}