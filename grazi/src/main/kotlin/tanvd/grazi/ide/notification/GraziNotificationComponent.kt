// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package tanvd.grazi.ide.notification

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import tanvd.grazi.GraziConfig
import tanvd.grazi.GraziPlugin

open class GraziNotificationComponent : StartupActivity, DumbAware {
  override fun runActivity(project: Project) {
    GraziConfig.update {
      when {
        it.lastSeenVersion == null -> Notification.showInstallationMessage(project)
        GraziPlugin.version != it.lastSeenVersion -> Notification.showUpdateMessage(project)
      }

      if (it.hasMissedLanguages()) Notification.showLanguagesMessage(project)

      it.update(lastSeenVersion = GraziPlugin.version)
    }
  }
}
