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
import java.util.List;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import static com.personnel.viewer.Bundle.*;

public class AccessInfoRootNode extends AbstractNode {

    @Messages("CTRL_RootName=Root")
    public AccessInfoRootNode(Children kids) {
        super(kids);
        setDisplayName(CTRL_RootName());
    }

    @Override
    public Action[] getActions(boolean context) {
        List<? extends Action> actionsForAccessInfo = Utilities.actionsForPath("Actions/AccessInfo");
        return actionsForAccessInfo.toArray(new Action[actionsForAccessInfo.size()]);
    }

}