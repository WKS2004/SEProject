package lk.sliit.inventorycontrolsystem.projectse2030se.models;

import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Constructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.DBDataRetrieveConstructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Getter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Setter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumn;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTable;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.structure.Model;

import java.time.LocalDateTime;

@Model
@DBTable("Courses")
public class Course extends DefaultModel {

    @DBColumn("Name")
    private String name;

    @DBColumn("Code")
    private String code;

    @DBColumn("Description")
    private String description;

    @DBColumn("DurationMinutes")
    private int durationMinutes;

    @DBColumn("Price")
    private double price;

    @DBColumn("Level")
    private String level;

    @DBColumn("CourseStatus")
    private boolean courseStatus;

    @Constructor
    public Course(String name, String code, String description, int durationMinutes, double price, String level) {
        super();
        this.name = name;
        this.code = code;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.price = price;
        this.level = level;
    }

    @Constructor
    @DBDataRetrieveConstructor
    public Course(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String code, String description, int durationMinutes, double price, String level, boolean courseStatus) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.code = code;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.price = price;
        this.level = level;
        this.courseStatus = courseStatus;
    }

    @Setter
    public void setName(String name) {
        this.name = name;
    }

    @Setter
    public void setCode(String code) {
        this.code = code;
    }

    @Setter
    public void setDescription(String description) {
        this.description = description;
    }

    @Setter
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @Setter
    public void setPrice(double price) {
        this.price = price;
    }

    @Setter
    public void setLevel(String level) {
        this.level = level;
    }

    @Setter
    public void setCourseStatus(boolean courseStatus) {
        this.courseStatus = courseStatus;
    }

    @Getter
    public String getName() {
        return name;
    }

    @Getter
    public String getCode() {
        return code;
    }

    @Getter
    public String getDescription() {
        return description;
    }

    @Getter
    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Getter
    public double getPrice() {
        return price;
    }

    @Getter
    public String getLevel() {
        return level;
    }

    @Getter
    public boolean isCourseStatus() {
        return courseStatus;
    }

}
