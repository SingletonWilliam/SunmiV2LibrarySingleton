package com.singleton.sunmiprinterlibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.singleton.sunmilibrary.utils_printer.BluetoothUtil;
import com.singleton.sunmilibrary.utils_printer.Alignment;
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
        Toast.makeText(this, "Printer is connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sunmiPrinterOnDisconnected() {
        Toast.makeText(this, "Printer is disconnected", Toast.LENGTH_SHORT).show();
    }

    public void onClickTestPrinter(View view) {
        int fontSize = 24;
        if (!BluetoothUtil.isBlueToothPrinter) {
            SunmiPrintHelper sunmiPrinter = SunmiPrintHelper.getInstance();
            sunmiPrinter.setFonSize(fontSize);
            sunmiPrinter.setAlign(Alignment.ALIGN_CENTER);
            sunmiPrinter.printText("Hello world");
            sunmiPrinter.feedPaper();
        }
    }
}