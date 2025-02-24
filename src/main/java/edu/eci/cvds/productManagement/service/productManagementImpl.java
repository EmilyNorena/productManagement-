package edu.eci.cvds.productManagement.service;

import edu.eci.cvds.productManagement.model.Agent;
import edu.eci.cvds.productManagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public class productManagementImpl implements productManagementService{
    private HashMap<String, Product> products;
    private final Agent agentLog;
    private final Agent agentWarning;

    public productManagementImpl(Agent agentLog, Agent agentWarning) {
        products = new HashMap<>();
        this.agentLog = agentLog;
        this.agentWarning = agentWarning;
    }

    @Override
    public void addProduct(Product product) throws Exception{
        if (product == null) {
            throw new Exception("Producto nulo no puede ser añadido");
        }
        else if(products.containsKey(product.getName())){
            throw new Exception("El producto ya está añadido");
        }
        else if (product.getQuantity() < 0 || product.getPrice() < 0){
            throw new Exception("No se aceptan valores negativos");
        }
        products.put(product.getName(),product);

    }
    @Override
    public void updateProduct (String name, Integer quantity) throws Exception{
        if(quantity < 0){
            throw new Exception("Error, la cantidad del producto no puede ser negativa");
        }
        else if(!products.containsKey(name)) {
            throw new Exception("Error, el producto que quiere actualizar no está añadido");
        }
        Product product = products.get(name);
        product.setQuantity(quantity);
        notifyAgents(product);

    }

    @Override
    public void notifyAgents(Product product){
        agentLog.notify(product);
        agentWarning.notify(product);
    }

    @Override
    public HashMap getProducts(){return products;}

}
