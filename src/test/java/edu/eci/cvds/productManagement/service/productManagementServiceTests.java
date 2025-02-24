package edu.eci.cvds.productManagement.service;

import edu.eci.cvds.productManagement.model.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class productManagementServiceTests {
    public Agent agentLog = new AgentLog();
    public Agent agentWarning = new AgentWarning();
    public productManagementService service = new productManagementImpl(agentLog, agentWarning);
    Throwable exception;

    @Test
    public void agentLogTest(){
        Product product = new Product("iPhone", 200F, 10, "phones");
        assertEquals(agentLog.notify(product), "Producto: iPhone -> 10 unidades disponibles.");
    }
    @Test
    public void agentWarningTest(){
        Product product = new Product("table", 10F, 2, "phones");
        assertEquals(agentWarning.notify(product), "ALERTA!!! El stock del Producto: table es muy bajo, solo quedan 2 unidades.");
    }

    @Test
    public void addProductTest() throws Exception {
        Product product = new Product("xbox", 34.2F, 3, "games");
        service.addProduct(product);
        assertTrue(service.getProducts().containsValue(product));
    }
    @Test
    public void updateProductTest() throws Exception {
        Product product = new Product("xbox", 34.2F, 3, "games");
        service.addProduct(product);
        service.updateProduct(product.getName(), 9);
        assertEquals(9, product.getQuantity());
    }
    @Test()
    public void shouldntUpdateProductTest(){
        Exception exception = assertThrows(Exception.class, () -> service.updateProduct("iPhone", 6));
        assertEquals("Error, el producto que quiere actualizar no está añadido", exception.getMessage());
    }

    @Test
    public void shouldntAddProductTest(){
        Exception exception = assertThrows(Exception.class, () -> service.addProduct(null));
        assertEquals("Producto nulo no puede ser añadido", exception.getMessage());
    }

}
