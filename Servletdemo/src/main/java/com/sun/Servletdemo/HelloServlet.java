package com.sun.Servletdemo;

import com.google.gson.Gson;
import net.sf.json.JSONObject;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;


    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("get方法");
        String str=request.getParameter("str");

        Gson gson = new Gson();
        Persion p = gson.fromJson(str, Persion.class);
        String pJSONString = gson.toJson(p);

        System.out.println(p.toString());
        response.getWriter().println("sad");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    public void destroy() {
    }
}