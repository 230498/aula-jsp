package servlets;

import java.io.IOException;

import dao.DAOProdutosRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelProdutos;

/**
 * Servlet implementation class ServletProdutos
 */
@WebServlet(urlPatterns = { "/principal/ServletProdutos", "/ServletProdutos" })
public class ServletProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProdutos() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			DAOProdutosRepository produtos = new DAOProdutosRepository(); //CRIAÇÃO DO OBJETO DE REPOSITÓRIO DENTRO DO SERVLET DE CONTROLE
			String produto = request.getParameter("produto");

			if (produto != null && !produto.isEmpty()) { // VERIFICA SE O CAMPO PARA RECEBER O PRODUTO ESTÁ VAZIO.

				ModelProdutos modelproduto = new ModelProdutos();//CRIA UM OBJETO PRODUTO
				modelproduto.setNome(produto);                   //SETA PARA O OBJETO O NOME DIGITADO PELO USUÁRIO.
				produtos.setProdutos(modelproduto);              //SETAR PARA O OBJETO O VALOR DA CLASSE MODELPRODUTO

				//RETORNA NA TELA DE CADASTRO A MENSAGEM DE VALIDAÇÃO DO CADASTRO.
				RequestDispatcher redirecionar = request.getRequestDispatcher("cadastro.jsp");
				request.setAttribute("msg", "\"Produto Cadastrado com sucesso!\"");
				redirecionar.forward(request, response);

			} else {
				///RETORNA PARA A TELA DE LOGIN E EXIBE MENSAGEM AO USUÁRIO CASO O CAMPO "NOME PRODUTO" ESTIVER VAZIO.
				RequestDispatcher redirecionar = request.getRequestDispatcher("cadastro.jsp"); 
				request.setAttribute("msg", "Informe o nome do produto corretamente!");
				redirecionar.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}