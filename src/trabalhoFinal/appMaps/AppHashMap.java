package trabalhoFinal.appMaps;

import java.util.*;

import trabalhoFinal.tools.StopwatchCPU;

public class AppHashMap {

	public static void main(String[] args) {
		HashMapEd hashmap = new HashMapEd();
		LinkedHashMapEd linkedhashmap = new LinkedHashMapEd();
		TreeMapEd treemap = new TreeMapEd();
		Scanner sc = new Scanner(System.in);
		double tempoHash = 0;
		int op = 0;
		while (op != 4) {
			System.out.println("\nMenu\n1.Preencher HashMap\n2.Preencher LinkedHashMap\n3.Preencher TreeMap\n4.Sair");
			op = Integer.parseInt(sc.nextLine());
			switch (op) {
			case 1:
				HashMap<String, Integer> pesquisa = new HashMap<String, Integer>();
				System.out.println("\nPreenchendo o HashMap...");
				StopwatchCPU timer = new StopwatchCPU();
				pesquisa = hashmap.inserir();
				tempoHash = timer.elapsedTime();
				System.out.println("Tempo para preencher o HashMap: " + tempoHash + " segundos");
				System.out.println(hashmap.pesquisar(pesquisa));
				System.out.println(hashmap.remover(pesquisa));

				break;

			case 2:
				LinkedHashMap<String, Integer> pesquisa2 = new LinkedHashMap<String, Integer>();
				System.out.println("\nPreenchendo o LinkedHashMap...");
				timer = new StopwatchCPU();
				pesquisa2 = linkedhashmap.inserir();
				tempoHash = timer.elapsedTime();
				System.out.println("Tempo para preencher o LinkedHashMap: " + tempoHash + " segundos");
				System.out.println(linkedhashmap.pesquisar(pesquisa2));
				System.out.println(linkedhashmap.remover(pesquisa2));
				break;

			case 3:
				TreeMap<String, Integer> pesquisa3 = new TreeMap<String, Integer>();
				System.out.println("\nPreenchendo o TreeMap...");
				timer = new StopwatchCPU();
				pesquisa3 = treemap.inserir();
				tempoHash = timer.elapsedTime();
				System.out.println("Tempo para preencher o TreeMap: " + tempoHash + " segundos");
				System.out.println(treemap.pesquisar(pesquisa3));
				System.out.println(treemap.remover(pesquisa3));
				break;

			case 4:

				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		System.out.println("End of Program");
		sc.close();

	}

}
