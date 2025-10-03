package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.CourseDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.CourseDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;

import java.time.LocalDateTime;

public record CourseRequestUpdateDTO(String name, String code, String description, int durationMinutes, double price, String level, boolean courseStatus) {

    private static final CourseDAO courseDAO = new CourseDAOJdbc();

    public Course toCourse() {
        Course course = courseDAO.getByName(name);

        if (course != null) {
            course.setUpdatedAt();
            course.setCode(code);
            course.setDescription(description);
            course.setDurationMinutes(durationMinutes);
            course.setPrice(price);
            course.setLevel(level);
            course.setCourseStatus(courseStatus);
        }

        return course;
    }
}
