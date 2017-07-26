package com.michaelmay.cordova.plugin.barcodescanner;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.util.Log;

import com.zebra.scannercontrol.DCSSDKDefs;
import com.zebra.scannercontrol.DCSScannerInfo;
import com.zebra.scannercontrol.FirmwareUpdateEvent;
import com.zebra.scannercontrol.IDcsSdkApiDelegate;

import com.michaelmay.cordova.plugin.barcodescanner.barcode.BarcodeTypes;

import org.json.JSONException;

public class NotificationReceiver extends BroadcastReceiver implements IDcsSdkApiDelegate {
	NotificationReceiver() {
		Log.d("ScannerListEvent", "Setting up Scanner Delegate");

		int notifications_mask = 0;
		Log.d("ScannerListEvent", "Setting up scanner sdk.");
		// Subscribe to scanner available/unavailable events
		notifications_mask |=
				DCSSDKDefs.DCSSDK_EVENT.DCSSDK_EVENT_SCANNER_APPEARANCE.value |
						DCSSDKDefs.DCSSDK_EVENT.DCSSDK_EVENT_SCANNER_DISAPPEARANCE.value;

		// Subscribe to scanner connection/disconnection events
		notifications_mask |=
				DCSSDKDefs.DCSSDK_EVENT.DCSSDK_EVENT_SESSION_ESTABLISHMENT.value |
						DCSSDKDefs.DCSSDK_EVENT.DCSSDK_EVENT_SESSION_TERMINATION.value;

		// Subscribe to barcode events
		notifications_mask |=
				DCSSDKDefs.DCSSDK_EVENT.DCSSDK_EVENT_BARCODE.value;


		BarcodeScanner.sdkHandler.dcssdkEnableAvailableScannersDetection(true);
		BarcodeScanner.sdkHandler.dcssdkSetOperationalMode(DCSSDKDefs.DCSSDK_MODE.DCSSDK_OPMODE_SNAPI);
		BarcodeScanner.sdkHandler.dcssdkSubsribeForEvents(notifications_mask);

		BarcodeScanner.sdkHandler.dcssdkSetDelegate(this);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationManager mgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		String notificationText = intent.getStringExtra(Constants.NOTIFICATIONS_TEXT);
		int notificationType = intent.getIntExtra(Constants.NOTIFICATIONS_TYPE, 0);

		Log.d("ScannerListEvent", notificationText);
	}

	@Override
	public void dcssdkEventScannerAppeared(DCSScannerInfo scanner) {
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Scanner Appeared");
		try {
			BarcodeScanner.broadcastScannerPluggedIn();
		} catch(JSONException err) {
			Log.e("ScannerListEvent", "ERROR broadcasting puggedin event.");
		}
	}

	@Override
	public void dcssdkEventScannerDisappeared(int scannerId) {
		BarcodeScanner.sdkHandler.dcssdkTerminateCommunicationSession(scannerId);
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Scanner Disappeared");
		try {
			BarcodeScanner.broadcastScannerUnplugged();
		} catch(JSONException err) {
			Log.e("ScannerListEvent", "ERROR broadcasting unplugged event.");
		}
	}

	@Override
	public void dcssdkEventCommunicationSessionEstablished(DCSScannerInfo var1) {
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Communication Session Established");
		try {
			BarcodeScanner.broadcastScannerConnected();
		} catch(JSONException err) {
			Log.e("ScannerListEvent", "ERROR broadcasting connected event.");
		}
	}

	@Override
	public void dcssdkEventCommunicationSessionTerminated(int var1) {
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Communication Session Terminated");
		try {
			BarcodeScanner.broadcastScannerDisconnected();
		} catch(JSONException err) {
			Log.e("ScannerListEvent", "ERROR broadcasting disconnected event.");
		}
	}

	@Override
	public void dcssdkEventBarcode(byte[] barcodeData, int barcodeType, int fromScannerId) {
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Got Barcode");
		Log.d("ScannerListEvent", "\nType: " + BarcodeTypes.getBarcodeTypeName(barcodeType) + ".\n From scanner: " + fromScannerId + ".\n Data: " + new String(barcodeData));
		try {
			BarcodeScanner.broadcastBarcodeReceived(new String(barcodeData), BarcodeTypes.getBarcodeTypeName(barcodeType), fromScannerId);
		} catch(JSONException err) {
			Log.e("ScannerListEvent", "ERROR broadcasting barcode.");
		}
	}

	@Override
	public void dcssdkEventImage(byte[] var1, int var2) {
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Got Image?");
	}

	@Override
	public void dcssdkEventVideo(byte[] var1, int var2) {
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Got Video??");
	}

	@Override
	public void dcssdkEventFirmwareUpdate(FirmwareUpdateEvent var1) {
		Log.d("ScannerListEvent", "GOT DCSScanner Info - Firmware Update Event");
	}
}
