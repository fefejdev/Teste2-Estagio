import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        final int num = 4;
        String[] src = new String[num];
        for(int i = 0; i < num; i++) {
            String nomeFile = "pocota"+ i + ".txt";
            File file = new File(nomeFile);
            FileWriter fw = new FileWriter(file);
            fw.write("pocoto"+i);
            fw.close();
            src[i] = nomeFile;
        }
        CriadorDeZip.comprime(src);

    }
}
