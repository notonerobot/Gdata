//package de.gdata.death;
//
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//class MainTest {
//
//    @Test
//    void nulltest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(0);
//        assertThat(value)
//                .isEqualTo("");
//    }
//
//    @Test
//    void Itest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(1);
//        assertThat(value)
//                .isEqualTo("I");
//    }
//
//    @Test
//    void IVtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(4);
//        assertThat(value)
//                .isEqualTo("IV");
//    }
//
//    @Test
//    void Vtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(5);
//        assertThat(value)
//                .isEqualTo("V");
//    }
//
//    @Test
//    void IXtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(9);
//        assertThat(value)
//                .isEqualTo("IX");
//    }
//
//    @Test
//    void Xtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(10);
//        assertThat(value)
//                .isEqualTo("X");
//    }
//
//    @Test
//    void XLVtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(45);
//        assertThat(value)
//                .isEqualTo("XLV");
//    }
//
//    @Test
//    void Ltest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(50);
//        assertThat(value)
//                .isEqualTo("L");
//    }
//
//    @Test
//    void Ctest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(100);
//        assertThat(value)
//                .isEqualTo("C");
//    }
//
//    @Test
//    void Dtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(500);
//        assertThat(value)
//                .isEqualTo("D");
//    }
//
//    @Test
//    void Mtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(1000);
//        assertThat(value)
//                .isEqualTo("M");
//    }
//
//    @Test
//    void MMXXVtest() {
//        RomanNumeral variable = new RomanNumeral();
//        String value = variable.callForAction(2025);
//        assertThat(value)
//                .isEqualTo("MMXXV");
//    }
//}