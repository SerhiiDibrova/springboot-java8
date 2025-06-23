package hello;

import hello.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        String product = productService.getProduct();
        System.out.println(product);
    }
}