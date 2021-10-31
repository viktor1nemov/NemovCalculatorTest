import java.util.Scanner;

public class Calculator extends Arifmetic  {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String abc = scanner.nextLine();
        try {
            String[] data = abc.split(" ");
            String a = data[0];
            String b = data[1];
            String c = data[2];
            if (data.length > 3) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *))");
            }else {
                System.out.println(a + " " + b + " " + c + " =");
                System.out.println(calculator.calk(a,b,c));}
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Cтрока не является математической операцией");
        }
    }
}


