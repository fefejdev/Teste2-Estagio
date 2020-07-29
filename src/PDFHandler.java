// Classe responsável pelo tratamento dos PDFs
import com.oracle.deploy.update.UpdateCheckFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PDFHandler {
    //TODO Mecanismos para extrair dados do pdf
    static File arquivo = new File("Padrao_TISS_Componente_Organizacional_202006.pdf");

    public static void pdfParaTxt() throws IOException {
        PDDocument documento = PDDocument.load(arquivo);
        System.out.println(documento.isEncrypted());
        PDPage page = documento.getPage(81);
        PDFTextStripper tStripper  = new PDFTextStripper();

        String text = tStripper.getText(documento);
        documento.close();

        File destino = new File("Padrao_TISS_Componente_Organizacional_202006_TXT.txt");

        FileWriter fileWriter = new FileWriter(destino);

        fileWriter.write(text);
        fileWriter.close();
    }

}
