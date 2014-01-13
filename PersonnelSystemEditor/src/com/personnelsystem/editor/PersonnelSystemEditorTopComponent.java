/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personnelsystem.editor;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.Icon;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Confirmation;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.UndoRedo;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.WindowManager;
import smls.AccessInfo;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.personnelsystem.editor//PersonnelSystemEditor//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "PersonnelSystemEditorTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.personnelsystem.editor.PersonnelSystemEditorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PersonnelSystemEditorAction",
        preferredID = "PersonnelSystemEditorTopComponent"
)
@Messages({
    "CTL_PersonnelSystemEditorAction=PersonnelSystemEditor",
    "CTL_PersonnelSystemEditorTopComponent=PersonnelSystemEditor Window",
    "HINT_PersonnelSystemEditorTopComponent=This is a PersonnelSystemEditor window"
})
public final class PersonnelSystemEditorTopComponent extends TopComponent implements LookupListener {

    private Lookup.Result result = null;
    private UndoRedo.Manager manager = new UndoRedo.Manager();
    AccessInfo ai;

    InstanceContent instanceContent;

    public PersonnelSystemEditorTopComponent() {
        initComponents();
        setName(Bundle.CTL_PersonnelSystemEditorTopComponent());
        setToolTipText(Bundle.HINT_PersonnelSystemEditorTopComponent());
        redoundo();
    }

    private void redoundo() {
        idField.getDocument().addUndoableEditListener(manager);
        usernameField.getDocument().addUndoableEditListener(manager);
        passwordField.getDocument().addUndoableEditListener(manager);
        lastNameField.getDocument().addUndoableEditListener(manager);
        firstNameField.getDocument().addUndoableEditListener(manager);
        middleNameField.getDocument().addUndoableEditListener(manager);
        ssnField.getDocument().addUndoableEditListener(manager);
        birthDateField.getDocument().addUndoableEditListener(manager);
        //genderComboBox..addUndoableEditListener(manager);
        serviceDateField.getDocument().addUndoableEditListener(manager);
        streetField.getDocument().addUndoableEditListener(manager);
        cityField.getDocument().addUndoableEditListener(manager);
        //state..addUndoableEditListener(manager);
        postalCodeField.getDocument().addUndoableEditListener(manager);
        mobilePhoneField.getDocument().addUndoableEditListener(manager);
        officePhoneField.getDocument().addUndoableEditListener(manager);
        homePhoneField.getDocument().addUndoableEditListener(manager);
        nameField.getDocument().addUndoableEditListener(manager);
        relationshipField.getDocument().addUndoableEditListener(manager);
        phoneField.getDocument().addUndoableEditListener(manager);
        eStreetField.getDocument().addUndoableEditListener(manager);
        eCityField.getDocument().addUndoableEditListener(manager);
        //estate..addUndoableEditListener(manager);
        ePostalCodeField.getDocument().addUndoableEditListener(manager);
        //userRole..addUndoableEditListener(manager);
        //skill..addUndoableEditListener(manager);
        //#year experience..addUndoableEditListener(manager);
        TCNField.getDocument().addUndoableEditListener(manager);
        certificateDateField.getDocument().addUndoableEditListener(manager);
    }

