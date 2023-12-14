package org.abi.pages.control;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagesBean {

    public String getLandingPage() {
        return """
                <header> THIS IS A TEST </header>
                <h>Ayo</h>
                """;
        
    }
    
}
