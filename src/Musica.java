import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Musica {

    public static void playMusic(String filepath) {
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Reproducir en bucle
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            System.out.println("Reproduciendo música de fondo...");

            // Mantener el programa abierto hasta que el usuario presione Enter
            System.out.println("Presiona ENTER para detener la música.");
            System.in.read();

            clip.stop();
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
