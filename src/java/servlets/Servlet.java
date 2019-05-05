/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author beatriz
 */

public class Servlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        Questoes questoes = new Questoes();
        
        String quest = request.getParameter("quest");
        session.setAttribute("resposta", "<p>Voce nao enviou nada para a pagina click <a href='index.html'>aqui</a> para voltar</p>");
        if(quest!=null)
            switch (quest){
                case "1":
                    session.setAttribute("resposta", "<p>nao implementado</p>");
                    break;
                case "2" :
                    int num1 = Integer.parseInt(request.getParameter("num1"));
                    int num2 = Integer.parseInt(request.getParameter("num2"));
                    session.setAttribute("resposta", questoes.quest2(num1, num2));
                    break;
                case "3":                    
                    int inteiro = Integer.parseInt(request.getParameter("inteiro"));
                    session.setAttribute("resposta", questoes.quest3(inteiro));
                    break;
                case "4":
                    String nums = request.getParameter("numeros");
                    session.setAttribute("resposta", questoes.quest4(nums));
                    break;
                case "5":
                    String nome = request.getParameter("nome");
                    session.setAttribute("resposta", questoes.quest5(nome));
                    break;
                case "6":
                    if(getServletContext().getAttribute("votos")==null)
                        getServletContext().setAttribute("votos", new int[8]);
                    String voto = request.getParameter("voto");;
                    if(request.getParameter("btn")==null)
                        voto = "";
                    session.setAttribute("resposta", questoes.quest6(voto, (int []) getServletContext().getAttribute("votos")));
                    break;
                case "7":
                    float m = Float.valueOf(request.getParameter("valInicial"));
                    float t = Float.valueOf(request.getParameter("juros"));
                    int i = Integer.valueOf(request.getParameter("meses"));
                    float p = Float.valueOf(request.getParameter("valMensal"));
                    session.setAttribute("resposta", questoes.quest7(m, t, i, p));
                    break;
                case "8":
                    session.setAttribute("resposta", "<p>nao implementado</p>");
                    break;
                case "9":
                    session.setAttribute("resposta", "<p>nao implementado</p>");
                    break;
                case "10":
                    session.setAttribute("resposta", "<p>nao implementado</p>");
                    break;
                case "11":
                    session.setAttribute("resposta", "<p>nao implementado</p>");
                    break;
                default:
                    session.setAttribute("resposta", "<p>Houve algum problema</p>");
                    break;
            }
        RequestDispatcher view = request.getRequestDispatcher("resposta.jsp");
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
    }


}
