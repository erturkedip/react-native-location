
Pod::Spec.new do |s|
  s.name         = "RNReactNativeLocation"
  s.version      = "1.0.0"
  s.summary      = "RNReactNativeLocation"
  s.description  = <<-DESC
                  RNReactNativeLocation
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNReactNativeLocation.git", :tag => "master" }
  s.source_files  = "RNReactNativeLocation/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  