    private void addkey() {
        idField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        lastNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        firstNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        middleNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        ssnField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        birthDateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        //genderComboBox..addUndoableEditListener(manager);
        serviceDateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        streetField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        cityField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        //state..addUndoableEditListener(manager);
        postalCodeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        mobilePhoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        officePhoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        homePhoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        relationshipField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        phoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        eStreetField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        eCityField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        //estate..addUndoableEditListener(manager);
        ePostalCodeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        //userRole..addUndoableEditListener(manager);
        //skill..addUndoableEditListener(manager);
        //#year experience..addUndoableEditListener(manager);
        TCNField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
        certificateDateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                modify();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        mobilePhoneField1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        officePhoneField1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        homePhoneField1 = new javax.swing.JTextField();
        smlsTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        middleNameField = new javax.swing.JTextField();
        ssnField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        birthDateField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        serviceDateField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        officePhoneField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        postalCodeField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mobilePhoneField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        homePhoneField = new javax.swing.JTextField();
        stateComboBox = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        eStreetField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        eCityField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        eStateComboBox = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        ePostalCodeField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        relationshipField = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        TCNField = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        certificateDateField = new javax.swing.JTextField();
        userRoleComboBox = new javax.swing.JComboBox();
        skillComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel23, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel23.text")); // NOI18N

        mobilePhoneField1.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.mobilePhoneField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel24, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel24.text")); // NOI18N

        officePhoneField1.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.officePhoneField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel25, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel25.text")); // NOI18N

        homePhoneField1.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.homePhoneField1.text")); // NOI18N
        homePhoneField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePhoneField1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel3.text")); // NOI18N

        idField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.idField.text")); // NOI18N

        usernameField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.usernameField.text")); // NOI18N

        passwordField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.passwordField.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        smlsTab.addTab(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel4.text")); // NOI18N

        lastNameField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.lastNameField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel5.text")); // NOI18N

        firstNameField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.firstNameField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel6.text")); // NOI18N

        middleNameField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.middleNameField.text")); // NOI18N

        ssnField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.ssnField.text")); // NOI18N
        ssnField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssnFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel7.text")); // NOI18N

        birthDateField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.birthDateField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel9.text")); // NOI18N

        serviceDateField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.serviceDateField.text")); // NOI18N
        serviceDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceDateFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel10.text")); // NOI18N

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ssnField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(middleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serviceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        smlsTab.addTab(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel11.text")); // NOI18N

        streetField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.streetField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel12.text")); // NOI18N

        cityField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.cityField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel13.text")); // NOI18N

        officePhoneField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.officePhoneField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel14.text")); // NOI18N

        postalCodeField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.postalCodeField.text")); // NOI18N
        postalCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postalCodeFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel15.text")); // NOI18N

        mobilePhoneField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.mobilePhoneField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel16, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel16.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel17, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel17.text")); // NOI18N

        homePhoneField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.homePhoneField.text")); // NOI18N
        homePhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePhoneFieldActionPerformed(evt);
            }
        });

        stateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
        stateComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.stateComboBox.toolTipText")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(streetField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobilePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(officePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(homePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobilePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(officePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        smlsTab.addTab(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel19, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel19.text")); // NOI18N

        eStreetField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.eStreetField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel20, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel20.text")); // NOI18N

        eCityField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.eCityField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel21, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel21.text")); // NOI18N

        eStateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel22, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel22.text")); // NOI18N

        ePostalCodeField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.ePostalCodeField.text")); // NOI18N
        ePostalCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ePostalCodeFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel26, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel26.text")); // NOI18N

        nameField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.nameField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel27, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel27.text")); // NOI18N

        relationshipField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.relationshipField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel28, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel28.text")); // NOI18N

        phoneField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.phoneField.text")); // NOI18N
        phoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eStreetField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ePostalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relationshipField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(relationshipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eStreetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(eStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ePostalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(34, 34, 34))
        );

        smlsTab.addTab(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jPanel4.TabConstraints.tabTitle"), jPanel4); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel18, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel18.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel29, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel29.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel30, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel30.text")); // NOI18N

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel31, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel31.text")); // NOI18N

        TCNField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.TCNField.text")); // NOI18N
        TCNField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCNFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel32, org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jLabel32.text")); // NOI18N

        certificateDateField.setText(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.certificateDateField.text")); // NOI18N

        userRoleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chief Engineer", "Logistics Maintenance", "Lead Maintenance Person", "Personnel Administrator", "System Administrator" }));

        skillComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chilled Water", "Electric Generation", "Electrician", "HVAC", "IT Technician", "Propulsion" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel18)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TCNField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(certificateDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skillComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(userRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(skillComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TCNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certificateDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        smlsTab.addTab(org.openide.util.NbBundle.getMessage(PersonnelSystemEditorTopComponent.class, "PersonnelSystemEditorTopComponent.jPanel5.TabConstraints.tabTitle"), jPanel5); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smlsTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smlsTab)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ssnFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssnFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssnFieldActionPerformed

    private void serviceDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviceDateFieldActionPerformed

    private void postalCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postalCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postalCodeFieldActionPerformed

    private void homePhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homePhoneFieldActionPerformed

    private void ePostalCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ePostalCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ePostalCodeFieldActionPerformed

    private void homePhoneField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePhoneField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homePhoneField1ActionPerformed

    private void phoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneFieldActionPerformed

    private void TCNFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCNFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCNFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TCNField;
    private javax.swing.JTextField birthDateField;
    private javax.swing.JTextField certificateDateField;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField eCityField;
    private javax.swing.JTextField ePostalCodeField;
    private javax.swing.JComboBox eStateComboBox;
    private javax.swing.JTextField eStreetField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JComboBox genderComboBox;
    private javax.swing.JTextField homePhoneField;
    private javax.swing.JTextField homePhoneField1;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField middleNameField;
    private javax.swing.JTextField mobilePhoneField;
    private javax.swing.JTextField mobilePhoneField1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField officePhoneField;
    private javax.swing.JTextField officePhoneField1;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JTextField relationshipField;
    private javax.swing.JTextField serviceDateField;
    private javax.swing.JComboBox skillComboBox;
    private javax.swing.JTabbedPane smlsTab;
    private javax.swing.JTextField ssnField;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JTextField streetField;
    private javax.swing.JComboBox userRoleComboBox;
    private javax.swing.JTextField usernameField;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        result = WindowManager.getDefault().findTopComponent("PersonnelSubystemViewerTopComponent").getLookup().lookupResult(AccessInfo.class);
        result.addLookupListener(this);
        resultChanged(new LookupEvent(result));
    }

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
        result = null;
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public void resultChanged(LookupEvent lookupEvent) {
        Lookup.Result r = (Lookup.Result) lookupEvent.getSource();
        Collection<AccessInfo> coll = r.allInstances();
        if (!coll.isEmpty()) {
            for (AccessInfo accessinfo : coll) {
                ai=accessinfo;
                idField.setText(accessinfo.getUserId());
                usernameField.setText(accessinfo.getUsername());
                passwordField.setText(accessinfo.getPassword());
            }
        } else {
            idField.setText("[no id]");
            usernameField.setText("[no username]");
            passwordField.setText("[no password]");
        }
    }

    @Override
    public UndoRedo getUndoRedo() {
        return manager;
    }

    private void modify() {
        if (getLookup().lookup(MySavable.class) == null) {
            instanceContent.add(new MySavable());
        }
    }
    private static final Icon ICON = ImageUtilities.loadImageIcon("org/shop/editor/Icon.png", true);

    private class MySavable extends AbstractSavable implements Icon {

        MySavable() {
            register();
        }

        @Override
        protected String findDisplayName() {
            String name = nameField.getText();
            String city = cityField.getText();
            return name + " from " + city;
        }

        @Override
        protected void handleSave() throws IOException {
            Confirmation message = new NotifyDescriptor.Confirmation("Do you want to save \""
                    + nameField.getText() + " (" + cityField.getText() + ")\"?",
                    NotifyDescriptor.OK_CANCEL_OPTION,
                    NotifyDescriptor.QUESTION_MESSAGE);
            Object result = DialogDisplayer.getDefault().notify(message);
            //When user clicks "Yes", indicating they really want to save,
            //we need to disable the Save action,
            //so that it will only be usable when the next change is made
            //to the JTextArea:
            if (NotifyDescriptor.YES_OPTION.equals(result)) {
                EntityManager entityManager = Persistence.createEntityManagerFactory("CustomerLibraryPU").createEntityManager();
                entityManager.getTransaction().begin();
                AccessInfo c = entityManager.find(AccessInfo.class, ai.getUserId());
                c.setUsername(usernameField.getText());
                c.setPassword(passwordField.getText());
                entityManager.getTransaction().commit();
                tc().instanceContent.remove(this);
                unregister();
            }
        }

        PersonnelSystemEditorTopComponent tc() {
            return PersonnelSystemEditorTopComponent.this;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MySavable) {
                MySavable m = (MySavable) obj;
                return tc() == m.tc();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return tc().hashCode();
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            ICON.paintIcon(c, g, x, y);
        }

        @Override
        public int getIconWidth() {
            return ICON.getIconWidth();
        }

        @Override
        public int getIconHeight() {
            return ICON.getIconHeight();
        }

    }
}
