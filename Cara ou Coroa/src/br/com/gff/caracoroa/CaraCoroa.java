package br.com.gff.caracoroa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CaraCoroa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtPontos;
	private JLabel lblMoeda;
	private JLabel lblPontos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaraCoroa frame = new CaraCoroa();
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
	public CaraCoroa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCara = new JButton("Cara");
		btnCara.addActionListener(new ActionListener() {
			int jog = 0;
			public void actionPerformed(ActionEvent arg0) {
				Random cnt = new Random();
				int num;
				txtPontos.setText(Integer.toString(jog));
				num = cnt.nextInt(2);
				char a = 'a';
				if (num == 1) {
					a = 'C';
				} else {
					a = 'c';
				}
				if (a == 'C') {
					textField.setText("Cara");
					jog++;
					txtPontos.setText(Integer.toString(jog));
				} else if (a == 'c') {
					textField.setText("Coroa");
					txtPontos.setText(Integer.toString(jog));

				}

			}
		});
		btnCara.setBounds(43, 21, 89, 23);
		contentPane.add(btnCara);

		JButton btnCoroa = new JButton("Coroa");
		btnCoroa.addActionListener(new ActionListener() {
			int jog = 0;

			public void actionPerformed(ActionEvent arg0) {
				Random cnt = new Random();
				int num;
				txtPontos.setText(Integer.toString(jog));
				num = cnt.nextInt(2);
				char a = 'a';
				if (num == 1) {
					a = 'C';
				} else {
					a = 'c';
				}
				if (a == 'C') {
					textField.setText("Cara");
					txtPontos.setText(Integer.toString(jog));
				} else if (a == 'c') {
					textField.setText("Coroa");
					jog++;
					txtPontos.setText(Integer.toString(jog));
				}
			}
		});
		btnCoroa.setBounds(213, 21, 89, 23);
		contentPane.add(btnCoroa);

		textField = new JTextField();
		textField.setBounds(133, 110, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		txtPontos = new JTextField();
		txtPontos.setBounds(133, 157, 86, 20);
		contentPane.add(txtPontos);
		txtPontos.setColumns(10);

		lblMoeda = new JLabel("Moeda");
		lblMoeda.setBounds(43, 113, 46, 14);
		contentPane.add(lblMoeda);

		lblPontos = new JLabel("Pontos");
		lblPontos.setBounds(43, 160, 46, 14);
		contentPane.add(lblPontos);
	}
}
