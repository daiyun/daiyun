package daiyun.leetcode.lcci;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，
 * 或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。
 * 请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。
 * 允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 * <p>
 * 收纳所的最大容量为20000
 */
public class Question0306 {

    public static void main(String[] args) {
        Question0306 question = new Question0306();

    }


    static class AnimalShelf {

        LinkedList<Pair<Integer, Integer>> animals = new LinkedList<>();

        int maxSize = 20000;

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            if (animal == null || animal.length != 2) {
                return;
            }

            if (animals.size() > maxSize) {
                return;
            }

            animals.add(new Pair<>(animal[0], animal[1]));
        }

        public int[] dequeueAny() {
            if (animals.size() > 0) {
                Pair<Integer, Integer> animal = animals.removeFirst();
                return new int[]{animal.getKey(), animal.getValue()};
            }
            return new int[]{-1, -1};
        }

        // int[1]=1
        public int[] dequeueDog() {
            for (int i = 0; i < animals.size(); i++) {
                Pair<Integer, Integer> animal = animals.get(i);
                if (animal.getValue() == 1) {
                    animals.remove(i);
                    return new int[]{animal.getKey(), animal.getValue()};
                }
            }
            return new int[]{-1, -1};
        }

        // int[1]=0
        public int[] dequeueCat() {
            for (int i = 0; i < animals.size(); i++) {
                Pair<Integer, Integer> animal = animals.get(i);
                if (animal.getValue() == 0) {
                    animals.remove(i);
                    return new int[]{animal.getKey(), animal.getValue()};
                }
            }
            return new int[]{-1, -1};
        }
    }

}
