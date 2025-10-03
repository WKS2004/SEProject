package lk.sliit.inventorycontrolsystem.projectse2030se.services;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.PaymentDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.PaymentDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment.PaymentRequestAddDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment.PaymentRequestDeleteDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment.PaymentRequestStatusDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.PaymentStatus;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Payment;

public class PaymentServices {

    private static final PaymentDAO paymentDAO = new PaymentDAOJdbc();

    public boolean addPayment(PaymentRequestAddDTO paymentRequestAddDTO) {
        try {
            Payment payment = paymentRequestAddDTO.toPayment();
            paymentDAO.create(payment);
            System.out.println("Payment added successfully!");
            return true;
        } catch (Exception e) {
            System.out.println("Error while adding the Payment!");
        }
        return false;
    }

    public PaymentStatus changePaymentStatus(PaymentRequestStatusDTO paymentRequestStatusDTO) {
        try {
            if (!(paymentRequestStatusDTO.getOldPaymentStatus() == PaymentStatus.REJECTED)) {
                Payment payment = paymentRequestStatusDTO.toPayment();
                paymentDAO.delete(payment);
                System.out.println("Payment deleted successfully!");
                return paymentRequestStatusDTO.paymentStatus();
            }
            else {
                System.out.println("Payment is already Rejected!");
            }
        }
        catch (Exception e) {
            System.out.println("Error while deleting the Payment!");
        }
        return PaymentStatus.REJECTED;
    }

    public boolean deletePayment(PaymentRequestDeleteDTO paymentRequestDeleteDTO) {
        try {
            Payment payment = paymentRequestDeleteDTO.toPayment();
            paymentDAO.delete(payment);
            System.out.println("Payment deleted successfully!");
            return true;
        }
        catch (Exception e) {
            System.out.println("Error while deleting the Payment!");
        }
        return false;
    }
}
