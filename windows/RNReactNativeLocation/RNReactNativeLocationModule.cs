using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNReactNativeLocation
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativeLocationModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativeLocationModule"/>.
        /// </summary>
        internal RNReactNativeLocationModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativeLocation";
            }
        }
    }
}
