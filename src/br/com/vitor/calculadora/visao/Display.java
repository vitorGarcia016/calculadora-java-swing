package br.com.vitor.calculadora.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.vitor.calculadora.modelo.Historico;
import br.com.vitor.calculadora.modelo.Observe;

@SuppressWarnings("serial")
public class Display extends JPanel implements Observe{

	private JLabel label;

	public Display() {
		Historico.getObjetohistorico().registrarObserve(this);
		
		label = new JLabel(Historico.getObjetohistorico().getNumeroAtual());
		label.setFont(new Font("courier", Font.PLAIN, 30));
		label.setForeground(Color.WHITE);

		setBackground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 30));

		add(label);
	}
	
	@Override
	public void atualizarDisplay(String valor) {
		label.setText(valor);
		
	}
}
