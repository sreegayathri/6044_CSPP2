/**.
 * { item_description }
 */
import java.util.Scanner;
class Item {
    private String pname;
    private int quantity;
    private float unitprice;
    
    Item() {

    }

    Item(final String name, final int quant, final float price) {
        this.pname = name;
        this.quantity = quant;
        this.unitprice = price;
    }

    public String getpname() {
        return pname;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(final int quant) {
        this.quantity = quant;
    }

    public float getunitPrice() {
        return unitprice;
    }
    public void setunitPrice(final float price) {
        this.unitprice = price;
    }

    public String toString() {
        return this.getpname() + " " + this.getquantity() + " " + this.getunitPrice();
    }

    @Override
    public boolean equals(final Object item) {
        Item myItem = (Item)item;
        return this.getpname().equals(myItem.getpname());
    }
}

class ShoppingCart {
    private List<Item> catalog;
    private List<Item> cart;
    float couponCode;
    boolean isCouponApplied;

    ShoppingCart() {
        catalog = new List<Item>();
        cart = new List<Item>();
        isCouponApplied = false;
    }


    public void addToCatalog(final Item item) {
        int index = catalog.indexOf(item);
        if (index == -1) {
            catalog.add(item);
        }
    }

    public void addToCart(final Item item) {
        int index = catalog.indexOf(item);
        Item catalogItem = catalog.get(index);
        index = cart.indexOf(item);

        Item cartItem = cart.get(index);
        if (cartItem != null) {
            cartItem.setquantity(cartItem.getquantity() + item.getquantity());
            catalogItem.setquantity(catalogItem.getquantity() - item.getquantity());
            return;
        }
        if (catalogItem.getquantity() >= item.getquantity()) {
            item.setunitPrice(catalogItem.getunitPrice());
            cart.add(item);
            catalogItem.setquantity(catalogItem.getquantity() - item.getquantity());
        }
    }
        
    public void removeFromCart(final Item item) {
        int index = catalog.indexOf(item);
        Item catalogItem = catalog.get(index);
        
        index = cart.indexOf(item);
        Item cartItem = cart.get(index);

        if (cartItem != null) {
            if (cartItem.getquantity() == item.getquantity()) {
                cart.remove(index);
            } else {
                cartItem.setquantity(cartItem.getquantity() - item.getquantity());
                catalogItem.setquantity(catalogItem.getquantity() + item.getquantity());
            }
        }
        // for (Item cartitem : cart) {
        //     if ((cartitem.getpname()).equals(item.getpname())) {
        //         int a = cartitem.getquantity();
        //         int b = item.getquantity();
        //         int c = a - b;
        //         cartitem.setquantity(c);
        //     }
        // }
    }

    public void showCart() {
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            // System.out.println(item);
            System.out.println(item.getpname() + " " + item.getquantity());
        }
    }
    public void showCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println(catalog.get(i));
            //Item item = catalog.get(i);
            //System.out.println(item.getpname() + " " + item.getquantity() + " " + item.getunitPrice());
        }
    }

    public float getTotalAmount() {
        float totalAmount = 0.0f;
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            totalAmount = totalAmount + item.getquantity() * item.getunitPrice();
        }
        return totalAmount;
    }

    public float getPayableAmount() {
        float totalAmount = getTotalAmount();
        float disc = totalAmount * couponCode;
        totalAmount = totalAmount - disc;
        float payableAmount = totalAmount + (totalAmount * 0.15f);
        return payableAmount;
    }

    public void applyCoupon(final String coupon) {
        if (isCouponApplied == false) {
            if (coupon.equals("IND10")) {
            couponCode = 0.1f;
            } else if (coupon.equals("IND20")) {
                couponCode = 0.2f;
            } else if (coupon.equals("IND30")) {
                couponCode = 0.3f;
            } else if (coupon.equals("IND50")) {
                couponCode = 0.5f;
            } else {
                System.out.println("Invalid coupon");
                return;
            }
            isCouponApplied = true;
        }
    }

    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i));
        }
        System.out.println("Total:" + getTotalAmount());
        if (isCouponApplied == true) {
            float totalAmount = getTotalAmount();
            float disc = totalAmount * couponCode;
            System.out.println("Disc%:" + disc);
            totalAmount = totalAmount - disc;
            float tax = (totalAmount * 15) / 100;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + tax;
            System.out.println("Payable amount: " + totalAmount);
        } else {
            float totalAmount = getTotalAmount();
            System.out.println("Disc%:" + 0.0);
            float tax = (totalAmount * 15) / 100;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + tax;
            System.out.println("Payable amount: " + totalAmount);
        }
    }
}
