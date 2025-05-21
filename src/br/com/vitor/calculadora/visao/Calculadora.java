package br.com.vitor.calculadora.visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{

	public Calculadora() {
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		organizarComponentes();
		setVisible(true);
	}
	
	private void organizarComponentes() {
		setLayout(new BorderLayout());
		setTitle("Calculadora");
		Display display = new Display();
		display.setPreferredSize(new Dimension(200, 70));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		new Calculadora();
	}
}
