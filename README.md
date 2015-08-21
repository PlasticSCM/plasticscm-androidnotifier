# PlasticSCM notifier for Android
--------------------------------------

#### You must have...
- Android Studio  
- Python  
- A PlasticSCM setup with the `cm` utility available, and the capacity to add triggers  
- The capacity to install Python modules, and [`py-gcm`](https://github.com/daftshady/py-gcm) installed

#### The Android app

1. Clone this repository in your computer.
2. Open Android Studio and choose _Open an existing Android Studio project_.
3. Connect your device. You must have the _developer mode_ enabled and the _Allow USB debugging_ checkbox checked.
4. Press the _play_ button and choose your device from the list.
5. Wait until a GCM ID has been retrieved. Then, tap it to copy it to your smartphone clipboard and send it to your PC in order to copy it into the trigger. You can use [Pushbullet](https://play.google.com/store/apps/details?id=com.pushbullet.android) for a shared clipboard.

#### The trigger

1. Copy both the `plasticenviron.py` and the `trigger.py` files to a directory.
2. Open a terminal (triggers can not be added using the GUI)
3. Add the trigger following the sample:

```
$ cm addtrigger <operation> <name> <command to be executed>
```

```
$ cm addtrigger after-mkbranch "GoogleCloudBranch" "python /opt/triggers/cloud_trigger.py \"New branch created\" \"%{USER} created the branch %{BRANCH} in %{REPNAME} with the following comment: %{COMMENT}\""

```
--------------------------------------

### Available keywords

Remember that you can change them in the code, these are the current keywords.

- %{USER}: the user who started the operation in the client.
- %{CLIENTMACHINE}: the client machine in which the operation was started.
- %{SERVER}: the hostname of the PlasticSCM server.
- %{COMMENT}: the comment given at the following operations:
    - Branch creation.
    - Label creation.
    - Checkin operation.
- %{BRANCH}: the partial name of the branch that is being created.
- %{FULLBRANCH}: the full name of the branch that is being created.
- %{REPNAME}: the repository name.
- %{REPID}: the repository ID.
- %{LABEL}: the label name.
- %{ATTR}: the name of the attribute that is being created (not its value!)
- %{WKSPACENAME}: the name of the workspace.
- %{WKSPACEPATH}: the path of the workspace.
- %{UPDATEPATH}: 
- %{REVIEWTITLE}: the title of the new code review.
- %{REVIEWSTATUS}: the status of a code review.
- %{REVIEWASGINEE}: the asignee of a code review.
- %{REVIEWTARGET}: the specification of the target of a code review.
- %{REVIEWTARGETTYPE}: the type of object of the code review target.