package lk.sliit.inventorycontrolsystem.projectse2030se.services;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.CourseDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.CourseDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course.CourseRequestAddDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course.CourseRequestRemoveDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course.CourseRequestUpdateDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;

public class CourseServices {

    private static final CourseDAO courseDAO = new CourseDAOJdbc();

    public boolean addCourse(CourseRequestAddDTO courseRequestAddDTO) {
        try {
            Course course = courseRequestAddDTO.toCourse();

            courseDAO.create(course);
            System.out.println("Course added successfully!");
            return true;
        } catch (Exception e) {
            System.out.println("Error while trying to add a new Course!");
        }
        return false;
    }

    public boolean updateCourse(CourseRequestUpdateDTO courseRequestUpdateDTO) {
        try {
            Course course = courseRequestUpdateDTO.toCourse();

            courseDAO.update(course);
            System.out.println("Course updated successfully!");
            return true;
        } catch (Exception e) {
            System.out.println("Error while trying to update the Course!");
        }
        return false;
    }

    public boolean deleteCourse(CourseRequestRemoveDTO courseRequestRemoveDTO) {
        try {
            Course course = courseRequestRemoveDTO.toCourse();

            courseDAO.delete(course);
            System.out.println("Course deleted successfully!");
            return true;
        } catch (Exception e) {
            System.out.println("Error while trying to delete the Course!");
        }
        return false;
    }
}
