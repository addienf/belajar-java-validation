package pzn.validation.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SampleData {

    private Data<@NotBlank @Size(min = 10) String> data;

    public  Data<String> getData(){return data;}

    public void setData(Data<String> data) {
        this.data = data;
    }
}
