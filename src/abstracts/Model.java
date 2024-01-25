package abstracts;

import java.util.LinkedHashMap;

import helper.Relation;

public abstract class Model {
    protected LinkedHashMap<String, String> map;
    protected LinkedHashMap<String, Class<?>> relationMap;

    public Model() {
        map = new LinkedHashMap<>();

        if (getIdName() != null) {
            map.put(getIdName(), null);
        }
        String[] attributes = getAttributes();
        for (int i = 0; i < getAttributes().length; i++) {
            map.put(attributes[i], null);
        }
        for (Relation relation : getRelations()) {
            map.put(relation.getForeignKey(), null);
            relationMap.put(relation.getForeignKey(), relation.getClass());
        }
    }

    public String getIdName() {
        return null;
    }

    public abstract String[] getAttributes();

    public final LinkedHashMap<String, String> getMap() {
        return map;
    };

    public final String getValue(String attribute) {
        return map.get(attribute);
    }

    protected void setValue(String attributeName, String value) {
        map.put(attributeName, value);
    }

    public void setValues(String[] values) {
        String[] attributes = getAttributes();
        for (int i = 0; i < getAttributes().length; i++) {
            map.put(attributes[i], values[i] == null ? null : values[i]);
        }
        setObjects();
    }

    public void setObjects() {
    };

    public String[] getValues() {
        return (String[]) map.values().toArray(new String[] {});
    }

    public String[] getKeys() {
        return (String[]) map.keySet().toArray(new String[] {});
    }

    public void setValues(LinkedHashMap<String, String> m) {
        for (String key : map.keySet()) {
            if (m.containsKey(key)) {
                map.put(key, m.get(key));
            }
        }

    }

    public Relation[] getRelations() {
        return new Relation[0];
    }

}
