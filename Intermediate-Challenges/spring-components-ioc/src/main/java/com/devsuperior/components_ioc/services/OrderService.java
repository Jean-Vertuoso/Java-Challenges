package com.devsuperior.components_ioc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.components_ioc.entities.Order;

@Service
public class OrderService {
    
    //injecao do componente ShippingService
    @Autowired
    ShippingService shippingService;
    
    public double total(Order order){
        return (order.getBasic() + shippingService.shipment(order)) - (order.getBasic() * (order.getDiscount()/100));
    }
}
