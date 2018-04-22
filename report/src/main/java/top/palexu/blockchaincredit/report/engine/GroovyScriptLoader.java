package top.palexu.blockchaincredit.report.engine;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.palexu.blockchaincredit.common.util.MD5Util;

import java.util.HashMap;

public class GroovyScriptLoader {
    Logger logger = LoggerFactory.getLogger(GroovyScriptLoader.class);
    private static HashMap<String, GroovyObject> groovyObjectMap = new HashMap<>();

    public GroovyObject parseScript(String script) {
        String md5 = MD5Util.MD5EncodeUtf8(script);
        GroovyObject groovyObject = groovyObjectMap.get(md5);

        if (groovyObject != null) {
            return groovyObject;
        }

        try {
            Class<Script> clazz = new GroovyClassLoader().parseClass(script);
            groovyObject = clazz.newInstance();

            groovyObjectMap.put(md5, groovyObject);
            return groovyObject;
        } catch (InstantiationException e) {
            logger.error("groovy 脚本加载异常,script={}", script, e);
        } catch (Exception e) {
            logger.error("groovy 脚本加载异常,script={}", script, e);
        }
        return null;
    }
}
