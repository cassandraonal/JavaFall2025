/*
Add arrayList to wallet class instead of array.
So we can add money to wallet without
restriction on size of wallet.

Create a Money class which abstract
define abstract displayAmount funtion in Money
define abstract double moneyAmount funtion

create Coin, Bill class inherites from Money class
Create Penny, Nikel, Dime, Quarter extends from Coin

Create Wallet class which have Array of Money object
define total function that return total amount of Wallet
define add funtion which add Money object to wallet
define display function which display all Money object from wallet
(use displayAmount funtion of Money object)

create an interface spendable declare spend funtion
Wallet is implements from spendable

spend function use the last added money of wallet
*/
import java.util.ArrayList;
class Wallet{
    private ArrayList<Money> moneyList = new ArrayList<Money>();
    void add(Money m){
        moneyList.add(m);
    }
    void spend(){
        if(moneyList.size()>=1) moneyList.remove(moneyList.size()-1);
        else System.out.println("No money to spend.");
    }
    void display(){
        for(int i=0;i<moneyList.size();i++){
            moneyList.get(i).displayAmount();
        }
    }
    double total(){
        double sum = 0;
        for(int i=0;i<moneyList.size();i++){
            sum += moneyList.get(i).MoneyAmount();
        }
        return sum;
    }
}