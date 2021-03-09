package io.swagger.configuration;

import lombok.SneakyThrows;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teste {



    @SneakyThrows
    public static void main(String[] args) {

        String ZIP = ".zip";
        LocalDate d1 = LocalDate.now().minusDays(1);
        String dataD1 = d1.format(DateTimeFormatter.ofPattern("ddMMyyyy"));

        URL url = new URL("http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_D" + dataD1 + ZIP);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream in = connection.getInputStream();
        FileOutputStream out = new FileOutputStream( "Cotacao" + dataD1 + ZIP);
        FileCopyUtils.copy(in,out);

        //FileSystemUtils.deleteRecursively(Path.of("test.zip"));

    }
}
