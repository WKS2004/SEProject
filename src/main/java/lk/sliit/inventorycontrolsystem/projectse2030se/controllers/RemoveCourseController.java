package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course.CourseRequestRemoveDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.CourseServices;

import java.io.File;
import java.io.IOException;

@WebServlet("/course/remove")
public class RemoveCourseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        CourseServices courseServices = new CourseServices();
        CourseRequestRemoveDTO courseRequestRemoveDTO = new CourseRequestRemoveDTO(name);

        boolean success = courseServices.deleteCourse(courseRequestRemoveDTO);
        response.sendRedirect(success ? request.getContextPath() + "/course/remove?success=true" : request.getContextPath() + "/course/remove?success=false");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/removeCourseJSP.jsp").forward(request, response);
    }
}
