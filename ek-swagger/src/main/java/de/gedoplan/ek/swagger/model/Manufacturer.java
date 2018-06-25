package de.gedoplan.ek.swagger.model;

import java.util.List;

/**
 *
 * @author Dominik Mathmann
 */
public class Manufacturer {
    
    private List<Material> material;
    
    private List<Order> orders;

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
    
}
