
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
             src.add("fffff.csv");
             src.add("Padrao_TISS_Componente_Organizacional_202006.pdf");
            CriadorDeZip.comprime(src);
        } else if(verifica == 3){
            PDFHandler.pdfParaTxt();
            PDFHandler.separadorDeTabelas();

        }



    }

    static public int Menu(){
        Scanner scan = new Scanner(System.in);
        int escolha;
            System.out.println("Deseja seguir a rotina normal ou comprimir algum arquivo específico? Ou deseja apenas passar o arquivo para txt? \n");
            System.out.println("1- Rotina normal /  / 2 - Arquivo Específico /  / 3 - Arquivo para txt");
            escolha = scan.nextInt();
            scan.nextLine();
        return escolha;
    }
}
