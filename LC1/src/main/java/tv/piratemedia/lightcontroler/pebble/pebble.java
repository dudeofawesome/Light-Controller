package tv.piratemedia.lightcontroler.pebble;

import android.content.Context;
import android.util.Log;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.PebbleKit.PebbleDataReceiver;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.UUID;

import tv.piratemedia.lightcontroler.controlCommands;
import tv.piratemedia.lightcontroler.controller;

/*
created by mrwhale 18/06/2016
This is the services that connects to and listens to a pebble watch. Receives commands and then actions them
 */
public class pebble {
    static final UUID appUuid = UUID.fromString("1d6c7f01-d948-42a6-aa4e-b2084210ebbc");
    private static final int KEY_CMD = 2;

    // Create a new dictionary
    PebbleDictionary dict = new PebbleDictionary();
/*
Pebble related activities. Pass through context, and data receiver, so we can then pause it from Controller

 */
// todo add the ability to semd data to the watch.Need to send Zone data to the watch so it can display it

    public static void pebbleaction(Context ctx, PebbleDataReceiver dataReceiver){
        Log.d("pebble app", "starting onResume in pebble java");
        boolean isConnected = PebbleKit.isWatchConnected(ctx);
        Log.d("Pebble app", "Pebble " + (isConnected ? "is" : "is not") + " connected!");
        //TODO probably should put a if statement to check if pebble is conncted/if we are on the right wifi, so we dont do any work we done need to
        // Create a new receiver to get AppMessages from the C app
        // Create a new controller instance so we can send commands to the wifi controller
        final controller mCont = new controller();
        final controlCommands contcmd;
        contcmd = new controlCommands(ctx, mCont.mHandler);

        dataReceiver = new PebbleDataReceiver(appUuid) {

            @Override
            public void receiveData(Context context, int transaction_id, PebbleDictionary dict) {
                Log.d("pebble app", "pebble java" + dict + " was received by the android app");
                // A new AppMessage was received, tell Pebble
                Long cmdValue = dict.getUnsignedIntegerAsLong(2);
                if(cmdValue != null){
                    //TODO put some more logic around getting cmd value to verify its an int 0-9
                    int cmd = cmdValue.intValue();
                    Log.d("Pebble app","from pebble " + cmd);
                    //TODO compact this switch statement into one if(state) then toggle
                    //Switch to see what command was from, and action this
                    switch (cmd){
                        case 0:
                            Log.d("pebble app","toggling zone " + cmd);
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                //TODO add some feedback to the pebble if something has gone wrong?
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 1:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 2:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 3:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 4:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 5:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 6:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 7:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 8:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                        case 9:
                            Log.d("pebble app", "Zone state is " + contcmd.appState.getOnOff(cmd));
                            if(contcmd.appState.getOnOff(cmd) == false){
                                Log.d("pebble app", "Zone " + cmd + " was off, turning on");
                                contcmd.appState.setOnOff(cmd,true);
                            }else{
                                Log.d("pebble app", "Zone " + cmd + " was on, turning off");
                                contcmd.appState.setOnOff(cmd,false);
                            }
                            break;
                    }
                }
                PebbleKit.sendAckToPebble(context, transaction_id);
            }

        };
        PebbleKit.registerReceivedDataHandler(ctx, dataReceiver);

    }
}
