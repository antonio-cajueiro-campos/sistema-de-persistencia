import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class ScreenManager {

	public static final String os = System.getProperty("os.name"); 
	private static final Scanner scan = new Scanner(System.in);
	
	public static int createScreenContext(int screenId, int optionsNumber) {
		int retorno = 0;
		boolean isError = false;

		do {
			showScreen(screenId, isError);
			try {
				retorno = scan.nextInt();
				if (retorno < 1 || retorno > optionsNumber) throw new InputMismatchException();
			} catch (InputMismatchException e) {
				playSound("error");
				isError = true;
				scan.nextLine();
			}
		} while (retorno < 1 || retorno > optionsNumber);
		playSound("ok");
		return retorno;
	}

	public final static void setTitle(String titleName) {
		if (os.contains("Windows 10")) {
			try {
				new ProcessBuilder("cmd", "/c", "title "+titleName).inheritIO().start().waitFor();
			}
			catch (InterruptedException e) {}
			catch (IOException e) {}
		}
	}

	public final static void cleanScreen() {
		try {
			if (os.contains("Windows 10")) {
				try {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} catch (InterruptedException e) {}
			}
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException e) {}
		System.out.println("\r\n");
	}

	public static synchronized void playSound(String soundName) {
		new Thread(new Runnable() {
		 	public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(MainSystem.class.getResourceAsStream("/sounds/"+soundName+".wav"));
					clip.open(inputStream);

					FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					volumeControl.setValue(-28f);

					clip.start();
				} catch (Exception e) {}
			}
		}).start();
	}

	public static void showScreen(int indice, boolean isError) {
		cleanScreen();

		ArrayList<ArrayList<String>> telas = new ArrayList<>(Arrays.asList(Screen.INITIAL, Screen.LEAVE, Screen.REGISTER));

		telas.get(indice).stream().forEach(System.out::println);
		if (isError) System.out.println("\r\tDigite uma reposta válida");
		System.out.print("\tResposta: ");
	}
}
