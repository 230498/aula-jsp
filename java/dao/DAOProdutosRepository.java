package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnectionBanco;
import model.ModelProdutos;

     // ESTRUTURA RESPONS�VEL POR REALIZAR TODAS AS OPERA��ES COM O BANCO DE DADOS
public class DAOProdutosRepository {



	private Connection connection;

	public DAOProdutosRepository() {

	//PEGAR CONEX�O
		connection = SingleConnectionBanco.getConnection();
	}

	// READ
	// M�TODO PARA RETORNAR TODOS OS REGISTROS CADASTRADOS NO BANCO DE DADOS

	public List<String> getProdutos() throws Exception {

		List<String> produtos = new ArrayList<>();

		String sql = "select * from model_produtos";
		PreparedStatement statement = connection.prepareStatement(sql);

		// M�TODO QUE ESPERA OBTER UM CONJUNTO DE RESULTADOS(COMO UMA INSTRU��O SELECT)
		ResultSet resultSet = statement.executeQuery();

		// PERCORRER EM TODOS OS REGISTROS CADASTRADOS NO BANCO E ADICIONAR NA LISTA
		while (resultSet.next()) {
			produtos.add(resultSet.getString("nome"));

		}
		// RETORNA LISTA DE PRODUTOS
		return produtos;

	}

	// INSERT
	// M�TODO PARA INSERIR O PRODUTO DIGITADO NA TELA NO BANCO DE DADOS
	public void setProdutos(ModelProdutos produtos) throws Exception {

		String sql = "insert into model_produtos (nome) values (?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, produtos.getNome());

		statement.execute();
		connection.commit();
		statement.close();

	}

}
