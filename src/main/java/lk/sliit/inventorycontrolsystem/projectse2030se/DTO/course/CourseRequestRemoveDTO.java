package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.CourseDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.CourseDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;

public record CourseRequestRemoveDTO(String name) {

    private static final CourseDAO courseDAO = new CourseDAOJdbc();

    public Course toCourse() {
        Course course = courseDAO.getByName(name);
        return course;
    }

    public boolean isCourseFound() {
        return (courseDAO.getByName(name) != null);
    }

}
