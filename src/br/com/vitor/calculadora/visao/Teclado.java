package br.com.vitor.calculadora.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.vitor.calculadora.modelo.Historico;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

	private GridBagConstraints bc = new GridBagConstraints();
	
	private Color corCinza = Color.GRAY;
	private Color corLaranja = Color.ORANGE;

	public Teclado() {
		setLayout(new GridBagLayout());
		
		bc.weightx = 1;
		bc.weighty = 1;
		bc.gridheight = 1;
		bc.gridwidth = 1;
		bc.fill = GridBagConstraints.BOTH;
		
		bc.gridwidth = 3;
		adicionarBotao("AC", corLaranja, 0, 0);
		bc.gridwidth = 1;
		adicionarBotao("/", corLaranja, 3, 0);

		adicionarBotao("7", corCinza, 0, 1);
		adicionarBotao("8", corCinza, 1, 1);
		adicionarBotao("9", corCinza, 2, 1);
		adicionarBotao("*", corLaranja, 3, 1);

		adicionarBotao("4", corCinza, 0, 2);
		adicionarBotao("5", corCinza, 1, 2);
		adicionarBotao("6", corCinza, 2, 2);
		adicionarBotao("-", corLaranja, 3, 2);
		
		adicionarBotao("1", corCinza, 0, 3);
		adicionarBotao("2", corCinza, 1, 3);
		adicionarBotao("3", corCinza, 2, 3);
		adicionarBotao("+", corLaranja, 3, 3);
		
		bc.gridwidth = 2;
		adicionarBotao("0", corCinza, 0, 4);
		bc.gridwidth = 1;
		adicionarBotao(",", corCinza, 2, 4);
		adicionarBotao("=", corLaranja, 3, 4);

	}

	private void adicionarBotao(String nome, Color cor, int x, int y) {

		Botao botao = new Botao(nome, cor);
		
		botao.addActionListener(this);
		bc.gridx = x;
		bc.gridy = y;
		add(botao, bc);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Historico.getObjetohistorico().gerarEvento(botao.getText());
		}
		
	}

}
