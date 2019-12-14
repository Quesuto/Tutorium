import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MakeNikolaus {

    public static void main(String args[]) throws IOException {

        // ////////////////////////////////////////////////////
        // Aufgabe a) Pfad zur Bilddatei auf IHREM Rechner anpassen.
        // ////////////////////////////////////////////////////

        // Pfad zur Bilddatei:
        String path = System.getProperty("user.dir") + "/Java/Abgabe 8"; // Sucht euch den Path der Datei raus.
        String filename = path + "/Nikolaus.jpg";
        System.out.println(filename);

        // ////////////////////////////////////////////////////
        // Folgenden Code bitte VOR den Aufgaben b),c),d) stehen lassen
        // ////////////////////////////////////////////////////

        // Lade Bilddatei:
        MyFile f = new MyFile(null);
        BufferedImage img = loadImage(f, filename);
        // Konvertiere in 2D Array
        int[][] imageArray = BufferedImageToArray(img);

        // Lies Bildgröße aus:
        int width = img.getWidth(); // 300px
        int height = img.getHeight(); // 600px

        /////////////////////////// AUFGABEN ///////////////////////////////
        // b)
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = imageArray[y][x];
                // c)
                if (isBlue(color)) {
                    imageArray[y][x] = makeColor(255, 0, 0);
                }
                // d)
                if (y >= (420)) {
                    imageArray[y][x] = makeColor(0, 0, 0);
                }

                // e)
                if (y >= (420)) {
                    if (x <= 255)
                        imageArray[y][x] = makeColor(0, x, 0);
                    else
                        imageArray[y][x] = makeColor((x - 255) * 4, 255, 0);

                }
            }

        }

        ///////////////////////////////////////////////////////////////////////

        // ////////////////////////////////////////////////////
        // Den folgenden Code bitte immer NACH Ihrem Code stehen lassen:
        // ////////////////////////////////////////////////////

        // Verwandle Array zu Bilddatei
        ArrayToBufferedImage(imageArray, img);
        // Schreibe Bild an den selben Ort wie das Eingangsbild
        writeImage(f, img);
    }

    // ////////////////////////////////////////////////////
    //
    //
    // Bitte Funktionen unterhalb dieses Kommentars NICHT verändern
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    // Oh, Sie haben doch entschieden, bis hier hin weiterzulesen?
    // Na dann hoffe ich, Sie lernen noch was schönes dabei :)
    //
    // ////////////////////////////////////////////////////

    // Funktion die den Farbwert in die Bestandteile r,g,b aufteilt
    // und überprüft, ob ein sehr hoher Blauanteil und sehr niedriger Rotanteil
    // vorliegt:
    private static boolean isBlue(int color) {
        int r = (color >> 16) & 0xff;
        int g = (color >> 8) & 0xff;
        int b = color & 0xff;

        if (b > 200 && r < 50) {
            return true;
        } else {
            return false;
        }
    }

    // Funktion, die r,g,b Intensitätswerte nimmt und in einen Pixelwert umwandelt.
    public static int makeColor(int r, int g, int b) {
        return (255 << 24) | (r << 16) | (g << 8) | b;
    }

    // Konvertiert ein BufferedImage Objekt in ein 2D Array
    public static int[][] BufferedImageToArray(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        int[][] twoDarray = new int[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                twoDarray[y][x] = img.getRGB(x, y);
            }
        }

        return twoDarray;
    }

    // Konvertiert ein 2D Array in ein BufferedImage Objekt
    public static void ArrayToBufferedImage(int[][] twoDarray, BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                img.setRGB(i, j, twoDarray[j][i]);
            }
        }
    }

    // Lädt eine Bilddatei am angegebenen Pfad
    public static BufferedImage loadImage(MyFile f, String filename) {
        BufferedImage img = null;
        System.out.println("Lade Bild:");
        // Try to read the image
        try {
            f.myFile = new File(filename);
            System.out.println("Prüfe Pfad: " + f.myFile.getPath());
            img = ImageIO.read(f.myFile);
            System.out.println("Bild erfolgreich geladen");
        } catch (IOException e) {
            System.out.println(e);
        }
        return img;
    }

    // Speichert das bearbeitete Bild an der selben Stelle wie das originale Bild
    public static void writeImage(MyFile f, BufferedImage img) {
        System.out.println("Speichere Bild:");
        try {
            File g = new File(f.myFile.getParent() + "/NewNikolaus.jpg");
            ImageIO.write(img, "jpg", g);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Bild erfolgreich gespeichert:");
        System.out.println(f.myFile.getParent() + "/NewNikolaus.jpg");
    }
}

// Wrapperklasse, um File Objekt weiterzugeben
class MyFile {
    public File myFile;

    MyFile(File myFile) {
        this.myFile = myFile;
    }
}