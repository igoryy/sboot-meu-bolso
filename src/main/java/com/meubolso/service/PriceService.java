package com.meubolso.service;

import com.meubolso.exception.PriceException;
import com.meubolso.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Service
@Slf4j
public class PriceService {

    LocalDate d1 = LocalDate.now().minusDays(1);
    String dataD1 = d1.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
    String nameFile = "Price" + dataD1 + Constants.ZIP;

    @SneakyThrows
    public boolean readPriceB3(){

        URL url = new URL("http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_D" + dataD1 + Constants.ZIP);
        log.info("readPriceB3 - > Tentativa de busca de arquivo B3 (Cotacao Historica) " + url.getPath() );

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try{
            InputStream in = connection.getInputStream();

            FileOutputStream out = new FileOutputStream(nameFile );
            FileCopyUtils.copy(in,out);

            File file = new File(nameFile);

            log.info("readPriceB3 -> Arquivo ZIP encontrado " + file.getName());
            readFileInZip(nameFile);

            return this.readFileInZip(nameFile);

        }catch (RuntimeException e){
            throw new PriceException("Erro ao buscar arquivo B3 " + e.getMessage());
        }
    }

    @SneakyThrows
    public boolean readFileInZip(String nameFile){

        ZipFile zipFile = new ZipFile(nameFile);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        log.info("readFileInZip -> Leitura arquivo ZIP");

        try{
            while (entries.hasMoreElements()){
                ZipEntry entry = entries.nextElement();

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(zipFile.getInputStream(entry)));

                Stream<String> line = br.lines();

                line.forEach(item -> System.out.println(item));
            }

           return this.deleteFilePriceB3();

        }catch (RuntimeException e){
            throw new PriceException("Erro ao ler arquivo ZIP " + e.getMessage());
        }
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
