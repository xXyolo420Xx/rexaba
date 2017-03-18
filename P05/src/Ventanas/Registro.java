package Ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Juego.Jugador;
import Principal.Principal;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.UIManager;

public class Registro extends JPanel {
	
	private JTextField txtApellido, txtEdad, txtNombre;
	private JTextArea txtRes;
	private String nombre, edad, apellido;
	private int edad_num;
	
	public Registro(Principal wind) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 0, 44, 211, 80, 0};
		gridBagLayout.rowHeights = new int[]{54, 24, 31, 0, 0, 0, 82, 31, 34, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		JLabel lblRegistro = new JLabel("Registro del jugador");
		lblRegistro.setFont(new Font("Liberation Serif", Font.BOLD, 32));
		lblRegistro.setBounds(12, 12, 156, 15);
		GridBagConstraints gbc_lblRegistro = new GridBagConstraints();
		gbc_lblRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistro.gridwidth = 5;
		gbc_lblRegistro.gridx = 0;
		gbc_lblRegistro.gridy = 0;
		add(lblRegistro, gbc_lblRegistro);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lblNombre.setBounds(12, 60, 66, 15);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		txtNombre.setBounds(96, 58, 124, 19);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.anchor = GridBagConstraints.NORTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lblApellidos.setBounds(12, 115, 66, 15);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 3;
		add(lblApellidos, gbc_lblApellidos);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		txtApellido.setBounds(96, 113, 124, 19);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.anchor = GridBagConstraints.NORTH;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 3;
		add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lblEdad.setBounds(12, 171, 66, 15);
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 4;
		add(lblEdad, gbc_lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		txtEdad.setBounds(96, 169, 124, 19);
		GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEdad.anchor = GridBagConstraints.NORTH;
		gbc_txtEdad.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad.gridx = 2;
		gbc_txtEdad.gridy = 4;
		add(txtEdad, gbc_txtEdad);
		txtEdad.setColumns(10);
		
		JButton btnReg = new JButton("Registrarse");
		btnReg.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
				LinkedList<String> result = new LinkedList<String>();
				txtRes.setText("");
				
				edad = txtEdad.getText();
				try{edad_num = Integer.valueOf(edad);}catch(Exception e){};
				nombre = txtNombre.getText();
				apellido = txtApellido.getText();
				
				if(edad.matches("\\d+")){
					if(edad_num < 0){
						result.add("La edad no puede ser negativa.");
					}else if(edad_num > 120){
						result.add("No me creo que tengas mas de 120 años");
					}
				}else{
					result.add("Introduce una edad válida");
				}
				if(nombre.length() < 3){
					result.add("El nombre no es válido");
				}
				if(apellido.length()<4){
					result.add("Los apellidos no son válidos");
				}
				if(result.isEmpty()){
					Jugador j1 = new Jugador();
					j1.setNombre(nombre);
					j1.setApellido(apellido);
					j1.setEdad(edad_num);
					j1.setPuntos(0);
					wind.startJuego(j1);
				}else{
					for(int i=0;i<result.size();i++){
						txtRes.setText(txtRes.getText()+"·"+result.get(i)+"\n");
					}
				}				
			}
		});
		GridBagConstraints gbc_btnReg = new GridBagConstraints();
		gbc_btnReg.insets = new Insets(0, 0, 5, 5);
		gbc_btnReg.gridx = 2;
		gbc_btnReg.gridy = 6;
		add(btnReg, gbc_btnReg);
		
		txtRes = new JTextArea();
		txtRes.setBackground(UIManager.getColor("Panel.background"));
		txtRes.setForeground(Color.RED);
		txtRes.setEditable(false);
		GridBagConstraints gbc_txtRes = new GridBagConstraints();
		gbc_txtRes.gridwidth = 2;
		gbc_txtRes.insets = new Insets(0, 0, 5, 5);
		gbc_txtRes.fill = GridBagConstraints.BOTH;
		gbc_txtRes.gridx = 2;
		gbc_txtRes.gridy = 7;
		add(txtRes, gbc_txtRes);
		txtNombre.setText("Simeon");
		txtApellido.setText("Shopov");
		txtEdad.setText("23");
	}
	}
