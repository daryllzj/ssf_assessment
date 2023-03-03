package ssf.ssf_assessment.model;

import jakarta.validation.constraints.NotNull;

public class Address {

    @NotNull(message="mandatory")
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
