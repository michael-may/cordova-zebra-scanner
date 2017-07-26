# Zebra USB Barcode Scanner Plugin for Android

## Overview
This plugin provides a (reasonably) easy-to-use interface for the following supported Zebra USB barcode scanners:
```
• PL3307
• DS457 (Tested)
• DS4308
• LS2208
• DS6878 and Presentation Cradle
• MP6210 (CSS + Scale) + EAS (Sensormatic).
```
Bluetooth support is possible, but not implemented.
Theoretically, that would add support for the following models:
```
• CS4070 (in Bluetooth SSI Profile mode)
• LI4278 (in SSI Host Server mode or Cradle Host mode by scanning pairing bar code)
• DS6878 (in SSI Host Server mode or Cradle Host mode by scanning pairing bar code)
• RFD8500 (in default mode)
• DS3678 (In SSI BT Classic mode)
• LI3678 (In SSI BT Classic mode).
```

A sample Ionic implementation of this plugin can be found [here](https://github.com/michael-may/cordova-zebra-scanner-example).  
This plugin is implemented in `/src/pages/home/`

## Setup
### Cordova CLI
- From your project directory, run `cordova plugin add cordova-zebra-scanner`.
### Manual
- Copy the plugin to `/plugins/com.michaelmay.cordova.plugin.barcodescanner` in your Cordova-based project.
- (If necessary) Remove and re-add the Android platform to add the plugin to your project.

## Implementation
The plugin provides only two methods for you to interface with.
- cordova.plugins.barcodescanner.attachHandlers
- cordova.plugins.barcodescanner.connectToScanner

### Method: attachHandlers(cb): Object
Used to listen and react to scanner events. Provide a callback function that will handle the different scanner events you want to react to. An Object is passed to the callback.

This single function is shared in the Java code of the Cordova plugin, so make sure you listen to all the events you want to react to. Subsequent calls to this method will erase previous listeners on the native side.

#### Object Response:
```
{
	eventType: 'barcodeEvent' | 'scannerPluggedIn' | 'scannerUnplugged' | 'scannerConnected' | 'scannerDisconnected',
	payload: (barcodeEvent only) {
		{
			scannerId: <number>,
			barcodeType: <string>,
			barcodeData: <string>
		}
	}
}
```

#### Example:
```
cordova.plugins.barcodescanner.attachHandlers((ev) => {
	switch(ev.eventType) {
		case 'barcodeEvent':
			// Got a barcode of some sort
			break;
		case 'scannerPluggedIn':
			// Scanner physically plugged in.
			break;
		case 'scannerUnplugged':
			// Scanner physically unplugged.
			break;
		case 'scannerConnected':
			// Scanner is available for use.
			break;
		case 'scannerDisconnected':
			// Scanner is not available or initialized.
			break;
	}
});
```


### Method: connectToScanner(cb): Object
Used to manage scanner connection state. This must be called to initialize scanning functionality. Provide a callback function to handle the responses from the native side. An Object is passed to the callback.

After calling the function, you will receive one of two responses.

If you receive the following response, you're set to go:
#### Object Response (Success):
```
{
	status: 'paired',
	message: <string>
}
```

If you don't you'll see a response like this:
#### Object Response (Not Paired):
```
{
	status: 'pairingRequired',
	connectionBarcode: <base64 encoded jpeg>
}
```
Display the barcode somewhere on the screen, and scan it with your scanner to pair the device.

#### Example:
```
cordova.plugins.barcodescanner.connectToScanner((result) => {
	switch(result.status) {
		case: 'pairingRequired':
			// Handle barcode display. Pairing needed before scanning will work.
			break;
		case: 'paired':
			// Ready to scan.
			break;
	}
});
```

