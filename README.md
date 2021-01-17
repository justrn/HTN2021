<!-- TABLE OF CONTENTS -->
# Table of Contents
  <ol>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
        <ul>
        <li><a href="#android-app">Android App</a></li>
      </ul>
       <ul>
        <li><a href="#video-feed">Video Feed</a></li>
      </ul>
      </ul>
    </li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>

<!-- GETTING STARTED -->
# Getting Started

To get a local copy up and running follow these steps.

## Installation
### Android App
You must download Android Studio at https://developer.android.com/studio

Import /AndroidApp into Android Studio and build the APK.

### Video Feed
1. Install Raspberry Pi OS onto a Raspberry Pi 4
2. ``apt update && apt upgrade``
3. Install the lastest version of Python
4. ``sudo apt install hostapd dnsmasq``
5. ``sudo DEBIAN_FRONTEND=noninteractive apt install -y netfilter-persistent iptables-persistent``
6. ``sudo systemctl unmask hostapd && sudo systemctl enable hostapd``
7. ``sudo nano /etc/dhcpcd.conf`` and add the following to the bottom of the page
```
interface wlan0
    static ip_address=192.168.3.1/24
    nohook wpa_supplicant
```
8. ``sudo nano /etc/sysctl.d/routed-ap.conf`` and put the following into the conf ``net.ipv4.ip_forward=1``
9. ``sudo iptables -t nat -A POSTROUTING -o eth0 -j MASQUERADE``
10. ``sudo netfilter-persistent save``
11. ``sudo mv /etc/dnsmasq.conf /etc/dnsmasq.conf.orig`` then ``sudo nano /etc/dnsmasq.conf`` and add the following
```
interface=wlan0
dhcp-range=192.168.3.2,192.168.4.20,255.255.255.0,24h
domain=wlan
address=/gw.wlan/192.168.3.1
```
12. ``sudo rfkill unblock wlan``
13. ``sudo nano /etc/hostapd/hostapd.conf``
14. Enter information for Wi-Fi broadcast SSID
```
country_code=CA
interface=wlan0
ssid=HTN_Dev
hw_mode=g
channel=7
macaddr_acl=0
auth_algs=1
ignore_broadcast_ssid=0
wpa=2
wpa_passphrase=HacktheNorth2020
wpa_key_mgmt=WPA-PSK
wpa_pairwise=TKIP
rsn_pairwise=CCMP
```
15. Install the required dependencies for the program in Python
* ```pip3 install flask```
* ```pip3 install numpy```
* ```pip3 install opencv-python```
* ```pip3 install imutils```

cd into the directory where you have PiStream stored, and run the command below to start stream.

```python3 stream.py -i 0.0.0.0 -o 8000```
<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

This project was created by Patrick Huynh, Justin Tran, Alejandro Gomez, and Ananya Rao for the Hack the North 2020 Hackathon.
