package lk.sliit.inventorycontrolsystem.projectse2030se.DAO;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;

import java.util.List;

interface GeneralDAO<T extends DefaultModel> {
    T getById(String id);
    List<T> getAll();
    boolean create(T object);
    boolean update(T object);
    boolean delete(T object);
}
