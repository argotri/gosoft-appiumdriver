
# gosoft-appiumdriver
Appium Driver for Serenity implementation

Using serenity.properties for your appium webdriver

silahkan ditambahkan di serenity.properties anda

----------
#Appears at the top of the reports

serenity.project.name = Bukalapak Automation Project

####### Android CAPS ######

#Jika True maka harus install appium server sendiri dan dijalankan manual

#Jika false tidak perlu install appium serve , akan dijalankan lewat java tapi mesti diinstall appiumnya lewat **Node JS ingat NODE JS**

appium.usingappiumserver = true
appium.port = 4723

#appium.dc disesuaikan dengan desired capability tergantung ios atau android yak

appium.dc.automationName=uiautomator2

appium.dc.platformName = Android

##appium.dc.platformVersion = 6.0

appium.dc.deviceName  = device
appium.dc.appActivity = com.bukalapak.android.HomeActivity_

appium.dc.appPackage = com.bukalapak.android

#appium.dc.app =(path ke appnya)  saya tidak menyarankan memasukkan APK di repository , karena nanti membengkak

----------
