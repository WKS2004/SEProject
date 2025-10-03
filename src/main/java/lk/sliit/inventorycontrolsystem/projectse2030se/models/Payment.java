package lk.sliit.inventorycontrolsystem.projectse2030se.models;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.PaymentMethod;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.PaymentStatus;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Constructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.DBDataRetrieveConstructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Getter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Setter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumn;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTable;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.structure.Model;

import java.time.LocalDateTime;

@Model
@DBTable("Payments")
public class Payment extends DefaultModel {

    @DBColumn("Amount")
    private final double amount;

    @DBColumn("Currency")
    private final String currency;

    @DBColumn("PaymentMethod")
    private final PaymentMethod paymentMethod;

    @DBColumn("PaymentStatus")
    private PaymentStatus paymentStatus;

    @Constructor
    public Payment(double amount, String currency, PaymentMethod paymentMethod) {
        super();
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = (paymentMethod.equals(PaymentMethod.CARD) ? PaymentStatus.APPROVED : PaymentStatus.PENDING);
    }

    @Constructor
    @DBDataRetrieveConstructor
    public Payment(String id, LocalDateTime createdAt, LocalDateTime updatedAt, double amount, String currency, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        super(id, createdAt, updatedAt);
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    @Setter
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Getter
    public double getAmount() {
        return amount;
    }

    @Getter
    public String getCurrency() {
        return currency;
    }

    @Getter
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Getter
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

}
