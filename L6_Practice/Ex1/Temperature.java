public class Temperature {
    private double kelvin;

    Temperature(){
        this(0);
    }
    Temperature(double kelvin){
        this.kelvin = kelvin;
    }
    public void setTempKelvin(double kelvin){
        this.kelvin = kelvin;
    }
    public void setTempFahrenheit(double f){
        kelvin = (5.0/9) * (f - 32) + 273.15;
    }


    public void setTempCelcius(double celsius){
        kelvin = celsius + 273.15;
    }

    public double getTempKelvin(){return kelvin;}

    public double getTempFahrenheit(){
        double fahrenheit = (9.0/5) * (kelvin - 273.15)+ 32;
        return fahrenheit;
    }
    public double getTempCelsius(){
        double celsius = kelvin - 273.15;
        return celsius;
    }
    public void display(){
        System.out.println("Kelvin: "+kelvin);
        System.out.println("Fahrenheit: "+getTempFahrenheit());
        System.out.println("Celsius: "+getTempCelsius());
    }
    public String toString(){
        String s = "Kelvin: "+kelvin+ "/n";
        s += "Fahrenheit: "+ +getTempFahrenheit()+ "/n";
        s += "Celsius: "+getTempCelsius();
        return s;
    }

}
