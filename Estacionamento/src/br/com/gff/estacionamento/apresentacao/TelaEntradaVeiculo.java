package br.com.gff.estacionamento.apresentacao;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.gff.estacionamento.controle.EstacionamentoController;
import br.com.gff.estacionamento.controle.EstacionamentoException;
import br.com.gff.estacionamento.controle.VeiculoException;

import java.awt.SystemColor;

public class TelaEntradaVeiculo extends JFrame implements ActionListener{
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtMarca;
	private JFormattedTextField txfPlaca;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private String placa, marca, modelo, cor;;
	
	private JFrame parent; //Cria um "Pai" para que, caso a classe seja fechada, ela retorne para o ponto anterior
	
	public TelaEntradaVeiculo(JFrame parent) {
		setResizable(false);
		setTitle("Entrada de ve\u00EDculo");
		getContentPane().setLayout(null);
		this.parent = parent;
		setSize(new Dimension(270, 330));
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(39, 41, 46, 14);
		getContentPane().add(lblPlaca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(39, 96, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(39, 151, 46, 14);
		getContentPane().add(lblCor);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(39, 206, 46, 14);
		getContentPane().add(lblMarca);
		
	
		try {
			txfPlaca = new JFormattedTextField(new MaskFormatter("UUU-####")); //Criação da placa com padrão nacional 
		} catch (ParseException e) {
			assert false : "Padrão de placa errado!";
		}
		txfPlaca.setBounds(132, 38, 69, 20);
		getContentPane().add(txfPlaca);

		
		txtModelo = new JTextField();
		txtModelo.setBounds(110, 93, 116, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(110, 148, 116, 20);
		getContentPane().add(txtCor);
		txtCor.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(110, 203, 116, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(SystemColor.menu);
		btnRegistrar.setBounds(37, 256, 89, 23);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("registrar");
		getContentPane().add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(137, 256, 89, 23);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		getContentPane().add(btnCancelar);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String cmd = evento.getActionCommand();
		JFrame tela = null;
		if (cmd.equals("registrar")) { //Se o botão Registrar for pressionado
			
			EstacionamentoController controle = new EstacionamentoController(); //Cria uma instância com o Controller para usar o método
			placa = txfPlaca.getText();
			marca = txtMarca.getText();
			modelo = txtModelo.getText();
			cor = txtCor.getText();
			//Pega as informações e guarda em variáveis
			
				try {
					controle.processarEntrara(placa,marca,modelo,cor);
					//Manda as informações das variáveis para o Controller
					JOptionPane.showMessageDialog(null, "Carro registrado!", "Registro", JOptionPane.INFORMATION_MESSAGE); //Cria uma mensagem 
					this.parent.setVisible(true); //Volta pra tela anterior
					this.dispose(); //Deleta essa tela
				} catch (EstacionamentoException | VeiculoException e) { //Se houver algum erro irá aparecer uma mensagem com tal
					JOptionPane.showMessageDialog(null, e.getMessage(), "Falha na entrada!", JOptionPane.ERROR_MESSAGE);
				} 
				
			
		}else { //Se o botão Cancelar for pressionado
			this.parent.setVisible(true); //Volta pra tela anterior
			this.dispose(); //Deleta essa tela
		}
	
	}
}
