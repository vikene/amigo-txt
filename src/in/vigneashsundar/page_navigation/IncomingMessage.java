package in.vigneashsundar.page_navigation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.Activity;

public class IncomingMessage extends BroadcastReceiver {

		private NotificationManager mmanager;
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		// Retrieves a map of extended data from the intent.
		
        final Bundle bundle = arg1.getExtras();
 
        try {
             
        		
            if (bundle != null) {
                 
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                NotificationCompat.Builder build = new NotificationCompat.Builder(arg0);
                build.setSmallIcon(R.drawable.ic_launcher);
                
                 
                for (int i = 0; i < pdusObj.length; i++) {
                     
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                     
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
 
                    
                     build.setContentTitle("Javaji: "+phoneNumber);
                     build.setContentText(message);
                     
                     NotificationManager mNotificationManager =
                    		    (NotificationManager) arg0.getSystemService(Context.NOTIFICATION_SERVICE);
                    		    
                    		// notificationID allows you to update the notification later on.
                    		mNotificationManager.notify("1", 0, build.build());
 
                   // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(arg0, 
                                 "senderNum: "+ senderNum + ", message: " + message, duration);
                    toast.show();
                     
                } // end for loop
              } // bundle is null
 
        } catch (Exception e) {
            
             
        }
		
	}
	 

}
