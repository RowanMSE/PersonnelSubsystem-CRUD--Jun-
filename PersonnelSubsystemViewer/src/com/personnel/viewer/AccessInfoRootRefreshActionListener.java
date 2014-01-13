/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.personnel.viewer;

/**
 *
 * @author junxin
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(id="com.personnel.viewer.AccessInfoRootRefreshActionListener", category="AccessInfo")
@ActionRegistration(displayName="#CTL_AccessInfoRootRefreshActionListener")
@Messages("CTL_AccessInfoRootRefreshActionListener=Refresh")
public class AccessInfoRootRefreshActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        PersonnelSubystemViewerTopComponent.refreshNode();
    }
    
}
