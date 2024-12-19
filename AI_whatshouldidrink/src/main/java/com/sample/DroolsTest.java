package com.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class DroolsTest {
    public static final void main(String[] args) {
    	KieServices ks = KieServices.Factory.get();
    	KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	JFrame f = new JFrame();
    	try {
    	    kSession.fireAllRules();
    	} catch (Throwable t) {
    	    t.printStackTrace();
    	}
    	f.setLayout(null);
    }
}
