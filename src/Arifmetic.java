import java.util.Arrays;

public class Arifmetic implements Converter {
    String[] RIM = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    String[] ARAB = {"1","2","3","4","5","6","7","8","9","10"};
    public String calk(String a, String b, String c){
        boolean containsRIM1 = Arrays.stream(RIM).anyMatch((a)::equals);
        boolean containsRIM2 = Arrays.stream(RIM).anyMatch((c)::equals);
        boolean containsARAB1 = Arrays.stream(ARAB).anyMatch((a)::equals);
        boolean containsARAB2 = Arrays.stream(ARAB).anyMatch((c)::equals);
        int sum1;
        int sum2;
        boolean flag = false;

        if((containsRIM1) && (containsRIM2)) {
            flag = true;
            sum1 = Integer.parseInt(new Calculator().convRIM(a));
            sum2 = Integer.parseInt(new Calculator().convRIM(c));
        }else if((containsRIM1) && (containsARAB2)){
            System.out.println("Используются одновременно разные системы счисления");
            return "";
        }else if((containsARAB1) && (containsRIM2)){
            System.out.println("Используются одновременно разные системы счисления");
            return "";
        }else try {
            sum1 = Integer.parseInt(a);
            sum2 = Integer.parseInt(c);
            if((sum1 > 10) || (sum1 < 1)){
                System.out.println("Числа от 1 до 10");
                return "";
            } else if((sum2 > 10)|| (sum2 < 1)){
                System.out.println("Числа от 1 до 10");
                return "";
            }
        }catch (NumberFormatException e){
            System.out.println("Неверный формат числа");
            return "";
        }

        int sumNum;
        switch (b) {
            case "+": {
                sumNum = sum1 + sum2;
                break;
            }case "-": {
                sumNum = sum1 - sum2;
                break;
            }case "*": {
                sumNum = sum1 * sum2;
                break;
            }case "/": {
                sumNum = sum1 / sum2;
                break;
            }default:
                System.out.println("Не корректная математическая операция!");
                return "";
        }
        String sumStr = "" + sumNum;
        if(flag){
            if(sumNum < 1){
                System.out.println("В римской системе нет отрицательных чисел!(0)");
                return "";
            }else sumStr = convARAB(sumStr);
        }
        return sumStr;
    }
}
