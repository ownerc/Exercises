package loja;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandler {

    public static int readCode(Scanner sc) throws InputMismatchException {
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        return codigo;
    }
}

