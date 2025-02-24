package edu.eci.cvds.productManagement.model;

import java.util.ArrayList;
import java.util.List;

public class AgentWarning implements Agent{
    private List<String> agentMessages = new ArrayList<>();
    @Override
    public String notify(Product product){
        if (product.getQuantity() < 5){
            String message = String.format("ALERTA!!! El stock del Producto: %s es muy bajo, solo quedan %d unidades.", product.getName(), product.getQuantity());
            agentMessages.add(message);
            System.out.println(message);
            return message;
        }
        return null;
    }
}

