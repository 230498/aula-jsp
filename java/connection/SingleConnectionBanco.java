package connection;

import java.sql.Connection;
import java.sql.DriverManager;

//Conex�o com o servidor ao startar(Conex�o com Banco)

public class SingleConnectionBanco {
	
	//
	private static String banco = "jdbc:postgresql://localhost:5433/aula-jsp?autoReconnect=true"; // Endere�o do banco/caminho/Nome do Banco
	private static String user = "postgres"; //usu�rio administrador
	private static String senha = "123456";  //Senha instala��o
	private static Connection connection = null; //Vari�vel cria conex�o
	
//cria objeto DAO, ELE PUXA A CONEX�O
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	
	public SingleConnectionBanco() {/*quando tiver um instancia vai conectar*/
		conectar();
	}
	
	
	private static void conectar() {
		
		try {
			
			if(connection == null) { //conex�o ativa?
				Class.forName("org.postgresql.Driver"); /*Carrega o driver de conex�o do banco, criar drive postgre*/ 
				connection = DriverManager.getConnection(banco, user, senha);//objeto de conex�o criado
				connection.setAutoCommit(false); /*para nao efetuar alteracoes no banco sem nosso comando*/
			}
			
		}catch (Exception e) {
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
		}
	}

}
