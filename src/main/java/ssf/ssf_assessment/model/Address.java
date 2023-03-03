package ssf.ssf_assessment.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Address {

    @NotNull(message="mandatory")
    @Size (min=2, message="minimum 2 characters")
    private String name;

    @NotNull(message="mandatory")
    private String address;

    public Address(@NotNull(message = "mandatory") String name, @NotNull(message = "mandatory") String address) {
        this.name = name;
        this.address = address;
    }

    public Address() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
}
