package br.com.vitor.calculadora.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton {

	public Botao(String num, Color cor) {
		
		setText(num);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(cor);
		setOpaque(true);
		setFont(new Font("courier", Font.PLAIN, 19));
	}
}
