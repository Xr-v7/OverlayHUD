#!/usr/bin/env bash
set -euo pipefail
sudo apt-get update -y
sudo apt-get install -y openjdk-17-jdk unzip wget
wget -q https://services.gradle.org/distributions/gradle-8.7-bin.zip -O /tmp/gradle.zip
sudo unzip -q /tmp/gradle.zip -d /opt/gradle || true
export PATH=/opt/gradle/gradle-8.7/bin:$PATH
ANDROID_SDK_ROOT=$HOME/Android
mkdir -p $ANDROID_SDK_ROOT/cmdline-tools
wget -q https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip -O /tmp/cmd.zip
unzip -q /tmp/cmd.zip -d $ANDROID_SDK_ROOT/cmdline-tools
mv $ANDROID_SDK_ROOT/cmdline-tools/cmdline-tools $ANDROID_SDK_ROOT/cmdline-tools/latest || true
export PATH=$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$PATH
yes | sdkmanager --sdk_root=$ANDROID_SDK_ROOT --licenses || true
sdkmanager --sdk_root=$ANDROID_SDK_ROOT "platform-tools" "platforms;android-34" "build-tools;34.0.0"
