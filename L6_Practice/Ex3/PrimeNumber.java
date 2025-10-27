public class PrimeNumber {
    private int number;
    PrimeNumber(){
        number = 1;
    }
    PrimeNumber(int n){
        if(isPrime(n)) number = n;
        else {
            System.out.println(n+" is not a prime, so initialized to 1.");
            number = 1;
        }
    }
    static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    int getPrimeNumber(){return number;}
    int next(){
        int temp = number+1;
        while(!isPrime(temp)){temp++;}
        return temp;
    }
    int previous(){
        if(number == 1) return number;
        int temp = number -1;
        while(!isPrime(temp)){temp--;}
        return temp;
    }
}