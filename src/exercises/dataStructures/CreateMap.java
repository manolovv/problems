package exercises.dataStructures;


import java.util.ArrayList;
import java.util.List;

public class CreateMap {
    public static void main(String[] args) {

        Map map = new Map();

        map.put("Manol", 69);
        map.put("Manol", 6);
        map.putIfAbsent("Tanya", 0);
        map.putIfAbsent("Tanya", 5);
        map.putIfAbsent("Ivan", 73);

        map.printKeyAndValue();

        System.out.println("\nValue of key 'Manol' is: " + map.get("Manol") +
                "\nIs Key contains 'Tanya' ? : " + map.containsKey("Tanya") +
                "\nIs Value contains number '69' : " + map.containsValue(69));

    }
    private static class Map {
        private final List<String> keyList;
        private final List<Integer> valueList;

        public Map() {
            this.keyList = new ArrayList<>();
            this.valueList = new ArrayList<>();
        }

        public void put(String key, int value) {
            if (containsKey(key)) {
                changeValue(takeKeyIndex(key), value);
            } else {
                keyList.add(key);
                addValue(takeKeyIndex(key), value);
            }
        }

        public void putIfAbsent(String key, int value) {
            if (containsKey(key)) {
                if (!containsValue(takeKeyIndex(key))) {
                    changeValue(takeKeyIndex(key), value);
                }
            } else {
                keyList.add(key);
                addValue(takeKeyIndex(key), value);
            }
        }

        public int get(String key) {
            int value;
            if (containsKey(key)) {
                int index = takeKeyIndex(key);
                value = valueList.get(index);
                return value;
            } else {
                throw new IllegalArgumentException("Null");
            }
        }

        public boolean containsKey(String searchingKey) {
            return keyList.contains(searchingKey);
        }

        public boolean containsValue(int searchingIndex) {
            return valueList.contains(searchingIndex);
        }

        public int takeKeyIndex(String key) {
            int index = 0;
            for (int i = 0; i < keyList.size(); i++) {
                if (keyList.get(i).equals(key)) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        private void addValue(int index, int value) {
            valueList.add(index, value);
        }

        public void changeValue(int index, int value) {
            valueList.remove(index);
            valueList.add(value);
        }

        public void printKeyAndValue() {
            for (int i = 0; i < keyList.size(); i++) {
                System.out.print("Key: " + keyList.get(i) + " -> Value: " + valueList.get(i) + "\n");
            }
        }
    }
}
