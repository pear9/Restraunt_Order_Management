package com.example.myapplication;


import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class bluetooth extends AppCompatActivity  {
    private final static int REQUEST_ENABLE_BT = 0;
    private final static int REQUEST_DISCOVER_BT = 1;
    BluetoothAdapter bluetoothAdapter;
    BluetoothSocket socket;
    ImageView bimage;
    ListView available, paired;
    Switch bdiscoverable, bon;
    TextView btext;
    ArrayAdapter<String> arrayAdapter1, arrayAdapter2;
    ArrayList<String> scannedarray, pairedarray;

    ParcelUuid[] uuidno;
    BluetoothDevice[] btdevice=new BluetoothDevice[56];
    Button scan;
    byte[] readBuffer;
    int readBufferPosition;
    volatile boolean stopWorker;
    OutputStream mmOutputStream;
    InputStream mmInputStream;
    Thread workerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth);
      scan = findViewById(R.id.scan);
//        available = findViewById(R.id.available);
        paired = findViewById(R.id.paired);
        bimage = findViewById(R.id.bimage);
        bon = findViewById(R.id.switch1);
        bdiscoverable = findViewById(R.id.switch2);
        btext = findViewById(R.id.textView3);


//        scannedarray =new ArrayList<String>();
        pairedarray = new ArrayList<String>();
        final Boolean b1, b2;

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        arrayAdapter2=new ArrayAdapter<String>(bluetooth.this,android.R.layout.simple_list_item_1,scannedarray);
         //available.setAdapter(arrayAdapter2);
        arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pairedarray);
//
        paired.setAdapter(arrayAdapter1);

        scan.setVisibility(View.INVISIBLE);
        if (!(bluetoothAdapter.isEnabled())) {
            bon.setChecked(false);
            bimage.setImageResource(R.drawable.blutooth_off);
            bdiscoverable.setVisibility(View.GONE);
            scan.setVisibility(View.INVISIBLE);
            paired.setVisibility(View.INVISIBLE);
//              //available.setVisibility(View.INVISIBLE);
            btext.setVisibility(View.INVISIBLE);
        } else {
           Bon();
        }


        if (!bluetoothAdapter.isDiscovering()) {
            bdiscoverable.setChecked(false);

        } else {
            bdiscoverable.setChecked(true);
        }


        bon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (!bluetoothAdapter.isEnabled()) {
                        toast("enabling bluetooth");
                        Intent intent = new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(intent, REQUEST_ENABLE_BT);


                    }

                    }

                if (!isChecked) {
                    if (bluetoothAdapter.isEnabled()) {
                        bluetoothAdapter.disable();
                        toast("bluetooth is turning off");
                        bimage.setImageResource(R.drawable.blutooth_off);
                        bdiscoverable.setVisibility(View.GONE);
//                        scan.setVisibility(View.INVISIBLE);
                        paired.setVisibility(View.INVISIBLE);
                        //available.setVisibility(View.INVISIBLE);
                        btext.setVisibility(View.INVISIBLE);


                    }
                }


            }
        });

        bdiscoverable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (!bluetoothAdapter.isDiscovering()) {
                        toast("making discoverable");
                        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                        startActivityForResult(intent, REQUEST_DISCOVER_BT);
                    } else {
                        toast("turn off bluetooth");

                    }
                }
            }


        });
///------------------------------------------------------------------------/
// /------------------------------------------------------------------------//

//        scan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TAG1","clicked scan");
//                checksys();
//                bluetoothAdapter.startDiscovery();
//
//            }
//        });
//        Log.d("TAG1","scanning");
//        IntentFilter intentFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
//        registerReceiver(receiver,intentFilter);
//
//
//
//            }

//    private void checksys() {
//        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){
//            Log.d("TAG1","checking permission");
//            int permissionCheck=this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
//            permissionCheck+=this.checkSelfPermission("Manifest.permission.ACCESS_C0ARSE_LOCATION");
//            if (permissionCheck!=0){
//                Log.d("TAG1","getting permission");
//                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},1001);
//                Log.d("TAG1","got permission");
//
//            }
//            else{
//                Log.d("TAG1","already got permission");
//            }
//        }
//    }


