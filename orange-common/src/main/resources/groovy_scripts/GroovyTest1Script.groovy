package groovy_scripts

import groovy.interfaces.GroovyTest1Interf

class GroovyTest1Script implements GroovyTest1Interf {

    @Override
    String testMethod1(String p) {
        println 'hello ' + p;
        return "thanks orange";
    }
}
