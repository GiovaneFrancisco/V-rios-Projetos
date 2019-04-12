package br.com.gff.estacionamento.apresentacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;


public class TelaLogin extends JFrame implements ActionListener{
	
	//TODO remover antes de entregar
	public static void main(String[] args) {
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
	}
	
	
	private JRadioButton rdbtnOperador;
	private JRadioButton rdbtnAdministrador;
	private JButton btnOk;
	private JPanel pnlEscolha;
	private JPanel pnlBtn;
	private JPanel pnlSenha;
	private JPasswordField txpSenha;
	
	public TelaLogin() {
		setTitle("Login");
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(450,150));
		
		pnlEscolha = new JPanel();
		getContentPane().add(pnlEscolha, BorderLayout.NORTH);
		
		rdbtnOperador = new JRadioButton("Operacional");
		rdbtnOperador.setSelected(true);
		rdbtnOperador.addActionListener(this);
		rdbtnOperador.setActionCommand("operador");
		pnlEscolha.add(rdbtnOperador);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.addActionListener(this);
		rdbtnAdministrador.setActionCommand("administrador");
		pnlEscolha.add(rdbtnAdministrador);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnAdministrador);
		grupo.add(rdbtnOperador);
		
		pnlBtn = new JPanel();
		getContentPane().add(pnlBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("Ok");
		btnOk.setBackground(SystemColor.menu);
		btnOk.addActionListener(this);
		btnOk.setActionCommand("ok");
		
		pnlBtn.add(btnOk);
		
		pnlSenha = new JPanel();
		getContentPane().add(pnlSenha, BorderLayout.CENTER);
		pnlSenha.setVisible(false);
		JLabel lblSenha = new JLabel("Senha: ");
		pnlSenha.add(lblSenha);
		
		txpSenha = new JPasswordField();
		txpSenha.setColumns(20);
		pnlSenha.add(txpSenha);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String cmd = evento.getActionCommand(); //Cria um leitor para o comando
		JFrame tela = null;
		if(cmd.equals("operador")) { //Se o botão Operador estiver selecionado
			pnlSenha.setVisible(false); //Deixe o campo de texto desabilitado
			
		}else if (cmd.equals("administrador")) { //Se o botão Administrador estiver selecionado
			txpSenha.setText(null); //Limpe o campo de texto 
			pnlSenha.setVisible(true); //Deixe o campo de texto habilitado
	
		}else if(cmd.equals("ok")) { //Quando o botão Ok for apertado
			if(rdbtnOperador.isSelected()) { //Se o botão Operacional estiver selecionado
				tela = new TelaInicialMovimentacao(); //Abra a tela de movimentação
				tela.setVisible(true); //Habilita a tela que foi determinada pelo botão
				
			}else { //Se o botão Administrador estiver selecionado
				String senha = new String(txpSenha.getPassword()); //Guarda os caracteres informados no campo de senha
				if(senha.equals("giovane")) { //Se a senha for igual à pré definida
					tela = new TelaInicialRelatorio(); //Abra a tela de relatório
					tela.setVisible(true); //Habilita a tela que foi determinada pelo botão
				}else { //Se a senha for diferente
					JOptionPane.showMessageDialog(null, "Senha Incorreta!", "Erro", JOptionPane.ERROR_MESSAGE); //Exibe uma mensagem de erro
					txpSenha.setText(null);
					return;
				}
			}
			this.dispose(); //Desabilita a tela de login
		}
	}

}
