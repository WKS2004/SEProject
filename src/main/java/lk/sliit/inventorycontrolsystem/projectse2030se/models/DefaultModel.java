package lk.sliit.inventorycontrolsystem.projectse2030se.models;

import lk.sliit.inventorycontrolsystem.projectse2030se.utils.IDPartHandler;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Constructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.GetterHelper;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumn;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Getter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Setter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.StringBuilderAppendUtils;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class DefaultModel {

    @DBColumn("ID")
    protected final String id;

    @DBColumn("CreatedAt")
    protected final LocalDateTime createdAt;

    @DBColumn("UpdatedAt")
    protected LocalDateTime updatedAt;

    @Constructor
    protected DefaultModel() {
        String idPart = IDPartHandler.idRetriever(this.getClass());
        if (idPart == null || idPart.isEmpty()) {
            throw new IllegalArgumentException("The id part cannot be null or empty!");
        }

        this.id = idPart + "-" + UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        setUpdatedAt();
    }

    @Constructor
    protected DefaultModel(String id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Setter
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    @Getter
    public String getId() {
        return id;
    }

    @Getter
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Getter
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String retrieveAllDataToString() {
        StringBuilder allData = new StringBuilder();
        List<Method> methods = GetterHelper.getOrderedAllPublicGetters(this);

        try {
            for (Method method : methods) {
                Object value = method.invoke(this);
                if (value != null) {
                    StringBuilderAppendUtils.appendWithCommaAndSpace(allData, value);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception while retrieving all crypto to String!");
        }

        return allData.toString();
    }

}
