import java.io.IOException;

public class MainSystem {
	
	public static void main(String[] args) throws IOException {
		ScreenManager.setTitle("Sistema de Persistência de Dados - Antonio Carlos");
		initScreen();
    }
	
	public static void initScreen() {
		int retorno = ScreenManager.createScreenContext(0, 2);

		if (retorno == 2)
		leaveScreen();
		else
		loginScreen();
	}
	
	public static void leaveScreen() {
		int retorno = ScreenManager.createScreenContext(1, 3);

		if (retorno == 1) {
			registerScreen();
		} else if (retorno == 2) {
			initScreen();
		} else	System.exit(0);

	}

	public static void loginScreen() {

	}

	public static void registerScreen() {

	}

	public static void profileScreen(String username) {

	}	
}
