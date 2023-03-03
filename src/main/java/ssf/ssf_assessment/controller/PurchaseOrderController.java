package ssf.ssf_assessment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ssf.ssf_assessment.model.Address;
import ssf.ssf_assessment.model.Cart;
// import ssf.ssf_assessment.model.CartList;
import ssf.ssf_assessment.model.Item;
import ssf.ssf_assessment.service.QuotationService;


@Controller
@RequestMapping
public class PurchaseOrderController {

    @Autowired
    QuotationService quotationService;

    // @GetMapping(path="/")
    // public String showView1(Model model, CartList list) {

    //     Item item = new Item();

    //     model.addAttribute("item", item);
    //     model.addAttribute("list", list);

    //     return "view1";
    // }

    @GetMapping(path="/")
    public String showView1(Model model, Cart contents) {

        Item item = new Item();

        model.addAttribute("item", item);
        model.addAttribute("contents", contents.getCartContents());

        return "view1";
    }

    // @PostMapping(path="/addOrder")
    // public String storeOrder(@RequestBody MultiValueMap<String,String> form, Model model, HttpSession session) {

    //     // get values from form
    //     String itemName = form.getFirst("item");
    //     String quantity = form.getFirst("quantity");
    //     Integer quantityInInt = Integer.parseInt(quantity);
    
    //     // // check if there is a cart object in session
    //     CartList list = (CartList)session.getAttribute("list");

    //     // // if there is no cart object in session, then create a new cart object in session
    //     if (null == list) {
    //         list = new CartList();
    //         session.setAttribute("list", list);
    //     } 

    //     Item item = new Item(itemName, quantityInInt);

    //     list.addItemToCart(item);

    //     System.out.println(list.toString());

    //     // add cart and item to model
    //     model.addAttribute("item", new Item());
    //     model.addAttribute("list", list);

    //     return "view1";
        
    // }


    @PostMapping(path="/addOrder")
    public String storeOrder(@RequestBody MultiValueMap<String,String> form, Model model, HttpSession session, @Valid Item item, BindingResult bindingResults) throws Exception {

        

        // get values from form
        String itemName = form.getFirst("item");
        String quantity = form.getFirst("quantity");
        Integer quantityInInt = Integer.parseInt(quantity);
    
        // // check if there is a cart object in session
        Cart contents = (Cart)session.getAttribute("cart");

        // // if there is no cart object in session, then create a new cart object in session
        if (null == contents) {
            contents = new Cart();
            session.setAttribute("cart", contents);
        } 

        if (bindingResults.hasErrors())
			return "view1";

        contents.addToCart(itemName, new Item(itemName, quantityInInt));

        List<String> itemsInList = quotationService.generateList(contents.getCartContents());

        // quotationService.getQuotations(itemsInList);

        session.setAttribute("items", itemsInList);

        // add cart and item to model
        model.addAttribute("item", new Item());
        model.addAttribute("cart", contents);

        return "view1";
        
    }

    @GetMapping(path="/shippingaddress")
    public String showView2( Model model) {


        model.addAttribute("address", new Address());

        return "view2";
    }

    @PostMapping(path="/checkout")
    public String showView3(@RequestBody MultiValueMap<String,String> form, Model model, Address Address, HttpSession session) {

        String name = form.getFirst("name");
        String address = form.getFirst("address");

        Address addressToSend = new Address(name,address);

        model.addAttribute("address", addressToSend);

        session.invalidate();

        return "view3";
    }



    
    
}
