package edu.eci.cvds.productManagement.model;

import java.util.ArrayList;
import java.util.List;

public class AgentLog implements Agent{
    private List<String> agentMessages = new ArrayList<>();
    @Override
    public String notify(Product product){
        String message = String.format("Producto: %s -> %d unidades disponibles.", product.getName(), product.getQuantity());
        agentMessages.add(message);
        System.out.println(message);
        return message;
    }
}


