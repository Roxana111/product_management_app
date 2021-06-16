package md.tekwill.app;

import md.tekwill.ShoppingCart;
import md.tekwill.entity.product.Product;
import md.tekwill.service.ProductService;

import java.util.Scanner;

public class ProductManagementUserMenu {
    private final ProductService productService;
    private final ShoppingCart cart;
    private final Scanner scanner;

    public ProductManagementUserMenu(ProductService productService, ShoppingCart cart, Scanner scanner) {
        this.productService = productService;
        this.cart = cart;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean exitOptionNotSelected;
        do {
            System.out.println("Available options: ");
            System.out.println("=================USER OPTIONS=============");
            System.out.println("[1] View all products");
            System.out.println("[2] View shopping cart");
            System.out.println("[3] Add product to shopping cart");
            System.out.println("[4] Print bill");
            System.out.println("==========================================");
            System.out.println("[0] Exit");
            System.out.println("==========================================");
            System.out.println(">> ");
            exitOptionNotSelected = handleUserChoice(scanner.nextInt());
        }
        while (exitOptionNotSelected);

    }

    private boolean handleUserChoice(int userChoice) {
        scanner.nextLine();
        switch (userChoice) {
            case 1:
                viewAllNonExpiredProducts();
                return true;
            case 2:
                viewShoppingCart();
                return true;
            case 3:
                addProductToShoppingCart();
                return true;
            case 4:
                printBill();
                return true;
            case 0:
                System.out.println("BYE!");
                return false;
            default:
                System.out.println("Unknown option selected! ");
                return true;
        }

    }
    private void printBill(){
        System.out.println("Full price: "+cart.getPriceWithoutDiscount());
        System.out.println("Discount: "+ cart.getSavedMoney());

    }

    private void viewAllNonExpiredProducts(){
        for(Product p: productService.getAllNonExpired()){
            System.out.println(p);
        }
    }
    private void viewShoppingCart(){
       /* if(cart.getProductList()!=null){
            for(Product p:cart.getProductList())
                System.out.println(p);*/



        try{
                if(cart.getProductList()!=null){
                    for(Product p:cart.getProductList())
                        System.out.println(p);


                }
            }
            catch(NullPointerException ex){
                System.out.println("The cart is empty!");
            }
        }

    private void addProductToShoppingCart(){
        System.out.println("Choose id!");
        int optionID=scanner.nextInt();
        //Product p= productService.getById(optionID);
        cart.addProduct(productService.getById(optionID));
    }
}
