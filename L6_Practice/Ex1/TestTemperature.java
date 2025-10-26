public class TestTemperature {
    public static void main(String args[]){
        Temperature a = new Temperature();
        System.out.println(a.getTempKelvin()); // 0
        System.out.println(a.getTempCelsius()); // -273.15
        System.out.println(a.getTempFahrenheit()); // -459.67
        a.setTempKelvin(100);
        a.display();
        /*kelvin: 100
        Celsius: -173.15
        Fahrenheit: -279.67*/
        a.setTempCelsius(100);
        a.display();
        /*kelvin: 373.15
        Celsius: 100
        Fahrenheit: 212*/
        a.setTempFahrenheit(100);
        System.out.println(a);
        /*kelvin: 310.928
        Celsius: 37.7778
        Fahrenheit: 100
        */
    }
}
