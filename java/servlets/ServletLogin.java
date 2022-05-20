package servlets;

import java.io.IOException;

import dao.DAOLoginRepository;
import dao.DAOProdutosRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

/*O chamando Controller são as servlets ou ServletLoginController*/
@WebServlet(urlPatterns = { "/principal/ServletLogin", "/ServletLogin" }) /* Mapeamento de URL que vem da tela */
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();
	private DAOProdutosRepository daoProdutosRepository = new DAOProdutosRepository();

	public ServletLogin() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/* RECEBE OS DADOS ENVIADOS POR UM FORMULÁRIO */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");

		try {

			if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {// VERIFICA SE OLOGIN E SENHA ESTÃO VAZIOS

				ModelLogin modelLogin = new ModelLogin();
				modelLogin.setLogin(login);
				modelLogin.setSenha(senha);

				// VALIDAR USUÁRIO
				if (daoLoginRepository.validarAutenticacao(modelLogin)) { /* Simulando login */

					request.getSession().setAttribute("usuario", modelLogin.getLogin()); // CRIA UMA SESSÃO PARA O  USUÁRIO

																						
					if (url == null || url.equals("null")) {
						url = "principal/principal.jsp";
					}

					RequestDispatcher redirecionar = request.getRequestDispatcher(url);
					
					// CHAMA O MÉTODO GETPRODUTOS DA CLASSE DAO E EXIBE NA TELA PRINCIPAL OS  PRODUTOS ENCONTRADOS CADASTRADOS NO BANCO.
					request.setAttribute("msg", daoProdutosRepository.getProdutos() != null ? 
					daoProdutosRepository.getProdutos() : "Produto não existe");
					redirecionar.forward(request, response);

				} else {
					RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
					request.setAttribute("msg", "Informe o login e senha corretamente!");
					redirecionar.forward(request, response);
				}

			} else {
				//RETORNA PARA A TELA DE LOGIN E EXIBE MENSAGEM AO USUÁRIO CASO UM DOS CAMPOS "LOGIN" OU "SENHA" ESTIVEREM VAZIOS.
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Informe o login e senha corretamente!");
				redirecionar.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
