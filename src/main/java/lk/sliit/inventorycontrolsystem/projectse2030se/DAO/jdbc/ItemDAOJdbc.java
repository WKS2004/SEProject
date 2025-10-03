package lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.GeneralDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.ItemDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Item;

import java.util.List;

public class ItemDAOJdbc extends GeneralDAOJdbc<Item> implements ItemDAO {
    public ItemDAOJdbc() {
        super(Item.class);
    }

    @Override
    public Item getById(String id) {
        return super.getById(id);
    }

    @Override
    public List<Item> getAll() {
        return super.getAll();
    }

    @Override
    public boolean create(Item item) {
        return super.create(item);
    }

    @Override
    public boolean update(Item item) {
        return super.update(item);
    }

    @Override
    public boolean delete(Item item) {
        return super.delete(item);
    }
}
