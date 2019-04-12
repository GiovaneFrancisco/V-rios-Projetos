package br.com.gff.apresentacao;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicio extends JFrame implements ActionListener {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Date data = new Date();
	private String dataS;
	private DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
	

	public TelaInicio() {
		setSize(new Dimension(400, 400));
		setVisible(true);

		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JButton btnCriar = new JButton("Criar");
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriar.setBackground(SystemColor.menu);
		btnCriar.setBounds(38, 44, 120, 31);
		getContentPane().add(btnCriar);
		btnCriar.addActionListener(this);
		btnCriar.setActionCommand("criar");

		JButton btnVerLista = new JButton("Ver Lista");
		btnVerLista.setBackground(SystemColor.menu);
		btnVerLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerLista.setBounds(197, 44, 120, 31);
		getContentPane().add(btnVerLista);
		btnVerLista.addActionListener(this);
		btnVerLista.setActionCommand("lista");
		
		JLabel lblData = new JLabel("");
		lblData.setBounds(124, 141, 208, 14);
		getContentPane().add(lblData);
		
		
		lblData.setText(formatador.format(data));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame tela = null;

		if (cmd.equals("criar")) {
			tela = new TelaCriar();
		}else if(cmd.equals("lista")){
			tela = null;
		}
		tela.setVisible(true);
		this.dispose();
	}
}
