package model;

import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class Receipt {

    // This array list will hold all items in the cart
    private ArrayList<Pane> receiptItems = new ArrayList<Pane>();

    public void addtoReceipt(Pane pane) {
        receiptItems.add(pane);
    };

    public void receiptshowItems() {
        System.out.println(receiptItems);
    };

    public ArrayList<Pane> receiptgetItemList() {
        return receiptItems;
    }

    

}