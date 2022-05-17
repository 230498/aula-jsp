package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnectionBanco;

public class DAOProdutosRepository {

	// responsavel por coletar os dados do banco

	private Connection connection;

	public DAOProdutosRepository() {

		// Pega conexão
		connection = SingleConnectionBanco.getConnection();
	}

	public List<String> getProdutos() throws Exception {
		
		List<String> produtos = new ArrayList<>();

		String sql = "select * from model_produtos";
		PreparedStatement statement = connection.prepareStatement(sql);

		 //Retorna um objeto ResultSet. Use este método quando você espera obter um conjunto de resultados, como faria com uma instrução SELECT.
		ResultSet resultSet = statement.executeQuery();
        
		
		 while (resultSet.next()) {
		 produtos.add(resultSet.getString("nome"));
    
	
		}
		return produtos;

	}

}






/*String produtos =" ";

while (resultSet.next()) {
produtos += resultSet.getString("nome") + ";  \n";


}
return produtos;

}

}
*/

