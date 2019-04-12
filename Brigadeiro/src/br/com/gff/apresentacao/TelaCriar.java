package br.com.gff.apresentacao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class TelaCriar extends JFrame implements ActionListener {
	private JTextField txtNome;
	private JComboBox cboTipo;
	private JButton btnCriar;
	private JButton btnCancelar;
	private JFormattedTextField txfData;
	private JFormattedTextField txfData_1;

	public TelaCriar() {
		setSize(new Dimension(303, 263));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:....");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNome.setBounds(10, 14, 72, 14);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtNome.setBounds(66, 11, 197, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		cboTipo = new JComboBox();
		cboTipo.setBackground(SystemColor.info);
		cboTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboTipo.setModel(new DefaultComboBoxModel(
				new String[] { "Caixa 4", "Caixa 6", "Caixa 12", "Caixa 20", "Barca", "Cento" }));
		cboTipo.setBounds(177, 136, 86, 20);
		getContentPane().add(cboTipo);

		JLabel lblDataDeEntrega = new JLabel("Data de entrega:.............");
		lblDataDeEntrega.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDataDeEntrega.setBounds(10, 39, 166, 20);
		getContentPane().add(lblDataDeEntrega);

		txfData = new JFormattedTextField();
		txfData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			txfData_1 = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txfData_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		} catch (ParseException e) {
			assert false : "Padrão de data incorreto";
		}
		txfData_1.setBounds(170, 39, 86, 20);
		getContentPane().add(txfData_1);

		JLabel lblTipo = new JLabel("Tipo:.....................................");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTipo.setBounds(10, 138, 166, 17);
		getContentPane().add(lblTipo);

		btnCriar = new JButton("Criar");
		btnCriar.setBackground(SystemColor.menu);
		btnCriar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnCriar.setBounds(22, 176, 89, 23);
		getContentPane().add(btnCriar);
		btnCriar.addActionListener(this);
		btnCriar.setActionCommand("criar");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnCancelar.setBounds(167, 176, 96, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		JLabel lblQuantidadeDePedidos = new JLabel("Quantidade de pedidos:.....");
		lblQuantidadeDePedidos.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuantidadeDePedidos.setBounds(10, 92, 166, 23);
		getContentPane().add(lblQuantidadeDePedidos);
		
		JComboBox cboQuant = new JComboBox();
		cboQuant.setBackground(SystemColor.info);
		cboQuant.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cboQuant.setBounds(180, 93, 46, 20);
		getContentPane().add(cboQuant);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame tela = null;
		String nome, data, tipo;

		nome = (txtNome.getText());
		data = (txfData_1.getText());
		tipo = (String) cboTipo.getSelectedItem();

		if (cmd.equals("criar")) {
			if (nome.equals("")) {
				JOptionPane.showMessageDialog(null, "Adicione o nome do cliente", "Erro", JOptionPane.ERROR_MESSAGE);
			} else if (data.equals("  /  /    ")) {
				JOptionPane.showMessageDialog(null, "Adicione a data de entrega", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				if (tipo.equals("Caixa 4") || tipo.equals("Caixa 6")) {
					tela = new TelaCriarC4(nome, data, tipo);
				} else if (tipo.equals("Caixa 12")) {
					tela = new TelaCriarc12(nome, data, tipo);
				} else if (tipo.equals("Caixa 20")) {
					tela = new TelaCriarC20(nome, data, tipo);
				} else if (tipo.equals("Cento")) {
					tela = new TelaCriarCento(nome, data, tipo);
				} else if (tipo.equals("Barca")) {

				} else if (cmd.equals("cancelar")) {
					tela = new TelaInicio();
				}
				tela.setVisible(true);
				this.dispose();
			}
		}else if(cmd.equals("sair")) {
			System.exit(0);
		}
	}
}
