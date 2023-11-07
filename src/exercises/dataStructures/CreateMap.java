package exercises.dataStructures;


public class CreateMap {
    public static void main(String[] args) {

        Map map = new Map(6);

        map.put("Manol", 6);
        map.put("Ivan", 6);
        map.put("Milen", 0);
        map.putIfAbsent("Milen", 66);
        map.put("Tanya", 26);
        map.putIfAbsent("Mitko", 32);
        map.put("Iva", 25);
        map.put("Ivan", 17);

        boolean containsKey = map.containsKey("Manol");
        int takenValue = map.get("Manol");

        map.printKeyAndValue();
        System.out.println("Is map contains key 'Manol'? -> " + containsKey);
        System.out.println("Manol`s value is -> " + takenValue);
    }
    private static class Map {
        private final String[] keyArr;
        private final int[] valueArr;
        private int top;

        public Map(int length) {
            this.keyArr = new String[length];
            this.valueArr = new int[length];
            this.top = 0;
        }

        public void put(String key, int value) {
            if (containsKey(key)) {
                addValue(takeKeyIndex(key), value);
            } else {
                keyArr[top++] = key;
                addValue(takeKeyIndex(key), value);
            }
        }

        public void putIfAbsent(String key, int value) {
            if (containsKey(key)) {
                if (!containsValue(takeKeyIndex(key))) {
                    addValue(takeKeyIndex(key), value);
                }
            } else {
                keyArr[top++] = key;
                addValue(takeKeyIndex(key), value);
            }
        }

        public int get(String key) {
            int value;
            if (containsKey(key)) {
                int index = takeKeyIndex(key);
                value = valueArr[index];
                return value;
            } else {
                throw new IllegalArgumentException("Null");
            }
        }

        public boolean containsKey(String searchingKey) {
            for (String element : keyArr) {
                if (element != null) {
                    if (element.hashCode() == searchingKey.hashCode()) {
                        if (element.equals(searchingKey)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean containsValue(int searchingIndex) {
            return valueArr[searchingIndex] != 0;
        }

        public int takeKeyIndex(String key) {
            int index = 0;
            for (int i = 0; i < keyArr.length; i++) {
                if (keyArr[i].equals(key)) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        private void addValue(int index, int value) {
            valueArr[index] = value;
        }

        public void printKeyAndValue() {
            for (int i = 0; i < keyArr.length; i++) {
                System.out.print("Key: " + keyArr[i] + " -> Value: " + valueArr[i] + "\n");
            }
        }
    }
}
