package trabalhoFinal.appLists.setimaQuestao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import trabalhoFinal.tools.StopwatchCPU;

public class AppRemoveList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> nome = new ArrayList<String>();
		nome.add("Lisbon");
		nome.add("NASA");
		nome.add("Kyunghee");
		nome.add("Konkuk");
		nome.add("Sogang");
		nome.add("momentarily");
		nome.add("rubella");
		nome.add("vaccinations");
		nome.add("government");
		nome.add("Authorities");
		LinkedList<String> testeList = new LinkedList<String>();
		ArrayList<String> testeArray = new ArrayList<String>();
		Vector<String> testeVector = new Vector<String>();
		int op;
		double tempo;
		while (true) {
			System.out.println("1 - Tempo para inserir na LinkedList");
			System.out.println("2 - Tempo para inserir na ArrayList");
			System.out.println("3 - Tempo para inserir no Vector");
			System.out.println("4 - Tempo para remover 10 palavras na LinkedList");
			System.out.println("5 - Tempo para remover 10 palavras na ArrayList");
			System.out.println("6 - Tempo para remover 10 palavras no Vector");
			System.out.println("0 - Sair");
			op = Integer.parseInt(sc.nextLine());
			if (op == 1) {

				StopwatchCPU timer = new StopwatchCPU();
				String aux = new String();
				try {
					FileReader arq = new FileReader("arquivosTexto/No-repeat-leipzig100k.txt");
					BufferedReader linha = new BufferedReader(arq);
					for (int i = 0; i < 144256; i++) {
						aux = linha.readLine();
						testeList.add(aux);
					}
					linha.close();
				} catch (Exception e) {
					System.out.println("Erro ao abrir o arquivo!");
				}
				tempo = timer.elapsedTime();
				try {
					FileWriter arq = new FileWriter("LinkedList.txt");
					BufferedWriter arquivo = new BufferedWriter(arq);
					for (String s : testeList) {
						arquivo.write(s + "\n");
					}
					arquivo.close();
				} catch (Exception e) {
					System.out.println("Erro ao abrir o arquivo!");
				}

				System.out.println(tempo);
			} else if (op == 2) {

				StopwatchCPU timer = new StopwatchCPU();
				String aux = new String();
				try {
					FileReader arq = new FileReader("arquivosTexto/No-repeat-leipzig100k.txt");
					BufferedReader linha = new BufferedReader(arq);
					for (int i = 0; i < 144256; i++) {
						aux = linha.readLine();
						testeArray.add(aux);
					}
					linha.close();
				} catch (Exception e) {
					System.out.println("Erro ao abrir o arquivo!");
				}
				tempo = timer.elapsedTime();
				try {
					FileWriter arq = new FileWriter("ArrayList.txt");
					BufferedWriter arquivo = new BufferedWriter(arq);
					for (String s : testeArray) {
						arquivo.write(s + "\n");
					}
					arquivo.close();
				} catch (Exception e) {
					System.out.println("Erro ao abrir o arquivo!");
				}

				System.out.println(tempo);
			} else if (op == 3) {

				StopwatchCPU timer = new StopwatchCPU();
				String aux = new String();
				try {
					FileReader arq = new FileReader("arquivosTexto/No-repeat-leipzig100k.txt");
					BufferedReader linha = new BufferedReader(arq);
					for (int i = 0; i < 144256; i++) {
						aux = linha.readLine();
						testeVector.add(aux);
					}
					linha.close();
				} catch (Exception e) {
					System.out.println("Erro ao abrir o arquivo!");
				}
				tempo = timer.elapsedTime();
				try {
					FileWriter arq = new FileWriter("Vector.txt");
					BufferedWriter arquivo = new BufferedWriter(arq);
					for (String s : testeVector) {
						arquivo.write(s + "\n");
					}
					arquivo.close();
				} catch (Exception e) {
					System.out.println("Erro ao abrir o arquivo!");
				}

				System.out.println(tempo);
			} else if (op == 4) {
				StopwatchCPU timer = new StopwatchCPU();
				for (int i = 0; i < nome.size(); i++) {
					if (testeList.contains(nome.get(i)) == true) {
						testeList.remove(nome.get(i));
						System.out.println(nome.get(i) + " removido\n");
					}
				}
				tempo = timer.elapsedTime();
				System.out.println("Tempo total de remover 10 palavras = " + tempo);
			} else if (op == 5) {
				StopwatchCPU timer = new StopwatchCPU();
				for (int i = 0; i < nome.size(); i++) {
					if (testeArray.contains(nome.get(i)) == true) {
						testeArray.remove(nome.get(i));
						System.out.println(nome.get(i) + " removido\n");
					}
				}
				tempo = timer.elapsedTime();
				System.out.println("Tempo total de remover 10 palavras = " + tempo);
			} else if (op == 6) {
				StopwatchCPU timer = new StopwatchCPU();
				for (int i = 0; i < nome.size(); i++) {
					if (testeVector.contains(nome.get(i)) == true) {
						testeVector.remove(nome.get(i));
						System.out.println(nome.get(i) + " removido\n");
					}
				}
				tempo = timer.elapsedTime();
				System.out.println("Tempo total de remover 10 palavras = " + tempo);
			} else if (op == 0) {
				break;
			} else {
				System.out.println("Opção Inválida");
			}
		}
		sc.close();
		System.out.println("End of program!");
	}
}