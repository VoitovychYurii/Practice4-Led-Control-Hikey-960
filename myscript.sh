#!/bin/bash
adb shell su 0 'setenforce 0'
adb shell su 0 chmod 666 '/sys/class/leds/user_led1/brightness'
adb shell su 0 chmod 666 '/sys/class/leds/user_led2/brightness'
adb shell su 0 chmod 666 '/sys/class/leds/user_led3/brightness'
adb shell su 0 chmod 666 '/sys/class/leds/user_led4/brightness'

