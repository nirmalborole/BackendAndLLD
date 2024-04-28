package Generics.Documents;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {
        PdfDocument pdf= new PdfDocument("I am in new pdf");
        DocumentPrinter<PdfDocument> pdfDocumentDocumentPrinter= new DocumentPrinter<>(pdf);
        pdfDocumentDocumentPrinter.print();

        CsvDocument csv= new CsvDocument("in new csv");
        DocumentPrinter<CsvDocument> csvprint= new DocumentPrinter<>(csv);
        csvprint.print();

//        Student s= new Student(10,"nirma");
//        DocumentPrinter<Student> si= new DocumentPrinter<>(s);
//        si.print();

        SpecialPdf specialPdf= new SpecialPdf("I am special");
        DocumentPrinter<SpecialPdf> sppdf= new DocumentPrinter<>(specialPdf);
        sppdf.print();

    }
}
