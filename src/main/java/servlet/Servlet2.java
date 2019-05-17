package servlet;

import db.DBConnection;
import model.Employee;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2","/employeelist","/employee/remove/*","/employee/edit/*"})
public class Servlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SAXException {


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/employeelist") | path.equals("/Servlet2"))
            handleEmployeeList(request, response);
        else if(path.equals("/employee/edit") | path.equals("/employee/edit/*")) {
            handleEmployeeEdit(request, response);
        } else if(path.equals("/employee/remove"))
            handleEmployeeRemove(request,response) ;

    }

    private void handleEmployeeRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getPathInfo();
        Integer id = convId(s);

        DBConnection dbConnection = new DBConnection();
        dbConnection.removefromDb(id);

    }

    private void handleEmployeeEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getPathInfo();
        Integer id = convId(s);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);


        String pensja = request.getParameter("salaryedit");
        String imie =request.getParameter("imieedit");
        String nazwisko =request.getParameter("nazwiskoedit");
        Integer pensjaInt =Integer.parseInt(pensja);
        if(pensja!=null &imie!=null &nazwisko!=null) {
            DBConnection dbConnection = new DBConnection();
            dbConnection.editfromDb(id, imie, nazwisko, pensjaInt);
            }
     //   response.sendRedirect(request.getContextPath() + "/Servlet2");
        request.getRequestDispatcher("Servlet2").forward(request,response);
       // response.sendRedirect("Servlet2");

    }

    private void handleEmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnection dbConnection = new DBConnection();
        List<Employee> list = dbConnection.findall();
        request.setAttribute("employeeList", list);
        request.getRequestDispatcher("employeelist.jsp").forward(request, response);


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

    private Integer convId(String s) {
        if (s == null || !s.startsWith("/"))
            return null;
        try {
            return Integer.parseInt(s.substring(1));
        } catch (NumberFormatException e) {
            return null;
        }

    }
}
