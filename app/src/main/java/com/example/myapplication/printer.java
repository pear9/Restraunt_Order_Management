package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class printer extends AppCompatActivity {
    Button scan;
    Switch bon,bdis;
    TextView textView3;
    ListView available,paired;
    ArrayList<String> scanned,bonded;
    ImageView bimage;
    ArrayAdapter<String> a1,a2;
    BluetoothAdapter bluetoothAdapter;

    private final BroadcastReceiver obroadcastreceiver=new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(action.equals(bluetoothAdapter.ACTION_STATE_CHANGED)){
                final int state =intent.getIntExtra(bluetoothAdapter.EXTRA_STATE,bluetoothAdapter.ERROR);
                switch (state){
                    case BluetoothAdapter.STATE_OFF:
                        toast("Turned Off");
                        bon.setChecked(false);
                        textView3.setVisibility(View.INVISIBLE);
                        scan.setVisibility(View.INVISIBLE);
                        available.setVisibility(View.INVISIBLE);
                        paired.setVisibility(View.INVISIBLE);
                        bdis.setVisibility(View.INVISIBLE);
                        bimage.setImageResource(R.drawable.blutooth_off);
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        toast("Turning Off");

                        break;
                    case  BluetoothAdapter.STATE_ON:
                        toast("Turned On");
                        bon.setChecked(true);
                        textView3.setVisibility(View.VISIBLE);
                        scan.setVisibility(View.VISIBLE);
                        available.setVisibility(View.VISIBLE);
                        paired.setVisibility(View.VISIBLE);
                        bdis.setVisibility(View.VISIBLE);
                        bimage.setImageResource(R.drawable.blutooth_on);
                        Set<BluetoothDevice> devices =bluetoothAdapter.getBondedDevices();
                        for(BluetoothDevice device:devices){
                            Log.d("TAG1","getting paired device");
                            bonded.add(device.getName());}
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        toast("Turning On");
                        break;
                }

            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(obroadcastreceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

        bimage=findViewById(R.id.bimage);
        scan =findViewById(R.id.scan);
        bon=findViewById(R.id.switch1);
        bdis=findViewById(R.id.switch2);
        textView3=findViewById(R.id.textView3);
        available=findViewById(R.id.available);
        paired=findViewById(R.id.paired);
        a1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,scanned);
        a2=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,bonded);

        if(bluetoothAdapter.isEnabled()){
            bon.setChecked(true);
            textView3.setVisibility(View.VISIBLE);
            scan.setVisibility(View.VISIBLE);
            available.setVisibility(View.VISIBLE);
            paired.setVisibility(View.VISIBLE);
            bdis.setVisibility(View.VISIBLE);
            bimage.setImageResource(R.drawable.blutooth_on);
            Set<BluetoothDevice> devices =bluetoothAdapter.getBondedDevices();
            for(BluetoothDevice device:devices){
                Log.d("TAG1","getting paired device"+device.getName());
                bonded.add(device.getName());
                a2.notifyDataSetChanged();
                paired.setAdapter(a2);
                }}
            else{
            bon.setChecked(false);
            textView3.setVisibility(View.INVISIBLE);
            scan.setVisibility(View.INVISIBLE);
            available.setVisibility(View.INVISIBLE);
            paired.setVisibility(View.INVISIBLE);
            bdis.setVisibility(View.INVISIBLE);
            bimage.setImageResource(R.drawable.blutooth_off);

            }

        bon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(!bluetoothAdapter.isEnabled()){
                        Intent intent=new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivity(intent);
                        IntentFilter onoff =new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
                        registerReceiver(obroadcastreceiver,onoff);


                        }

                    }
                if(!isChecked){
                    if(bluetoothAdapter.isEnabled()){
                        bluetoothAdapter.disable();
                        IntentFilter onoff =new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
                        registerReceiver(obroadcastreceiver,onoff);


                    }}
            }
        });

    }
    public void toast(String t){
        Toast.makeText(getApplicationContext(),t,Toast.LENGTH_SHORT).show();
    }
}
