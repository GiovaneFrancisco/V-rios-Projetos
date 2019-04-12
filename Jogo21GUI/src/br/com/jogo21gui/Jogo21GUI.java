package br.com.jogo21gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Jogo21GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCarta;
	private JTextField txtSoma;
	private JButton btnCarta;
	private JButton btnParar;
	private JLabel lblCartaC;
	private JTextField txtCartaC;
	private JLabel lblSomaC;
	private JTextField txtSomaC;
	private JTextField txtSituacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo21GUI frame = new Jogo21GUI();
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
	public Jogo21GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 448, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCarta = new JButton("Pedir carta");
		btnCarta.addActionListener(new ActionListener() {
			int valorJ=0, somaJ=0;
			public void actionPerformed(ActionEvent arg0) {
				String[] cartas = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
				int [] nipes = new int[3];
				Random num = new Random();
				int carta = num.nextInt(13);
				int nipe = num.nextInt(3);
				btnParar.setVisible(true);
				if(cartas[carta]=="A" || cartas[carta]=="J"||cartas[carta]=="Q"||cartas[carta]=="K") {
					valorJ = 10;
				}else if(cartas[carta]=="2"){
					valorJ=2;
				}else if(cartas[carta]=="3"){
					valorJ=3;
				}else if(cartas[carta]=="4"){
					valorJ=4;
				}else if(cartas[carta]=="5"){
					valorJ=5;
				}else if(cartas[carta]=="6"){
					valorJ=6;
				}else if(cartas[carta]=="7"){
					valorJ=7;
				}else if(cartas[carta]=="8"){
					valorJ=8;
				}else if(cartas[carta]=="9"){
					valorJ=9;
				}else if(cartas[carta]=="10"){
					valorJ=10;
				}
				
				txtCarta.setText(cartas[carta]);
				somaJ = somaJ + valorJ;
				txtSoma.setText(Integer.toString(somaJ));
				if(somaJ>21) {
					txtSituacao.setText("Você estourou!");
					txtCarta.setText(null);
					txtSoma.setText(null);
				}
			}
		});
		btnCarta.setBounds(319, 22, 105, 23);
		contentPane.add(btnCarta);
		
		btnParar = new JButton("Parar");
		btnParar.setVisible(false);
		btnParar.addActionListener(new ActionListener() {
			int valorC=0, somaC=0;
			public void actionPerformed(ActionEvent arg0) {
				txtCartaC.setVisible(true);
				txtSomaC.setVisible(true);
				lblCartaC.setVisible(true);
				lblSomaC.setVisible(true);
				String[] cartas = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
				int [] nipes = new int[3];
				Random num = new Random();
				do {
				int carta = num.nextInt(13);
				int nipe = num.nextInt(3);
				btnParar.setVisible(true);
				if(cartas[carta]=="A" || cartas[carta]=="J"||cartas[carta]=="Q"||cartas[carta]=="K") {
					valorC = 10;
				}else if(cartas[carta]=="2"){
					valorC=2;
				}else if(cartas[carta]=="3"){
					valorC=3;
				}else if(cartas[carta]=="4"){
					valorC=4;
				}else if(cartas[carta]=="5"){
					valorC=5;
				}else if(cartas[carta]=="6"){
					valorC=6;
				}else if(cartas[carta]=="7"){
					valorC=7;
				}else if(cartas[carta]=="8"){
					valorC=8;
				}else if(cartas[carta]=="9"){
					valorC=9;
				}else if(cartas[carta]=="10"){
					valorC=10;
				}
				
				txtCartaC.setText(cartas[carta]);
				somaC = somaC + valorC;
				txtSomaC.setText(Integer.toString(somaC));
				}while(somaC<17);
				if(somaC>21) {
					txtSituacao.setText("O computador estourou!");
					txtCarta.setText(null);
					txtSoma.setText(null);
				}
			}
		});
		btnParar.setBounds(319, 79, 105, 23);
		contentPane.add(btnParar);
		
		JLabel lblSuaCarta = new JLabel("Sua carta:");
		lblSuaCarta.setBounds(30, 25, 63, 14);
		contentPane.add(lblSuaCarta);
		
		JLabel lblSuaSoma = new JLabel("Sua soma:");
		lblSuaSoma.setBounds(30, 65, 63, 14);
		contentPane.add(lblSuaSoma);
		
				
				txtCarta = new JTextField();
				txtCarta.setEditable(false);
				txtCarta.setHorizontalAlignment(SwingConstants.CENTER);
				txtCarta.setBounds(133, 22, 63, 20);
				contentPane.add(txtCarta);
				txtCarta.setColumns(10);
		
		txtSoma = new JTextField();
		txtSoma.setEditable(false);
		txtSoma.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoma.setBounds(133, 62, 63, 20);
		contentPane.add(txtSoma);
		txtSoma.setColumns(10);
		
		lblCartaC = new JLabel("Carta do computador:");
		lblCartaC.setBounds(30, 112, 123, 14);
		contentPane.add(lblCartaC);
		lblCartaC.setVisible(false);
		
		lblSomaC = new JLabel("Soma do computador:");
		lblSomaC.setBounds(30, 149, 152, 14);
		contentPane.add(lblSomaC);
		lblSomaC.setVisible(false);
		
		txtCartaC = new JTextField();
		txtCartaC.setEditable(false);
		txtCartaC.setBounds(192, 109, 86, 20);
		contentPane.add(txtCartaC);
		txtCartaC.setColumns(10);
		txtCartaC.setVisible(false);
		
		txtSomaC = new JTextField();
		txtSomaC.setEditable(false);
		txtSomaC.setBounds(192, 140, 86, 20);
		contentPane.add(txtSomaC);
		txtSomaC.setColumns(10);
		
		txtSituacao = new JTextField();
		txtSituacao.setBounds(319, 113, 86, 20);
		contentPane.add(txtSituacao);
		txtSituacao.setColumns(10);
		txtSomaC.setVisible(false);
		
	}
	
}
