public class IpCounterApp {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        long startTime = System.currentTimeMillis();

        fileReader.readLinesFromFile();

        long endTime = System.currentTimeMillis();

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Использовано памяти: " + (usedMemoryAfter - usedMemoryBefore) + " байт");
        System.out.println("Время выполнения: " + (endTime - startTime) + " миллисекунд");

    }

}
