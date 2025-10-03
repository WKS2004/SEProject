package lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.GeneralDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.PaymentDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Payment;

import java.util.List;

public class PaymentDAOJdbc extends GeneralDAOJdbc<Payment> implements PaymentDAO {
    public PaymentDAOJdbc() {
        super(Payment.class);
    }

    @Override
    public Payment getById(String id) {
        return super.getById(id);
    }

    @Override
    public List<Payment> getAll() {
        return super.getAll();
    }

    @Override
    public boolean create(Payment payment) {
        return super.create(payment);
    }

    @Override
    public boolean update(Payment payment) {
        return super.update(payment);
    }

    @Override
    public boolean delete(Payment payment) {
        return super.delete(payment);
    }

}
