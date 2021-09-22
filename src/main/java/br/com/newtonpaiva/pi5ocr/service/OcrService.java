package br.com.newtonpaiva.pi5ocr.service;

import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

@Service
public class OcrService {

    public String realizerOcr(MultipartFile file, String username) throws Exception {
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!"png".equals(ext) && !"jpg".equals(ext)) {
            return null;
        }

        String resultado = "";

        try {
            BufferedImage img = ImageIO.read(file.getInputStream());
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
            resultado = "";
            tesseract.setLanguage("por");
            resultado = tesseract.doOCR(img);
        } catch (IOException e) {
            throw new Exception("Erro ao ler arquivo");
        }
        return resultado;
    }

}
