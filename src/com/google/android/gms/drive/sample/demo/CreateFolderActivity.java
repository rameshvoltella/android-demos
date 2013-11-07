/**
 * Copyright 2013 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.drive.sample.demo;

import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveFolder.OnCreateFolderCallback;
import com.google.android.gms.drive.MetadataChangeSet;

import android.os.Bundle;

public class CreateFolderActivity extends BaseDemoActivity implements OnCreateFolderCallback {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        super.onConnected(connectionHint);
        MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                .setTitle("New folder")
                .build();
        Drive.DriveApi.getRootFolder().createFolder(
                getGoogleApiClient(), changeSet).addResultCallback(this);
    }

    @Override
    public void onCreateFolder(DriveFolderResult result) {
        if (!result.getStatus().isSuccess()) {
            showMessage("Error while trying to create the folder");
            return;
        }
        showMessage("Created a folder: " + result.getDriveFolder().getDriveId());
    }
}
