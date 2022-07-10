package atividadePratica3GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class AppBST {

	private JFrame frmAplicaoBinarySearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppBST window = new AppBST();
					window.frmAplicaoBinarySearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// BST
	BST<String, Integer> bst = new BST<>();

	ArrayList<String> nomes = new ArrayList<>();
	private JTextField textField;

	public void lerArq(String arqName, int qnt) {
		String aux = new String();
		try {
			FileReader arq = new FileReader(arqName);
			BufferedReader nomeAtual = new BufferedReader(arq);
			nomes = new ArrayList<>();
			bst = new BST<>();
			for (int i = 0; i < qnt; i++) {
				aux = nomeAtual.readLine();
				nomes.add(aux);
			}
			JOptionPane.showMessageDialog(null, "Arquivo de entrada modificado! Gere a arvore novamente");
			nomeAtual.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo!");
		}
	}

	/**
	 * Create the application.
	 */
	public AppBST() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAplicaoBinarySearch = new JFrame();
		frmAplicaoBinarySearch
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cassi\\Downloads\\diagram.png"));
		frmAplicaoBinarySearch.getContentPane().setBackground(Color.GRAY);
		frmAplicaoBinarySearch.setBackground(Color.GRAY);
		frmAplicaoBinarySearch.setTitle("Aplica\u00E7\u00E3o Binary Search Tree");
		frmAplicaoBinarySearch.setBounds(100, 100, 689, 357);
		frmAplicaoBinarySearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Arquivo de entrada padrao

		nomes.add("Paulo");
		nomes.add("Amarildo");
		nomes.add("Jose");
		nomes.add("Felipe");
		nomes.add("Eduarda");
		nomes.add("Carolina");
		nomes.add("Lia");
		nomes.add("Gabriel");
		nomes.add("Davi");
		nomes.add("Mariana");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		frmAplicaoBinarySearch.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(new Color(255, 250, 250));
		lblMenu.setFont(new Font("Arial", Font.BOLD, 16));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);

		JButton bttGenerateTree = new JButton("Gerar árvore");
		bttGenerateTree.setFont(new Font("Arial", Font.PLAIN, 12));
		bttGenerateTree.setForeground(new Color(255, 250, 240));
		bttGenerateTree.setBackground(new Color(199, 21, 133));
		bttGenerateTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;

				for (String s : nomes) {
					bst.put(s, i);
					i++;
				}

				JOptionPane.showMessageDialog(null, "Árvore Gerada!");
			}
		});

		JLabel lblOp = new JLabel("Op\u00E7\u00F5es:");
		lblOp.setForeground(new Color(255, 250, 250));
		lblOp.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton bttSize = new JButton("Tamanho");
		bttSize.setFont(new Font("Arial", Font.PLAIN, 12));
		bttSize.setForeground(new Color(255, 250, 240));
		bttSize.setBackground(new Color(199, 21, 133));
		bttSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bst.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Gere a árvore antes!");
				} else {
					JOptionPane.showMessageDialog(null, "Tamanho da árvore: " + bst.treeSize());
				}
			}
		});

		JButton bttHeigth = new JButton("Altura");
		bttHeigth.setFont(new Font("Arial", Font.PLAIN, 12));
		bttHeigth.setForeground(new Color(255, 250, 240));
		bttHeigth.setBackground(new Color(199, 21, 133));
		bttHeigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bst.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Gere a árvore antes!");
					return;
				}

				JOptionPane.showMessageDialog(null, "Altura da árvore: " + bst.height());

			}
		});

		JButton bttIPLength = new JButton("Comprimento interno");
		bttIPLength.setFont(new Font("Arial", Font.PLAIN, 12));
		bttIPLength.setForeground(new Color(255, 250, 240));
		bttIPLength.setBackground(new Color(199, 21, 133));
		bttIPLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bst.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Gere a árvore antes!");
					return;
				}
				JOptionPane.showMessageDialog(null, "Comprimento interno: " + bst.internalPathLength());
			}
		});

		JButton bttCrossing = new JButton("Travessias");
		bttCrossing.setFont(new Font("Arial", Font.PLAIN, 12));
		bttCrossing.setForeground(new Color(255, 250, 240));
		bttCrossing.setBackground(new Color(199, 21, 133));
		bttCrossing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bst.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Gere a árvore antes!");
					return;
				}

				StringBuilder preOrd = new StringBuilder();
				for (String s : bst.showPre()) {
					preOrd.append(s + " ");
				}

				StringBuilder inOrd = new StringBuilder();
				for (String s : bst.showOrd()) {
					inOrd.append(s + " ");
				}

				StringBuilder posOrd = new StringBuilder();
				for (String s : bst.showPos()) {
					posOrd.append(s + " ");
				}
				JOptionPane.showMessageDialog(null, "Travessias:\n" + "Pré-ordem: \n" + preOrd + "     \n\n"
						+ "Em ordem: \n" + inOrd + "     \n\n" + "Pós-Ordem: \n" + posOrd + "     \n");
			}
		});

		JButton bttShowKeys = new JButton("Mostrar arquivo de entrada");
		bttShowKeys.setForeground(new Color(255, 250, 240));
		bttShowKeys.setFont(new Font("Arial", Font.PLAIN, 12));
		bttShowKeys.setBackground(new Color(199, 21, 133));
		bttShowKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder arq = new StringBuilder();
				for (String s : nomes) {
					arq.append(s + "\n");
				}

				JOptionPane.showMessageDialog(null, "Chaves inseridas (Nessa ordem) :\n" + arq);
			}
		});

		textField = new JTextField();
		textField.setForeground(new Color(255, 250, 240));
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setBackground(new Color(255, 20, 147));
		textField.setToolTipText("Digite o arquivo de entrada.");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);

		JButton bttUpdateKeys = new JButton("Enviar");
		bttUpdateKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				String sizeArq = JOptionPane.showInputDialog("Quantas linhas possui o arquivo?");
				int qnt = Integer.parseInt(sizeArq);
				lerArq(input, qnt);
			}
		});
		bttUpdateKeys.setBackground(new Color(199, 21, 133));
		bttUpdateKeys.setFont(new Font("Arial", Font.PLAIN, 12));
		bttUpdateKeys.setForeground(new Color(255, 250, 250));

		JLabel lblInFile = new JLabel("Alterar o arquivo de entrada");
		lblInFile.setLabelFor(textField);
		lblInFile.setForeground(new Color(255, 255, 240));
		lblInFile.setFont(new Font("Arial", Font.PLAIN, 14));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(192).addComponent(lblMenu))
						.addGroup(gl_panel.createSequentialGroup().addGap(97).addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(bttGenerateTree).addComponent(lblOp)
												.addComponent(bttIPLength).addComponent(bttSize)
												.addComponent(bttHeigth))
										.addPreferredGap(ComponentPlacement.RELATED, 215, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(bttShowKeys))
										.addComponent(bttCrossing))
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblInFile))
												.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(
														textField, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))))
						.addGroup(gl_panel.createSequentialGroup().addGap(394).addComponent(bttUpdateKeys,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(397)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblMenu).addGap(9).addComponent(lblOp)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(bttGenerateTree)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(bttSize)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(bttHeigth)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(bttIPLength)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(bttCrossing).addGap(18))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblInFile)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGap(5)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(bttShowKeys)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(3).addComponent(bttUpdateKeys).addGap(42)));
		panel.setLayout(gl_panel);
	}
}
