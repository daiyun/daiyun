package daiyun.topic2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author godaiyun
 * @date 2018-12-11 20:11.
 */
public class ParallelComputingTest2 {

    //    private static Map<String, Integer> wordsCount = new HashMap<>();
    private static String lock = "lock";
    private int threadSize;
    private LinkedBlockingQueue<String> queue;
    private String dataDir;

    public static void main(String[] args) {
        ParallelComputingTest2 parallelComputingTest
                = new ParallelComputingTest2("C:\\Users\\godai\\Desktop\\data\\123", 5);


        parallelComputingTest.readDataFileToList();

        // 并行计算
        try {
            parallelComputingTest.doParallelComputing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("seemed:" + wordsCount.get("seemed"));
//        System.out.println("empty:" + wordsCount.get("empty"));
//        System.out.println("after:" + wordsCount.get("after"));
//        System.out.println("thought:" + wordsCount.get("thought"));

        /**
         * seemed:1111
         * empty:240
         * after:1122
         * thought:1122
         */


        // 结果合并
//        parallelComputingTest.doTo100Count();

    }

    public ParallelComputingTest2(String dataDir, int threadSize) {
        this.dataDir = dataDir;
        this.threadSize = threadSize;
    }

    private void doParallelComputing() throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(threadSize);

        CompletionService<HashMap<String, Integer>> pool = new ExecutorCompletionService<>(executors);

        List<Future> futures = new ArrayList<Future>();

        for (int i = 0; i < threadSize; i++) {
            ParallelComputingTask thread = new ParallelComputingTask(queue);
            pool.submit(thread);
        }

        for(int i = 0 ; i <threadSize ; i++){
            try {
                Future<HashMap<String, Integer>> f = pool.take();
                HashMap<String, Integer> da1 = (HashMap<String, Integer>) f.get();
                System.out.println(da1.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        executors.shutdown();

    }

    static class WordAndCount {
        String word;
        int count;

        public WordAndCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    private void doTo100Count(HashMap<String, Integer> wordsCount) {

        if (wordsCount.size() < 100) {
            WordAndCount[] wordAndCounts = new WordAndCount[wordsCount.size()];
            int index = 0;
            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                wordAndCounts[index++] = new WordAndCount(entry.getKey(), entry.getValue());
            }

            minHeapBuild(wordAndCounts);

            for (int i = wordAndCounts.length - 1; i >= 0; i--) {
                WordAndCount temp = wordAndCounts[0];
                wordAndCounts[0] = wordAndCounts[i];
                wordAndCounts[i] = temp;
                siftDown(wordAndCounts, 0, i - 1);
            }

            for (int i = 0; i < wordAndCounts.length; i++) {
                System.out.println(wordAndCounts[i].word + " =>" + wordAndCounts[i].count);
            }

        } else {
            WordAndCount[] wordAndCounts = new WordAndCount[100];
            int index = 0;
            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                if (index >= 100) {
                    if (entry.getKey().equals("seemed")
                            || entry.getKey().equals("empty")
                            || entry.getKey().equals("after")
                            || entry.getKey().equals("thought")
                            ) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                    if (entry.getValue().intValue() > wordAndCounts[0].count) {
                        WordAndCount minWordConnt = new WordAndCount(entry.getKey(), entry.getValue());
                        wordAndCounts[0] = minWordConnt;
//                        wordAndCounts[0].count = entry.getValue();
//                        wordAndCounts[0].word = entry.getKey();

                        siftDown(wordAndCounts, 0, 99);
                    }
                } else {
                    wordAndCounts[index++] = new WordAndCount(entry.getKey(), entry.getValue());
                    if (index == 100) {
                        minHeapBuild(wordAndCounts);
                    }
                }
            }

            System.out.println();
            for (int i = wordAndCounts.length - 1; i >= 0; i--) {
                WordAndCount temp = wordAndCounts[0];
                wordAndCounts[0] = wordAndCounts[i];
                wordAndCounts[i] = temp;
                siftDown(wordAndCounts, 0, i - 1);
            }

            for (int i = 0; i < wordAndCounts.length; i++) {
                System.out.println(wordAndCounts[i].word + " =>" + wordAndCounts[i].count);
            }

        }
    }

    public static void minHeapBuild(WordAndCount[] wordAndCounts) {
        int length = wordAndCounts.length - 1;
        for (int i = length / 2 - 1; i >= 0; i--) {
            siftDown(wordAndCounts, i, wordAndCounts.length - 1);
        }
    }

    public static void siftDown(WordAndCount[] wordAndCounts, int start, int end) {
        WordAndCount node = wordAndCounts[start];
        while (start < end) {
            if (2 * start + 2 <= end) {
                int maxSon = wordAndCounts[2 * start + 1].count < wordAndCounts[2 * start + 2].count ? 2 * start + 1 : 2 * start + 2;
                if (node.count < wordAndCounts[maxSon].count) {
                    break;
                } else {
                    wordAndCounts[start] = wordAndCounts[maxSon];
                    start = maxSon;
                }
            } else if (2 * start + 1 <= end) {
                if (wordAndCounts[start].count < wordAndCounts[2 * start + 1].count) {
                    break;
                } else {
                    wordAndCounts[start] = wordAndCounts[2 * start + 1];
                    start = 2 * start + 1;
                }
            } else {
                break;
            }
        }
        wordAndCounts[start] = node;
    }

    public void readDataFileToList() {
        File dataPath = new File(dataDir);

        if (dataPath.exists() && dataPath.isDirectory()) {
            String[] fileNames = dataPath.list();
            queue = new LinkedBlockingQueue<>();
            for (String fileName : fileNames) {
                queue.add(dataDir + File.separator + fileName);
            }
        } else {
            System.out.println("file path:[" + dataDir + "] not exists!");
        }
    }


    static class ParallelComputingTask implements Callable<HashMap<String, Integer>> {
        private LinkedBlockingQueue<String> queue;
        private HashMap<String, Integer> wordCount = new HashMap<>();

        public ParallelComputingTask(LinkedBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public HashMap<String, Integer> call() throws Exception {

            while (true) {
                String fileAbsPath = queue.poll();
                System.out.println(Thread.currentThread().getName() + "==>" + fileAbsPath);
                if (fileAbsPath == null) {
                    break;
                }

                FileReader fileReader = null;
                BufferedReader bufferedReader = null;
                try {
                    fileReader = new FileReader(fileAbsPath);
                    bufferedReader = new BufferedReader(fileReader);
                    String oneLine = null;
                    while ((oneLine = bufferedReader.readLine()) != null) {
                        String[] words = oneLine.split("\\s");
                        for (String word : words) {
                            word = wordHandler(word);
                            if (!"".equals(word)) {
                                String lowerStr = word.toLowerCase();

                                if (wordCount.containsKey(lowerStr)) {
                                    wordCount.put(lowerStr, wordCount.get(lowerStr) + 1);
                                } else {
                                    wordCount.put(lowerStr, 1);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            return wordCount;
        }

    }

    public static String wordHandler(String in) {
        StringBuilder sb = new StringBuilder();
        char[] ch = in.trim().toCharArray();
        int count = 0;
        for (char c : ch) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                sb.append(c);
            } else {
                break;
            }
        }

        if (count != ch.length) {
            return "";
        }

        return sb.toString();
    }

}
