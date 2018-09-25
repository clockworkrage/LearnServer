package com.strups.tranlan.frontend;

import dbservice.DBService;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SignUpServlet extends HttpServlet {
    private DBService dbService;

    public SignUpServlet(@NotNull DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void doPost(@NotNull HttpServletRequest request,
                       @NotNull HttpServletResponse response) throws ServletException, IOException {

            response.getWriter().println("test");
            response.setStatus(HttpServletResponse.SC_OK);

    }


    @Override
    protected void doGet(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String session = request.getSession(true).getId();

        if((name != null) && (password != null)) {
            dbService.isUserExist(session, name);

            /*while (!frontend.isResivedResponseExistUser(session)){
                TimeHelper.sleep(RESPONSE_TIME);
            }

            Map<String, Object> pageVariables = new HashMap<>();
            if (!frontend.getResponseExistUser(session)) {
                frontend.registerUser(name, password);
                pageVariables.put("errors", "null");
            } else {
                pageVariables.put("errors", "User with name '" + name + "' already exists");
            }*/

            //response.getWriter().println(PageGenerator.getPage("signupResult.json", pageVariables));
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
            response.setStatus(HttpServletResponse.SC_OK);
        }

}
