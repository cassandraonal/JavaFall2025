public class MyMath<T, U>{
    public Object add(T a, U b){
        if(a instanceof String || b instanceof String){
            return String.valueOf(a) + String.valueOf(b);
        }
        if(a instanceof Number && b instanceof Number){
            double d1 = ((Number) a).doubleValue();
            double d2 = ((Number) b).doubleValue();
            
            double result = d1 + d2;
            if(a instanceof Integer)
                return (int) result;
            return result;
        }
        if(a instanceof Boolean && b instanceof Boolean){
            return (Boolean) a || (Boolean) b;
        }
        if(a instanceof Character && b instanceof Character){
            return (int) ((Character) a) + (int)((Character) b);
        }
        return null;
    }
}
