# pi5-ocr
Microsserviço de OCR - Newton Paiva

### Microsserviço de OCR utilizando Java + Spring Boot + Tesseract

Method: POST
-- URL local para OCR: localhost:8080/api/ocr
Obs.: Caso o Spring Boot esteja rodando em outra porta, substitua o 8080 pela porta escolhida

##### Exemplo de input para OCR
Body formato form-data, espera dois parâmentros:
1 - KEY -> file -- VALUE -> Imagem a ser analisada
2 - KEY -> username -- VALUE -> username
##### Exemplo de output do OCR
{ Texto da imagem analisada  - HTTP - 200 - OK }

#### Caso a imagem não esteja no formato correto o serviço irá devolver a seguinte mensagem: "Extensão não suportada, favor enviar um arquivo PNG ou JPG" - HTTP - 400 - Bad Request.

### Esse microsserviço lê uma imagem e transforma em um texto utilizando o OCR Tesseract.
