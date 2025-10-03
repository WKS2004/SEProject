package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.PaymentDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.PaymentDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.PaymentStatus;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Payment;

public record PaymentRequestStatusDTO(String id, PaymentStatus paymentStatus) {

    private static final PaymentDAO paymentDAO = new PaymentDAOJdbc();

    public Payment toPayment() {
        Payment payment = paymentDAO.getById(id);
        payment.setPaymentStatus(paymentStatus);
        return payment;
    }

    public PaymentStatus getOldPaymentStatus() {
        return (paymentDAO.getById(id).getPaymentStatus());
    }
}
