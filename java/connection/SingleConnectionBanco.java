package connection;

import java.sql.Connection;
import java.sql.DriverManager;

//Conexão com o servidor ao startar(Conexão com Banco)

public class SingleConnectionBanco {
	
	//
	private static String banco = "jdbc:postgresql://localhost:5433/aula-jsp?autoReconnect=true"; // Endereço do banco/caminho/Nome do Banco
	private static String user = "postgres"; //usuário administrador
	private static String senha = "123456";  //Senha instalação
	private static Connection connection = null; //Variável cria conexão
	
//cria objeto DAO, ELE PUXA A CONEXÃO
	
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
			
			if(connection == null) { //conexão ativa?
				Class.forName("org.postgresql.Driver"); /*Carrega o driver de conexão do banco, criar drive postgre*/ 
				connection = DriverManager.getConnection(banco, user, senha);//objeto de conexão criado
				connection.setAutoCommit(false); /*para nao efetuar alteracoes no banco sem nosso comando*/
			}
			
		}catch (Exception e) {
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
		}
	}

}
