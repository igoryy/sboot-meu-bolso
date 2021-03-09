package com.meubolso.service;

import com.meubolso.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class PriceService {

    @SneakyThrows
    public boolean readPriceB3(){

        LocalDate d1 = LocalDate.now().minusDays(1);
        String dataD1 = d1.format(DateTimeFormatter.ofPattern("ddMMyyyy"));

        URL url = new URL("http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_D" + dataD1 + Constants.ZIP);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream in = connection.getInputStream();

        String nameFile = "Price" + dataD1 + Constants.ZIP;
        FileOutputStream out = new FileOutputStream(nameFile );
        FileCopyUtils.copy(in,out);

        File file = new File(nameFile);

        return file.exists() != false ? true : false;

    }



    @SneakyThrows
    public boolean deleteFilePriceB3(){

        LocalDate d1 = LocalDate.now().minusDays(1);
        String dataD1 = d1.format(DateTimeFormatter.ofPattern("ddMMyyyy"));

        File file = new File("Price" + dataD1 + Constants.ZIP);

        if(file.exists()){
            FileSystemUtils.deleteRecursively(Path.of("Price" + dataD1 + Constants.ZIP));
            return true;
        }
        return false;
    }
}
