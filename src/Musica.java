import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Musica {

    private static Clip clip; // Make clip a class field so we can control it later

    public static void playMusic(String filepath) {
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Reproducir en bucle
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            System.out.println("Reproduciendo música de fondo...");

            // Wait while the music plays (or add controls to stop it)
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (clip != null) {
                    clip.stop();
                    clip.close();
                }
            }));

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("ERROR REPRODUCIENDO MUSICA: " + e.getMessage());
        }
    }

    public static void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
            System.out.println("Música detenida.");
        }
    }

}