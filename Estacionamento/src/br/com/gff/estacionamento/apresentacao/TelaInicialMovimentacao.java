package br.com.gff.estacionamento.apresentacao;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaInicialMovimentacao extends JFrame implements ActionListener{
	private JButton btnSaida;
	private JButton btnEntrada;
	
	public TelaInicialMovimentacao() {
		setTitle("Sistema de estacionamento");
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setSize(new Dimension(550,300));
		
		btnEntrada = new JButton("");
		btnEntrada.setBackground(SystemColor.menu);
		btnEntrada.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/Entrar.png")));
		getContentPane().add(btnEntrada);
		btnEntrada.addActionListener(this);
		btnEntrada.setActionCommand("entrada");
		
		btnSaida = new JButton("");
		btnSaida.setBackground(SystemColor.menu);
		btnSaida.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/Sair.png")));
		getContentPane().add(btnSaida);
		btnSaida.addActionListener(this);
		btnSaida.setActionCommand("saida");
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String cmd = evento.getActionCommand();
		JFrame tela = null;
		if(cmd.equals("entrada")) { //Se o botão Entrada for acionado
			tela = new TelaEntradaVeiculo(this); //A tela de entrada é exibida
		}else { //Se o botão de Saída for acionado
			tela = new TelaSaidaVeiculo(this); //A tela de saída é exibida
		}
		tela.setVisible(true); //Exibe a tela selecionado
		this.setVisible(false); //Essa tela fica minimizada
	}
}
