// Classe responsável pelo tratamento dos PDFs
import com.opencsv.CSVWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PDFHandler {
    private static File arquivo = new File("Padrao_TISS_Componente_Organizacional_202006.pdf");
    private static ArrayList<String> nomeArquivos = new ArrayList<>();

    public static void pdfParaTxt() throws IOException {
        PDDocument documento = PDDocument.load(arquivo);
        System.out.println(documento.isEncrypted());
        PDFTextStripper tStripper  = new PDFTextStripper();

        String text = tStripper.getText(documento);
        documento.close();

        File destino = new File("Padrao_TISS_Componente_Organizacional_202006_TXT.txt");

        FileWriter fileWriter = new FileWriter(destino);

        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void separadorDeTabelas() throws IOException{

        File txt = new File("Padrao_TISS_Componente_Organizacional_202006_TXT.txt");
        Scanner fileReader = new Scanner(txt);
        FileWriter fw;

        while(fileReader.hasNextLine()){
            String data = fileReader.nextLine();

            if(data.equals("Quadro 30 – Tabela de tipo de demandante ")){

                File tabela30 = new File(data+".txt");

                fw = new FileWriter(tabela30);

                data = fileReader.nextLine();

                do{
                    fw.write(data + "\n");
                    System.out.println(data);

                    if(fileReader.hasNextLine())
                        data = fileReader.nextLine();

                }while(!(data.equals("Fonte: Elaborado pelos autores. ")));

                fw.close();
                tabelasParaCsv(tabela30.getName());
            }

        }
    }

    public static void tabelasParaCsv(String caminho) throws IOException {

        File txt = new File(caminho);

        Scanner fileReader = new Scanner(txt);

        String temp = fileReader.nextLine();

        nomeArquivos.add(temp + ".csv");

        Writer writer = Files.newBufferedWriter(Paths.get(temp + ".csv"));

        CSVWriter csvWriter = new CSVWriter(writer);
        while(fileReader.hasNextLine()){
            temp = fileReader.nextLine();

            csvWriter.writeNext(temp.split(" ", 2));

            }
        csvWriter.flush();
        writer.close();

        }
    }
