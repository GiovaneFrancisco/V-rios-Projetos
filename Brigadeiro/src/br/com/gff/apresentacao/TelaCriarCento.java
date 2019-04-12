package br.com.gff.apresentacao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import br.com.gff.dao.DAO;

public class TelaCriarCento extends JFrame implements ActionListener{
	private JTextField txtNome;
	private JTextField txtData;
	private JTextField txtTipo;
	private JTextField txtNota;
	private JComboBox cboSabor1;
	private JComboBox cboSabor2;
	private JComboBox cboSabor3;
	private JComboBox cboSabor4;
	private JComboBox cboSabor5;
	String nomeR, dataR, tipoR, sabor1, sabor2, sabor3, sabor4, sabor5, notaR;
	
	public TelaCriarCento(String nome, String data, String tipo) {
		setSize(new Dimension(412, 463));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		nomeR = nome;
		dataR = data;
		tipoR = tipo;
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblDataDeEntrega = new JLabel("Data de entrega:");
		lblDataDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeEntrega.setBounds(10, 59, 130, 17);
		getContentPane().add(lblDataDeEntrega);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 114, 46, 17);
		getContentPane().add(lblTipo);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setEditable(false);
		txtNome.setBounds(138, 5, 86, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(nome);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBounds(138, 56, 86, 20);
		getContentPane().add(txtData);
		txtData.setText(data);
		
		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipo.setEditable(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(138, 111, 86, 20);
		getContentPane().add(txtTipo);
		txtTipo.setText(tipo);
		
		JLabel lblSabores = new JLabel("Sabores:");
		lblSabores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabores.setBounds(10, 167, 130, 14);
		getContentPane().add(lblSabores);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 158, 396, 2);
		getContentPane().add(separator);
		
		cboSabor1 = new JComboBox();
		cboSabor1.setBackground(SystemColor.info);
		cboSabor1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor1.setModel(new DefaultComboBoxModel(new String[] {"Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor1.setBounds(35, 190, 129, 20);
		getContentPane().add(cboSabor1);
		
		cboSabor2 = new JComboBox();
		cboSabor2.setBackground(SystemColor.info);
		cboSabor2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor2.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor2.setBounds(35, 230, 129, 20);
		getContentPane().add(cboSabor2);
		
		cboSabor3 = new JComboBox();
		cboSabor3.setBackground(SystemColor.info);
		cboSabor3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor3.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor3.setBounds(35, 270, 129, 20);
		getContentPane().add(cboSabor3);
		
		cboSabor4 = new JComboBox();
		cboSabor4.setBackground(SystemColor.info);
		cboSabor4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor4.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor4.setBounds(35, 310, 129, 20);
		getContentPane().add(cboSabor4);
		
		cboSabor5 = new JComboBox();
		cboSabor5.setBackground(SystemColor.info);
		cboSabor5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor5.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor5.setBounds(38, 350, 129, 20);
		getContentPane().add(cboSabor5);
		
		JLabel label = new JLabel("1\u00BA");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 192, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2\u00BA");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 233, 46, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3\u00BA");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 273, 46, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4\u00BA");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 313, 46, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5\u00BA");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 353, 46, 14);
		getContentPane().add(label_4);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(SystemColor.menu);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(239, 189, 89, 29);
		getContentPane().add(btnCriar);
		btnCriar.addActionListener(this);
		btnCriar.setActionCommand("criar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(242, 240, 86, 29);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(10, 399, 46, 14);
		getContentPane().add(lblNota);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNota.setBounds(66, 396, 306, 20);
		getContentPane().add(txtNota);
		txtNota.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame tela = null;
		DAO dao = new DAO();
		
		if(cmd.equals("criar")) {
			
			sabor1 = (String) cboSabor1.getSelectedItem();
			sabor2 = (String) cboSabor2.getSelectedItem();
			sabor3 = (String) cboSabor3.getSelectedItem();
			sabor4 = (String) cboSabor4.getSelectedItem();
			sabor5 = (String) cboSabor5.getSelectedItem();
			notaR = txtNota.getText();
			
			dao.registrar(nomeR, dataR, tipoR, sabor1, sabor2, sabor3, sabor4, sabor5, notaR);
			
			tela = new TelaInicio();
		}else if(cmd.equals("cancelar")) {
			tela = new TelaCriar();
		}
		tela.setVisible(true);
		this.dispose();
	}
}
