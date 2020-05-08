import javax.swing.JOptionPane;

public class Actions {
    Events event = new Events();




    public int supplyShopping(){
        int itemsBought = 0;
        int maxItems = 3;
        if (event.getSupplyShortage()){
            maxItems = 2;
        }


        JOptionPane.showMessageDialog(null, "You have arrived at a supply shop. Here you may spend $1 to gain 1 supply.\nMaximum available for purchase: " + maxItems);

        itemsBought = Integer.parseInt(JOptionPane.showInputDialog("How many supplies would you like to purchase?"));
        while (itemsBought < 0 || itemsBought > maxItems){
            itemsBought = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Value of items bought must be between 0 and " + maxItems + "." +
                    "\nHow many supplies would you like to purchase?"));
        }

        if (itemsBought > 0){
            JOptionPane.showMessageDialog(null, "You bought " + itemsBought + " supplies." +
                    "\nYou paid $" + itemsBought  + " to the shopkeeper.");

            return itemsBought;}
        else{
            JOptionPane.showMessageDialog(null, "You bought no supplies. No money was spent.");
            return 0;
        }
    }




    public int foodShopping(){
        int itemsBought = 0;
        int maxItems = 3;
        if (event.getSupplyShortage()){
            maxItems = 2;
        }


        JOptionPane.showMessageDialog(null, "You have arrived at a food shop. Here you may spend $1 to gain 1 piece of food.\nMaximum available for purchase: " + maxItems);

        itemsBought = Integer.parseInt(JOptionPane.showInputDialog("How many pieces of food would you like to purchase?"));
        while (itemsBought < 0 || itemsBought > maxItems){
            itemsBought = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Value of items bought must be between 0 and " + maxItems + "." +
                    "\nHow much food would you like to purchase?"));
        }

        if (itemsBought > 0){
        JOptionPane.showMessageDialog(null, "You bought " + itemsBought + " pieces of food." +
                "\nYou paid $" + itemsBought + " to the shopkeeper.");

        return itemsBought;}
        else{
            JOptionPane.showMessageDialog(null, "You bought no food. No money was spent.");
            return 0;
        }
    }



}
