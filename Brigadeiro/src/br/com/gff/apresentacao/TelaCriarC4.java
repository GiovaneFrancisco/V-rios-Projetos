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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.gff.dao.DAO;

public class TelaCriarC4 extends JFrame implements ActionListener{
	private JTextField txtNome;
	private JTextField txtData;
	private String nomeR, dataR, tipoR, sabor1, sabor2, sabor3, sabor4, sabor5, nota;
	private JTextField txtNota;
	private JTextField txtTipo;
	private JComboBox cboSabor1;
	private JComboBox cboSabor2;

	public TelaCriarC4(String nome, String data, String tipo) {
		setTitle("Criar caixa C4 / C6");
		getContentPane().setLayout(null);
		setSize(new Dimension(297, 368));
		nomeR = nome;
		dataR = data;
		tipoR = tipo;
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(25, 21, 132, 14);
		getContentPane().add(lblNome);
		
		JLabel lblDataDeEntrega = new JLabel("Data de entrega:");
		lblDataDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeEntrega.setBounds(25, 57, 132, 17);
		getContentPane().add(lblDataDeEntrega);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(167, 18, 86, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(nome);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(167, 57, 86, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		txtData.setText(data);
		
		JLabel lblSabor = new JLabel("1\u00BA Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor.setBounds(25, 143, 70, 14);
		getContentPane().add(lblSabor);
		
		JLabel lblSabor_1 = new JLabel("2\u00BA Sabor:");
		lblSabor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabor_1.setBounds(25, 190, 70, 14);
		getContentPane().add(lblSabor_1);
		
		cboSabor1 = new JComboBox();
		cboSabor1.setBackground(SystemColor.info);
		cboSabor1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor1.setModel(new DefaultComboBoxModel(new String[] {"Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor1.setBounds(124, 140, 129, 20);
		getContentPane().add(cboSabor1);
		
		cboSabor2 = new JComboBox();
		cboSabor2.setBackground(SystemColor.info);
		cboSabor2.setModel(new DefaultComboBoxModel(new String[] {"--------------------", "Ao leite", "Meio amargo", "Branco", "Morango", "Beijinho", "Oreo", "Ninho c/ Nutella", "Pa\u00E7oca", "Damasco", "Confeti", "Ninho simples", "Churros", "Caf\u00E9", "Frutas vermelhas", "Prest\u00EDgio", "Palha italiana", "Lim\u00E3o"}));
		cboSabor2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSabor2.setBounds(124, 187, 129, 20);
		getContentPane().add(cboSabor2);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(SystemColor.info);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBounds(25, 280, 89, 23);
		getContentPane().add(btnCriar);
		btnCriar.addActionListener(this);
		btnCriar.setActionCommand("criar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.info);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(166, 280, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(25, 234, 70, 14);
		getContentPane().add(lblNota);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNota.setBounds(73, 231, 180, 20);
		getContentPane().add(txtNota);
		txtNota.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(25, 91, 73, 17);
		getContentPane().add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipo.setBounds(170, 94, 86, 20);
		getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		txtTipo.setText(tipo);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame tela = null;
		
		DAO dao = new DAO();
		
		if(cmd.equals("criar")) {
			if(txtNome.equals(null)) {
				JOptionPane.showMessageDialog(null, "Adicione o nome do cliente", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			sabor1 = (String) cboSabor1.getSelectedItem();
			sabor2 = (String) cboSabor2.getSelectedItem();
			nota = txtNota.getText();
			sabor3 = "--------------------";
			sabor4 = "--------------------";
			sabor5 = "--------------------";
			
			if(nota == "") {
				nota = "--------------------";
			}
			
			dao.registrar(nomeR, dataR, tipoR, sabor1, sabor2, sabor3, sabor4, sabor5, nota);
			tela = new TelaInicio();
		}else if(cmd.equals("cancelar")){
			tela = new TelaCriar();
		}
		tela.setVisible(true);
		this.dispose();
	}
}
