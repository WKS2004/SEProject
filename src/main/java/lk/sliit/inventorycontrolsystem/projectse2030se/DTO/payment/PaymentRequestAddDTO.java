package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.PaymentMethod;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Payment;

public record PaymentRequestAddDTO(double amount, String currency, PaymentMethod paymentMethod) {

    public Payment toPayment() {
        return new Payment(amount, currency, paymentMethod);
    }

}
