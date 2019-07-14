import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.LafManagerListener;
import com.intellij.ide.ui.laf.LafManagerImpl;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class NyanApplicationComponent implements ApplicationComponent {
    public NyanApplicationComponent(LafManagerImpl lafManager) {
        lafManager.addLafManagerListener(new LafManagerListener() {
            @Override
            public void lookAndFeelChanged(LafManager lafManager) {
                updateProgressBarUi();
            }
        });
    }

    @Override
    public void initComponent() {
        updateProgressBarUi();
    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override

    public String getComponentName() {
        return "NyanLafUpdater";
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", NyanProgressBarUi.class.getName());
        UIManager.getDefaults().put(NyanProgressBarUi.class.getName(), NyanProgressBarUi.class);
    }

    static NyanApplicationComponent getInstance() {
        return ApplicationManager.getApplication().getComponent(NyanApplicationComponent.class);
    }
}
