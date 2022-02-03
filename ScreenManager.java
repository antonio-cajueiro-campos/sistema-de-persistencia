import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class ScreenManager {

	public static final String os = System.getProperty("os.name");
	public static final Scanner scan = new Scanner(System.in);
	
	public static String createScreenContext(int screenId) {
		boolean isError = false;
		String[] retorno = {"true", null};
		
		do {
			ArrayList<String> validOptions = showScreen(screenId, isError);
			retorno = inputReader(validOptions);
			
		} while (Boolean.parseBoolean(retorno[0]));

		return retorno[1];
	}
	
	public static String[] inputReader(ArrayList<String> validOptions) {
		String input = scan.next();

		Boolean isError = validOptions.stream().noneMatch(op -> op.equals(input));
			
		if (isError) playSound("error"); else playSound("ok");

		String[] retorno = {isError.toString(), input};
		return retorno;
	}

	public final static void setTitle(String titleName) {
		if (os.contains("Windows")) {
			try {
				new ProcessBuilder("cmd", "/c", "title "+titleName).inheritIO().start().waitFor();
			}
			catch (InterruptedException e) {}
			catch (IOException e) {}
		}
	}

	public final static void cleanScreen() {
		try {
			if (os.contains("Windows")) {
				try {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} catch (InterruptedException e) {}
			} else Runtime.getRuntime().exec("clear");

		} catch (IOException e) {}
		System.out.println("\r\n");
	}

	public static final synchronized void playSound(String soundName) {
		new Thread(new Runnable() {
		 	public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(MainSystem.class.getResourceAsStream("sounds/"+soundName+".wav"));
					clip.open(inputStream);

					FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					float volume = -28f;
					if (soundName == "hello" || soundName == "bye") volume = -10f;
					volumeControl.setValue(volume);

					clip.start();
				} catch (Exception e) {}
			}
		}).start();
	}

	public static final ArrayList<String> showScreen(int indice, boolean isError) {
		cleanScreen();

		ArrayList<ArrayList<String>> telas = new ArrayList<>(Arrays.asList(Screen.INITIAL, Screen.LEAVE, Screen.REGISTER, Screen.LOGIN, Screen.PROFILE));

		telas.get(indice).stream().forEach(System.out::println);
		if (isError) System.out.println("\r\tDigite uma reposta válida");
		System.out.print("\t>: ");
		return Screen.VALID_OPTIONS.get(indice);
	}
}
