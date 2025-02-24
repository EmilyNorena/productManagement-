package edu.eci.cvds.productManagement.service;

import edu.eci.cvds.productManagement.model.Product;

import java.util.HashMap;

public interface productManagementService {
     void addProduct(Product product) throws Exception;
     void updateProduct(String name, Integer quantity) throws Exception;
     void notifyAgents(Product product);
     HashMap getProducts();
}
