package servlet;

import db.DBConnection;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SAXException {


    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String pensja = request.getParameter("salary");
            String imie =request.getParameter("imie");
            String nazwisko =request.getParameter("nazwisko");
            Integer pensjaInt =Integer.parseInt(pensja);


            DBConnection dbConnection = new DBConnection();
            dbConnection.addtoDB(imie,nazwisko,pensjaInt);
            response.sendRedirect("Servlet2");



    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}

