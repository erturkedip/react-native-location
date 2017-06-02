
# react-native-location

## Getting started

`$ npm install --save git+https://github.com/erturkedip/react-native-location.git`

### Mostly automatic installation

`$ react-native link react-native-location`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-location` and add `RNReactNativeLocation.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeLocation.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.rnl.RNReactNativeLocationPackage;` to the imports at the top of the file
  - Add `new RNReactNativeLocationPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-location'
  	project(':react-native-location').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-location/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-location')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativeLocation.sln` in `node_modules/react-native-location/windows/RNReactNativeLocation.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNReactNativeLocation;` to the usings at the top of the file
  - Add `new RNReactNativeLocationPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNReactNativeLocation from 'react-native-location';

// TODO: What to do with the module?
RNReactNativeLocation;
```
  