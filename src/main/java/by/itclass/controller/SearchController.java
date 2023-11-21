package by.itclass.controller;

import by.itclass.model.db.DbInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "searchController", value = "/search")
public class SearchController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        boolean isContains = DbInMemory.isContainsInDb(fio);
        RequestDispatcher rd;
        if(isContains){
            rd = req.getRequestDispatcher("/pages/yes.html");
        } else {
            rd = req.getRequestDispatcher("/pages/no.html");
        }
        rd.forward(req, resp);
    }
}
