package br.edu.ifba.ads.inf008.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;
import br.edu.ifba.ads.inf008.model.entidades.PigmentoMensagem;
import br.edu.ifba.ads.inf008.model.session.ServicosPigmentoApp;
import br.edu.ifba.ads.inf008.model.session.ServicosPigmentos;

public class PigmentoView extends JFrame implements ActionListener {

	private JTextField txtCorHexa;
	private JTextField txtQuantidade;

	private JButton btnBuscarCor;
	private JButton btnFinalizarCompra;
	private ServicosPigmentoApp app;
	private PigmentoMensagem pm;

	public PigmentoView() throws ClassNotFoundException, IOException {
		this.app = new ServicosPigmentos();
	}

	public void run() {
		this.asm();
		this.setVisible(true);
	}

	private void asm() {

		this.txtCorHexa = new JTextField();
		this.txtQuantidade = new JTextField();
		this.btnBuscarCor = new JButton("Buscar");

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(4, 2));
		panel.add(new JLabel("Cor Hexa -> AAFF00: "));
		panel.add(this.txtCorHexa);
		panel.add(new JLabel("Quantidade (L): "));
		panel.add(this.txtQuantidade);

		this.setSize(400, 150);
		this.setTitle("Finalizar Compra");
		this.add(panel, BorderLayout.CENTER);
		this.add(btnBuscarCor, BorderLayout.SOUTH);
		this.btnBuscarCor.addActionListener(this);

		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		(new PigmentoView()).run();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			pm = (PigmentoMensagem) this.app.localizarPigmento(this.txtCorHexa.getText(),
					Double.parseDouble(this.txtQuantidade.getText()));

			pm.setTotalQueVaiPagar(Double.parseDouble(this.txtQuantidade.getText()));

//			int dialogResult = JOptionPane.showConfirmDialog(this,
//					" -> Nome da Cor: " + pm.getNome() + "\n" + " -> Estoque Disponivel: " + pm.getEstoque()
//							+ " litro(s)\n" + " -> Preco Produto: R$ " + pm.getPreco() + " \n"
//							+ " -> Quantidade Solicitada: " + this.txtQuantidade.getText() + " litro(s)\n"
//							+ " -> Total a Pagar: R$ " + pm.getTotalAPagar() + "\n");

			Object[] options = { "Finalizar Compra", "Pesquisar Outro" };

			int opcao = 0;

			opcao = JOptionPane.showOptionDialog(null,
					" -> Nome da Cor: " + pm.getNome() + "\n" + " -> Estoque Disponivel: " + pm.getEstoque()
							+ " litro(s)\n" + " -> Preco Produto: R$ " + pm.getPreco() + " \n"
							+ " -> Quantidade Solicitada: " + this.txtQuantidade.getText() + " litro(s)\n"
							+ " -> Total a Pagar: R$ " + pm.getTotalAPagar() + "\n",
					"Pigmento Encontrado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
					options[0]);

			if (opcao == 0) {

				this.app.finalizarCompra(pm, Double.parseDouble(this.txtQuantidade.getText()));

				pm.setBaixaNoEstoque(Double.parseDouble(this.txtQuantidade.getText()));

				JOptionPane.showMessageDialog(this, " -> Compra da cor > " + pm.getNome()
						+ " < realizada com sucesso!\n" + " -> Estoque atual: " + pm.getEstoque() + " litro(s)\n");
			}

		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "A quantidade precisa ser um número real", "Erro de Tipo de Campo",
					JOptionPane.ERROR_MESSAGE);
		} catch (PigmentoException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Erro na busca", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

}
