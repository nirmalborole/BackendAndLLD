package Generics.Documents;

public class CsvDocument extends Document{
    public CsvDocument(String content) {
        super(content);
    }

    @Override
    public String toString() {
        return "CsvDocument{" +
                "content='" + content + '\'' +
                '}';
    }
}
