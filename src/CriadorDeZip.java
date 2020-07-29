import java.io.*;
import java.util.zip.*;

public class CriadorDeZip {
    static final String caminho = "Teste_Intuitive_Care_Fernando_Gomes.zip"; // nome do arquivo .zip a ser criado
    static final int buffer  = 1024;

    public static void comprime(final String... srcs) throws IOException {

    int controlador;
    final byte[] dados = new byte[buffer];

    final FileOutputStream fos = new FileOutputStream(new File(caminho));
    final ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));

    for (final String src : srcs) {
        final File arquivo = new File(src);
        final FileInputStream fis = new FileInputStream(arquivo);
        final BufferedInputStream bis = new BufferedInputStream(fis, buffer);
        final ZipEntry ze = new ZipEntry(arquivo.getName());
        zos.putNextEntry(ze);

        while ((controlador = bis.read(dados, 0, buffer)) != -1) {
            zos.write(dados, 0, controlador);
        }
        bis.close();
    }

    zos.close();
}
}




