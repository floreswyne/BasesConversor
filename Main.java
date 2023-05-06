package basesconversor;

import basesconversor.enums.BasesOrders;
import basesconversor.factories.Conversor;

public class Main {

    public static void main(String[] args) {

        Conversor conversor = new Conversor(BasesOrders.TEN_TO_BINARY);
        conversor.convert("123456789");

        conversor = new Conversor(BasesOrders.BINARY_TO_TEN);
        conversor.convert("111010110111100110100010101");

        conversor = new Conversor(BasesOrders.TEN_TO_FOUR);
        conversor.convert("9");

        conversor = new Conversor(BasesOrders.FOUR_TO_TEN);
        conversor.convert("21");

        conversor = new Conversor(BasesOrders.TEN_TO_OCTAL);
        conversor.convert("9");

        conversor = new Conversor(BasesOrders.OCTAL_TO_TEN);
        conversor.convert("11");

        conversor = new Conversor(BasesOrders.TEN_TO_HEXA);
        conversor.convert("63");

        conversor = new Conversor(BasesOrders.HEXA_TO_TEN);
        conversor.convert("3F");

        conversor = new Conversor(BasesOrders.TEN_TO_THIRTY_TWO);
        conversor.convert("12558965447");

        conversor = new Conversor(BasesOrders.THIRTY_TWO_TO_TEN);
        conversor.convert("BM956M7");

    }

}
