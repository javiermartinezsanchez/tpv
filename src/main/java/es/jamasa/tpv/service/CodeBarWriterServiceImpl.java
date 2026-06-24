package es.jamasa.tpv.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;

@Service
public class CodeBarWriterServiceImpl implements CodeBarWriterService {

	@Override
	public void genCodeBarEAN13(String codigoAGenerar) {
		int ancho = 400;
        int alto = 200;
        String archivo = "codigo_interno_001.png";
        try {
        EAN13Writer writer = new EAN13Writer();
        // Pasamos los 12 dígitos; el escritor se encarga del cálculo matemático de control
        BitMatrix bitMatrix = writer.encode(codigoAGenerar, BarcodeFormat.EAN_13, ancho, alto);

        Path path = FileSystems.getDefault().getPath(archivo);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        
        System.out.println("Código comercial interno generado correctamente.");
        }
        catch (IOException e) {
        	
        }
	}

	@Override
	public List<String>	 genCodeBarEAN12Base64(List<String> listaCodigos) {
		List<String> imagenesBase64 = new ArrayList<>();
        EAN13Writer writer = new EAN13Writer();
        try {
            for (String codigoBase : listaCodigos) {
                // Generar matriz de bits (300px ancho x 120px alto)
                BitMatrix bitMatrix = writer.encode(codigoBase, BarcodeFormat.EAN_13, 300, 120);
                
                // Escribir la imagen en un flujo de bytes en memoria
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "PNG", outputStream);
                
                // Convertir los bytes a una cadena Base64
                String base64 = Base64.getEncoder().encodeToString(outputStream.toByteArray());
                imagenesBase64.add(base64);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return imagenesBase64;
	}

}
