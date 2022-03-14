package zhaw.devops;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class App {
    /**
     * Create a PDF file with PDFBox
     * 
     * @throws IOException
     */
    public void createPdf() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        PDFont fontDefault = PDType1Font.HELVETICA;

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Create title
        contentStream.beginText();
        contentStream.setFont(fontBold, 12);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText("DevOps-Kurs FS2022 an der ZHAW");
        contentStream.endText();
        
        // Create text
        contentStream.beginText();
        contentStream.setFont(fontDefault, 10);
        contentStream.newLineAtOffset(50, 680);
        contentStream.showText("Dieser Inhalt wurde mithilfe der Bibliothek PDFBox erstellt.");
        contentStream.endText();

        contentStream.close();

        // Add information about document
        document.getDocumentInformation().setCreator("ZHAW");
        document.getDocumentInformation().setAuthor("ZHAW");
        document.getDocumentInformation().setTitle("DevOps: FS2022 ZHAW");
        document.getDocumentInformation().setSubject("Gradle-Beispiel");

        document.save("Dokument.pdf");
        document.close();
    }

    public static void main(String[] args) {
        try {
            new App().createPdf();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
