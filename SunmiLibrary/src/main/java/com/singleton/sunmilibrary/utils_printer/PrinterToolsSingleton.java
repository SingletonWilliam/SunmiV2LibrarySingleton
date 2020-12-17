package com.singleton.sunmilibrary.utils_printer;

public class PrinterToolsSingleton {
    SunmiPrintHelper sunmiPrinter;
    int textSize = 24;
    public PrinterToolsSingleton(SunmiPrintHelper printHelper) {
        this.sunmiPrinter = printHelper;
    }


    public void printRow(String message){
        sunmiPrinter.printText(message + "\n", textSize, false, false);
    }
    public void printRow(String message, int textSize, boolean isBold){
        sunmiPrinter.printText(message + "\n", textSize, isBold, false);
    }
    public void printRow(String message, boolean isBold){
        sunmiPrinter.printText(message + "\n", textSize, isBold, false);
    }

    public void printRow(String message, boolean isBold, boolean isUnderline){
        sunmiPrinter.printText(message + "\n", textSize, isBold, isUnderline);
    }

    public void printCenterRow(String message){
        sunmiPrinter.printText(centerString(message) + "\n", textSize, false, false);
    }

    public void printCenterRow(String message, boolean isBold){
        sunmiPrinter.printText(centerString(message) + "\n", textSize, isBold, false);
    }

    public void printCenterRow(String message, boolean isBold, boolean isUnderline){
        sunmiPrinter.printText(centerString(message) + "\n", textSize, isBold, isUnderline);
    }

    public void printLine(){
        sunmiPrinter.printText(lineCharacteres("-")+ "\n", textSize, true, false);
    }

    public void printLine(String character){
        sunmiPrinter.printText(lineCharacteres(character)+ "\n", textSize, true, false);
    }

    public void printQR(String data){
        sunmiPrinter.printQr(data, 4, 3);
    }

    public void printSaltoLinea(){
        sunmiPrinter.printText("\n", textSize, false, false);
    }

    public void feedPaper() {
        sunmiPrinter.feedPaper();
    }



    private String lineCharacteres(String character) {
        String acumCharacter = "";
        for (int i = 0; i < cantidadCaracteresPorFila(); i++) {
            acumCharacter += character;
        }
        return acumCharacter;
    }

    private int cantidadCaracteresPorFila(){
        switch (textSize){
            case 24:
                return 32;
            default:
                return 32;
        }
    }

    private String centerString(String s) {
        return centerString(s, cantidadCaracteresPorFila(), ' ');
    }
    private String centerString(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }


}
