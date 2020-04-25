import javax.swing.JOptionPane;

public class Actions {

    public int foodShopping(){
        int itemsBought = 0;

        JOptionPane.showMessageDialog(null, "You have arrived at a food shop. Here you may spend $2 to gain 1 piece of food.");

        itemsBought = Integer.parseInt(JOptionPane.showInputDialog("How many pieces of food would you like to purchase?"));

        JOptionPane.showMessageDialog(null, "You bought " + itemsBought + " pieces of food." +
                "\nYou paid $" + itemsBought * 2 + " to the shopkeeper.");

        return itemsBought;
    }



}
