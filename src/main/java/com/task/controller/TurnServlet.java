package com.task.controller;

import com.task.domain.Keywords;
import com.task.service.KeywordService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Antony on 10.07.2016.
 */
@WebServlet("/task/turn")
public class TurnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("TurnServlet");
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } finally {
                reader.close();
            }
            System.out.println(sb.toString());

            JSONObject req = new JSONObject(sb.toString());

            sb = new StringBuilder();
            KeywordService service = new KeywordService(Keywords.class);
            if (service.isExist(req.getString("keyword"))) {
                service.toggle();
                sb.append(service.getResponse());
            }
            else {
                sb.append("Bad keyword");
            }
            System.out.println(sb.toString());

            JSONObject resp = new JSONObject();
            resp.put("response", sb.toString());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(resp.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
