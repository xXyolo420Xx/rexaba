package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import Ventanas.Juego;
import Ventanas.Registro;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 381);
		setResizable(false);
		Registro reg = new Registro(this);
		setContentPane(reg);
	}

	public void startJuego(Jugador j1) {
		Juego joc = new Juego(this, j1);
		setResizable(true);
		setBounds(100, 100, 1157, 554);
		this.setMinimumSize(getSize());
		setContentPane(joc);
		revalidate();
		repaint();
	}

}
