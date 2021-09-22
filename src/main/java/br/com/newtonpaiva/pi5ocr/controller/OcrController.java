package br.com.newtonpaiva.pi5ocr.controller;


import br.com.newtonpaiva.pi5ocr.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping()
    public ResponseEntity<String> realizaOcr(@RequestParam(name="file") MultipartFile file, @RequestParam(name="username") String username) throws Exception{

        String response = ocrService.realizerOcr(file, username);
        if(response == null){
            return ResponseEntity.badRequest().body("Extensão não suportada, favor enviar um arquivo PNG ou JPG");
        } else {
            return ResponseEntity.ok(response);
        }
    }
}