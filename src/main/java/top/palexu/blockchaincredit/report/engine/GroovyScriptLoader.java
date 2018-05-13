package top.palexu.blockchaincredit.report.engine;

import com.google.common.base.Strings;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.palexu.blockchaincredit.common.util.MD5Util;
import top.palexu.blockchaincredit.report.engine.script.ScriptProcessor;
import top.palexu.blockchaincredit.report.model.FactorDo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GroovyScriptLoader {
    static Logger logger = LoggerFactory.getLogger(GroovyScriptLoader.class);
    private static HashMap<String, GroovyObject> groovyObjectMap = new HashMap<>();

    private static GroovyObject parseScript(String script) {
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

    public static GroovyObject parse(FactorDo factorDo) {
        assert !Strings.isNullOrEmpty(factorDo.getContent());
        return parseScript(factorDo.getContent());
    }

    public static List<ScriptProcessor> parse(Collection<FactorDo> factorDos) {
        List<ScriptProcessor> gs = new ArrayList<>(factorDos.size());
        for (FactorDo sd : factorDos) {
            gs.add(new ScriptProcessor(parse(sd)));
        }
        return gs;
    }
}
