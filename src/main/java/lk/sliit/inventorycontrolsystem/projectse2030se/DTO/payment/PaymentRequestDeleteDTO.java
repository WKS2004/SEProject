package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.PaymentDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.PaymentDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.PaymentStatus;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Payment;

public record PaymentRequestDeleteDTO(String id) {

    private static final PaymentDAO paymentDAO = new PaymentDAOJdbc();

    public Payment toPayment() {
        Payment payment = paymentDAO.getById(id);
        return payment;
    }

    public boolean isPaymentFound() {
        return (paymentDAO.getById(id) != null);
    }

    public PaymentStatus isPaymentActive() {
        return (paymentDAO.getById(id).getPaymentStatus());
    }
}
