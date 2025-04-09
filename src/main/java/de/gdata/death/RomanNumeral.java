//package de.gdata.death;
//
//public class RomanNumeral {
//
//    String out = "";
//
//    public int numeral1(int input, int val, int nextval, String type, String big, String small){
//
//        int nextnumr = input / nextval;
//            if (nextnumr == 9) {
//                input = input - nextnumr * nextval;
//        }
//
//        int numr = input / val;
//        input = input - numr * val;
//
//        if(nextnumr == 9){
//            out = out + (small + big);
//            //System.out.print(out);
//        } else if (numr == 4) {
//            out = out + (type + big);
//            //System.out.print(out);
//        } else {
//            for (int i=numr; i>0; i--) {
//                out = out + type;
//                //System.out.print(out);
//
//            }
//        }
//
//        return input;
//    }
//    public int numeral5(int input, int val, String type, String big){
//
//        int numr = input / val;
//        input = input - numr * val;
//
//        if (numr == 4) {
//            out = out + (type + big);
//            //System.out.print(out);
//        } else {
//            for (int i=numr; i>0; i--) {
//                out = out + type;
//                //System.out.print(out);
//
//            }
//        }
//
//        return input;
//    }
//
//    public String callForAction(int input) {
//        //System.out.println(input);
//        //M
//        input = numeral5(input, 1000,"M","");
//        //System.out.println(input);
//        //D
//        input = numeral1(input, 500,100,"D","M","C");
//        //System.out.println(input);
//        //C
//        input = numeral5(input, 100,"C","D");
//        //System.out.println(input);
//        //L
//        input = numeral1(input, 50,10,"L","C","X");
//        //System.out.println(input);
//        //X
//        input = numeral5(input, 10,"X","L");
//        //System.out.println(input);
//        //V
//        input = numeral1(input, 5,1,"V","X","I");
//        //System.out.println(input);
//        //I
//        input = numeral5(input, 1,"I","V");
//        //System.out.println(input);
//        return out;
//    }
//}
