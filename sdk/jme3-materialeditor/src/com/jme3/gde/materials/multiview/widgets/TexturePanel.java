/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectionPanel.java
 *
 * Created on 14.06.2010, 16:52:22
 */
package com.jme3.gde.materials.multiview.widgets;

import com.jme3.gde.core.assets.ProjectAssetManager;
import com.jme3.gde.core.properties.TexturePropertyEditor;
import com.jme3.gde.core.properties.preview.DDSPreview;
import com.jme3.gde.materials.MaterialProperty;
import com.jme3.texture.Texture;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import jme3tools.converters.ImageToAwt;
import org.openide.util.ImageUtilities;

/**
 *
 * @author normenhansen
 */
public class TexturePanel extends MaterialPropertyWidget {

    private TexturePropertyEditor editor;
    private ProjectAssetManager manager;
    private boolean flip = false;
    private boolean repeat = false;
    private String textureName = null;
    private DDSPreview ddsPreview;

    /** Creates new form SelectionPanel */
    public TexturePanel(ProjectAssetManager manager) {
        this.manager = manager;
        editor = new TexturePropertyEditor(manager);
        initComponents();
    }

    private void displayPreview() {
        if (!"".equals(textureName)) {
            Texture tex = manager.loadTexture(textureName);
            Icon newicon = null;
            if (textureName.endsWith(".dds") || textureName.endsWith(".DDS")) {
                if (ddsPreview == null) {
                    ddsPreview = new DDSPreview(manager);
                }
                ddsPreview.requestPreview(textureName, "", 80, 80, texturePreview, null);
            } else {
                newicon = ImageUtilities.image2Icon(resizeImage(ImageToAwt.convert(tex.getImage(), false, true, 0)));
            }
            texturePreview.setIcon(newicon);
        }
    }

    private String getName(String path) {
        int idx = path.lastIndexOf("/");
        if (idx != -1 && path.length() > idx + 1) {
            path = path.substring(idx + 1, path.length());
        }
        if (path.length() > 15) {
            path = path.substring(0, 15) + "..";
        }
        return path;
    }

    private void updateFlipRepeat() {
        if (flip && repeat) {
            property.setValue("Flip Repeat " + textureName);
            texturePreview.setToolTipText("Flip Repeat " + textureName);
        } else if (flip) {
            property.setValue("Flip " + textureName);
            texturePreview.setToolTipText("Flip " + textureName);
        } else if (repeat) {
            property.setValue("Repeat " + textureName);
            texturePreview.setToolTipText("Repeat " + textureName);
        } else {
            property.setValue(textureName);
            texturePreview.setToolTipText(textureName);
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage) {
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        float ratio = (float) originalImage.getWidth() / (float) originalImage.getHeight();
        int width = 80;
        int height = 25;
        if (ratio <= 1) {
            height = (int) ((float) width * ratio);
        } else {
            width = (int) ((float) height * (float) ratio);
        }
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        texturePreview = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(32767, 45));
        setPreferredSize(new java.awt.Dimension(467, 45));

        jLabel1.setText(org.openide.util.NbBundle.getMessage(TexturePanel.class, "TexturePanel.jLabel1.text")); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 16));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(10, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/materials/multiview/widgets/icons/picture_add.png"))); // NOI18N
        jButton1.setText(org.openide.util.NbBundle.getMessage(TexturePanel.class, "TexturePanel.jButton1.text")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(2);
        jButton1.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jCheckBox1.setText(org.openide.util.NbBundle.getMessage(TexturePanel.class, "TexturePanel.jCheckBox1.text")); // NOI18N
        jCheckBox1.setFocusable(false);
        jCheckBox1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox2.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jCheckBox2.setText(org.openide.util.NbBundle.getMessage(TexturePanel.class, "TexturePanel.jCheckBox2.text")); // NOI18N
        jCheckBox2.setFocusable(false);
        jCheckBox2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/materials/multiview/widgets/icons/picture_delete.png"))); // NOI18N
        jButton2.setText(org.openide.util.NbBundle.getMessage(TexturePanel.class, "TexturePanel.jButton2.text")); // NOI18N
        jButton2.setToolTipText(org.openide.util.NbBundle.getMessage(TexturePanel.class, "TexturePanel.jButton2.toolTipText")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        texturePreview.setText(org.openide.util.NbBundle.getMessage(TexturePanel.class, "TexturePanel.texturePreview.text")); // NOI18N
        texturePreview.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        texturePreview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        texturePreview.setFocusable(false);
        texturePreview.setIconTextGap(0);
        texturePreview.setMaximumSize(new java.awt.Dimension(75, 25));
        texturePreview.setMinimumSize(new java.awt.Dimension(75, 25));
        texturePreview.setPreferredSize(new java.awt.Dimension(75, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texturePreview, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 229, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 228, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(texturePreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 24, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Component view = editor.getCustomEditor();
        view.setVisible(true);
        if (editor.getValue() != null) {
            textureName = editor.getAsText();
            displayPreview();
            updateFlipRepeat();
            fireChanged();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        textureName = "";
        texturePreview.setIcon(null);
        texturePreview.setToolTipText("");
        property.setValue("");
        fireChanged();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (property == null) {
            return;
        }
        flip = jCheckBox1.isSelected();
        updateFlipRepeat();
        fireChanged();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (property == null) {
            return;
        }
        repeat = jCheckBox2.isSelected();
        updateFlipRepeat();
        fireChanged();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    @Override
    protected void readProperty() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                if (property.getValue().startsWith("Flip Repeat ")) {
                    flip = true;
                    repeat = true;
                    textureName = property.getValue().replaceFirst("Flip Repeat ", "").trim();
                } else if (property.getValue().startsWith("Flip ")) {
                    flip = true;
                    textureName = property.getValue().replaceFirst("Flip ", "").trim();
                } else if (property.getValue().startsWith("Repeat ")) {
                    repeat = true;
                    textureName = property.getValue().replaceFirst("Repeat ", "").trim();
                } else {
                    textureName = property.getValue();
                }
                jLabel1.setText(property.getName());
                jLabel1.setToolTipText(property.getName());
                displayPreview();
                texturePreview.setToolTipText(property.getValue());
                MaterialProperty prop = property;
                property = null;
                jCheckBox1.setSelected(flip);
                jCheckBox2.setSelected(repeat);
                property = prop;
            }
        });
    }

    @Override
    public void cleanUp() {
        if (ddsPreview != null) {
            ddsPreview.cleanUp();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel texturePreview;
    // End of variables declaration//GEN-END:variables
}
