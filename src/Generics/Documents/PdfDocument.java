package Generics.Documents;

public class PdfDocument extends Document{
    public PdfDocument(String content) {
        super(content);
    }

    @Override
    public String toString() {
        return "PdfDocument{" +
                "content='" + content + '\'' +
                '}';
    }
}
