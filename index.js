
import { DeviceEventEmitter, NativeModules } from 'react-native';

const { RNReactNativeLocation } = NativeModules;

export default {
	getLocation: function () {
		return RNReactNativeLocation.getLocation();
	},
	addLocationListener: function(callback) {
		return DeviceEventEmitter.addListener(
			'locationDidChange', callback
		);
	},
	removeListener: function(listener) {
		DeviceEventEmitter.removeListener(
			'locationDidChange', listener
		);
	}
}
