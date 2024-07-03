package com.devsuperior.components_ioc.services;

import org.springframework.stereotype.Service;

import com.devsuperior.components_ioc.entities.Order;

@Service
public class ShippingService {
    
    public double shipment(Order order){        
        double shipment = 0.0;
        
        if(order.getBasic() < 100.00){
            shipment = 20.00;
        } else if(order.getBasic() <= 200.00){
            shipment = 12.00;
        } else {
            shipment = 0.0;
        }
        return shipment;
    }
}
