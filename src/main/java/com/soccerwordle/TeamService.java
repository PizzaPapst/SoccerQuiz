package com.soccerwordle;

import com.soccerwordle.api.football.FootballApiService;
import com.soccerwordle.api.football.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service  // Wenn FootballApiService bereits als Service annotiert ist, dann ist @Autowired korrekt
public class TeamService {

    @Autowired
    private FootballApiService footballApiService;

    public Team getTeam(String teamName) {
        Team team = footballApiService.getTeam(teamName);

        // Die URL des Logos abrufen
        String imageUrl = team.getLogo();  // Hier den tatsächlichen Link zu deinem Team-Logo verwenden

        // Bild von der URL laden
        BufferedImage originalImage = null;
        try {
            originalImage = loadImageFromUrl(imageUrl);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Laden des Bildes: " + e.getMessage(), e);
        }

        // Bild in Graustufen konvertieren
        BufferedImage grayscaleImage = convertToGrayscale(originalImage);

        byte[] grayscaleImageBytes = null;
        try {
            grayscaleImageBytes = convertToByteArray(grayscaleImage);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Konvertieren des Bildes: " + e.getMessage(), e);
        }

        // Speichern der byte[] im Team-Objekt
        team.setLogoByteArray(grayscaleImageBytes);

        // Optional: Graustufenbild auch als Datei speichern (falls gewünscht)
        try {
            saveImage(grayscaleImage, "src/grayscale_logo.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return team;
    }

    // Methode zum Laden eines Bildes von einer URL
    private static BufferedImage loadImageFromUrl(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        InputStream inputStream = url.openStream();
        return ImageIO.read(inputStream);
    }

    // Methode zur Umwandlung eines Bildes in Graustufen
    private static BufferedImage convertToGrayscale(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        // Neues Bild im Graustufenformat erstellen
        BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        // Grafikobjekt für die Bearbeitung des neuen Bildes
        Graphics2D g2d = grayscaleImage.createGraphics();

        // Das Originalbild in das Graustufenbild zeichnen
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.dispose();

        return grayscaleImage;
    }

    // Methode zum Konvertieren eines BufferedImage in ein byte[]
    private static byte[] convertToByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Bild als PNG in den Byte-Array schreiben
        ImageIO.write(image, "PNG", byteArrayOutputStream);

        // Das Byte-Array zurückgeben
        return byteArrayOutputStream.toByteArray();
    }

    // Methode zum Speichern des Graustufenbildes als Datei
    private static void saveImage(BufferedImage image, String filename) throws IOException {
        File outputFile = new File(filename);
        ImageIO.write(image, "PNG", outputFile);  // Bild als PNG speichern
    }
}
