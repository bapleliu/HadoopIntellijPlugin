package com.fangyuzhong.intelliJ.hadoop.core.ui;

import com.fangyuzhong.intelliJ.hadoop.fsconnection.ConnectionHandler;
import com.fangyuzhong.intelliJ.hadoop.fsconnection.ConnectionProvider;
import com.fangyuzhong.intelliJ.hadoop.fsobject.FileSystemObject;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by fangyuzhong on 17-7-21.
 */
public class FileSystemHeaderForm
        extends FileSystemBaseFormImpl
{
    public static final LineBorder BORDER = new LineBorder(UIUtil.getBoundsColor());
    private JLabel objectLabel;
    private JPanel mainPanel;

    public FileSystemHeaderForm()
    {

        this.mainPanel.setBorder(BORDER);
    }

    public FileSystemHeaderForm(String title, Icon icon)
    {
        this(title, icon, null);
    }

    public FileSystemHeaderForm(String title, Icon icon, Color background)
    {

        this.objectLabel.setText(title);
        this.objectLabel.setIcon(icon);
        if (background != null)
        {
            this.mainPanel.setBackground(background);
        }
        this.mainPanel.setBorder(BORDER);
    }

    public FileSystemHeaderForm(@NotNull FileSystemObject object)
    {

        update(object);
    }

    public void update(@NotNull FileSystemObject object)
    {
        if (object == null)
        {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fsobject", "com/dci/intellij/dbn/core/ui/FileSystemHeaderForm", "update"}));
        }
        ConnectionHandler connectionHandler = object.getConnectionHandler();

        String connectionName = connectionHandler.getName();
        this.objectLabel.setText("[" + connectionName + "] ");
        this.objectLabel.setIcon(object.getIcon());
        updateBorderAndBackground(object);
    }

    public FileSystemHeaderForm(@NotNull Presentable presentable)
    {

        this.objectLabel.setText(presentable.getName());
        this.objectLabel.setIcon(presentable.getIcon());
        updateBorderAndBackground(presentable);
    }

    public FileSystemHeaderForm(@NotNull ConnectionHandler connectionHandler)
    {

        this.objectLabel.setText(connectionHandler.getName());
        this.objectLabel.setIcon(connectionHandler.getIcon());
        updateBorderAndBackground(connectionHandler);
    }

    private void updateBorderAndBackground(Presentable presentable)
    {
        if ((presentable instanceof ConnectionProvider))
        {
            ConnectionProvider connectionProvider = (ConnectionProvider) presentable;
            ConnectionHandler connectionHandler = connectionProvider.getConnectionHandler();
            Color background = null;
        }
        this.mainPanel.setBorder(BORDER);
    }

    public void setBackground(Color background)
    {
        this.mainPanel.setBackground(background);
    }

    public void setTitle(String title)
    {
        this.objectLabel.setText(title);
    }

    public void setIcon(Icon icon)
    {
        this.objectLabel.setIcon(icon);
    }

    public Color getBackground()
    {
        return this.mainPanel.getBackground();
    }

    public JComponent getComponent()
    {
        return this.mainPanel;
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont)
    {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null)
        {
            resultName = currentFont.getName();
        } else
        {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1'))
            {
                resultName = fontName;
            } else
            {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 2, new Insets(4, 4, 4, 4), -1, -1));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        objectLabel = new JLabel();
        objectLabel.setText("[object]");
        mainPanel.add(objectLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return mainPanel;
    }
}
