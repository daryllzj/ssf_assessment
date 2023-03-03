package ssf.ssf_assessment.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, Item> cartContents = new HashMap<>();

    public Map<String, Item> getCartContents() {
        return cartContents;
    }

    public void setCartContents(Map<String, Item> cartContents) {
        this.cartContents = cartContents;
    }

    public void addToCart(String itemName,Item item) {

        if(this.cartContents.containsKey(itemName)){
            Item currentItem = cartContents.get(itemName);
            Integer currentQty = currentItem.getQuantity();
            Integer updatedQty = currentQty + item.getQuantity();
            this.cartContents.put(itemName, new Item(itemName, updatedQty));
        } else{
            this.cartContents.put(itemName, item);
        }

    }


    



    

    



    
    
}
