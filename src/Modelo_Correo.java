import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.util.Random;

public class Modelo_Correo {
	private static Modelo_Correo instancia;
	private final String remitente;
    private final String clave;
    private String asunto;
    private String cuerpo;
    private String [] codigos= new String [5];
    
    public Modelo_Correo (String remitente, String clave) {
        this.remitente = remitente;
        this.clave = clave;
    	codigos[0]="ZXM28";
    	codigos[1]="GLP39";
    	codigos[2]="YUI40";
    }
    
    public Modelo_Correo() {
    	//rfqa pjuc skac lutp 
        this.remitente = "carpiodkm@gmail.com";
        this.clave = "rfqapjucskaclutp" ;
    	codigos[0]="ZXM28";
    	codigos[1]="GLP39";
    	codigos[2]="YUI40";
    	codigos[3]="DRE78";
    	codigos[4]="NANAMI44";
    }
	
	public static Modelo_Correo getInstancia () {
		if (instancia==null) {
			instancia=new Modelo_Correo();
		}
			return instancia;
		}
	
	public int verificar_Codigo (String codigo) {
    	
    	int band=0;
    	
    	for (int i=0;i<5;i++) {
    		System.out.println(""+ codigo+" vs "+codigos[i]);
    		if (codigo.equals(codigos[i])) {
    			band=1;
    		}
    	}
    	
    	
    	return band;
    }
	
    public int enviarCorreo(String destinatario) {
    	int re=0;
    	Random rand = new Random();
    	int numero = rand.nextInt(5); // devuelve 0, 1 o 2
    	asunto="Dressing Up! Recuperación de contraseña 😎";
    	cuerpo="Has solicitado recuperar tu contraseña🥰. \nPara verificar que eres tu, ingresa el siguiente codigo: "+codigos[numero]+"\nGracias por jugar Dressing Up!😊";
    	
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            Transport.send(mensaje);

            re=1;
            System.out.println("Correo enviado exitosamente a " + destinatario);
        } catch (MessagingException e) {
            System.err.println("Error al enviar el correo:");
           re=0;
        }
        
        return re;
    }
    
  

}
