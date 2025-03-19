import java.math.BigDecimal;
import java.math.RoundingMode;

public class main {
    public static void main(String[] args) {
        var value1 = 0.1f;
        var value2 = 0.2f;

        System.out.println(value1 + value2);

        System.out.println(2.00f - 1.1f);
        System.out.println(2.00f - 1.2f);
        System.out.println(2.00f - 1.3f);
        System.out.println(2.00f - 1.4f);
        System.out.println(2.00f - 1.5f);
        System.out.println(2.00f - 1.6f);
        System.out.println(2.00f - 1.7f);
        System.out.println(2.00f - 1.8f);
        System.out.println(2.00f - 1.9f);

        //PARA MELHORAR A PRECISÃO USAR A CLASSE BIGDECIMAL
        System.out.println("=============USANDO BIGDECIMAL================");
        var value11 = new BigDecimal(0.1);
        var value22 = new BigDecimal(0.2);
        var value3 = new BigDecimal(56.36);
        var value4 = new BigDecimal(4.34);

        System.out.println(value11.add(value22));
        //valor1.divide(valor2, total_casas, tipo_de_arredondamento)
        System.out.println(value3.divide(value4, 4, RoundingMode.CEILING));

        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.1)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.2)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.3)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.4)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.5)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.6)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.7)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.8)));
        System.out.println(new BigDecimal(2.00f).subtract(new BigDecimal(1.9)));

    }
}
