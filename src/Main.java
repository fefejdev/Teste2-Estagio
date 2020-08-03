
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int verifica;
        ArrayList<String> src = new ArrayList<>();
        verifica = Menu();
        String escolha;
        if(verifica == 2) {
            do {
                System.out.println("Digite o path do arquivo que desejas comprimir\n");
                src.add(scan.nextLine());
                scan.nextLine();
                System.out.println("Deseja adicionar outro arquivo? S/N");
                escolha = scan.next();
            }while(escolha.equals("S"));
            CriadorDeZip.comprime(src);
        } else if(verifica == 1){
            PDFHandler.pdfParaTxt();
            PDFHandler.separadorDeTabelas();
            CriadorDeZip.comprime(PDFHandler.getNomeArquivos());
        }

    }

    static public int Menu(){
        Scanner scan = new Scanner(System.in);
        int escolha;
            System.out.println("Deseja seguir a rotina normal ou comprimir algum arquivo específico?  \n");
            System.out.println("1- Rotina normal /  / 2 - Arquivo Específico ");
            escolha = scan.nextInt();
            scan.nextLine();
        return escolha;
    }
}
