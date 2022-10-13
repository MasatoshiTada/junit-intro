package com.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PointCalculator {

    /**
     * 買物金額をもとにポイントを計算します。
     * ポイント計算ルールは次のとおりです。
     * 1. 買物金額1〜999円ではポイント無し
     * 2. 買物金額1000〜9999円ではポイントが3%
     * 3. 買物金額10000円以上ではポイントが5%
     * 4. すべて小数点以下は切り捨て
     * 5. 最大7文字
     * 6. 0以下や数字以外の場合はエラー
     *
     * @param amountStr 買物金額
     * @return ポイント
     * @throws RuntimeException amountが0以下や数字以外の場合
     */
    public int calculate(String amountStr) {
        try {
            BigDecimal amount = new BigDecimal(amountStr);
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new RuntimeException("エラー");
            }
            String rate;
            if (amount.compareTo(BigDecimal.valueOf(999)) <= 0) {
                rate = "0";
            } else if (amount.compareTo(BigDecimal.valueOf(9999)) <= 0) {
                rate = "0.03";
            } else {
                rate = "0.05";
            }
            BigDecimal point = amount.multiply(new BigDecimal(rate)).round(new MathContext(0, RoundingMode.FLOOR));
            return point.intValue();
        } catch (NumberFormatException e) {
            throw new RuntimeException("エラー", e);
        }
    }
}
