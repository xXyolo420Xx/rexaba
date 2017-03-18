package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import Juego.Dado;
import Juego.Jugador;
import Principal.Principal;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Juego extends JPanel{

	private JLabel lblBien, lblOp ;
	private JButton btnMenos, btnMas, btnMath, btnRep;
	private Dado[] rojo = new Dado[3];
	private Dado[] azul = new Dado[2];
	private Dado morado;
	private int res;
	private Jugador j1;
	private Principal wind;
	private JLabel lblRes;
	private JPanel contentPane;
	
	public Juego(Principal wind, Jugador j1) {
		this.contentPane= this;
		this.j1 = j1;
		this.wind = wind;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 140, 30, 140, 30, 140, 30, 150, 60, 150, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 60, 60, 30, 60, 60, 30, 60, 60, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 3.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblBien = new JLabel("");
		lblBien.setFont(new Font("Droid Serif", Font.BOLD, 22));
		lblBien.setText("Bienvenido al juego "+j1.getNombre());
		GridBagConstraints gbc_lblBien = new GridBagConstraints();
		gbc_lblBien.gridwidth = 3;
		gbc_lblBien.anchor = GridBagConstraints.SOUTH;
		gbc_lblBien.insets = new Insets(0, 0, 5, 5);
		gbc_lblBien.gridx = 7;
		gbc_lblBien.gridy = 0;
		add(lblBien, gbc_lblBien);
		
		btnMas = new JButton("+");
		btnMas.setName("btnMas");
		btnMas.setFont(new Font("Droid Serif", Font.BOLD, 50));
		btnMas.addMouseListener(new btnOp());
		GridBagConstraints gbc_btnMas = new GridBagConstraints();
		gbc_btnMas.fill = GridBagConstraints.BOTH;
		gbc_btnMas.insets = new Insets(0, 0, 5, 5);
		gbc_btnMas.gridx = 7;
		gbc_btnMas.gridy = 2;
		add(btnMas, gbc_btnMas);
		
		btnMenos = new JButton("-");
		btnMenos.setName("btnMenos");
		btnMenos.setFont(new Font("Droid Serif", Font.BOLD, 40));
		btnMenos.addMouseListener(new btnOp());
		GridBagConstraints gbc_btnMenos = new GridBagConstraints();
		gbc_btnMenos.fill = GridBagConstraints.BOTH;
		gbc_btnMenos.insets = new Insets(0, 0, 5, 5);
		gbc_btnMenos.gridx = 9;
		gbc_btnMenos.gridy = 2;
		add(btnMenos, gbc_btnMenos);
		
		lblOp = new JLabel("");
		lblOp.setFont(new Font("Droid Serif", Font.BOLD, 32));
		GridBagConstraints gbc_lblOp = new GridBagConstraints();
		gbc_lblOp.gridheight = 2;
		gbc_lblOp.gridwidth = 3;
		gbc_lblOp.insets = new Insets(0, 0, 5, 5);
		gbc_lblOp.gridx = 7;
		gbc_lblOp.gridy = 3;
		add(lblOp, gbc_lblOp);
		
		btnMath = new JButton("MATHDICE");
		btnMath.setEnabled(true);
		btnMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String full = lblOp.getText();
					String[] num = full.split("\\+|\\-");
					String[] ops = full.split("\\d");
					
					int numIndex = 0;
					int opsIndex = 0;
					int res = Integer.valueOf(num[numIndex]);
					if(num.length>1){
						while(!ops[opsIndex].matches("\\+|\\-") && opsIndex+1<= ops.length){
							opsIndex++;
						}
						
						while(numIndex<num.length-1){
							numIndex++;
							if(ops[opsIndex].matches("\\+")){
								res += Integer.valueOf(num[numIndex]);
							}else if(ops[opsIndex].matches("\\-")){
								res -= Integer.valueOf(num[numIndex]);
							}
							opsIndex++;
						}
						
						if(res == morado.getRnd()){
							lblRes.setText("Correcto");
						}else{
							lblRes.setText("Incorrecto, tu resultado es "+res);
						}
						for(Dado r:rojo){
							try{
								r.removeMouseListener(r.getMouseListeners()[0]);
							}catch(Exception err0){}
						}
						
						for(Dado a:azul){
							try{
							a.removeMouseListener(a.getMouseListeners()[0]);
							}catch(Exception err0){}
						}
						
						btnMenos.setEnabled(false);
						btnMas.setEnabled(false);
						btnMath.setEnabled(false);
						btnRep.setEnabled(true);
					}
					
				}catch(Exception a){}
				
			}
		});
		
		btnMath.setFont(new Font("Droid Serif", Font.BOLD, 40));
		GridBagConstraints gbc_btnMathdice = new GridBagConstraints();
		gbc_btnMathdice.fill = GridBagConstraints.BOTH;
		gbc_btnMathdice.gridwidth = 3;
		gbc_btnMathdice.insets = new Insets(0, 0, 5, 5);
		gbc_btnMathdice.gridx = 7;
		gbc_btnMathdice.gridy = 5;
		add(btnMath, gbc_btnMathdice);
		
		lblRes = new JLabel("");
		lblRes.setFont(new Font("Droid Serif", Font.BOLD, 25));
		GridBagConstraints gbc_lblRes = new GridBagConstraints();
		gbc_lblRes.gridwidth = 3;
		gbc_lblRes.insets = new Insets(0, 0, 5, 5);
		gbc_lblRes.gridx = 7;
		gbc_lblRes.gridy = 7;
		add(lblRes, gbc_lblRes);
		
		btnRep = new JButton("REPETIR");
		btnRep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Dado r:rojo){
					contentPane.remove(r);
				}
				for(Dado a:azul){
					contentPane.remove(a);
				}
				contentPane.remove(morado);
				btnMas.setEnabled(true);
				btnMenos.setEnabled(true);
				btnMath.setEnabled(true);
				btnRep.setEnabled(false);
				lblOp.setText("");
				lblRes.setText("");
				iniciarDados();
				revalidate();
				repaint();
			}
		});
		btnRep.setFont(new Font("Droid Serif", Font.BOLD, 40));
		btnRep.setEnabled(false);
		GridBagConstraints gbc_btnRep = new GridBagConstraints();
		gbc_btnRep.fill = GridBagConstraints.BOTH;
		gbc_btnRep.gridwidth = 3;
		gbc_btnRep.insets = new Insets(0, 0, 5, 5);
		gbc_btnRep.gridx = 7;
		gbc_btnRep.gridy = 8;
		add(btnRep, gbc_btnRep);
		iniciarDados();
		}
	
		private void iniciarDados(){
			
			int col = 1;
			for(int i=0;i<rojo.length;i++){
				rojo[i] = new Dado("r");			
				GridBagConstraints gbc_lblRojo = new GridBagConstraints();
				gbc_lblRojo.gridheight = 2;
				gbc_lblRojo.anchor = GridBagConstraints.SOUTH;
				gbc_lblRojo.insets = new Insets(0, 0, 5, 5);
				gbc_lblRojo.gridx = col;
				gbc_lblRojo.gridy = 1;
				rojo[i].addMouseListener(new click());
				add(rojo[i], gbc_lblRojo);
				col=col+2;
			}
			
			col = 1;
			for(int i=0;i<azul.length;i++){
				azul[i] = new Dado("a");
				GridBagConstraints gbc_lblAzul = new GridBagConstraints();
				gbc_lblAzul.anchor = GridBagConstraints.SOUTH;
				gbc_lblAzul.gridheight = 2;
				gbc_lblAzul.insets = new Insets(0, 0, 5, 5);
				gbc_lblAzul.gridx = col;
				gbc_lblAzul.gridy = 4;
				add(azul[i], gbc_lblAzul);
				col=col+2;
				azul[i].addMouseListener(new click());
			}
			
			col = 1;
			//MORADO
			morado = new Dado("m");
			GridBagConstraints gbc_lblMorado = new GridBagConstraints();
			gbc_lblMorado.gridheight = 2;
			gbc_lblMorado.anchor = GridBagConstraints.SOUTH;
			gbc_lblMorado.insets = new Insets(0, 0, 5, 5);
			gbc_lblMorado.gridx = 1;
			gbc_lblMorado.gridy = 7;
			add(morado, gbc_lblMorado);
		}
	
	private class click implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			btnRep.setEnabled(false);
			Dado d = ((Dado) e.getSource());
			String oldtxt = lblOp.getText();
			Boolean vacio = false;
			String txt = null;
			try{
				txt = oldtxt.substring(oldtxt.length()-1);
			}catch(Exception err){vacio = true;}
			
			try{
				if(vacio || txt.matches("\\-|\\+")){
					d.grey();
					d.removeMouseListener(this);
					lblOp.setText(oldtxt+String.valueOf(d.getRnd()));
				}
			}catch(Exception err1){};
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {			
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}	
	}
	
	private class btnOp implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton d = (JButton)e.getSource();
			try{
				String full = lblOp.getText();
				String last = full.substring(full.length()-1);
				String antep = full.substring(0, full.length()-1);
				
				switch(d.getName()){
				case "btnMas":
					if(last.matches("\\d")){
						lblOp.setText(full+"+");
					}else if(last.matches("\\-")){
						lblOp.setText(antep+"+");
					}
					break;
				case "btnMenos":
					if(last.matches("\\d")){
						lblOp.setText(full+"-");
					}else if(last.matches("\\+")){
						lblOp.setText(antep+"-");
					}
				}
			}catch(Exception err0){}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
}
