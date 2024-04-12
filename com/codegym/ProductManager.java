package com.codegym;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        ArrayList<Product> productList = new ArrayList<>();
        this.products = productList;
    }

    public boolean isIDInProductList(int id) {
        if (!products.isEmpty()) {
            for (Product product: products) {
                if (product.getId() == id)
                    return true;
            }
        }
        return false;
    }

    public Product inputProductData() {
        int id;
        String name;
        double price;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Product Name: ");
        name = scanner.nextLine();
        boolean isId = true;
        do {
            System.out.println("Product Id: ");
            id = scanner.nextInt();
            if (isIDInProductList(id)) {
                System.out.println("ID đã tồn tại.");
            } else {
                isId = false;
            }
        } while (isId);

        System.out.println("Product Price: ");
        price = scanner.nextDouble();

        Product product = new Product(id, name, price);
        return product;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductById() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào");
        } else {
            System.out.println("Product ID:");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            for (Product product: products) {
                if (product.getId() == id) {
                    return product;
                }
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "products=" + products +
                '}';
    }

    public void menu() {
        char choice = '?';
        while (choice != '0') {
            System.out.println("--Menu--");
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Tìm theo ID");
            System.out.println("Nhập vào lựa chọn:");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().charAt(0);
            switch (choice) {
                case '1': {
                    Product product = inputProductData();
                    addProduct(product);
                    break;}
                case '2':
                    System.out.println("Sửa");
                    break;
                case '3':
                    System.out.println("Xóa");
                    break;
                case '4': {
                    int id = inputId();
                    Product product = findProductById();
                    showProduct(product);
                    break;}
                case '5':
                    showProducts();
                    break;
            }
        }
    }

    private void showProducts() {
        for (Product product: products) {
            System.out.println("ProductID: " + product.getId() + ", ProductName: " + product.getName() + ", ProductPrice: " + product.getPrice());
        }
    }

    private void showProduct(Product product) {
        System.out.println("ProductID: " + product.getId() + ", ProductName: " + product.getName() + ", ProductPrice: " + product.getPrice());
    }

    private int inputId() {
        System.out.println("Product ID:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        return id;
    }
}
