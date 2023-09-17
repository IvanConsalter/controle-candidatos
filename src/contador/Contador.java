package contador;

import java.util.Scanner;

import contador.exception.ParametroInvalido;

public class Contador {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		boolean parametrosValidos;
		
		System.out.print("Digite o primeiro par�metro: ");
		int parametroUm = terminal.nextInt();
		int parametroDois;
		
		do {
            System.out.print("Digite o segundo par�metro: ");
            parametroDois = terminal.nextInt();

            try {
                contar(parametroUm, parametroDois);
                parametrosValidos = true; 
            } catch (ParametroInvalido e) {
                System.out.println("Erro: " + e.getMessage());
                parametrosValidos = false;
            }
        } while (!parametrosValidos);
		
	}
	
	static void contar(int parametroUm, int parametroDois ) throws ParametroInvalido {
        if(parametroUm > parametroDois) {
        	throw new ParametroInvalido("O segundo par�metro deve ser maior que o primeiro");
        }
		
		int contagem = parametroDois - parametroUm;
        for (int i = 0; i < contagem; i++) {
            System.out.println("Imprimindo o n�mero " + (i + 1));
        }
	}
}
