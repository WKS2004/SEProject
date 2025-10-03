package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course.CourseRequestAddDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.CourseServices;

import java.io.File;
import java.io.IOException;

@WebServlet("/course/add")
public class AddCourseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        int durationMinutes = Integer.parseInt(request.getParameter("durationMinutes"));
        double price = Double.parseDouble(request.getParameter("price"));
        String level = request.getParameter("level");

        CourseServices courseServices = new CourseServices();
        CourseRequestAddDTO courseRequestAddDTO = new CourseRequestAddDTO(name, code, description, durationMinutes, price, level);
        boolean success = courseServices.addCourse(courseRequestAddDTO);

        response.sendRedirect(success ? request.getContextPath() + "/course/add?success=true" : request.getContextPath() + "/course/add?success=false");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/addCourseJSP.jsp").forward(request, response);
    }
}
