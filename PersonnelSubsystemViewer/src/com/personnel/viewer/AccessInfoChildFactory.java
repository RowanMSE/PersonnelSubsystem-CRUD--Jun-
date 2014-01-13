/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personnel.viewer;

import java.beans.IntrospectionException;
import java.util.List;
import org.openide.nodes.BeanNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.lookup.Lookups;
import smls.AccessInfo;

/**
 *
 * @author junxin
 */
public class AccessInfoChildFactory extends ChildFactory<AccessInfo> {

    private List<AccessInfo> resultList;

    public AccessInfoChildFactory(List<AccessInfo> resultList) {
        this.resultList = resultList;
    }

    @Override
    protected boolean createKeys(List<AccessInfo> list) {
        for (AccessInfo ai : resultList) {
            list.add(ai);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(AccessInfo c) {
        try {
            return new AccessInfoBeanNode(c);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

    private class AccessInfoBeanNode extends BeanNode {

        public AccessInfoBeanNode(AccessInfo bean) throws IntrospectionException{
            super(bean, Children.LEAF, Lookups.singleton(bean));
        }
    }    
}
