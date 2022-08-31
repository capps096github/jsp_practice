package com.capps096apps.jsp_practice;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Battery", value = "/Battery")
public class Battery extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // servlet config
        ServletConfig config = getServletConfig();

        // rate i.e .2%
        double degradationRate = Double.parseDouble(config.getInitParameter("degradation_rate"));
        // degradation_duration i.e 30 hours
        double degradationDuration = Integer.parseInt(config.getInitParameter("degradation_duration"));

        // daily hourly usage
        double dailyUsage = Integer.parseInt(config.getInitParameter("daily_usage"));

        // hours to reach 100% degradation
        // Criteria: .2% = 30 hours, then 1% = (30/.2) hours
        double hoursTo100 = (degradationDuration / degradationRate) * 100;

        // daily degradation rate
        // Criteria: 1 day = 6 hours degradation, then 1 hour = (1/6) days
        // for 100% degradation, (1/6) * hoursTo100
        double totalDegradationDuration = (1 / dailyUsage) * hoursTo100;

        // print writer
        PrintWriter out = response.getWriter();

        // print out
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Battery Servlet</h1>");
        out.println("<p>Degradation Rate: " + degradationRate + "</p>");
        out.println("<p>Degradation Duration: " + degradationDuration + "</p>");
        out.println("<p>Daily Usage: " + dailyUsage + "</p>");
        out.println("<p>Hours to 100% Degradation: " + hoursTo100 + "</p>");
        out.println("<p>Total Degradation Duration: " + totalDegradationDuration + "</p>");
        out.println("</body>");
        out.println("</html>");


        // add a cookie with the total degradation duration
        Cookie cookie = new Cookie("total_degradation_duration", String.valueOf(totalDegradationDuration));
        response.addCookie(cookie);

        // read a cookie with the total degradation duration
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("total_degradation_duration")) {
                out.println("<p>Total Degradation Duration: " + c.getValue() + "</p>");
            }
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
