package trabalhoFinal.appPriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AppPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<String> filaP = new PriorityQueue<String>();
		PriorityQueue<String> filaN = new PriorityQueue<String>();
		Scanner sc = new Scanner(System.in);
		String nome;
		int op = 0;
		while (true) {
			System.out.println(
					"\nMenu de op��es:\n1.Chegada de pessoa para atendimento normal\n2.Chegada de pessoa para atendimento priorit�rio\n3.Atender pessoa\n4.Listar todas as pessoas da fila\n5.Gerar estat�sticas\n6.Sair\n");
			op = Integer.parseInt(sc.nextLine());
			if (op == 1) {
				System.out.println("Adicionar pessoa normal � fila:");
				System.out.print("Digite o nome: ");
				nome = sc.nextLine();
				filaN.add(nome);
			} else if (op == 2) {
				System.out.println("Adicionar pessoa com prioridade � fila:");
				System.out.print("Digite o nome: ");
				nome = sc.nextLine();
				filaP.add(nome);
			} else if (op == 3) {
				if (filaP.isEmpty() && filaN.isEmpty()) {
					System.out.println("Fila vazia.");
				} else if (filaP.isEmpty()) {
					System.out.println("Pessoa normal atendida: " + filaN.remove());
				} else {
					System.out.println("Pessoa prioridade atendida: " + filaP.remove());
				}
			} else if (op == 4) {
				System.out.println("Listar pessoas da fila: ");
				System.out.print(filaP);
				System.out.print(filaN);
			} else if (op == 5) {
				System.out.println("Gerar estatisticas di�rias da empresa: ");
				float soma = filaP.size() + filaN.size();
				float atendNormal = (filaN.size() / soma) * 100;
				float atendPrioritario = (filaP.size() / soma) * 100;
				System.out.printf("Porcentagem de atendimento priorit�rio: %.2f%%\n", atendPrioritario);
				System.out.printf("Porcentagem de atendimento normal: %.2f%%\n", atendNormal);
			} else if (op == 6) {
				if (filaP.isEmpty() && filaN.isEmpty()) {
					int qnt = filaP.size() + filaN.size();
					System.out.println("Quantidade de pessoas atendidas: " + qnt);
					break;
				} else {
					System.out.println("Fila ainda contem pessoas.");
				}
			} else {
				System.out.println("Op��o inv�lida");
			}
		}
		sc.close();
		System.out.println("End of program");
	}
}
