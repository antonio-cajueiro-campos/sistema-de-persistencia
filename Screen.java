import java.util.ArrayList;
import java.util.Arrays;

public class Screen {

	private static final ArrayList<String> INITIAL_OP = new ArrayList<>(Arrays.asList("1", "2"));
	private static final ArrayList<String> LEAVE_OP = new ArrayList<>(Arrays.asList("1", "2", "3"));
	private static final ArrayList<String> REGISTER_OP = new ArrayList<>(Arrays.asList("1", "register"));
	private static final ArrayList<String> LOGIN_OP = new ArrayList<>(Arrays.asList("1", "login"));
	private static final ArrayList<String> PROFILE_OP = new ArrayList<>(Arrays.asList("1", "2"));
	private static final ArrayList<String> PROFILE_INFO_OP = new ArrayList<>(Arrays.asList("1"));

	private static String user = null;

	public static final ArrayList<ArrayList<String>> VALID_OPTIONS = new ArrayList<>(Arrays.asList(INITIAL_OP, LEAVE_OP, REGISTER_OP, LOGIN_OP, PROFILE_OP, PROFILE_INFO_OP));

	public static final ArrayList<String> INITIAL = new ArrayList<>(Arrays.asList(
			"\tBem vindo ao sistema de cadastro e persistencia de informações com timestamp",
			"\t\t\t-----------------------------------------",
			"\t\t\t|\t  Você possui uma conta?\t|",
			"\t\t\t|\t\t\t\t\t|",
			"\t\t\t|\t  1-Sim\t\t\t\t|",
			"\t\t\t|\t  2-Não\t\t\t\t|",
			"\t\t\t-----------------------------------------")
	);

	public static final ArrayList<String> LEAVE = new ArrayList<>(Arrays.asList(
		"\tCadastre-se agora para poder persistir seus dados com timestamp em nosso sistema", 
		"\t\t\t-----------------------------------------", 
		"\t\t\t|\t  O que pretende fazer?\t\t|", 
		"\t\t\t|\t\t\t\t\t|", 
		"\t\t\t|\t  1-Cadastrar\t\t\t|", 
		"\t\t\t|\t  2-Voltar\t\t\t|", 
		"\t\t\t|\t  3-Sair\t\t\t|", 
		"\t\t\t-----------------------------------------")
	);

	public static final ArrayList<String> REGISTER = new ArrayList<>(Arrays.asList(
		"\t\t\tSessão de cadastro", 
		"\t\t\t-----------------------------------------", 
		"\t\t\t|\t  Digite o seu username\t\t|", 
		"\t\t\t|\t\t\t\t\t|", 
		"\t\t\t|\t  1-Cancelar\t\t\t|",
		"\t\t\t-----------------------------------------")
	);

	public static final ArrayList<String> LOGIN = new ArrayList<>(Arrays.asList(
		"\t\t\tSessão de login", 
		"\t\t\t-----------------------------------------", 
		"\t\t\t|\t  Digite o seu username\t\t|", 
		"\t\t\t|\t\t\t\t\t|", 
		"\t\t\t|\t  1-Cancelar\t\t\t|",
		"\t\t\t-----------------------------------------")
	);

	public static final ArrayList<String> PROFILE = new ArrayList<>(Arrays.asList(
		"\t\t\tPerfil de " + user, 
		"\t\t\t-----------------------------------------", 
		"\t\t\t|\t  Bem vindo ao seu perfil\t\t|", 
		"\t\t\t|\t\t\t\t\t|", 
		"\t\t\t|\t  1-Ver infos\t\t\t|",
		"\t\t\t|\t  2-Logout\t\t\t|",
		"\t\t\t-----------------------------------------")
	);

	public static final ArrayList<String> PROFILE_INFOS = new ArrayList<>(Arrays.asList(
		"\t\t\tPerfil de " + user, 
		"\t\t\t-----------------------------------------", 
		"\t\t\t|\t  Bem vindo ao seu perfil\t\t|", 
		"\t\t\t|\t\t\t\t\t|", 
		"\t\t\t|\t  1-Voltar\t\t\t|",
		"\t\t\t-----------------------------------------")
	);
}
