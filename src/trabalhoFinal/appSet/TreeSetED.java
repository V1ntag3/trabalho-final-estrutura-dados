package trabalhoFinal.appSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.TreeSet;

import trabalhoFinal.tools.StopwatchCPU;

public class TreeSetED {
	public double putTreeSet() {
		TreeSet<String> treeSet = new TreeSet<>();
		StopwatchCPU timer = new StopwatchCPU();

		String aux = new String();

		try {
			FileReader arq = new FileReader("arquivosTexto/No-repeat-leipzig100k.txt");
			BufferedReader linha = new BufferedReader(arq);
			for (int i = 0; i < 144256; i++) {
				aux = linha.readLine();
				treeSet.add(aux);
			}
			linha.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}

		double time = timer.elapsedTime();

		try {
			FileWriter arq = new FileWriter("arquivosTexto/treeSet.txt");
			BufferedWriter arquivo = new BufferedWriter(arq);
			for (String s : treeSet) {
				arquivo.write(s + "\n");
			}
			arquivo.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return time;
	}

	public double searchTreeSet() {
		TreeSet<String> treeSet = new TreeSet<>();

		String aux = new String();

		try {
			FileReader arq = new FileReader("arquivosTexto/No-repeat-leipzig100k.txt");
			BufferedReader linha = new BufferedReader(arq);
			for (int i = 0; i < 144256; i++) {
				aux = linha.readLine();
				treeSet.add(aux);
			}
			linha.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}

		StopwatchCPU timer = new StopwatchCPU();

		ArrayList<String> palavras = new ArrayList<>();
		palavras.add("Lisbon");
		palavras.add("NASA");
		palavras.add("Kyunghee");
		palavras.add("Konkuk");
		palavras.add("Sogang");
		palavras.add("momentarily");
		palavras.add("rubella");
		palavras.add("vaccinations");
		palavras.add("government");
		palavras.add("Authorities");

		for (String s : palavras) {
			treeSet.contains(s);
		}

		return timer.elapsedTime();

	}

	public double deleteLinkedHashSet() {
		TreeSet<String> treeSet = new TreeSet<>();

		String aux = new String();

		try {
			FileReader arq = new FileReader("arquivosTexto/No-repeat-leipzig100k.txt");
			BufferedReader linha = new BufferedReader(arq);
			for (int i = 0; i < 144256; i++) {
				aux = linha.readLine();
				treeSet.add(aux);
			}
			linha.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}

		StopwatchCPU timer = new StopwatchCPU();

		ArrayList<String> palavras = new ArrayList<>();
		palavras.add("Lisbon");
		palavras.add("NASA");
		palavras.add("Kyunghee");
		palavras.add("Konkuk");
		palavras.add("Sogang");
		palavras.add("momentarily");
		palavras.add("rubella");
		palavras.add("vaccinations");
		palavras.add("government");
		palavras.add("Authorities");

		for (String s : palavras) {
			treeSet.remove(s);
		}

		return timer.elapsedTime();

	}
}
