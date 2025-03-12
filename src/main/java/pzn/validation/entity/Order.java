package pzn.validation.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import pzn.validation.constraint.CheckCase;
import pzn.validation.constraint.CheckOrderId;
import pzn.validation.data.CaseMode;

public class Order {

    @CheckOrderId
    private String id;

    @Range(min = 10_000, max = 100_000_000, message = "{order.amount.range}")
    private Long amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
