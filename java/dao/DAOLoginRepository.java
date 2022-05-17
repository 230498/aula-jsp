package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOLoginRepository {
	
	// responsavel por coletar os dados do banco
	
	private Connection connection;
	
	
	public DAOLoginRepository() {
		//Pega conex�o
		connection = SingleConnectionBanco.getConnection();
	}
	
	
	public boolean validarAutenticacao(ModelLogin modelLogin) throws Exception {
		
		//Valida��o
		String sql = "select * from model_login where upper(login) = upper(?) and upper(senha) = upper(?) ";
		
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
		
		//classe que verifica se os estados s�o verdadeiros ou falsos
		ResultSet resultSet = statement.executeQuery();
		
		
		// usu�rio autenticado
		if (resultSet.next()) {
			return true;/*autenticado*/
		}
		// usu�rio que a pessoa passou n�o est� no Banco
		return false; /*nao autenticado*/
	}

}
