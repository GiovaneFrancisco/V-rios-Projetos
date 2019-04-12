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
import javax.swing.JTextField;

import br.com.gff.dao.DAO;

public class TelaCriarC20 extends JFrame implements ActionListener{
	private JTextField txtNota;
	private JTextField txtTipo;
	private JTextField txtData;
	private JTextField txtNome;
	private JComboBox cboSabor1;
	private JComboBox cboSabor2;
	private JComboBox cboSabor3;
	private JComboBox cboSabor4;
	private String nomeR, dataR, tipoR, sabor_1, sabor_2, sabor_3, sabor_4, sabor_5, notaR;


	public TelaCriarC20(String nome, String data, String tipo) {
		getContentPane().setLayout(null);
		setSize(new Dimension(300, 440));
		
		nomeR = nome;
		dataR = data;
		tipoR = tipo;
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 11, 129, 14);
		getContentPane().add(lblNome);
		
		JLabel lblDataDeEntrega = new JLabel("Data de entrega:");
		lblDataDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeEntrega.setBounds(10, 47, 129, 20);
		getContentPane().add(lblDataDeEntrega);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 88, 129, 20);
		getContentPane().add(lblTipo);
		
		JLabel lblSabor = new JLabel("1\u00BA Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor.setBounds(10, 145, 129, 14);
		getContentPane().add(lblSabor);
		
		JLabel lblSabor_1 = new JLabel("2\u00BA Sabor:");
		lblSabor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor_1.setBounds(10, 184, 129, 14);
		getContentPane().add(lblSabor_1);
		
		JLabel lblSabor_2 = new JLabel("3\u00BA Sabor:");
		lblSabor_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor_2.setBounds(10, 224, 129, 14);
		getContentPane().add(lblSabor_2);
		
		JLabel lblSabor_3 = new JLabel("4\u00BA Sabor:");
		lblSabor_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor_3.setBounds(10, 271, 129, 14);
		getContentPane().add(lblSabor_3);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(10, 324, 129, 14);
		getContentPane().add(lblNota);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNota.setBounds(69, 321, 202, 20);
		getContentPane().add(txtNota);
		txtNota.setColumns(10);
		notaR = txtNota.getText();
		
		cboSabor4 = new JComboBox();
		cboSabor4.setBackground(SystemColor.info);
		cboSabor4.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor4.setBounds(142, 265, 129, 20);
		getContentPane().add(cboSabor4);
		
		cboSabor3 = new JComboBox();
		cboSabor3.setBackground(SystemColor.info);
		cboSabor3.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor3.setBounds(142, 218, 129, 20);
		getContentPane().add(cboSabor3);
		
		cboSabor2 = new JComboBox();
		cboSabor2.setBackground(SystemColor.info);
		cboSabor2.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor2.setBounds(142, 178, 129, 20);
		getContentPane().add(cboSabor2);
		
		cboSabor1 = new JComboBox();
		cboSabor1.setBackground(SystemColor.info);
		cboSabor1.setModel(new DefaultComboBoxModel(new String[] {"Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor1.setBounds(142, 139, 129, 20);
		getContentPane().add(cboSabor1);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipo.setBounds(142, 88, 86, 20);
		getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		txtTipo.setText(tipo);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(142, 41, 86, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		txtData.setText(data);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(142, 5, 86, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(nome);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(SystemColor.menu);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(35, 366, 89, 23);
		getContentPane().add(btnCriar);
		btnCriar.addActionListener(this);
		btnCriar.setActionCommand("criar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(164, 366, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame tela = null;
		DAO dao = new DAO();
		if(cmd.equals("criar")) {
			sabor_1 = (String) cboSabor1.getSelectedItem();
			sabor_2 = (String) cboSabor2.getSelectedItem();
			sabor_3 = (String) cboSabor3.getSelectedItem();
			sabor_4 = (String) cboSabor4.getSelectedItem();
			sabor_5 = "--------------------";
			notaR = txtNota.getText();
			
			if(notaR == "") {
				notaR = "--------------------";
			}
			
			dao.registrar(nomeR, dataR, tipoR, sabor_1, sabor_2, sabor_3, sabor_4, sabor_5, notaR);
		
			tela = new TelaInicio();
		}else {
			tela = new TelaCriar();
		}
		tela.setVisible(true);
		this.dispose();
	}

}
