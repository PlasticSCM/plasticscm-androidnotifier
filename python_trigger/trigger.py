#!/usr/bin/python

import sys
from gcm import GCM
from plasticenviron import PlasticEnviron as Environ


# Useful if you want to store the IDS elsewhere.
def get_registration_ids():
    return ['your-device-ids-belong-here']


def main():
    if len(sys.argv) is not 3:
        sys.exit(1)

    cloud = GCM('your-API-key-belongs-here')
    environ = Environ()
    title = sys.argv[1]
    text = sys.argv[2]
    words = text.split(" ")
    text = ""

    for word in words:
        text += environ.replace(word) + " "

    notification = {"title": title, "message": text}
    ids = get_registration_ids()

    cloud.json_request(registration_ids=ids, data=notification)

    sys.exit(0)

if __name__ == '__main__':
    main()
