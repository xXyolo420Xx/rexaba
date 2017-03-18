package Juego;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado extends JLabel{
	
	Random gen = new Random();
	private int rnd;
	private ImageIcon icono;
	public Dado(String tipo) {
		switch(tipo){
			case "m":
				rnd = gen.nextInt(12)+1;
				icono = new ImageIcon(getClass().getResource("/img/"+String.valueOf(rnd)+"m.png"));
				setIcon(icono);
				break;
			case "r":
				rnd = gen.nextInt(6)+1;
				icono = new ImageIcon(getClass().getResource("/img/"+String.valueOf(rnd)+"r.jpg"));
				setIcon(icono);
				break;
			case "a":
				rnd = gen.nextInt(3)+1;
				icono = new ImageIcon(getClass().getResource("/img/"+String.valueOf(rnd)+"a.jpg"));
				setIcon(icono);
		}
	}
	public int getRnd(){
		return this.rnd;
	}
	
	public void grey(){
		setIcon(new ImageIcon(getClass().getResource("/img/gris.jpg")));
	}
	
}
