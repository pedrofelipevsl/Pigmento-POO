package br.edu.ifba.ads.inf008.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;
import br.edu.ifba.ads.inf008.model.entidades.PigmentoMensagem;
import br.edu.ifba.ads.inf008.model.session.ServicosPigmentoApp;
import br.edu.ifba.ads.inf008.model.session.ServicosPigmentos;

public class PigmentoUi extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorHexa;
	private Color corEscolhida;
	private PigmentoMensagem pm;
	private JTextField textFieldQuantidade;
	private ServicosPigmentoApp app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PigmentoUi frame = new PigmentoUi();
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
	public PigmentoUi() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCorHexa = new JLabel("Cor Hexa: ");
		lblCorHexa.setBounds(16, 15, 66, 16);
		contentPane.add(lblCorHexa);

		txtCorHexa = new JTextField();
		txtCorHexa.setText("00AAFF");
		txtCorHexa.setBounds(80, 10, 130, 26);
		contentPane.add(txtCorHexa);
		txtCorHexa.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(180, 41, 85, 29);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

			}
		});

		JLabel lblQuantidade = new JLabel("Quantidade (L):");
		lblQuantidade.setBounds(242, 15, 108, 16);
		contentPane.add(lblQuantidade);

		contentPane.add(btnBuscar);

		JLabel lblNomeDaCor = new JLabel("Nome da Cor: ");
		lblNomeDaCor.setBounds(16, 104, 90, 16);
		contentPane.add(lblNomeDaCor);

		JLabel lblEstoqueDisponvel = new JLabel("Estoque Disponível: ");
		lblEstoqueDisponvel.setBounds(16, 132, 130, 16);
		contentPane.add(lblEstoqueDisponvel);

		JLabel lblPreoDoProduto = new JLabel("Preço do Produto: ");
		lblPreoDoProduto.setBounds(16, 160, 115, 16);
		contentPane.add(lblPreoDoProduto);

		JLabel lblQuantidadeSolicitada = new JLabel("Quantidade Solicitada: ");
		lblQuantidadeSolicitada.setBounds(16, 187, 145, 16);
		contentPane.add(lblQuantidadeSolicitada);

		JLabel lblPreoTotal = new JLabel("Preço Total: ");
		lblPreoTotal.setBounds(16, 215, 85, 16);
		contentPane.add(lblPreoTotal);

		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso!");
			}
		});
		btnFinalizarCompra.setBounds(314, 243, 130, 29);
		contentPane.add(btnFinalizarCompra);

		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setText("2");
		textFieldQuantidade.setBounds(348, 10, 60, 26);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);

		JTextPane textPaneNomePigmento = new JTextPane();
		textPaneNomePigmento.setBounds(109, 104, 101, 16);
		contentPane.add(textPaneNomePigmento);

		JTextPane textPaneEstoquePigmento = new JTextPane();
		textPaneEstoquePigmento.setBounds(144, 132, 66, 16);
		contentPane.add(textPaneEstoquePigmento);

		JTextPane textPanePrecoPigmento = new JTextPane();
		textPanePrecoPigmento.setBounds(145, 160, 65, 16);
		contentPane.add(textPanePrecoPigmento);

		JTextPane textPaneQuantidadeSolicitada = new JTextPane();
		textPaneQuantidadeSolicitada.setBounds(160, 187, 50, 16);
		contentPane.add(textPaneQuantidadeSolicitada);

		JTextPane textPanePrecoTotal = new JTextPane();
		textPanePrecoTotal.setBounds(105, 215, 105, 16);
		contentPane.add(textPanePrecoTotal);

		JLabel lblTonalidade = new JLabel("Tonalidade:");
		lblTonalidade.setBounds(302, 104, 73, 16);
		contentPane.add(lblTonalidade);

		JPanel panel = new JPanel();
		panel.setBounds(384, 103, 48, 16);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 43, 50, 14);
		contentPane.add(panel_1);
	}
}
