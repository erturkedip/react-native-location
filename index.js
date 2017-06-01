
import { DeviceEventEmitter, NativeModules } from 'react-native';

const { RNReactNativeLocation } = NativeModules;

export default {
	startLocationPolling: function (interval: number, distance: double, priority: number) {
		return RNReactNativeLocation.startLocationPolling(interval, distance, priority);
	},
	addLocationListener: function(callback) {
		return DeviceEventEmitter.addListener(
			'location_changed', callback
		);
	},
	removeLocationListener: function (listener) {
		DeviceEventEmitter.removeListener(
			'location_changed', listener
		);
	},
	BALANCED_POWER_KEY: RNReactNativeLocation.BALANCED_POWER_KEY,
	HIGH_ACCURACY_KEY: RNReactNativeLocation.HIGH_ACCURACY_KEY,
	LOW_POWER_KEY: RNReactNativeLocation.LOW_POWER_KEY,
	NO_POWER_KEY: RNReactNativeLocation.NO_POWER_KEY,
}
