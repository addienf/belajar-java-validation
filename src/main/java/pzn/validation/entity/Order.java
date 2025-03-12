package pzn.validation.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class Order {

    @NotBlank(
            message = "{order.id.notblank}"
    )
    @Size(
            min = 1,
            max = 10,
            message = "{order.id.size}"
    )
    private String id;

    @Range(
            min = 10_000,
            max = 100_000_000,
            message = "{order.amount.range}"
    )
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
