package top.palexu.blockchaincredit.report.engine.script;

import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScriptProcessor {
    GroovyObject groovyObject;

    public ScriptProcessor(GroovyObject groovyObject) {
        this.groovyObject = groovyObject;
    }

    public Object invokeMethod(Object param) {
        try {
            if (this.groovyObject == null) {
                return null;
            }
            return groovyObject.invokeMethod("execute", param);
        } catch (Exception e) {
            log.info("groovy invoke exception", e);
        }
        return null;
    }
}
