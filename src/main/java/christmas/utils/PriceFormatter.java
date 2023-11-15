package christmas.utils;

import java.text.DecimalFormat;

public class PriceFormatter {
    public static String formatPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }
}
