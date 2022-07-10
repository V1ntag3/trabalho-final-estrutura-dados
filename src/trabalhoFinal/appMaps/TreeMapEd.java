package trabalhoFinal.appMaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeMap;

public class TreeMapEd {

	public TreeMap<String, Integer> inserir() {
		TreeMap<String, Integer> nomes = new TreeMap<String, Integer>();
		try {
			String nome = new String();
			FileReader arq = new FileReader("arquivosTexto/No-repeat-leipzig100k.txt");
			BufferedReader nomeAtual = new BufferedReader(arq);
			for (int i = 0; i < 144256; i++) {
				nome = nomeAtual.readLine();
				nomes.put(nome, i);
			}
			nomeAtual.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}

		try {
			FileWriter arq = new FileWriter("NomesTreeMap.txt");
			BufferedWriter arquivo = new BufferedWriter(arq);
			for (String key : nomes.keySet()) {
				arquivo.write(key + " = " + nomes.get(key) + "\n");
			}
			arquivo.close();
		} catch (Exception e) {
			System.out.println("Erro ao escrever no arquivo!");
		}
		return nomes;
	}

	public double pesquisar(TreeMap<String, Integer> nomes) {
		double inicio;
		double fim;

		inicio = System.currentTimeMillis();
		nomes.containsKey("Lisbon");
		nomes.containsKey("NASA");
		nomes.containsKey("Kyunghee");
		nomes.containsKey("Konkuk");
		nomes.containsKey("Sogang");
		nomes.containsKey("momentarily");
		nomes.containsKey("rubella");
		nomes.containsKey("vaccinations");
		nomes.containsKey("government");
		nomes.containsKey("Authorities");
		fim = System.currentTimeMillis();

		return fim - inicio;
	}

	public double remover(TreeMap<String, Integer> nomes) {
		long inicio;
		long fim;
		inicio = System.currentTimeMillis();
		nomes.remove("Lisbon");
		nomes.remove("NASA");
		nomes.remove("Kyunghee");
		nomes.remove("Konkuk");
		nomes.remove("Sogang");
		nomes.remove("momentarily");
		nomes.remove("rubella");
		nomes.remove("vaccinations");
		nomes.remove("government");
		nomes.remove("Authorities");
		fim = System.currentTimeMillis();

		return fim - inicio;
	}

}
