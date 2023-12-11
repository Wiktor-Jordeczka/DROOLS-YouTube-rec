package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.api.logger.*;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test");
        	
            // go !
        	kSession.fireAllRules();
        	
        	/*// Nie wiem czy to ma sens skoro klasy są w .drl
        	QueryResults results = kSession.getQueryResults( "Kanały do obejrzenia:" );
        	for ( QueryResultsRow row : results ) {
        	    Solution solution = ( Solution ) row.get( "solution" );
        	    System.out.println( solution.getSolutionText() + "\n" );
        	}
        	*/
        	
        	kLogger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}