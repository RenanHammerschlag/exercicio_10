package conta_bancaria;

import java.util.Scanner;


public class Contas {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		ContaBancaria conta = null;
		System.out.println("Sistema bancario");
		
		System.out.println("Qual tipo de conta?");
		System.out.println("1- Conta poupança");
		System.out.println("2- Conta especial");
		
		int tipoConta = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Nome do cliente: ");
		String cliente = sc.next();
		
		System.out.println("Numero da conta: ");
		int num_conta = sc.nextInt();
		
		System.out.println("Digite o saldo atual: ");
		float saldo = sc.nextFloat();
		
		if(tipoConta == 1) {
			System.out.println("Qual o dia do rendimento da conta?");
			int dia_de_rendimento = sc.nextInt();
			conta = new ContaPoupanca(cliente, num_conta, saldo, dia_de_rendimento);
		}else if(tipoConta == 2) {
			System.out.println("Qual o limite da conta especial?");
            float limite = sc.nextFloat();
            conta = new ContaEspecial(cliente, num_conta, saldo, limite);
		}
		
		 int opcao;
	        do {
	            System.out.println("\nEscolha uma operação:");
	            System.out.println("1. Depositar");
	            System.out.println("2. Sacar");
	            System.out.println("3. Calcular novo saldo com rendimento (apenas para Conta Poupança)");
	            System.out.println("4. Mostrar saldo");
	            System.out.println("5. Mostrar dados da conta");
	            System.out.println("0. Sair");
	            opcao = sc.nextInt();

	            switch (opcao) {
	                case 1:
	                    // Depósito
	                    System.out.println("Digite o valor a depositar:");
	                    float valorDeposito = sc.nextFloat();
	                    conta.depositar(valorDeposito);
	                    break;
	                case 2:
	                    // Saque
	                    System.out.println("Digite o valor a sacar:");
	                    float valorSaque = sc.nextFloat();
	                    conta.sacar(valorSaque);
	                    break;
	                case 3:
	                    // Calcular novo saldo (apenas para poupança)
	                    if (conta instanceof ContaPoupanca) {
	                        System.out.println("Digite a taxa de rendimento:");
	                        float taxaRendimento = sc.nextFloat();
	                        ((ContaPoupanca) conta).calcularNovoSaldo(taxaRendimento);
	                    } else {
	                        System.out.println("Esta operação só é permitida para contas poupança.");
	                    }
	                    break;
	                case 4:
	                    // Mostrar saldo
	                    System.out.println("Saldo atual: " + conta.getSaldo());
	                    break;
	                case 5:
	                    // Mostrar dados da conta
	                    System.out.println(conta.toString());
	                    break;
	                case 0:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        } while (opcao != 0);

		
		sc.close();
	}
}
