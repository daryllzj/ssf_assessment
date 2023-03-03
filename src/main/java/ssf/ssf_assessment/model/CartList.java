package ssf.ssf_assessment.model;

import java.util.LinkedList;
import java.util.List;

public class CartList {

    private List<Item> cart = new LinkedList<>();

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public void addItemToCart(Item item){
        if (cart.contains(item)){
            int index = cart.indexOf(item);
            Item currentItem = cart.get(index);
            Integer currentItemQty = currentItem.getQuantity();
            Integer updatedQty = currentItemQty + item.getQuantity();
            Item updateItem = new Item(item.getItem(), updatedQty);
            this.cart.add(updateItem);
            cart.remove(index);
        } else {
            this.cart.add(item);
        }
        
    }

    

    

    
    
}
