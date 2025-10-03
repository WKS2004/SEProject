package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course.CourseRequestUpdateDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.CourseServices;

import java.io.File;
import java.io.IOException;

@WebServlet("/course/update")
public class UpdateCourseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        int durationMinutes = Integer.parseInt(request.getParameter("durationMinutes"));
        double price = Double.parseDouble(request.getParameter("price"));
        String level = request.getParameter("level");
        Boolean activeStatus = Boolean.parseBoolean(request.getParameter("activeStatus"));

        CourseServices courseServices = new CourseServices();
        CourseRequestUpdateDTO courseRequestUpdateDTO = new CourseRequestUpdateDTO(name, code, description, durationMinutes, price, level, activeStatus);

        boolean success = courseServices.updateCourse(courseRequestUpdateDTO);

        response.sendRedirect(success ? request.getContextPath() + "/course/update?success=true" : request.getContextPath() + "/course/update?success=false");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/updateCourseJSP.jsp").forward(request, response);
    }
}
