package de.gedoplan.ek.swagger.model;

import java.util.List;

/**
 *
 * @author Dominik Mathmann
 */
public class Order {
 
    List<OrderItem> items;

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    
    
}
