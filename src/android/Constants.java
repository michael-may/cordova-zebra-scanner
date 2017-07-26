package com.michaelmay.cordova.plugin.barcodescanner;

import android.util.Log;

/**
* Helper class
*/
public class Constants {
	public static final String PREFS_NAME = "BarcodeScannerPrefs";

	//For Debugging
	public static final boolean DEBUG = true;
	public static final int COLOR_BG_GRAY = 0XF0F0F0;

	public enum DEBUG_TYPE {
		TYPE_DEBUG, TYPE_ERROR
	}

	//For shared prefs
	public static final String PREF_OPMODE = "MOT_SETTING_OPMODE";
	public static final String PREF_SCANNER_DETECTION = "MOT_SETTING_SCANNER_DETECTION";

	public static final String PREF_EVENT_ACTIVE = "MOT_SETTING_EVENT_ACTIVE";
	public static final String PREF_EVENT_AVAILABLE = "MOT_SETTING_EVENT_AVAILABLE";
	public static final String PREF_EVENT_BARCODE = "MOT_SETTING_EVENT_BARCODE";
	public static final String PREF_EVENT_IMAGE = "MOT_SETTING_EVENT_IMAGE";
	public static final String PREF_EVENT_VIDEO = "MOT_SETTING_EVENT_VIDEO";

	public static final String PREF_DONT_SHOW_INSTRUCTIONS = "MOT_SETTING_DONT_SHOW_MSG";

	public static final String PREF_NOTIFY_ACTIVE = "MOT_SETTING_NOTIFICATION_ACTIVE";
	public static final String PREF_NOTIFY_AVAILABLE = "MOT_SETTING_NOTIFICATION_AVAILABLE";
	public static final String PREF_NOTIFY_BARCODE = "MOT_SETTING_NOTIFICATION_BARCODE";
	public static final String PREF_NOTIFY_IMAGE = "MOT_SETTING_NOTIFICATION_IMAGE";
	public static final String PREF_NOTIFY_VIDEO = "MOT_SETTING_NOTIFICATION_VIDEO";

	public static final String PREF_PAIRING_BARCODE_TYPE = "MOT_SETTING_PAIRING_BARCODE_TYPE";
	public static final String PREF_PAIRING_BARCODE_CONFIG = "MOT_SETTING_PAIRING_BARCODE_CONFIG";
	public static final String PREF_COMMUNICATION_PROTOCOL_TYPE = "MOT_SETTING_COMMUNICATION_PROTOCOL_TYPE";
	//Data related to notifications
	public static final String NOTIFICATIONS_TYPE = "notifications_type";
	public static final String NOTIFICATIONS_TEXT = "notifications_text";
	public static final String NOTIFICATIONS_ID = "notifications_id";

	//Action strings for various RFID Events
	public static final String ACTION_SCANNER_CONNECTED = "com.zebra.scannercontrol.connected";
	public static final String ACTION_SCANNER_DISCONNECTED = "com.zebra.scannercontrol.disconnected";
	public static final String ACTION_SCANNER_AVAILABLE = "com.zebra.scannercontrol.available";
	public static final String ACTION_SCANNER_CONN_FAILED = "com.zebra.scannercontrol.conn.failed";
	public static final String ACTION_SCANNER_BARCODE_RECEIVED = "com.zebra.scannercontrol.barcode.received";
	public static final String ACTION_SCANNER_IMAGE_RECEIVED = "com.zebra.scannercontrol.image.received";
	public static final String ACTION_SCANNER_VIDEO_RECEIVED = "com.zebra.scannercontrol.video.received";

	//Data regarding bluetooth
	public static final String DATA_BLUETOOTH_DEVICE = "com.zebra.scannercontrol.data.bluetooth.device";

	//Intent Data
	public static final String INTENT_ACTION = "intent_action";
	public static final String INTENT_DATA = "intent_data";

	//Config Details Intent Data
	public static final String CONFIG_NAME = "intent_config_name";
	public static final String CONFIG_DESC = "intent_config_desc";
	public static final String CONFIG_VALUE = "intent_config_value";
	public static final String CONFIG_TITLE = "intent_config_title";
	public static final String CONFIG_MSG = "intent_config_message";
	public static final String LAUNCH_FROM_FCS = "launch_from_fcs";
	//Available Scanners Data
	public static final String SCANNER_NAME = "avail_scanner_name";
	public static final String SCANNER_ADDRESS = "avail_scanner_address";
	public static final String SCANNER_ID = "active_scanner_id";
	public static final String AUTO_RECONNECTION="auto_reconnection";
	public static final String PICKLIST_MODE="picklist+mode";
	public static final String PAGER_MOTOR_STATUS="pager_motor_status";
	public static final String CONNECTED="connected";
	public static final String SHOW_BARCODE_VIEW="barcode_view";
	public static final String FW_REBOOT="fw_reboot";
	public static final String BATTERY_STATUS = "battery_status";

	public static final String CONNECTION_HELP_TYPE="connection_help";
	public static final int CONNECTION_HELP_TYPE_CS4070 = 0;
	public static final int CONNECTION_HELP_TYPE_LI4278 = 1;
	public static final int CONNECTION_HELP_TYPE_RFD8500 = 2;

	public static final String CONNECTION_HELP_CS4070_RESET_DEFAULTS="Reset Factory Defaults";
	public static final String CONNECTION_HELP_CS4070_SSI_PROFILE="Bluetooth SSI Profile";
	public static final String CONNECTION_HELP_LI4278_SET_DEFAULTS="Set Factory Defaults";
	public static final String CONNECTION_HELP_LI4278_SSI_HOST_SERVER="SSI Host Server";

	//Error Messages
	public static final String INVALID_SCANNER_ID_MSG = "Invalid Scanner ID";

	//Type of data recieved
	public static final int BARCODE_RECEIVED = 30;
	public static final int SESSION_ESTABLISHED = 31;
	public static final int SESSION_TERMINATED = 32;
	public static final int SCANNER_APPEARED = 33;
	public static final int SCANNER_DISAPPEARED = 34;
	public static final int FW_UPDATE_EVENT = 35;

	///---
	public static final String BTH_SCAN_TO_CONNECT="[BTH_CONNECT]";
}
