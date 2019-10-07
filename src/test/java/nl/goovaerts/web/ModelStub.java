package nl.goovaerts.web;

import org.springframework.ui.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ModelStub implements Model {

    private final Map<String, Object> modelMap = new HashMap<>();

    @Override
    public Model addAttribute(String s, Object o) {
        this.modelMap.put(s, o);
        return this;
    }

    @Override
    public Model addAttribute(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Model addAllAttributes(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Model addAllAttributes(Map<String, ?> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Model mergeAttributes(Map<String, ?> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAttribute(String s) {
        return this.modelMap.containsKey(s);
    }

    @Override
    public Map<String, Object> asMap() {
        return this.modelMap;
    }
}
