package com.singleton.sunmiprinterlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import com.singleton.sunmilibrary.utils_printer.BluetoothUtil;
import com.singleton.sunmilibrary.utils_printer.SunmiPrintHelper;
import com.singleton.sunmilibrary.utils_printer.SunmiPrinterStatus;

public class MainActivity extends AppCompatActivity implements SunmiPrinterStatus {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SunmiPrintHelper.getInstance().setSunmiPrinterStatus(this);
        SunmiPrintHelper.getInstance().initSunmiPrinterService(this);
    }

    @Override
    public void sunmiPrinterOnConnected() {
        int tamanoLetra = 24;
        if (!BluetoothUtil.isBlueToothPrinter) {
            SunmiPrintHelper sunmiPrinter = SunmiPrintHelper.getInstance();
            sunmiPrinter.printText("Hola Mundo", tamanoLetra, false, false);
            sunmiPrinter.feedPaper();
        }
    }

    @Override
    public void sunmiPrinterOnDisconnected() {
        Toast.makeText(this, "No se reconoció ninguna impresora", Toast.LENGTH_SHORT).show();
    }
}