package de.gedoplan.ek.swagger.model;

/**
 *
 * @author Dominik Mathmann
 */
public class OrderItem {
    
    private Order order;
    
    private Material material;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
    
}
