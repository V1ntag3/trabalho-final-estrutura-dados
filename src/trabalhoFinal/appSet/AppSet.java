package trabalhoFinal.appSet;

import java.util.Scanner;

public class AppSet {
	public static void main(String[] args) {
		HashSetED hs = new HashSetED();
		LinkedHashSetED lhs = new LinkedHashSetED();
		TreeSetED ts = new TreeSetED();

		int op;
		double timeIns, timeSearch, timeDelete;
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("1 - HashSet");
			System.out.println("2 - LinkedHashSet");
			System.out.println("3 - TreeSet");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opcao: ");
			op = Integer.parseInt(scan.nextLine());
			if (op == 4) {
				break;
			} else if (op == 1) {
				System.out.println("Tempo para insercao:");
				timeIns = hs.putHashSet();
				System.out.println("Arquivo hashSet.txt gerado");
				System.out.println("Tempo total = " + timeIns);
				System.out.println("Tempo para busca:");
				timeSearch = hs.searchHashSet();
				System.out.println("Tempo total = " + timeSearch);
				System.out.println("Tempo para remover:");
				timeDelete = hs.deleteHashSet();
				System.out.println("Tempo total = " + timeDelete);
			} else if (op == 2) {
				System.out.println("Tempo para insercao:");
				timeIns = lhs.putLinkedHashSet();
				System.out.println("Arquivo linkedHashSet.txt gerado");
				System.out.println("Tempo total = " + timeIns);
				System.out.println("Tempo para busca:");
				timeSearch = lhs.searchLinkedHashSet();
				System.out.println("Tempo total = " + timeSearch);
				System.out.println("Tempo para remover:");
				timeDelete = lhs.deleteLinkedHashSet();
				System.out.println("Tempo total = " + timeDelete);
			} else if (op == 3) {
				System.out.println("Tempo para insercao:");
				timeIns = ts.putTreeSet();
				System.out.println("Arquivo treeSet.txt gerado");
				System.out.println("Tempo total = " + timeIns);
				System.out.println("Tempo para busca:");
				timeSearch = ts.putTreeSet();
				System.out.println("Tempo total = " + timeSearch);
				System.out.println("Tempo para remover:");
				timeDelete = ts.putTreeSet();
				System.out.println("Tempo total = " + timeDelete);
			} else {
				System.out.println("Opcao invalida!");
			}
		}
		scan.close();
		System.out.println("End of program!");
	}
}
