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
@DBTable("Items")
public class Item extends DefaultModel {

    @DBColumn("Name")
    private String name;

    @DBColumn("Description")
    private String description;

    @DBColumn("Category")
    private String category;

    @DBColumn("Price")
    private String price;

    @DBColumn("Quantity")
    private String quantity;

    @DBColumn("AvailableStatus")
    private boolean availableStatus;

    @Constructor
    public Item(String name, String description, String category, String price, String quantity) {
        super();
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.availableStatus = true;
    }

    @Constructor
    @DBDataRetrieveConstructor
    public Item(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String description, String category, String price, String quantity, boolean availableStatus) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.availableStatus = availableStatus;
    }

    @Setter
    private void setName(String name) {
        this.name = name;
    }

    @Setter
    public void setDescription(String description) {
        this.description = description;
    }

    @Setter
    public void setCategory(String category) {
        this.category = category;
    }

    @Setter
    public void setPrice(String price) {
        this.price = price;
    }

    @Setter
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Setter
    public void setAvailableStatus(boolean availableStatus) {
        this.availableStatus = availableStatus;
    }

    @Getter
    public String getName() {
        return name;
    }

    @Getter
    public String getDescription() {
        return description;
    }

    @Getter
    public String getCategory() {
        return category;
    }

    @Getter
    public String getPrice() {
        return price;
    }

    @Getter
    public String getQuantity() {
        return quantity;
    }

    @Getter
    public boolean isAvailableStatus() {
        return availableStatus;
    }
}
