package com.github.longdt.dsljson;

import com.dslplatform.json.processor.AttributeInfo;
import com.dslplatform.json.processor.NamingStrategy;

import java.util.*;

public class SnakeCaseNaming implements NamingStrategy {
    @Override
    public Map<String, String> prepareNames(Map<String, AttributeInfo> attributes) {
        var result = new LinkedHashMap<String, String>();
        for (AttributeInfo p : attributes.values()) {
            result.put(p.id, Objects.requireNonNullElseGet(p.alias, () -> camelToSnake(p.id)));
        }
        return result;
    }

    public static String camelToSnake(String name) {
        var builder = new StringBuilder(name.length() * 2);
        builder.append(Character.toLowerCase(name.charAt(0)));
        for (int i = 1; i < name.length(); ++i) {
            char ch = name.charAt(i);
            if (Character.isUpperCase(ch)) {
                builder.append('_')
                        .append(Character.toLowerCase(ch));
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
