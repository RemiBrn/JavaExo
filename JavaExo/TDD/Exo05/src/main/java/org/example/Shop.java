package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) {
        throw new ExecutionControl.NotImplementedException();
    }
}
