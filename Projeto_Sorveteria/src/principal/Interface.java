package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bean.Caixa;
import bean.Compra;
import bean.Produto;
import dao.CaixaDAO;
import dao.CompraDAO;
import dao.ProdutoDAO;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ed_peso;
	private JTextField textField_ed_tipo;
	private JTextField textField_ed_preco;
	private JLayeredPane layeredPane;
	private JPanel produtos_Update;
	private JPanel produtos_Delete;
	private JTextField textField_cad_cpf;
	private JTextField textField_cad_nome;
	private JTextField textField_cad_salario;
	private JTextField textField_cad_carga_horaria;
	private JTextField textField_cad_cep;
	private JTextField textField_cad_cidade;
	private JTextField textField_cad_rua;
	private JTextField textField_cad_estado;
	private JTextField textField_cad_num;
	private JTextField textField_ed_nome;
	private JTextField textField_ed_salario;
	private JTextField textField_ed_ch;
	private JTextField textField_ed_cep;
	private JTextField textField_ed_cidade;
	private JTextField textField_ed_rua;
	private JTextField textField_ed_estado;
	private JTextField textField_ed_numero;
	private JPanel home;
	private JTextField textField_cad_cod;
	private JTextField textField_cad_tipo;
	private JTextField textField_cad_peso;
	private JTextField textField_cad_preco;
	private JTable table_Produtos;
	private JPanel produtos_Cadastrar;
	private JPanel caixa_Cadastrar;
	private JPanel caixa_Update;
	private JPanel caixa_Delete;
	private JTextField textField_com_nfiscal;
	private JTextField textField_com_data;
	private JTextField textField_com_hora;
	private JTextField textField_com_ncliente;
	private JTextField textField_com_ed_data;
	private JTextField textField_com_ed_hora;
	private JTextField textField_com_ed_ncliente;
	private JPanel compra_Efetuar;
	private JPanel compra_Update;
	private JTable tableCaixas;
	private JComboBox comboBox_ed_prod;
	private JComboBox comboBox_del_prod;
	private JComboBox comboBox_ed_caixa;
	private JComboBox comboBox_del_caixa;
	private JComboBox comboBox_com_produto;
	private JComboBox comboBox_com_caixa;
	private JTable table_compra;
	private JTable table_preco_produto;
	private JTable table_total_compra;
	private JComboBox comboBox_ed_compra_nota;
	private JComboBox comboBox_ed_com_prod;
	private JComboBox comboBox_ed_com_caixa;
	private JTable table_todas_compras;
	private JPanel compra_Mostrar;
	private JComboBox comboBox_rel_prod;
	private JTable table_rel_prod;
	private JPanel compra_Delete;
	private JTable table_quant_prod;
	private JTable table_quant_caixa;
	private JTable table_maior_caixa;
	private JTable table_menor_caixa;
	private JPanel relatorio_Prod;
	private JComboBox comboBox_rel_caixa;
	private JPanel relatorio_Caixa;
	private JTable table_rel_total;
	private JPanel relatorio_Compra;
	private JComboBox comboBox_rel_data_compra;
	private JTable table_rel_compras_data;
	private JComboBox comboBox_del_compra_nota;
	private JComboBox comboBox_del_compra_prod;
	private JComboBox comboBox_del_compra_caixa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setBackground(new Color(51, 0, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 100, 1554, 830);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(153, 102, 102));
		setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Home");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(home);
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon(Interface.class.getResource("/img/casa.png")));
		mntmNewMenuItem_9.setForeground(Color.WHITE);
		mntmNewMenuItem_9.setBackground(new Color(153, 102, 102));
		mntmNewMenuItem_9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		menuBar.add(mntmNewMenuItem_9);

		JMenu mnNewMenu = new JMenu("Produtos");
		mnNewMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		mnNewMenu.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete (2).png")));
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setBackground(SystemColor.textHighlight);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Adicionar");
		mntmNewMenuItem.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(produtos_Cadastrar);
				ProdutoDAO pdao = new ProdutoDAO();
				ArrayList<Produto> produtos = pdao.getLista();
				DefaultTableModel model = (DefaultTableModel) table_Produtos.getModel();
				model.setRowCount(0);
				for (int i = 0; i < produtos.size(); i++) {
					model.addRow(new Object[] { produtos.get(i).getCod(), produtos.get(i).getTipo(),
							produtos.get(i).getPeso(), produtos.get(i).getPreco() });
				}
			}
		});
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setBackground(new Color(204, 153, 255));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Editar");
		mntmNewMenuItem_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(produtos_Update);
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(new Color(204, 153, 204));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Deletar");
		mntmNewMenuItem_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(produtos_Delete);
			}
		});
		mntmNewMenuItem_2.setForeground(Color.WHITE);
		mntmNewMenuItem_2.setBackground(new Color(204, 153, 153));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Caixa");
		mnNewMenu_1.setIcon(new ImageIcon(Interface.class.getResource("/img/caixa-registradora (1).png")));
		mnNewMenu_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		mnNewMenu_1.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Adicionar");
		mntmNewMenuItem_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_3.setBackground(new Color(204, 153, 255));
		mntmNewMenuItem_3.setForeground(Color.WHITE);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(caixa_Cadastrar);
				CaixaDAO cdao = new CaixaDAO();
				ArrayList<Caixa> caixas = cdao.getLista();
				DefaultTableModel model = (DefaultTableModel) tableCaixas.getModel();
				model.setRowCount(0);
				for (int i = 0; i < caixas.size(); i++) {
					model.addRow(
							new Object[] { caixas.get(i).getCpf(), caixas.get(i).getNome(), caixas.get(i).getSalario(),
									caixas.get(i).getCarga_horaria(), caixas.get(i).getCep(), caixas.get(i).getCidade(),
									caixas.get(i).getRua(), caixas.get(i).getEstado(), caixas.get(i).getNum() });
				}
			}
		});

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Editar\r\n");
		mntmNewMenuItem_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_4.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_4.setForeground(Color.WHITE);
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(caixa_Update);
			}
		});

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Deletar");
		mntmNewMenuItem_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_5.setBackground(new Color(204, 153, 153));
		mntmNewMenuItem_5.setForeground(Color.WHITE);
		mnNewMenu_1.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(caixa_Delete);
			}
		});

		JMenu mnNewMenu_2 = new JMenu("Compra");
		mnNewMenu_2.setIcon(new ImageIcon(Interface.class.getResource("/img/carrinho-de-compras.png")));
		mnNewMenu_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		mnNewMenu_2.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Efetuar");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(compra_Efetuar);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_6.setBackground(new Color(204, 153, 255));
		mntmNewMenuItem_6.setForeground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Editar");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(compra_Update);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_7.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_7.setForeground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Deletar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(compra_Delete);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mntmNewMenuItem_8.setBackground(new Color(204, 153, 153));
		mntmNewMenuItem_8.setForeground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Leitura");
		mntmNewMenuItem_13.setBackground(new Color(102, 0, 0));
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(compra_Mostrar);
				CompraDAO codao = new CompraDAO();
				ArrayList<Compra> compras = codao.getLista();
				DefaultTableModel model = (DefaultTableModel) table_todas_compras.getModel();
				model.setRowCount(0);
				for (int i = 0; i < compras.size(); i++) {
					model.addRow(new Object[] { compras.get(i).getNota_fiscal(), compras.get(i).getCod_produto(),
							compras.get(i).getCpf_caixa(), compras.get(i).getData(), compras.get(i).getHora(),
							compras.get(i).getNome_cliente() });
				}

			}
		});
		mntmNewMenuItem_13.setForeground(Color.WHITE);
		mntmNewMenuItem_13.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_13);

		JMenu mnNewMenu_3 = new JMenu("Relat\u00F3rios");
		mnNewMenu_3.setIcon(new ImageIcon(Interface.class.getResource("/img/relatorio.png")));
		mnNewMenu_3.setForeground(Color.WHITE);
		mnNewMenu_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Produtos");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(relatorio_Prod);
				ProdutoDAO pdao = new ProdutoDAO();
				int quant = pdao.quantProduto();
				DefaultTableModel model = (DefaultTableModel) table_quant_prod.getModel();
				model.setRowCount(0);
				model.addRow(new Object[] { quant });

			}
		});
		mntmNewMenuItem_10.setBackground(new Color(204, 153, 255));
		mntmNewMenuItem_10.setForeground(Color.WHITE);
		mntmNewMenuItem_10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_10);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Caixas");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(relatorio_Caixa);

				CaixaDAO cdao = new CaixaDAO();

				ArrayList<Caixa> caixas = cdao.getListaMaior();
				System.out.println(caixas);
				DefaultTableModel model = (DefaultTableModel) table_maior_caixa.getModel();
				model.setRowCount(0);
				for (int i = 0; i < caixas.size(); i++) {
					model.addRow(new Object[] { caixas.get(i).getNome(), caixas.get(i).getSalario() });
				}

				ArrayList<Caixa> caixasmenor = cdao.getListaMenor();
				System.out.println(caixasmenor);
				DefaultTableModel model2 = (DefaultTableModel) table_menor_caixa.getModel();
				model2.setRowCount(0);
				for (int i = 0; i < caixasmenor.size(); i++) {
					model2.addRow(new Object[] { caixasmenor.get(i).getNome(), caixasmenor.get(i).getSalario() });
				}

			}
		});
		mntmNewMenuItem_11.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_11.setForeground(Color.WHITE);
		mntmNewMenuItem_11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_11);

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Compras");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(relatorio_Compra);
				CompraDAO codao = new CompraDAO();
				double total = codao.valorTotal();
				DefaultTableModel model = (DefaultTableModel) table_rel_total.getModel();
				model.setRowCount(0);
				model.addRow(new Object[] { total });
			}
		});
		mntmNewMenuItem_12.setBackground(new Color(204, 153, 153));
		mntmNewMenuItem_12.setForeground(Color.WHITE);
		mntmNewMenuItem_12.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_12);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1540, 805);
		contentPane.add(layeredPane);

		ArrayList<String> lpro = new ArrayList<>();
		ProdutoDAO pdao = new ProdutoDAO();
		lpro = pdao.getCodProdutos();
		System.out.println(lpro);
		String[] listaproduto = new String[100];
		for (int i = 0; i < lpro.size(); i++) {
			listaproduto[i] = lpro.get(i);
		}

		ArrayList<String> lcai = new ArrayList<>();
		CaixaDAO cdao = new CaixaDAO();
		lcai = cdao.getCpfCaixas();
		System.out.println(lcai);
		String[] listacaixa = new String[100];
		for (int i = 0; i < lcai.size(); i++) {
			listacaixa[i] = lcai.get(i);
		}

		ArrayList<String> lquantpro = new ArrayList<>();
		ProdutoDAO prodao = new ProdutoDAO();
		lquantpro = prodao.getCodProdutos();
		System.out.println(lquantpro);

		ArrayList<String> lnota = new ArrayList<>();
		CompraDAO codao = new CompraDAO();
		lnota = codao.getNota_Fiscal();
		System.out.println(lnota);
		String[] listanotaFiscal = new String[100];
		for (int i = 0; i < lnota.size(); i++) {
			listanotaFiscal[i] = lnota.get(i);
		}
		ArrayList<String> ldata = new ArrayList<>();
		CompraDAO codao1 = new CompraDAO();
		ldata = codao1.getDataSolicitada();
		System.out.println(ldata);
		String[] listadata = new String[100];
		for (int i = 0; i < ldata.size(); i++) {
			listadata[i] = ldata.get(i);
		}
		
				home = new JPanel();
				home.setLayout(null);
				home.setBackground(new Color(51, 0, 51));
				home.setBounds(0, 0, 1540, 826);
				layeredPane.add(home);
				
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(Interface.class.getResource("/img/logo-removebg-preview.png")));
						lblNewLabel.setBackground(SystemColor.controlDkShadow);
						lblNewLabel.setBounds(947, 33, 989, 783);
						home.add(lblNewLabel);
						
								JLabel lblNewLabel_1 = new JLabel("Este software foi desenvolvido pelos alunos Gabriel e Vin\u00EDcius.");
								lblNewLabel_1.setForeground(new Color(255, 204, 255));
								lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 26));
								lblNewLabel_1.setBounds(177, 484, 800, 67);
								home.add(lblNewLabel_1);
								
										JLabel lblNewLabel_2 = new JLabel("Sua funcionalidade principal \u00E9 realizar o cadastro de produtos,");
										lblNewLabel_2.setForeground(new Color(255, 204, 204));
										lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 26));
										lblNewLabel_2.setBounds(177, 552, 800, 67);
										home.add(lblNewLabel_2);
										
												JLabel lblNewLabel_2_1 = new JLabel("funcion\u00E1rios do caixa e registrar compras.");
												lblNewLabel_2_1.setForeground(new Color(255, 204, 204));
												lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 26));
												lblNewLabel_2_1.setBounds(177, 584, 800, 67);
												home.add(lblNewLabel_2_1);
												
														JLabel lblNewLabel_3 = new JLabel("GaVi Sorvetes");
														lblNewLabel_3.setForeground(new Color(153, 255, 153));
														lblNewLabel_3.setFont(new Font("Bakery", Font.PLAIN, 70));
														lblNewLabel_3.setBounds(177, 210, 392, 99);
														home.add(lblNewLabel_3);
														
																JLabel lblNewLabel_6 = new JLabel("");
																lblNewLabel_6.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo.png")));
																lblNewLabel_6.setBounds(-11, 0, 1551, 283);
																home.add(lblNewLabel_6);

		compra_Efetuar = new JPanel();
		compra_Efetuar.setLayout(null);
		compra_Efetuar.setBackground(new Color(102, 102, 153));
		compra_Efetuar.setBounds(0, 0, 1540, 783);
		layeredPane.add(compra_Efetuar);

		JLabel lblNewLabel_4_1_2_3 = new JLabel("Compra");
		lblNewLabel_4_1_2_3.setForeground(new Color(0, 204, 102));
		lblNewLabel_4_1_2_3.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_2_3.setBounds(634, 10, 262, 103);
		compra_Efetuar.add(lblNewLabel_4_1_2_3);

		JLabel lblNewLabel_5_1_2_3 = new JLabel("Cadastrar");
		lblNewLabel_5_1_2_3.setForeground(new Color(0, 153, 204));
		lblNewLabel_5_1_2_3.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_2_3.setBounds(672, 91, 167, 69);
		compra_Efetuar.add(lblNewLabel_5_1_2_3);

		JLabel lblNewLabel_6_3_2_3 = new JLabel("Nota Fiscal:");
		lblNewLabel_6_3_2_3.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_3_2_3.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_3.setBounds(139, 125, 183, 47);
		compra_Efetuar.add(lblNewLabel_6_3_2_3);

		JLabel lblNewLabel_7_3_2_3 = new JLabel(
				"Este campo deve ser preenchido com a nota fiscal de identifica\u00E7\u00E3o da compra.");
		lblNewLabel_7_3_2_3.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_3.setBounds(139, 170, 655, 24);
		compra_Efetuar.add(lblNewLabel_7_3_2_3);

		JLabel lblNewLabel_6_1_1_1_4 = new JLabel("C\u00F3digo do produto:");
		lblNewLabel_6_1_1_1_4.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_1_1_1_4.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_1_1_1_4.setBounds(139, 231, 311, 47);
		compra_Efetuar.add(lblNewLabel_6_1_1_1_4);

		JLabel lblNewLabel_7_1_1_1_4 = new JLabel(
				"Este campo deve ser preenchido com o c\u00F3digo de identifica\u00E7\u00E3o do produto.");
		lblNewLabel_7_1_1_1_4.setForeground(SystemColor.menu);
		lblNewLabel_7_1_1_1_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_1_1_1_4.setBounds(139, 276, 606, 24);
		compra_Efetuar.add(lblNewLabel_7_1_1_1_4);

		textField_com_nfiscal = new JTextField();
		textField_com_nfiscal.setColumns(10);
		textField_com_nfiscal.setBounds(139, 204, 301, 19);
		compra_Efetuar.add(textField_com_nfiscal);

		JLabel lblNewLabel_6_2_2_1_4 = new JLabel("CPF Caixa:");
		lblNewLabel_6_2_2_1_4.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_2_2_1_4.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_2_1_4.setBounds(139, 339, 183, 47);
		compra_Efetuar.add(lblNewLabel_6_2_2_1_4);

		JLabel lblNewLabel_7_2_2_1_4 = new JLabel(
				"Este campo deve ser preenchido com o CPF de identifica\u00E7\u00E3o do caixa.");
		lblNewLabel_7_2_2_1_4.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_4.setBounds(139, 384, 606, 24);
		compra_Efetuar.add(lblNewLabel_7_2_2_1_4);

		JButton btnNewButton_1_2_3 = new JButton("Cadastrar");
		btnNewButton_1_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nota_fiscal = textField_com_nfiscal.getText();

				int itemSelecionado_cod = comboBox_com_produto.getSelectedIndex();
				String item_cod = listaproduto[itemSelecionado_cod];
				Produto p = new Produto();
				p.setCod(item_cod);

				int itemSelecionado_cpf = comboBox_com_caixa.getSelectedIndex();
				String item_cpf = listacaixa[itemSelecionado_cpf];
				Caixa c = new Caixa();
				c.setCpf(item_cpf);

				String data = textField_com_data.getText();
				String hora = textField_com_hora.getText();
				String nome_cliente = textField_com_ncliente.getText();

				DefaultTableModel model = (DefaultTableModel) table_compra.getModel();
				model.addRow(new Object[] { nota_fiscal, item_cod, item_cpf, data, hora, nome_cliente });

				Compra co = new Compra(nota_fiscal, item_cod, item_cpf, data, hora, nome_cliente);
				CompraDAO codao = new CompraDAO();
				codao.inserir(co);

				ProdutoDAO pdao = new ProdutoDAO();
				double valorP = pdao.valorProduto(p);
				System.out.println(valorP);
				DefaultTableModel model2 = (DefaultTableModel) table_preco_produto.getModel();
				model2.addRow(new Object[] { valorP });
				double compratotal = 0;
				for (int i = 0; i < table_preco_produto.getRowCount(); i++) {
					double valor = Double.parseDouble(table_preco_produto.getModel().getValueAt(i, 0).toString());
					compratotal = compratotal + valor;
				}

				DefaultTableModel model3 = (DefaultTableModel) table_total_compra.getModel();
				model3.setRowCount(0);
				model3.addRow(new Object[] { compratotal });

				textField_com_nfiscal.setText("");
				textField_com_data.setText("");
				textField_com_hora.setText("");
				textField_com_ncliente.setText("");
			}
		});
		btnNewButton_1_2_3.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_2_3.setBounds(248, 649, 112, 40);
		compra_Efetuar.add(btnNewButton_1_2_3);

		JLabel lblNewLabel_6_2_1_1_1_4 = new JLabel("Data:");
		lblNewLabel_6_2_1_1_1_4.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_2_1_1_1_4.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1_4.setBounds(139, 447, 150, 47);
		compra_Efetuar.add(lblNewLabel_6_2_1_1_1_4);

		textField_com_data = new JTextField();
		textField_com_data.setColumns(10);
		textField_com_data.setBounds(139, 497, 150, 19);
		compra_Efetuar.add(textField_com_data);

		JLabel lblNewLabel_6_2_1_1_1_4_1 = new JLabel("Hora:");
		lblNewLabel_6_2_1_1_1_4_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_2_1_1_1_4_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1_4_1.setBounds(323, 447, 150, 47);
		compra_Efetuar.add(lblNewLabel_6_2_1_1_1_4_1);

		textField_com_hora = new JTextField();
		textField_com_hora.setColumns(10);
		textField_com_hora.setBounds(323, 497, 150, 19);
		compra_Efetuar.add(textField_com_hora);

		JLabel lblNewLabel_6_2_2_1_4_1 = new JLabel("Nome do Cliente:");
		lblNewLabel_6_2_2_1_4_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_2_2_1_4_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_2_1_4_1.setBounds(139, 526, 281, 47);
		compra_Efetuar.add(lblNewLabel_6_2_2_1_4_1);

		JLabel lblNewLabel_7_2_2_1_4_1 = new JLabel("Este campo deve ser preenchido com o nome do cliente.");
		lblNewLabel_7_2_2_1_4_1.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1_4_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_4_1.setBounds(139, 571, 606, 24);
		compra_Efetuar.add(lblNewLabel_7_2_2_1_4_1);

		textField_com_ncliente = new JTextField();
		textField_com_ncliente.setColumns(10);
		textField_com_ncliente.setBounds(139, 605, 301, 19);
		compra_Efetuar.add(textField_com_ncliente);

		comboBox_com_produto = new JComboBox(listaproduto);
		comboBox_com_produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox_com_produto.setBounds(139, 310, 301, 21);
		compra_Efetuar.add(comboBox_com_produto);

		comboBox_com_caixa = new JComboBox(listacaixa);
		comboBox_com_caixa.setBounds(139, 416, 301, 21);
		compra_Efetuar.add(comboBox_com_caixa);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(786, 160, 635, 498);
		compra_Efetuar.add(scrollPane_1);

		table_compra = new JTable();
		scrollPane_1.setViewportView(table_compra);
		table_compra.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nota Fiscal", "Cod Produto", "CPF Caixa", "Data", "Hora", "Nome Cliente" }) {
			Class[] columnTypes = new Class[] { Integer.class, Integer.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(1420, 160, 86, 498);
		compra_Efetuar.add(scrollPane_2);

		table_preco_produto = new JTable();
		scrollPane_2.setViewportView(table_preco_produto);
		table_preco_produto.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Pre\u00E7o" }) {
			Class[] columnTypes = new Class[] { Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JButton btnNewButton = new JButton("Finalizar Compra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_compra.getModel();
				model.setRowCount(0);
				DefaultTableModel model2 = (DefaultTableModel) table_preco_produto.getModel();
				model2.setRowCount(0);
				DefaultTableModel model3 = (DefaultTableModel) table_total_compra.getModel();
				model3.setRowCount(0);
			}
		});
		btnNewButton.setBounds(1338, 668, 167, 40);
		compra_Efetuar.add(btnNewButton);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(1151, 668, 167, 40);
		compra_Efetuar.add(scrollPane_3);

		table_total_compra = new JTable();
		scrollPane_3.setViewportView(table_total_compra);
		table_total_compra.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Total" }) {
			Class[] columnTypes = new Class[] { Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JLabel lblNewLabel_6_1_1_2_1_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1_1_1_1
				.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo azul.png")));
		lblNewLabel_6_1_1_2_1_1_1_1.setBounds(0, 0, 1594, 283);
		compra_Efetuar.add(lblNewLabel_6_1_1_2_1_1_1_1);
		
		JLabel lblNewLabel_7_2_2_1_4_1_2 = new JLabel("R$");
		lblNewLabel_7_2_2_1_4_1_2.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1_4_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_4_1_2.setBounds(1111, 682, 30, 24);
		compra_Efetuar.add(lblNewLabel_7_2_2_1_4_1_2);

		caixa_Update = new JPanel();
		caixa_Update.setLayout(null);
		caixa_Update.setBackground(new Color(0, 51, 0));
		caixa_Update.setBounds(0, 0, 1540, 783);
		layeredPane.add(caixa_Update);

		JLabel lblNewLabel_4_1_2_1 = new JLabel("Caixa");
		lblNewLabel_4_1_2_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_1_2_1.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_2_1.setBounds(645, 36, 233, 103);
		caixa_Update.add(lblNewLabel_4_1_2_1);

		JLabel lblNewLabel_5_1_2_1 = new JLabel("Editar");
		lblNewLabel_5_1_2_1.setForeground(new Color(102, 204, 0));
		lblNewLabel_5_1_2_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_2_1.setBounds(684, 107, 137, 69);
		caixa_Update.add(lblNewLabel_5_1_2_1);

		JLabel lblNewLabel_6_3_2_1 = new JLabel("Cpf:");
		lblNewLabel_6_3_2_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_3_2_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_1.setBounds(704, 225, 183, 47);
		caixa_Update.add(lblNewLabel_6_3_2_1);

		JLabel lblNewLabel_7_3_2_1 = new JLabel("Selecione o CPF do caixa para ser editado.");
		lblNewLabel_7_3_2_1.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_1.setBounds(571, 269, 606, 24);
		caixa_Update.add(lblNewLabel_7_3_2_1);

		JLabel lblNewLabel_6_1_1_1_2 = new JLabel("Nome:");
		lblNewLabel_6_1_1_1_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_1_1_1_2.setBounds(139, 318, 183, 47);
		caixa_Update.add(lblNewLabel_6_1_1_1_2);

		JLabel lblNewLabel_7_1_1_1_2 = new JLabel("Este campo deve ser preenchido com o nome completo do caixa.");
		lblNewLabel_7_1_1_1_2.setForeground(SystemColor.menu);
		lblNewLabel_7_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_1_1_1_2.setBounds(139, 363, 606, 24);
		caixa_Update.add(lblNewLabel_7_1_1_1_2);

		textField_ed_nome = new JTextField();
		textField_ed_nome.setColumns(10);
		textField_ed_nome.setBounds(139, 397, 301, 19);
		caixa_Update.add(textField_ed_nome);

		JLabel lblNewLabel_6_2_2_1_2 = new JLabel("Sal\u00E1rio:");
		lblNewLabel_6_2_2_1_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_2_2_1_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_2_1_2.setBounds(830, 334, 183, 47);
		caixa_Update.add(lblNewLabel_6_2_2_1_2);

		JLabel lblNewLabel_7_2_2_1_2 = new JLabel("Este campo deve ser preenchido com o sal\u00E1rio do caixa.");
		lblNewLabel_7_2_2_1_2.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_2.setBounds(830, 379, 606, 24);
		caixa_Update.add(lblNewLabel_7_2_2_1_2);

		textField_ed_salario = new JTextField();
		textField_ed_salario.setColumns(10);
		textField_ed_salario.setBounds(830, 413, 301, 19);
		caixa_Update.add(textField_ed_salario);

		JButton btnNewButton_1_2_1 = new JButton("Editar");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_cod = comboBox_ed_caixa.getSelectedIndex();
				String cpf = listacaixa[itemSelecionado_cod];
				String nome = textField_ed_nome.getText();
				double salario = Double.parseDouble(textField_ed_salario.getText());
				String carga_horaria = textField_ed_ch.getText();
				String cep = textField_ed_cep.getText();
				String cidade = textField_ed_cidade.getText();
				String rua = textField_ed_rua.getText();
				String estado = textField_ed_estado.getText();
				int num = Integer.parseInt(textField_ed_numero.getText());

				Caixa c = new Caixa(cpf, nome, salario, carga_horaria, cep, cidade, rua, estado, num);

				int i = JOptionPane.showConfirmDialog(null,
						"As informações serão editadas permanentemente. Deseja continuar?");
				if (i == 0) {
					cdao.alterar(c);
					JOptionPane.showMessageDialog(null, "Caixa editado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Caixa NÃO foi editado!");
				}

				textField_ed_nome.setText("");
				textField_ed_salario.setText("");
				textField_ed_ch.setText("");
				textField_ed_cep.setText("");
				textField_ed_cidade.setText("");
				textField_ed_rua.setText("");
				textField_ed_estado.setText("");
				textField_ed_numero.setText("");

			}
		});
		btnNewButton_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_2_1.setBounds(705, 676, 112, 40);
		caixa_Update.add(btnNewButton_1_2_1);

		JLabel lblNewLabel_6_2_1_1_1_2 = new JLabel("Carga Hor\u00E1ria:");
		lblNewLabel_6_2_1_1_1_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_2_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1_2.setBounds(139, 509, 273, 47);
		caixa_Update.add(lblNewLabel_6_2_1_1_1_2);

		JLabel lblNewLabel_7_2_1_1_1_2 = new JLabel(
				"Este campo deve ser preenchido com a carga hor\u00E1ria do caixa.");
		lblNewLabel_7_2_1_1_1_2.setForeground(SystemColor.menu);
		lblNewLabel_7_2_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_1_1_1_2.setBounds(139, 554, 606, 24);
		caixa_Update.add(lblNewLabel_7_2_1_1_1_2);

		textField_ed_ch = new JTextField();
		textField_ed_ch.setColumns(10);
		textField_ed_ch.setBounds(139, 588, 301, 19);
		caixa_Update.add(textField_ed_ch);

		JLabel lblNewLabel_4_3 = new JLabel("CEP:");
		lblNewLabel_4_3.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_3.setBounds(843, 509, 89, 24);
		caixa_Update.add(lblNewLabel_4_3);

		textField_ed_cep = new JTextField();
		textField_ed_cep.setColumns(10);
		textField_ed_cep.setBounds(843, 543, 150, 19);
		caixa_Update.add(textField_ed_cep);

		JLabel lblNewLabel_4_2_3 = new JLabel("Cidade:");
		lblNewLabel_4_2_3.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2_3.setBounds(1027, 509, 89, 24);
		caixa_Update.add(lblNewLabel_4_2_3);

		textField_ed_cidade = new JTextField();
		textField_ed_cidade.setColumns(10);
		textField_ed_cidade.setBounds(1027, 543, 150, 19);
		caixa_Update.add(textField_ed_cidade);

		JLabel lblNewLabel_4_2_1_1 = new JLabel("Rua:");
		lblNewLabel_4_2_1_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2_1_1.setBounds(843, 572, 89, 24);
		caixa_Update.add(lblNewLabel_4_2_1_1);

		textField_ed_rua = new JTextField();
		textField_ed_rua.setColumns(10);
		textField_ed_rua.setBounds(843, 606, 334, 19);
		caixa_Update.add(textField_ed_rua);

		JLabel lblNewLabel_4_2_2_2 = new JLabel("Estado:");
		lblNewLabel_4_2_2_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2_2_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2_2_2.setBounds(1212, 509, 89, 24);
		caixa_Update.add(lblNewLabel_4_2_2_2);

		textField_ed_estado = new JTextField();
		textField_ed_estado.setColumns(10);
		textField_ed_estado.setBounds(1212, 543, 71, 19);
		caixa_Update.add(textField_ed_estado);

		JLabel lblNewLabel_4_2_2_1_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_4_2_2_1_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2_2_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2_2_1_1.setBounds(1212, 572, 89, 24);
		caixa_Update.add(lblNewLabel_4_2_2_1_1);

		textField_ed_numero = new JTextField();
		textField_ed_numero.setColumns(10);
		textField_ed_numero.setBounds(1212, 606, 71, 19);
		caixa_Update.add(textField_ed_numero);

		comboBox_ed_caixa = new JComboBox(listacaixa);
		comboBox_ed_caixa.setBounds(571, 303, 343, 21);
		caixa_Update.add(comboBox_ed_caixa);

		JLabel lblNewLabel_6_1_1_2_1_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1_1
				.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo verde.png")));
		lblNewLabel_6_1_1_2_1_1.setBounds(-11, 0, 1594, 283);
		caixa_Update.add(lblNewLabel_6_1_1_2_1_1);

		caixa_Cadastrar = new JPanel();
		caixa_Cadastrar.setLayout(null);
		caixa_Cadastrar.setBackground(new Color(0, 51, 0));
		caixa_Cadastrar.setBounds(0, 0, 1540, 783);
		layeredPane.add(caixa_Cadastrar);

		JLabel lblNewLabel_4_1_2 = new JLabel("Caixa");
		lblNewLabel_4_1_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_1_2.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_2.setBounds(666, 10, 233, 103);
		caixa_Cadastrar.add(lblNewLabel_4_1_2);

		JLabel lblNewLabel_5_1_2 = new JLabel("Cadastrar");
		lblNewLabel_5_1_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_5_1_2.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_2.setBounds(676, 91, 167, 69);
		caixa_Cadastrar.add(lblNewLabel_5_1_2);

		JLabel lblNewLabel_6_3_2 = new JLabel("Cpf:");
		lblNewLabel_6_3_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_3_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2.setBounds(139, 125, 183, 47);
		caixa_Cadastrar.add(lblNewLabel_6_3_2);

		JLabel lblNewLabel_7_3_2 = new JLabel(
				"Este campo deve ser preenchido com o CPF de identifica\u00E7\u00E3o do caixa.");
		lblNewLabel_7_3_2.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2.setBounds(139, 170, 606, 24);
		caixa_Cadastrar.add(lblNewLabel_7_3_2);

		textField_cad_cpf = new JTextField();
		textField_cad_cpf.setColumns(10);
		textField_cad_cpf.setBounds(139, 204, 301, 19);
		caixa_Cadastrar.add(textField_cad_cpf);

		JLabel lblNewLabel_6_1_1_1 = new JLabel("Nome:");
		lblNewLabel_6_1_1_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_1_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_1_1_1.setBounds(139, 231, 183, 47);
		caixa_Cadastrar.add(lblNewLabel_6_1_1_1);

		JLabel lblNewLabel_7_1_1_1 = new JLabel("Este campo deve ser preenchido com o nome completo do caixa.");
		lblNewLabel_7_1_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_1_1_1.setBounds(139, 276, 606, 24);
		caixa_Cadastrar.add(lblNewLabel_7_1_1_1);

		textField_cad_nome = new JTextField();
		textField_cad_nome.setColumns(10);
		textField_cad_nome.setBounds(139, 310, 301, 19);
		caixa_Cadastrar.add(textField_cad_nome);

		JLabel lblNewLabel_6_2_2_1 = new JLabel("Sal\u00E1rio:");
		lblNewLabel_6_2_2_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_2_2_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_2_1.setBounds(139, 339, 183, 47);
		caixa_Cadastrar.add(lblNewLabel_6_2_2_1);

		JLabel lblNewLabel_7_2_2_1 = new JLabel("Este campo deve ser preenchido com o sal\u00E1rio do caixa.");
		lblNewLabel_7_2_2_1.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1.setBounds(139, 384, 606, 24);
		caixa_Cadastrar.add(lblNewLabel_7_2_2_1);

		textField_cad_salario = new JTextField();
		textField_cad_salario.setColumns(10);
		textField_cad_salario.setBounds(139, 418, 301, 19);
		caixa_Cadastrar.add(textField_cad_salario);

		JButton btnNewButton_1_2 = new JButton("Cadastrar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textField_cad_cpf.getText();
				String nome = textField_cad_nome.getText();
				double salario = Double.parseDouble(textField_cad_salario.getText());
				String carga_horaria = textField_cad_carga_horaria.getText();
				String cep = textField_cad_cep.getText();
				String cidade = textField_cad_cidade.getText();
				String rua = textField_cad_rua.getText();
				String estado = textField_cad_estado.getText();
				int num = Integer.parseInt(textField_cad_num.getText());

				Caixa c = new Caixa(cpf, nome, salario, carga_horaria, cep, cidade, rua, estado, num);
				CaixaDAO cdao = new CaixaDAO();

				ArrayList<Caixa> caixas = cdao.getLista();

				for (int i = 0; i < caixas.size(); i++) {
					if (caixas.get(i).getCpf().equals(cpf)) {
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Este caixa já foi cadastrado!", "Alert",
								JOptionPane.WARNING_MESSAGE);
					} else {
						cdao.inserir(c);
					}
				}

				caixas = cdao.getLista();

				DefaultTableModel model = (DefaultTableModel) tableCaixas.getModel();
				model.setRowCount(0);
				for (int i = 0; i < caixas.size(); i++) {
					model.addRow(
							new Object[] { caixas.get(i).getCpf(), caixas.get(i).getNome(), caixas.get(i).getSalario(),
									caixas.get(i).getCarga_horaria(), caixas.get(i).getCep(), caixas.get(i).getCidade(),
									caixas.get(i).getRua(), caixas.get(i).getEstado(), caixas.get(i).getNum() });
				}
				textField_cad_cpf.setText("");
				textField_cad_nome.setText("");
				textField_cad_salario.setText("");
				textField_cad_carga_horaria.setText("");
				textField_cad_cep.setText("");
				textField_cad_cidade.setText("");
				textField_cad_rua.setText("");
				textField_cad_estado.setText("");
				textField_cad_num.setText("");
			}
		});
		btnNewButton_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(139, 707, 112, 40);
		caixa_Cadastrar.add(btnNewButton_1_2);

		JLabel lblNewLabel_6_2_1_1_1 = new JLabel("Carga Hor\u00E1ria:");
		lblNewLabel_6_2_1_1_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_6_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1.setBounds(139, 447, 273, 47);
		caixa_Cadastrar.add(lblNewLabel_6_2_1_1_1);

		JLabel lblNewLabel_7_2_1_1_1 = new JLabel("Este campo deve ser preenchido com a carga hor\u00E1ria do caixa.");
		lblNewLabel_7_2_1_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_1_1_1.setBounds(139, 492, 606, 24);
		caixa_Cadastrar.add(lblNewLabel_7_2_1_1_1);

		textField_cad_carga_horaria = new JTextField();
		textField_cad_carga_horaria.setColumns(10);
		textField_cad_carga_horaria.setBounds(139, 526, 301, 19);
		caixa_Cadastrar.add(textField_cad_carga_horaria);

		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setForeground(new Color(204, 0, 0));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(139, 560, 89, 24);
		caixa_Cadastrar.add(lblNewLabel_4);

		textField_cad_cep = new JTextField();
		textField_cad_cep.setBounds(139, 594, 150, 19);
		caixa_Cadastrar.add(textField_cad_cep);
		textField_cad_cep.setColumns(10);

		JLabel lblNewLabel_4_2 = new JLabel("Cidade:");
		lblNewLabel_4_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(323, 560, 89, 24);
		caixa_Cadastrar.add(lblNewLabel_4_2);

		textField_cad_cidade = new JTextField();
		textField_cad_cidade.setColumns(10);
		textField_cad_cidade.setBounds(323, 594, 150, 19);
		caixa_Cadastrar.add(textField_cad_cidade);

		JLabel lblNewLabel_4_2_1 = new JLabel("Rua:");
		lblNewLabel_4_2_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2_1.setBounds(139, 623, 89, 24);
		caixa_Cadastrar.add(lblNewLabel_4_2_1);

		textField_cad_rua = new JTextField();
		textField_cad_rua.setColumns(10);
		textField_cad_rua.setBounds(139, 657, 334, 19);
		caixa_Cadastrar.add(textField_cad_rua);

		JLabel lblNewLabel_4_2_2 = new JLabel("Estado:");
		lblNewLabel_4_2_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2_2.setBounds(508, 560, 89, 24);
		caixa_Cadastrar.add(lblNewLabel_4_2_2);

		textField_cad_estado = new JTextField();
		textField_cad_estado.setColumns(10);
		textField_cad_estado.setBounds(508, 594, 71, 19);
		caixa_Cadastrar.add(textField_cad_estado);

		JLabel lblNewLabel_4_2_2_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_4_2_2_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_2_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4_2_2_1.setBounds(508, 623, 89, 24);
		caixa_Cadastrar.add(lblNewLabel_4_2_2_1);

		textField_cad_num = new JTextField();
		textField_cad_num.setColumns(10);
		textField_cad_num.setBounds(508, 657, 71, 19);
		caixa_Cadastrar.add(textField_cad_num);

		JScrollPane scrollCaixas = new JScrollPane();
		scrollCaixas.setBounds(801, 177, 623, 488);
		caixa_Cadastrar.add(scrollCaixas);

		tableCaixas = new JTable();
		scrollCaixas.setViewportView(tableCaixas);
		tableCaixas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome", "Sal\u00E1rio",
				"Carga Hor\u00E1ria", "CEP", "Cidade", "Rua", "Estado", "Nro" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Double.class, String.class, String.class,
					String.class, String.class, String.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JLabel lblNewLabel_6_1_1_2_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo verde.png")));
		lblNewLabel_6_1_1_2_1.setBounds(-11, 0, 1594, 283);
		caixa_Cadastrar.add(lblNewLabel_6_1_1_2_1);

		produtos_Cadastrar = new JPanel();
		produtos_Cadastrar.setForeground(new Color(51, 0, 0));
		produtos_Cadastrar.setLayout(null);
		produtos_Cadastrar.setBackground(new Color(51, 0, 0));
		produtos_Cadastrar.setBounds(0, 0, 1540, 783);
		layeredPane.add(produtos_Cadastrar);

		JLabel lblNewLabel_4_1_2_2 = new JLabel("Produtos");
		lblNewLabel_4_1_2_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_4_1_2_2.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_2_2.setBounds(600, 25, 273, 103);
		produtos_Cadastrar.add(lblNewLabel_4_1_2_2);

		JLabel lblNewLabel_5_1_2_2 = new JLabel("Cadastrar");
		lblNewLabel_5_1_2_2.setForeground(new Color(102, 0, 0));
		lblNewLabel_5_1_2_2.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_2_2.setBounds(665, 103, 167, 69);
		produtos_Cadastrar.add(lblNewLabel_5_1_2_2);

		JLabel lblNewLabel_6_3_2_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_6_3_2_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_6_3_2_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_2.setBounds(88, 182, 183, 47);
		produtos_Cadastrar.add(lblNewLabel_6_3_2_2);

		JLabel lblNewLabel_7_3_2_2 = new JLabel(
				"Este campo deve ser preenchido com o c\u00F3digo de identifica\u00E7\u00E3o do produto.");
		lblNewLabel_7_3_2_2.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_2.setBounds(88, 227, 606, 24);
		produtos_Cadastrar.add(lblNewLabel_7_3_2_2);

		textField_cad_cod = new JTextField();
		textField_cad_cod.setColumns(10);
		textField_cad_cod.setBounds(88, 261, 301, 19);
		produtos_Cadastrar.add(textField_cad_cod);

		JLabel lblNewLabel_6_1_1_1_3 = new JLabel("Tipo:");
		lblNewLabel_6_1_1_1_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_6_1_1_1_3.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_1_1_1_3.setBounds(88, 288, 183, 47);
		produtos_Cadastrar.add(lblNewLabel_6_1_1_1_3);

		JLabel lblNewLabel_7_1_1_1_3 = new JLabel(
				"Este campo deve ser preenchido com o tipo do produto (pote, picol\u00E9, etc).");
		lblNewLabel_7_1_1_1_3.setForeground(SystemColor.menu);
		lblNewLabel_7_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_1_1_1_3.setBounds(88, 333, 606, 24);
		produtos_Cadastrar.add(lblNewLabel_7_1_1_1_3);

		textField_cad_tipo = new JTextField();
		textField_cad_tipo.setColumns(10);
		textField_cad_tipo.setBounds(88, 367, 301, 19);
		produtos_Cadastrar.add(textField_cad_tipo);

		JLabel lblNewLabel_6_2_2_1_3 = new JLabel("Peso:");
		lblNewLabel_6_2_2_1_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_6_2_2_1_3.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_2_1_3.setBounds(88, 396, 183, 47);
		produtos_Cadastrar.add(lblNewLabel_6_2_2_1_3);

		JLabel lblNewLabel_7_2_2_1_3 = new JLabel(
				"Este campo deve ser preenchido com o peso do produto em quilogramas.");
		lblNewLabel_7_2_2_1_3.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_3.setBounds(88, 441, 606, 24);
		produtos_Cadastrar.add(lblNewLabel_7_2_2_1_3);

		textField_cad_peso = new JTextField();
		textField_cad_peso.setColumns(10);
		textField_cad_peso.setBounds(88, 475, 301, 19);
		produtos_Cadastrar.add(textField_cad_peso);

		JButton btnNewButton_1_2_2 = new JButton("Cadastrar");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod = textField_cad_cod.getText();
				String tipo = textField_cad_tipo.getText();
				double peso = Double.parseDouble(textField_cad_peso.getText());
				double preco = Double.parseDouble(textField_cad_preco.getText());

				Produto p = new Produto(cod, tipo, peso, preco);
				ProdutoDAO pdao = new ProdutoDAO();

				ArrayList<Produto> produtos = pdao.getLista();
				DefaultTableModel model = (DefaultTableModel) table_Produtos.getModel();
				model.setRowCount(0);

				for (int i = 0; i < produtos.size(); i++) {
					if (produtos.get(i).getCod().equals(cod)) {
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Este produto já foi cadastrado!", "Alert",
								JOptionPane.WARNING_MESSAGE);
					} else {
						pdao.inserir(p);
					}
				}

				produtos = pdao.getLista();
				for (int i = 0; i < produtos.size(); i++) {
					model.addRow(new Object[] { produtos.get(i).getCod(), produtos.get(i).getTipo(),
							produtos.get(i).getPeso(), produtos.get(i).getPreco() });
				}

				textField_cad_cod.setText("");
				textField_cad_tipo.setText("");
				textField_cad_peso.setText("");
				textField_cad_preco.setText("");
			}
		});

		btnNewButton_1_2_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_2_2.setBounds(187, 657, 112, 40);
		produtos_Cadastrar.add(btnNewButton_1_2_2);

		JLabel lblNewLabel_6_2_1_1_1_3 = new JLabel("Pre\u00E7o:");
		lblNewLabel_6_2_1_1_1_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_6_2_1_1_1_3.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1_3.setBounds(88, 504, 273, 47);
		produtos_Cadastrar.add(lblNewLabel_6_2_1_1_1_3);

		JLabel lblNewLabel_7_2_1_1_1_3 = new JLabel("Este campo deve ser preenchido com o pre\u00E7o do produto.");
		lblNewLabel_7_2_1_1_1_3.setForeground(SystemColor.menu);
		lblNewLabel_7_2_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_1_1_1_3.setBounds(88, 549, 606, 24);
		produtos_Cadastrar.add(lblNewLabel_7_2_1_1_1_3);

		textField_cad_preco = new JTextField();
		textField_cad_preco.setColumns(10);
		textField_cad_preco.setBounds(88, 583, 301, 19);
		produtos_Cadastrar.add(textField_cad_preco);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(851, 163, 614, 493);
		produtos_Cadastrar.add(scrollPane);

		table_Produtos = new JTable();
		scrollPane.setViewportView(table_Produtos);
		JTableHeader tableheader = table_Produtos.getTableHeader();
		table_Produtos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_Produtos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Tipo", "Peso", "Pre\u00E7o" }) {
					Class[] columnTypes = new Class[] { Integer.class, String.class, Double.class, Double.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});

		JLabel lblNewLabel_7_2_2_1_1_1_1_1 = new JLabel("$RS");
		lblNewLabel_7_2_2_1_1_1_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_7_2_2_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_1_1_1_1.setBounds(38, 578, 75, 24);
		produtos_Cadastrar.add(lblNewLabel_7_2_2_1_1_1_1_1);

		JLabel lblNewLabel_7_2_2_1_1_1_1_1_1 = new JLabel("Kg");
		lblNewLabel_7_2_2_1_1_1_1_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_7_2_2_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_1_1_1_1_1.setBounds(393, 470, 75, 24);
		produtos_Cadastrar.add(lblNewLabel_7_2_2_1_1_1_1_1_1);

		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo rosa.png")));
		lblNewLabel_6_1.setBounds(-21, 0, 1583, 283);
		produtos_Cadastrar.add(lblNewLabel_6_1);

		compra_Delete = new JPanel();
		compra_Delete.setLayout(null);
		compra_Delete.setBackground(new Color(102, 102, 153));
		compra_Delete.setBounds(0, 0, 1540, 783);
		layeredPane.add(compra_Delete);

		JLabel lblNewLabel_4_1_2_3_1_1 = new JLabel("Compra");
		lblNewLabel_4_1_2_3_1_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_4_1_2_3_1_1.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_2_3_1_1.setBounds(637, 10, 262, 103);
		compra_Delete.add(lblNewLabel_4_1_2_3_1_1);

		JLabel lblNewLabel_5_1_2_3_1_1 = new JLabel("Deletar");
		lblNewLabel_5_1_2_3_1_1.setForeground(new Color(0, 153, 204));
		lblNewLabel_5_1_2_3_1_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_2_3_1_1.setBounds(693, 81, 167, 69);
		compra_Delete.add(lblNewLabel_5_1_2_3_1_1);

		JLabel lblNewLabel_6_3_2_3_1_3 = new JLabel("Nota Fiscal:");
		lblNewLabel_6_3_2_3_1_3.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_3_2_3_1_3.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_3_1_3.setBounds(641, 269, 183, 47);
		compra_Delete.add(lblNewLabel_6_3_2_3_1_3);

		JLabel lblNewLabel_7_3_2_3_1_3 = new JLabel("Escolha a nota fiscal da compra para ser exclu\u00EDda.");
		lblNewLabel_7_3_2_3_1_3.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_3_1_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_3_1_3.setBounds(539, 315, 409, 24);
		compra_Delete.add(lblNewLabel_7_3_2_3_1_3);

		JButton btnNewButton_1_2_3_1_1 = new JButton("Deletar");
		btnNewButton_1_2_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_nota = comboBox_del_compra_nota.getSelectedIndex();
				String notaf = listanotaFiscal[itemSelecionado_nota];
				int itemSelecionado_prod = comboBox_del_compra_prod.getSelectedIndex();
				String prod = listaproduto[itemSelecionado_prod];
				int itemSelecionado_caixa = comboBox_del_compra_caixa.getSelectedIndex();
				String caixa = listacaixa[itemSelecionado_caixa];

				Compra co = new Compra();
				co.setNota_fiscal(notaf);
				co.setCod_produto(prod);
				co.setCpf_caixa(caixa);
				CompraDAO codao = new CompraDAO();
				int i = JOptionPane.showConfirmDialog(null,
						"A compra será deletada permanentemente. Deseja continuar?");
				if (i == 0) {
					codao.remover(co);
					JOptionPane.showMessageDialog(null, "Compra Excluida com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Compra NÃO foi excluida!");
				}
			}
		});
		btnNewButton_1_2_3_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_2_3_1_1.setBounds(680, 644, 112, 40);
		compra_Delete.add(btnNewButton_1_2_3_1_1);

		comboBox_del_compra_nota = new JComboBox(listanotaFiscal);
		comboBox_del_compra_nota.setBounds(581, 349, 301, 21);
		compra_Delete.add(comboBox_del_compra_nota);

		JLabel lblNewLabel_6_1_1_2_1_1_1_1_1_2 = new JLabel("");
		lblNewLabel_6_1_1_2_1_1_1_1_1_2
				.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo azul.png")));
		lblNewLabel_6_1_1_2_1_1_1_1_1_2.setBounds(0, 0, 1594, 283);
		compra_Delete.add(lblNewLabel_6_1_1_2_1_1_1_1_1_2);

		JLabel lblNewLabel_6_3_2_3_1_1_1 = new JLabel("COD Produto");
		lblNewLabel_6_3_2_3_1_1_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_3_2_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_3_1_1_1.setBounds(628, 380, 222, 47);
		compra_Delete.add(lblNewLabel_6_3_2_3_1_1_1);

		JLabel lblNewLabel_7_3_2_3_1_1_1 = new JLabel("Escolha o produto da compra para ser exclu\u00EDda.");
		lblNewLabel_7_3_2_3_1_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_3_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_3_1_1_1.setBounds(539, 426, 409, 24);
		compra_Delete.add(lblNewLabel_7_3_2_3_1_1_1);

		comboBox_del_compra_prod = new JComboBox(listaproduto);
		comboBox_del_compra_prod.setBounds(581, 460, 301, 21);
		compra_Delete.add(comboBox_del_compra_prod);

		JLabel lblNewLabel_6_3_2_3_1_2_1 = new JLabel("CPF Caixa");
		lblNewLabel_6_3_2_3_1_2_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_3_2_3_1_2_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_3_1_2_1.setBounds(641, 505, 183, 47);
		compra_Delete.add(lblNewLabel_6_3_2_3_1_2_1);

		JLabel lblNewLabel_7_3_2_3_1_2_1 = new JLabel("Escolha o caixa da compra para ser exclu\u00EDda.");
		lblNewLabel_7_3_2_3_1_2_1.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_3_1_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_3_1_2_1.setBounds(539, 551, 409, 24);
		compra_Delete.add(lblNewLabel_7_3_2_3_1_2_1);

		comboBox_del_compra_caixa = new JComboBox(listacaixa);
		comboBox_del_compra_caixa.setBounds(581, 585, 301, 21);
		compra_Delete.add(comboBox_del_compra_caixa);

		relatorio_Caixa = new JPanel();
		relatorio_Caixa.setLayout(null);
		relatorio_Caixa.setBackground(SystemColor.controlDkShadow);
		relatorio_Caixa.setBounds(0, 0, 1540, 826);
		layeredPane.add(relatorio_Caixa);

		JLabel lblNewLabel_3_1_1 = new JLabel("Relat\u00F3rios");
		lblNewLabel_3_1_1.setForeground(new Color(102, 204, 255));
		lblNewLabel_3_1_1.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 75));
		lblNewLabel_3_1_1.setBackground(new Color(102, 204, 255));
		lblNewLabel_3_1_1.setBounds(695, 34, 194, 99);
		relatorio_Caixa.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_5_2 = new JLabel("Caixa com o maior sal\u00E1rio:");
		lblNewLabel_5_2.setForeground(SystemColor.menu);
		lblNewLabel_5_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5_2.setBounds(299, 262, 462, 27);
		relatorio_Caixa.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_1_3 = new JLabel("Quantidade de compras do caixa:");
		lblNewLabel_5_1_3.setForeground(SystemColor.menu);
		lblNewLabel_5_1_3.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5_1_3.setBounds(503, 487, 580, 27);
		relatorio_Caixa.add(lblNewLabel_5_1_3);

		comboBox_rel_caixa = new JComboBox(listacaixa);
		comboBox_rel_caixa.setBounds(942, 487, 219, 28);
		relatorio_Caixa.add(comboBox_rel_caixa);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(613, 542, 432, 77);
		relatorio_Caixa.add(scrollPane_8);

		table_quant_caixa = new JTable();
		scrollPane_8.setViewportView(table_quant_caixa);
		table_quant_caixa
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Quantidade de compras do caixa" }) {
					Class[] columnTypes = new Class[] { Integer.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});

		JButton btnNewButton_1_3 = new JButton("MOSTRAR");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_cpf = comboBox_rel_caixa.getSelectedIndex();
				String item = listacaixa[itemSelecionado_cpf];
				Caixa c = new Caixa();
				c.setCpf(item);
				CaixaDAO cdao = new CaixaDAO();
				int quant = cdao.quantCompras(c);
				DefaultTableModel model = (DefaultTableModel) table_quant_caixa.getModel();
				model.setRowCount(0);
				model.addRow(new Object[] { quant });
			}
		});
		btnNewButton_1_3.setBounds(770, 641, 111, 47);
		relatorio_Caixa.add(btnNewButton_1_3);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(253, 358, 432, 77);
		relatorio_Caixa.add(scrollPane_7);

		table_maior_caixa = new JTable();
		scrollPane_7.setViewportView(table_maior_caixa);
		table_maior_caixa.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Sal\u00E1rio" }) {
			Class[] columnTypes = new Class[] { String.class, Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("Caixa");
		lblNewLabel_4_1_1_2_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_1_1_2_1.setFont(new Font("Bakery", Font.PLAIN, 63));
		lblNewLabel_4_1_1_2_1.setBounds(735, 114, 225, 103);
		relatorio_Caixa.add(lblNewLabel_4_1_1_2_1);

		JLabel lblNewLabel_5_2_1 = new JLabel("Caixa com o menor sal\u00E1rio:");
		lblNewLabel_5_2_1.setForeground(SystemColor.menu);
		lblNewLabel_5_2_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5_2_1.setBounds(915, 262, 462, 27);
		relatorio_Caixa.add(lblNewLabel_5_2_1);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(869, 358, 432, 77);
		relatorio_Caixa.add(scrollPane_9);

		table_menor_caixa = new JTable();
		scrollPane_9.setViewportView(table_menor_caixa);
		table_menor_caixa.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Sal\u00E1rio" }) {
			Class[] columnTypes = new Class[] { String.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		relatorio_Compra = new JPanel();
		relatorio_Compra.setLayout(null);
		relatorio_Compra.setBackground(SystemColor.controlDkShadow);
		relatorio_Compra.setBounds(0, 0, 1540, 826);
		layeredPane.add(relatorio_Compra);

		JLabel lblNewLabel_3_1_2 = new JLabel("Relat\u00F3rios");
		lblNewLabel_3_1_2.setForeground(new Color(102, 204, 255));
		lblNewLabel_3_1_2.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 75));
		lblNewLabel_3_1_2.setBackground(new Color(102, 204, 255));
		lblNewLabel_3_1_2.setBounds(695, 34, 194, 99);
		relatorio_Compra.add(lblNewLabel_3_1_2);

		JLabel lblNewLabel_4_1_1_3_1 = new JLabel("Compra");
		lblNewLabel_4_1_1_3_1.setForeground(new Color(102, 153, 153));
		lblNewLabel_4_1_1_3_1.setFont(new Font("Bakery", Font.PLAIN, 63));
		lblNewLabel_4_1_1_3_1.setBounds(705, 142, 184, 99);
		relatorio_Compra.add(lblNewLabel_4_1_1_3_1);

		JLabel lblNewLabel_5_3 = new JLabel("Valor total j\u00E1 arrecadado em compras:");
		lblNewLabel_5_3.setForeground(SystemColor.menu);
		lblNewLabel_5_3.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5_3.setBounds(239, 331, 522, 27);
		relatorio_Compra.add(lblNewLabel_5_3);

		JLabel lblNewLabel_5_1_4 = new JLabel("Compras realizadas na data:");
		lblNewLabel_5_1_4.setForeground(SystemColor.menu);
		lblNewLabel_5_1_4.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5_1_4.setBounds(853, 330, 522, 27);
		relatorio_Compra.add(lblNewLabel_5_1_4);

		comboBox_rel_data_compra = new JComboBox(listadata);
		comboBox_rel_data_compra.setBounds(1234, 330, 219, 28);
		relatorio_Compra.add(comboBox_rel_data_compra);

		JButton btnNewButton_1_4 = new JButton("MOSTRAR");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_data = comboBox_rel_data_compra.getSelectedIndex();
				String data = listadata[itemSelecionado_data];
				Compra co = new Compra();
				co.setData(data);
				CompraDAO codao = new CompraDAO();
				ArrayList<Compra> compras = codao.getListaData(data);
				System.out.println(compras);
				DefaultTableModel model = (DefaultTableModel) table_rel_compras_data.getModel();
				model.setRowCount(0);
				for (int i = 0; i < compras.size(); i++) {
					model.addRow(new Object[] { compras.get(i).getNota_fiscal(), compras.get(i).getCod_produto(),
							compras.get(i).getCpf_caixa(), compras.get(i).getData(), compras.get(i).getHora(),
							compras.get(i).getNome_cliente() });
				}

			}
		});
		btnNewButton_1_4.setBounds(1095, 666, 111, 47);
		relatorio_Compra.add(btnNewButton_1_4);

		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(254, 427, 432, 77);
		relatorio_Compra.add(scrollPane_10);

		table_rel_total = new JTable();
		scrollPane_10.setViewportView(table_rel_total);
		table_rel_total.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Valor total" }) {
			Class[] columnTypes = new Class[] { Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(853, 423, 600, 208);
		relatorio_Compra.add(scrollPane_11);

		table_rel_compras_data = new JTable();
		scrollPane_11.setViewportView(table_rel_compras_data);
		table_rel_compras_data.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nota Fiscal", "COD Produto", "CPF do Caixa", "Data", "Hora", "Nome do Cliente" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		produtos_Update = new JPanel();
		produtos_Update.setLayout(null);
		produtos_Update.setBackground(new Color(51, 0, 0));
		produtos_Update.setBounds(0, 0, 1540, 795);
		layeredPane.add(produtos_Update);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Produtos");
		lblNewLabel_4_1_1_1.setForeground(new Color(255, 0, 51));
		lblNewLabel_4_1_1_1.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_1_1.setBounds(629, 21, 270, 103);
		produtos_Update.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_5_1_1_1 = new JLabel("Editar");
		lblNewLabel_5_1_1_1.setForeground(new Color(102, 0, 0));
		lblNewLabel_5_1_1_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_1_1.setBounds(700, 121, 143, 69);
		produtos_Update.add(lblNewLabel_5_1_1_1);

		JLabel lblNewLabel_6_3_1_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_6_3_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_6_3_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_1_1.setBounds(713, 235, 183, 47);
		produtos_Update.add(lblNewLabel_6_3_1_1);

		JLabel lblNewLabel_7_3_1_1 = new JLabel("Escolha o c\u00F3digo do produto para ser editado.");
		lblNewLabel_7_3_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_3_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_1_1.setBounds(580, 276, 606, 24);
		produtos_Update.add(lblNewLabel_7_3_1_1);

		JLabel lblNewLabel_6_1_1_1_1 = new JLabel("Peso:");
		lblNewLabel_6_1_1_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_6_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_1_1_1_1.setBounds(723, 351, 183, 47);
		produtos_Update.add(lblNewLabel_6_1_1_1_1);

		JLabel lblNewLabel_7_1_1_1_1 = new JLabel(
				"Este campo deve ser preenchido com o peso do produto, em quilogramas.");
		lblNewLabel_7_1_1_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_1_1_1_1.setBounds(481, 396, 606, 24);
		produtos_Update.add(lblNewLabel_7_1_1_1_1);

		textField_ed_peso = new JTextField();
		textField_ed_peso.setColumns(10);
		textField_ed_peso.setBounds(627, 428, 301, 19);
		produtos_Update.add(textField_ed_peso);

		JLabel lblNewLabel_6_2_2_1_1 = new JLabel("Tipo:");
		lblNewLabel_6_2_2_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_6_2_2_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_2_1_1.setBounds(723, 457, 183, 47);
		produtos_Update.add(lblNewLabel_6_2_2_1_1);

		JLabel lblNewLabel_7_2_2_1_1 = new JLabel(
				"Este campo deve ser preenchido com o tipo do produto (pote, picol\u00E9, etc).");
		lblNewLabel_7_2_2_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_1.setBounds(493, 502, 606, 24);
		produtos_Update.add(lblNewLabel_7_2_2_1_1);

		textField_ed_tipo = new JTextField();
		textField_ed_tipo.setColumns(10);
		textField_ed_tipo.setBounds(627, 536, 301, 19);
		produtos_Update.add(textField_ed_tipo);

		JButton btnNewButton_1_1_1 = new JButton("Editar");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_cod = comboBox_ed_prod.getSelectedIndex();
				String item = listaproduto[itemSelecionado_cod];
				System.out.println("item=" + item);
				String tipo = textField_ed_tipo.getText();
				double peso = Double.parseDouble(textField_ed_peso.getText());
				double preco = Double.parseDouble(textField_ed_preco.getText());

				Produto p = new Produto(item, tipo, peso, preco);
				ProdutoDAO pdao = new ProdutoDAO();
				pdao.alterar(p);

				int i = JOptionPane.showConfirmDialog(null,
						"As informações serão editadas permanentemente. Deseja continuar?");
				if (i == 0) {
					pdao.alterar(p);
					JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Produto NÃO foi editado!");
				}

				textField_ed_tipo.setText("");
				textField_ed_peso.setText("");
				textField_ed_preco.setText("");
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(715, 687, 112, 40);
		produtos_Update.add(btnNewButton_1_1_1);

		JLabel lblNewLabel_6_2_1_1_1_1 = new JLabel("Pre\u00E7o:");
		lblNewLabel_6_2_1_1_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_6_2_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1_1.setBounds(723, 563, 183, 47);
		produtos_Update.add(lblNewLabel_6_2_1_1_1_1);

		JLabel lblNewLabel_7_2_1_1_1_1 = new JLabel("Este campo deve ser preenchido com o pre\u00E7o do produto.");
		lblNewLabel_7_2_1_1_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_1_1_1_1.setBounds(545, 610, 606, 24);
		produtos_Update.add(lblNewLabel_7_2_1_1_1_1);

		textField_ed_preco = new JTextField();
		textField_ed_preco.setColumns(10);
		textField_ed_preco.setBounds(627, 644, 301, 19);
		produtos_Update.add(textField_ed_preco);

		JList list_1 = new JList();
		list_1.setBounds(803, 709, 623, -484);
		produtos_Update.add(list_1);

		comboBox_ed_prod = new JComboBox(listaproduto);
		comboBox_ed_prod.setBounds(627, 310, 301, 21);
		produtos_Update.add(comboBox_ed_prod);

		JLabel lblNewLabel_7_2_2_1_1_1 = new JLabel("Kg");
		lblNewLabel_7_2_2_1_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_7_2_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_1_1.setBounds(935, 423, 75, 24);
		produtos_Update.add(lblNewLabel_7_2_2_1_1_1);

		JLabel lblNewLabel_7_2_2_1_1_1_1 = new JLabel("$RS");
		lblNewLabel_7_2_2_1_1_1_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_7_2_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_1_1_1.setBounds(580, 639, 75, 24);
		produtos_Update.add(lblNewLabel_7_2_2_1_1_1_1);

		JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo rosa.png")));
		lblNewLabel_6_1_1.setBounds(0, 0, 1583, 283);
		produtos_Update.add(lblNewLabel_6_1_1);

		compra_Update = new JPanel();
		compra_Update.setLayout(null);
		compra_Update.setBackground(new Color(102, 102, 153));
		compra_Update.setBounds(0, 0, 1540, 783);
		layeredPane.add(compra_Update);

		JLabel lblNewLabel_4_1_2_3_1 = new JLabel("Compra");
		lblNewLabel_4_1_2_3_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_4_1_2_3_1.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_2_3_1.setBounds(637, 10, 262, 103);
		compra_Update.add(lblNewLabel_4_1_2_3_1);

		JLabel lblNewLabel_5_1_2_3_1 = new JLabel("Atualizar");
		lblNewLabel_5_1_2_3_1.setForeground(new Color(0, 153, 204));
		lblNewLabel_5_1_2_3_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_2_3_1.setBounds(693, 81, 167, 69);
		compra_Update.add(lblNewLabel_5_1_2_3_1);

		JLabel lblNewLabel_6_3_2_3_1 = new JLabel("Nota Fiscal:");
		lblNewLabel_6_3_2_3_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_3_2_3_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_3_1.setBounds(251, 293, 183, 47);
		compra_Update.add(lblNewLabel_6_3_2_3_1);

		JLabel lblNewLabel_7_3_2_3_1 = new JLabel("Escolha a nota fiscal da compra para ser editada.");
		lblNewLabel_7_3_2_3_1.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_3_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_3_1.setBounds(149, 339, 409, 24);
		compra_Update.add(lblNewLabel_7_3_2_3_1);

		JButton btnNewButton_1_2_3_1 = new JButton("Editar");
		btnNewButton_1_2_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_nota = comboBox_ed_compra_nota.getSelectedIndex();
				String item_nota = listanotaFiscal[itemSelecionado_nota];

				int itemSelecionado_cod = comboBox_ed_com_prod.getSelectedIndex();
				String item_cod = listaproduto[itemSelecionado_cod];
				Produto p = new Produto();
				p.setCod(item_cod);

				int itemSelecionado_cpf = comboBox_ed_com_caixa.getSelectedIndex();
				String item_cpf = listacaixa[itemSelecionado_cpf];
				Caixa c = new Caixa();
				c.setCpf(item_cpf);

				String data = textField_com_ed_data.getText();
				String hora = textField_com_ed_hora.getText();
				String nome_cliente = textField_com_ed_ncliente.getText();

				Compra co = new Compra(item_nota, item_cod, item_cpf, data, hora, nome_cliente);
				CompraDAO codao = new CompraDAO();

				int i = JOptionPane.showConfirmDialog(null,
						"As informações serão editadas permanentemente. Deseja continuar?");
				if (i == 0) {
					codao.alterar(co);
					JOptionPane.showMessageDialog(null, "Compra editada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Compra NÃO foi editada!");
				}

				textField_com_ed_data.setText("");
				textField_com_ed_hora.setText("");
				textField_com_ed_ncliente.setText("");
			}
		});
		btnNewButton_1_2_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_2_3_1.setBounds(733, 675, 112, 40);
		compra_Update.add(btnNewButton_1_2_3_1);

		JLabel lblNewLabel_6_2_1_1_1_4_2 = new JLabel("Data:");
		lblNewLabel_6_2_1_1_1_4_2.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_2_1_1_1_4_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1_4_2.setBounds(617, 484, 150, 47);
		compra_Update.add(lblNewLabel_6_2_1_1_1_4_2);

		textField_com_ed_data = new JTextField();
		textField_com_ed_data.setColumns(10);
		textField_com_ed_data.setBounds(617, 534, 150, 19);
		compra_Update.add(textField_com_ed_data);

		JLabel lblNewLabel_6_2_1_1_1_4_1_1 = new JLabel("Hora:");
		lblNewLabel_6_2_1_1_1_4_1_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_2_1_1_1_4_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_1_1_1_4_1_1.setBounds(801, 484, 150, 47);
		compra_Update.add(lblNewLabel_6_2_1_1_1_4_1_1);

		textField_com_ed_hora = new JTextField();
		textField_com_ed_hora.setColumns(10);
		textField_com_ed_hora.setBounds(801, 534, 150, 19);
		compra_Update.add(textField_com_ed_hora);

		JLabel lblNewLabel_6_2_2_1_4_1_1 = new JLabel("Nome do Cliente:");
		lblNewLabel_6_2_2_1_4_1_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_2_2_1_4_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_2_2_1_4_1_1.setBounds(644, 563, 281, 47);
		compra_Update.add(lblNewLabel_6_2_2_1_4_1_1);

		JLabel lblNewLabel_7_2_2_1_4_1_1 = new JLabel("Este campo deve ser preenchido com o nome do cliente.");
		lblNewLabel_7_2_2_1_4_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_2_2_1_4_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_2_2_1_4_1_1.setBounds(560, 610, 606, 24);
		compra_Update.add(lblNewLabel_7_2_2_1_4_1_1);

		textField_com_ed_ncliente = new JTextField();
		textField_com_ed_ncliente.setColumns(10);
		textField_com_ed_ncliente.setBounds(633, 644, 301, 19);
		compra_Update.add(textField_com_ed_ncliente);

		comboBox_ed_compra_nota = new JComboBox(listanotaFiscal);
		comboBox_ed_compra_nota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox_ed_compra_nota.setBounds(191, 373, 301, 21);
		compra_Update.add(comboBox_ed_compra_nota);

		JLabel lblNewLabel_6_1_1_2_1_1_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1_1_1_1_1
				.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo azul.png")));
		lblNewLabel_6_1_1_2_1_1_1_1_1.setBounds(0, 0, 1594, 283);
		compra_Update.add(lblNewLabel_6_1_1_2_1_1_1_1_1);

		JLabel lblNewLabel_6_3_2_3_1_1 = new JLabel("COD Produto");
		lblNewLabel_6_3_2_3_1_1.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_3_2_3_1_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_3_1_1.setBounds(677, 293, 222, 47);
		compra_Update.add(lblNewLabel_6_3_2_3_1_1);

		JLabel lblNewLabel_7_3_2_3_1_1 = new JLabel("Escolha o produto da compra para ser editada.");
		lblNewLabel_7_3_2_3_1_1.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_3_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_3_1_1.setBounds(588, 339, 409, 24);
		compra_Update.add(lblNewLabel_7_3_2_3_1_1);

		comboBox_ed_com_prod = new JComboBox(listaproduto);
		comboBox_ed_com_prod.setBounds(630, 373, 301, 21);
		compra_Update.add(comboBox_ed_com_prod);

		JLabel lblNewLabel_6_3_2_3_1_2 = new JLabel("CPF Caixa");
		lblNewLabel_6_3_2_3_1_2.setForeground(new Color(0, 204, 102));
		lblNewLabel_6_3_2_3_1_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_2_3_1_2.setBounds(1107, 293, 183, 47);
		compra_Update.add(lblNewLabel_6_3_2_3_1_2);

		JLabel lblNewLabel_7_3_2_3_1_2 = new JLabel("Escolha o caixa da compra para ser editada.");
		lblNewLabel_7_3_2_3_1_2.setForeground(SystemColor.menu);
		lblNewLabel_7_3_2_3_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7_3_2_3_1_2.setBounds(1005, 339, 409, 24);
		compra_Update.add(lblNewLabel_7_3_2_3_1_2);

		comboBox_ed_com_caixa = new JComboBox(listacaixa);
		comboBox_ed_com_caixa.setBounds(1047, 373, 301, 21);
		compra_Update.add(comboBox_ed_com_caixa);
		caixa_Delete = new JPanel();
		caixa_Delete.setLayout(null);
		caixa_Delete.setBackground(new Color(0, 51, 0));
		caixa_Delete.setBounds(0, 0, 1540, 795);
		layeredPane.add(caixa_Delete);

		JLabel lblNewLabel_4_1_1_2 = new JLabel("Caixa");
		lblNewLabel_4_1_1_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_4_1_1_2.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_1_2.setBounds(660, 59, 225, 103);
		caixa_Delete.add(lblNewLabel_4_1_1_2);

		JLabel lblNewLabel_5_1_1_2 = new JLabel("Deletar");
		lblNewLabel_5_1_1_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_5_1_1_2.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_1_2.setBounds(685, 130, 143, 69);
		caixa_Delete.add(lblNewLabel_5_1_1_2);

		JLabel lblNewLabel_6_3_1_2 = new JLabel("Caixa:");
		lblNewLabel_6_3_1_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_6_3_1_2.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_1_2.setBounds(739, 327, 183, 47);
		caixa_Delete.add(lblNewLabel_6_3_1_2);

		JLabel lblNewLabel_7_3_1_2 = new JLabel("Selecione o caixa a ser deletado:");
		lblNewLabel_7_3_1_2.setForeground(SystemColor.menu);
		lblNewLabel_7_3_1_2.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_7_3_1_2.setBounds(630, 384, 606, 35);
		caixa_Delete.add(lblNewLabel_7_3_1_2);

		JButton btnNewButton_1_1_2 = new JButton("Deletar");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_cod = comboBox_del_caixa.getSelectedIndex();
				String item = listacaixa[itemSelecionado_cod];
				Caixa c = new Caixa();
				c.setCpf(item);
				CaixaDAO cdao = new CaixaDAO();
				CompraDAO codao = new CompraDAO();
				System.out.println("item s" + itemSelecionado_cod);
				System.out.println("item" + item);
				int i = JOptionPane.showConfirmDialog(null,
						"Essa ação deletará todas as compras com este caixa. Deseja continuar?");
				if (i == 0) {
					codao.removerCompraCaixa(c);
					cdao.remover(c);
					JOptionPane.showMessageDialog(null, "Caixa Excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Caixa NÃO foi excluido!");
				}
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_1_2.setBounds(732, 531, 112, 40);
		caixa_Delete.add(btnNewButton_1_1_2);

		JList list_2 = new JList();
		list_2.setBounds(803, 709, 623, -484);
		caixa_Delete.add(list_2);

		comboBox_del_caixa = new JComboBox(listacaixa);
		comboBox_del_caixa.setBounds(457, 462, 665, 21);
		caixa_Delete.add(comboBox_del_caixa);

		JLabel lblNewLabel_6_1_1_2_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1_1_1
				.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo verde.png")));
		lblNewLabel_6_1_1_2_1_1_1.setBounds(-12, 0, 1594, 283);
		caixa_Delete.add(lblNewLabel_6_1_1_2_1_1_1);

		relatorio_Prod = new JPanel();
		relatorio_Prod.setLayout(null);
		relatorio_Prod.setBackground(UIManager.getColor("TabbedPane.darkShadow"));
		relatorio_Prod.setBounds(0, 0, 1540, 826);
		layeredPane.add(relatorio_Prod);

		JLabel lblNewLabel_3_1 = new JLabel("Relat\u00F3rios");
		lblNewLabel_3_1.setBackground(new Color(102, 204, 255));
		lblNewLabel_3_1.setForeground(new Color(102, 204, 255));
		lblNewLabel_3_1.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 75));
		lblNewLabel_3_1.setBounds(695, 34, 194, 99);
		relatorio_Prod.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1_1_3 = new JLabel("Produtos");
		lblNewLabel_4_1_1_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_4_1_1_3.setFont(new Font("Bakery", Font.PLAIN, 63));
		lblNewLabel_4_1_1_3.setBounds(705, 142, 184, 99);
		relatorio_Prod.add(lblNewLabel_4_1_1_3);

		JLabel lblNewLabel_5 = new JLabel("Quantidade de produtos registrados no sistema:");
		lblNewLabel_5.setForeground(SystemColor.menu);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5.setBounds(181, 331, 580, 27);
		relatorio_Prod.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Quantidade de compras do produto:");
		lblNewLabel_5_1.setForeground(SystemColor.menu);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_5_1.setBounds(795, 330, 580, 27);
		relatorio_Prod.add(lblNewLabel_5_1);

		comboBox_rel_prod = new JComboBox(listaproduto);
		comboBox_rel_prod.setBounds(1234, 330, 219, 28);
		relatorio_Prod.add(comboBox_rel_prod);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(915, 427, 432, 77);
		relatorio_Prod.add(scrollPane_6);

		table_rel_prod = new JTable();
		scrollPane_6.setViewportView(table_rel_prod);
		table_rel_prod.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Quantidade de compras do produto" }));

		JButton btnNewButton_1 = new JButton("MOSTRAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_cod = comboBox_rel_prod.getSelectedIndex();
				String item = listaproduto[itemSelecionado_cod];
				Produto p = new Produto();
				p.setCod(item);
				ProdutoDAO pdao = new ProdutoDAO();
				int quantvezes = pdao.quantVezes(p);
				DefaultTableModel model = (DefaultTableModel) table_rel_prod.getModel();
				model.setRowCount(0);
				model.addRow(new Object[] { quantvezes });

			}
		});
		btnNewButton_1.setBounds(1073, 557, 111, 47);
		relatorio_Prod.add(btnNewButton_1);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(253, 427, 432, 77);
		relatorio_Prod.add(scrollPane_5);

		table_quant_prod = new JTable();
		scrollPane_5.setViewportView(table_quant_prod);
		table_quant_prod.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Quantidade de produtos" }));
		table_quant_prod.getColumnModel().getColumn(0).setMinWidth(17);

		compra_Mostrar = new JPanel();
		compra_Mostrar.setLayout(null);
		compra_Mostrar.setBackground(new Color(102, 102, 153));
		compra_Mostrar.setBounds(0, 0, 1540, 795);
		layeredPane.add(compra_Mostrar);

		JLabel lblNewLabel_4_1_1_2_1_1 = new JLabel("Compra");
		lblNewLabel_4_1_1_2_1_1.setForeground(new Color(51, 204, 102));
		lblNewLabel_4_1_1_2_1_1.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_1_2_1_1.setBackground(new Color(51, 204, 102));
		lblNewLabel_4_1_1_2_1_1.setBounds(682, 43, 225, 103);
		compra_Mostrar.add(lblNewLabel_4_1_1_2_1_1);

		JLabel lblNewLabel_5_1_1_2_1_1 = new JLabel("Leitura");
		lblNewLabel_5_1_1_2_1_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_5_1_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_1_2_1_1.setBounds(738, 123, 143, 69);
		compra_Mostrar.add(lblNewLabel_5_1_1_2_1_1);

		JList list_2_1_1 = new JList();
		list_2_1_1.setBounds(803, 709, 623, -484);
		compra_Mostrar.add(list_2_1_1);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(170, 190, 1202, 526);
		compra_Mostrar.add(scrollPane_4);

		table_todas_compras = new JTable();
		scrollPane_4.setViewportView(table_todas_compras);
		table_todas_compras.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nota Fiscal", "C\u00F3digo Produto", "CPF Caixa", "Data", "Hora", "Nome Cliente" }) {
			Class[] columnTypes = new Class[] { Integer.class, Object.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JLabel lblNewLabel_6_1_1_2_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1_1_1_1_1_1
				.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo azul.png")));
		lblNewLabel_6_1_1_2_1_1_1_1_1_1.setBounds(0, 0, 1594, 283);
		compra_Mostrar.add(lblNewLabel_6_1_1_2_1_1_1_1_1_1);

		produtos_Delete = new JPanel();
		produtos_Delete.setLayout(null);
		produtos_Delete.setBackground(new Color(51, 0, 0));
		produtos_Delete.setBounds(0, 0, 1540, 795);
		layeredPane.add(produtos_Delete);

		JLabel lblNewLabel_4_1_1 = new JLabel("Produtos");
		lblNewLabel_4_1_1.setForeground(new Color(255, 0, 51));
		lblNewLabel_4_1_1.setFont(new Font("Bakery", Font.PLAIN, 83));
		lblNewLabel_4_1_1.setBounds(626, 40, 270, 103);
		produtos_Delete.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Deletar");
		lblNewLabel_5_1_1.setForeground(new Color(102, 0, 0));
		lblNewLabel_5_1_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_5_1_1.setBounds(684, 123, 143, 69);
		produtos_Delete.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_6_3_1 = new JLabel("Produto:");
		lblNewLabel_6_3_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_6_3_1.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel_6_3_1.setBounds(713, 328, 183, 47);
		produtos_Delete.add(lblNewLabel_6_3_1);

		JLabel lblNewLabel_7_3_1 = new JLabel("Selecione o produto a ser deletado:");
		lblNewLabel_7_3_1.setForeground(SystemColor.menu);
		lblNewLabel_7_3_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_7_3_1.setBounds(613, 385, 606, 35);
		produtos_Delete.add(lblNewLabel_7_3_1);

		JButton btnNewButton_1_1 = new JButton("Deletar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemSelecionado_cod = comboBox_del_prod.getSelectedIndex();
				String item = listaproduto[itemSelecionado_cod];
				Produto p = new Produto();
				p.setCod(item);
				ProdutoDAO pdao = new ProdutoDAO();
				CompraDAO codao = new CompraDAO();
				System.out.println("item s" + itemSelecionado_cod);
				System.out.println("item" + item);
				int i = JOptionPane.showConfirmDialog(null,
						"Essa ação deletará todas as compras com este produto. Deseja continuar?");
				if (i == 0) {
					codao.removerCompraProduto(p);
					pdao.remover(p);
					JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Produto NÃO foi excluido!");
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(732, 531, 112, 40);
		produtos_Delete.add(btnNewButton_1_1);

		JList list = new JList();
		list.setBounds(803, 709, 623, -484);
		produtos_Delete.add(list);

		comboBox_del_prod = new JComboBox(listaproduto);
		comboBox_del_prod.setBounds(457, 462, 665, 21);
		produtos_Delete.add(comboBox_del_prod);

		JLabel lblNewLabel_6_1_1_2 = new JLabel("");
		lblNewLabel_6_1_1_2.setIcon(new ImageIcon(Interface.class.getResource("/img/sorvete escorrendo rosa.png")));
		lblNewLabel_6_1_1_2.setBounds(0, 0, 1583, 283);
		produtos_Delete.add(lblNewLabel_6_1_1_2);
		tableheader.setFont(new Font("Tahoma", Font.PLAIN, 18));

	}

	public void Switch_screen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
