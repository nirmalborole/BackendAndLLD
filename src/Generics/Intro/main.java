package Generics.Intro;

public class main {
    public static void main(String[] args) {
        IntegerToPrint np= new IntegerToPrint(10);
        np.print();

        DoubleToPrint dp= new DoubleToPrint(23.4);
        dp.print();

        ObjectPrinter iop= new ObjectPrinter(23);
        ObjectPrinter dop= new ObjectPrinter(23d);
        ObjectPrinter sop= new ObjectPrinter("Nirmal");
        Integer io=(Integer) sop.get();

        Integer i= (Integer)iop.get();
    }
}
