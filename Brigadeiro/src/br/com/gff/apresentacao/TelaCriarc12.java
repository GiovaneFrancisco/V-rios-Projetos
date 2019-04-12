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

public class TelaCriarc12 extends JFrame implements ActionListener{
	private JTextField txtData;
	private JTextField txtNome;
	private JTextField txtTipo;
	private JComboBox cboSabor1;
	private JComboBox cboSabor2;
	private JComboBox cboSabor3;
	private String nomeR, dataR, tipoR, sabor_1, sabor_2, sabor_3, sabor_4, sabor_5,notaR;
	private JTextField txtNota;
	
	public TelaCriarc12(String nome, String data, String tipo) {
		getContentPane().setLayout(null);
		setSize(new Dimension(300, 390));
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(22, 11, 46, 14);
		getContentPane().add(lblNome);

		nomeR = nome;
		dataR = data;
		tipoR = tipo;
		
		JLabel lblDataDeEntrega = new JLabel("Data de entrega:");
		lblDataDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeEntrega.setBounds(22, 48, 131, 20);
		getContentPane().add(lblDataDeEntrega);
		
		JLabel lblSabor = new JLabel("1\u00BA Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor.setBounds(22, 155, 131, 14);
		getContentPane().add(lblSabor);
		
		JLabel lblSabor_1 = new JLabel("2\u00BA Sabor:");
		lblSabor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor_1.setBounds(22, 195, 131, 14);
		getContentPane().add(lblSabor_1);
		
		JLabel lblSabor_2 = new JLabel("3\u00BA Sabor:");
		lblSabor_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor_2.setBounds(22, 230, 131, 14);
		getContentPane().add(lblSabor_2);
		
		 cboSabor1 = new JComboBox();
		cboSabor1.setModel(new DefaultComboBoxModel(new String[] {"Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor1.setBackground(SystemColor.info);
		cboSabor1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor1.setBounds(120, 155, 129, 20);
		getContentPane().add(cboSabor1);
		
		cboSabor2 = new JComboBox();
		cboSabor2.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor2.setBackground(SystemColor.info);
		cboSabor2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor2.setBounds(120, 195, 129, 20);
		getContentPane().add(cboSabor2);
		
		cboSabor3 = new JComboBox();
		cboSabor3.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor3.setBackground(SystemColor.info);
		cboSabor3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor3.setBounds(120, 227, 129, 20);
		getContentPane().add(cboSabor3);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(SystemColor.menu);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(22, 317, 89, 23);
		getContentPane().add(btnCriar);
		btnCriar.addActionListener(this);
		btnCriar.setActionCommand("criar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(160, 317, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(163, 48, 86, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		txtData.setText(data);		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(163, 11, 86, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(nome);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(22, 90, 46, 19);
		getContentPane().add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setBounds(160, 89, 86, 20);
		getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		txtTipo.setText(tipo);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(22, 275, 46, 14);
		getContentPane().add(lblNota);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNota.setBounds(78, 274, 171, 20);
		getContentPane().add(txtNota);
		txtNota.setColumns(10);
		
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
			sabor_4 = "--------------------";
			sabor_5 = "--------------------";
			notaR = txtNota.getText();
			
			if(notaR == "") {
				notaR = "--------------------";
			}
			
			dao.registrar(nomeR, dataR, tipoR, sabor_1, sabor_2, sabor_3, sabor_4, sabor_5,notaR);
			tela = new TelaInicio();
		}else {
			tela = new TelaCriar();
		}
		tela.setVisible(true);
		this.dispose();
	}

}
