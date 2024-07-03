package com.devsuperior.components_ioc;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.devsuperior.components_ioc.entities.Order;
import com.devsuperior.components_ioc.services.OrderService;

@SpringBootApplication
public class ComponentsIocApplication implements CommandLineRunner {
    
    //injecao do componente OrderService
    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SpringApplication.run(ComponentsIocApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    
        Scanner sc = new Scanner(System.in);
        
        //Código
        Integer code = sc.nextInt();
        //Valor basico
        Double basic = sc.nextDouble();
        //Desconto
        Double discount = sc.nextDouble();
        
        Order order = new Order(code, basic, discount);
        
        System.out.println("Pedido código " + order.getCode());
        System.out.println("Valor total: R$" + String.format("%.2f", orderService.total(order)));

        sc.close();
    }
}