//    BroadcastReceiver receiver =new BroadcastReceiver() {
//              @Override
//              public void onReceive(Context context, Intent intent) {
//                  Log.d("TAG1","inside broadcast receiver");
//
//                      Log.d("TAG1","getting nearby devices");
//                      String name=intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
//                      BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//                      scannedarray.add(name);
//                      arrayAdapter2.notifyDataSetChanged();
//
//
//              }
//          };


//---------------------------------Restricted Under development----------------------------////
//-------------------------------------------------------------------------------------------///
        paired.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                connect(position);
            }
        });
    }

    private void Bon(){
        bon.setChecked(true);
        bdiscoverable.setVisibility(View.VISIBLE);
//                        scan.setVisibility(View.VISIBLE);
        paired.setVisibility(View.VISIBLE);
        //available.setVisibility(View.VISIBLE);
        btext.setVisibility(View.VISIBLE);
        bimage.setImageResource(R.drawable.blutooth_on);
        toast("Turned on");
       int index=0;
        Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
        if(devices.size() > 0){
        for (BluetoothDevice device : devices) {

            btdevice[index]=device;
            Log.d("TAG1", "getting paired device" + device.getName());
            pairedarray.add(device.getName());
            Log.d("TAG1", "getting paired device" + device.getUuids());
            arrayAdapter1.notifyDataSetChanged();
            index++;

        }}

    }
    private void toast (String t){
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show();
    }


    @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            switch (requestCode) {
                case REQUEST_ENABLE_BT:
                    if (resultCode == RESULT_OK) {
                     Bon();

                    } else {
                        toast("Coudln't turn on");
                        bdiscoverable.setVisibility(View.GONE);
//                        scan.setVisibility(View.INVISIBLE);
                        paired.setVisibility(View.INVISIBLE);
                        //available.setVisibility(View.INVISIBLE);
                        btext.setVisibility(View.INVISIBLE);
                        bon.setChecked(false);
                    }


            }
            super.onActivityResult(requestCode, resultCode, data);
        }
        public void connect(int position)  {
            UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

            BluetoothDevice device;

            device=btdevice[position];
            try {
                socket=device.createRfcommSocketToServiceRecord(uuid);
                socket.connect();
                mmOutputStream = socket.getOutputStream();
                mmInputStream = socket.getInputStream();
                beginListenForData();
                sendData();
                closeBT();


            } catch (IOException e) {
                toast("cannot connect");
                e.printStackTrace();
            }
        }
    void beginListenForData() {
        try {
            final Handler handler = new Handler();

            // this is the ASCII code for a newline character
            final byte delimiter = 10;

            stopWorker = false;
            readBufferPosition = 0;
            readBuffer = new byte[1024];

            workerThread = new Thread(new Runnable() {
                public void run() {

                    while (!Thread.currentThread().isInterrupted() && !stopWorker) {

                        try {

                            int bytesAvailable = mmInputStream.available();

                            if (bytesAvailable > 0) {

                                byte[] packetBytes = new byte[bytesAvailable];
                                mmInputStream.read(packetBytes);

                                for (int i = 0; i < bytesAvailable; i++) {

                                    byte b = packetBytes[i];
                                    if (b == delimiter) {

                                        byte[] encodedBytes = new byte[readBufferPosition];
                                        System.arraycopy(
                                                readBuffer, 0,
                                                encodedBytes, 0,
                                                encodedBytes.length
                                        );

                                        // specify US-ASCII encoding
                                        final String data = new String(encodedBytes, "US-ASCII");
                                        readBufferPosition = 0;

                                        // tell the user data were sent to bluetooth printer device
                                        handler.post(new Runnable() {
                                            public void run() {
                                               toast("data is sent");
                                            }
                                        });

                                    } else {
                                        readBuffer[readBufferPosition++] = b;
                                    }
                                }
                            }

                        } catch (IOException ex) {
                            stopWorker = true;
                        }

                    }
                }
            });

            workerThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void sendData() throws IOException {
        try {

            // the text typed by the user
            String msg = "Hello world this is test"+"\n"+"Hope all is good";


            mmOutputStream.write(msg.getBytes());

            // tell the user data were sent
          toast("sent data");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void closeBT() throws IOException {
        try {
            stopWorker = true;
            mmOutputStream.close();
            mmInputStream.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



