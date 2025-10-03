package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.course;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;

public record CourseRequestAddDTO(String name, String code, String description, int durationMinutes, double price, String level) {

    public Course toCourse() {
        return new Course(name, code, description, durationMinutes, price, level);
    }
}
