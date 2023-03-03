package ssf.ssf_assessment.model;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Item implements Serializable{

    private String item;

    @NotNull(message= "please enter input")
    @Min (value=1, message="You must add at least 1 item")
    private Integer quantity;

    public Item() {
    }

    public Item(String item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [item=" + item + ", quantity=" + quantity + "]";
    }

    


    

    
    
}
