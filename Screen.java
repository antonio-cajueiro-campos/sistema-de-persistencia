import java.util.ArrayList;
import java.util.Arrays;

public class Screen {
	public static final ArrayList<String> INITIAL = new ArrayList<>(Arrays.asList(
			"\tBem vindo ao sistema de cadastro e persistencia de informações com timestamp",
			"\t\t\t-----------------------------------------",
			"\t\t\t|\t Você possui uma conta?\t\t|",
			"\t\t\t|\t\t\t\t\t|",
			"\t\t\t|\t     1-Sim ou 2-Não\t\t|",
			"\t\t\t-----------------------------------------")
	);

	public static final ArrayList<String> LEAVE = new ArrayList<>(Arrays.asList(
		"\tCadastre-se agora para poder persistir seus dados em nosso sistema", 
		"\t\t\t-----------------------------------------", 
		"\t\t\t|\t  O que pretende fazer?\t\t|", 
		"\t\t\t|\t\t\t\t\t|", 
		"\t\t\t|\t     1-Cadastrar\t\t|", 
		"\t\t\t|\t     2-Voltar\t\t\t|", 
		"\t\t\t|\t     3-Sair\t\t\t|", 
		"\t\t\t-----------------------------------------")
	);

	public static final ArrayList<String> REGISTER = new ArrayList<>(Arrays.asList("---", "----"));
}
