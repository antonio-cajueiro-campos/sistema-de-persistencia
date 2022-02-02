import java.io.IOException;

public class MainSystem {	
	public static void main(String[] args) throws IOException {
		ScreenManager.setTitle("Sistema de Persistência de Dados - Antonio Carlos");
		ScreenManager.playSound("hello");
		initScreen();
	}
	
	public static void initScreen() {
		String input = ScreenManager.createScreenContext(0);

		if (input.equals("2"))
		leaveScreen();
		else
		loginScreen();
	}
	
	public static void leaveScreen() {
		String input = ScreenManager.createScreenContext(1);

		if (input.equals("1")) {
			registerScreen();
		} else if (input.equals("2")) {
			initScreen();
		} else {
			try {
				ScreenManager.playSound("bye"); Thread.sleep(1000); System.exit(0);
			} catch (InterruptedException e) {}
		}
	}

	public static void registerScreen() {
		String input = ScreenManager.createScreenContext(2);

		if (input.equals("1")) {
			initScreen();
		} else {
			//salvar username			
		}
	}

	public static void loginScreen() {
		String input = ScreenManager.createScreenContext(3);

		if (input.equals("1")) {
			initScreen();
		} else {
			//salvar username			
		}
	}


	public static void profileScreen(String username) {
		String input = ScreenManager.createScreenContext(4);

		if (input.equals("1")) {
			profileInfosScreen(username);
		} else {
			initScreen();
		}
	}

	public static void profileInfosScreen(String username) {
		String input = ScreenManager.createScreenContext(4);

		if (input.equals("1")) {
			profileScreen(username);
		}
	}	
}
