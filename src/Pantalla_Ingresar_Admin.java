import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pantalla_Ingresar_Admin extends JPanel {


	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);
	protected String fuente= "Niagara Engraved";
	JLabel fondo;
	JButton boton_conf = new JButton("AJUSTES");
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;




	public Pantalla_Ingresar_Admin(int num_fondo, int num_musica) {
		setBackground(new Color(199, 21, 133));
		setBounds(100, 100, 1122, 650);
		setLayout(null);
		
		JButton boton_volver = new JButton("VOLVER");
		boton_volver.setForeground(new Color(199, 21, 133));
		boton_volver.setBounds(10, 55, 122, 27);
		boton_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Menu_Admin (num_fondo,num_musica));
				
			}
		});
		boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_volver.setBackground(Color.PINK);
		add(boton_volver);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cuerpo", "Ojos", "Cejas", "Boca", "Vello", "Tatuaje", "Piercing", "Capa", "Peinado", "Pantalon", "Sombrero", "Lentes", "Calcetas", "Top", "Calzado"}));
		comboBox.setBounds(835, 151, 208, 31);
		comboBox.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		comboBox.setForeground(Color.PINK);
		comboBox.setBackground(Color.BLACK);
		add(comboBox);
		
		

		JButton boton_ingresar = new JButton("INGRESAR");
		boton_ingresar.setForeground(new Color(199, 21, 133));
		boton_ingresar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_ingresar.setBackground(Color.PINK);
		boton_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		boton_ingresar.setBounds(921, 226, 122, 27);
		add(boton_ingresar);
		
		JTextField textField = new JTextField(" ");
		textField.setForeground(new Color(199, 21, 133));
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBackground(Color.PINK);
		textField.setBounds(174, 151, 286, 33);
		add(textField);
		
		
		JLabel lblNewLabel = new JLabel("Ingresa nombre");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(174, 121, 208, 33);
		add(lblNewLabel);
		
		textField_1 = new JTextField(" ");
		textField_1.setForeground(new Color(199, 21, 133));
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.PINK);
		textField_1.setBounds(174, 224, 286, 33);
		add(textField_1);
		
		JLabel lblNewLabel4 = new JLabel("Ingresa nombre del archivo");
		lblNewLabel4.setOpaque(true);
		lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel4.setForeground(Color.PINK);
		lblNewLabel4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel4.setBackground(Color.BLACK);
		lblNewLabel4.setBounds(174, 194, 208, 33);
		add(lblNewLabel4);
		
		textField_2 = new JTextField(" ");
		textField_2.setForeground(new Color(199, 21, 133));
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.PINK);
		textField_2.setBounds(503, 151, 286, 33);
		add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa puntaje");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(503, 121, 208, 33);
		add(lblNewLabel_1);
		
		
		textField_3 = new JTextField(" ");
		textField_3.setForeground(new Color(199, 21, 133));
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.PINK);
		textField_3.setBounds(503, 224, 286, 33);
		add(textField_3);
		
		JLabel lblNewLabel_11 = new JLabel("Ingresa descripcion");
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setForeground(Color.PINK);
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_11.setBackground(Color.BLACK);
		lblNewLabel_11.setBounds(503, 194, 208, 33);
		add(lblNewLabel_11);
		this.add_fondo(num_fondo);
		//this.boton_ajustes(0,new Usuario (),num_fondo,num_musica);
	}

	
	public void add_fondo (int num_fondo) {
		System.out.println(""+num_fondo);
		JLabel fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.CENTER);
		fondo.setIcon(imagenes.getfondo(""+num_fondo));
		fondo.setBorder(null);
		fondo.setBounds(0, 0, 1134, 650);
		add(fondo);
		
		
		
	

	}
	
	public void botonframe (JPanel b) {
		removeAll();
		setLayout(new BorderLayout(0, 0));
		add(b);
		repaint();
		revalidate();
	}
}
