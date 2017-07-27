var exec = require('cordova/exec');

exports.attachHandlers = function(cb, scope) {
	var fn = this._createCallbackFn(cb, scope);

	exec(fn, null, 'BarcodeScanner', 'handleEvents', []);
};

exports.connectToScanner = function(scannerIdx, cb, scope) {
	if(typeof scannerIdx === 'function') {
		scope = cb;
		cb = scannerIdx;
		scannerIdx = 0;
	}
	var fn = this._createCallbackFn(cb, scope);

	exec(fn, null, 'BarcodeScanner', 'getScannerInfo', [scannerIdx]);
};

exports._createCallbackFn = function(callbackFn, scope) {
	if(typeof callbackFn !== 'function') {
		return;
	}

	return function() {
		callbackFn.apply(scope || this, arguments);
	};
};