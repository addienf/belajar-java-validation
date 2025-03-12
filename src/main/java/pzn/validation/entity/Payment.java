package pzn.validation.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import pzn.validation.group.CreditCardPaymentGroup;
import pzn.validation.group.VirtualAccountPaymentGroup;
import pzn.validation.payload.EmailErrorPayload;

public class Payment {

    @Valid
    @NotNull(
            groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "Customer must not null"
    )
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

    @NotBlank(
            groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "Order must not null"
    )
    private String orderId;

    @NotNull(
            groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "Amount must not null"
    )
    @Range(
            groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 10_000,
            max = 100_000_000,
            message = "Amount must between 10.000 and 100.000.000"
    )
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class},message = "Credit Card must not null")
    @LuhnCheck(
            groups = {CreditCardPaymentGroup.class},message = "Credit Card must valid number",
            payload = {EmailErrorPayload.class}
    )
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class},message = "Virtual Account must not null")
    private String virtualAccount;

    /* Getter Setter */

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
