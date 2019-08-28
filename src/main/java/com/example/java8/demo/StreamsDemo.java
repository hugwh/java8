package com.example.java8.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * stream demo
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-08-28 11:22
 */
@Slf4j
public class StreamsDemo {

    /**
     * 过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。
     * forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
     * @param stringList
     */
    public static void filter(List<String> stringList) {
        stringList.stream().filter((s) -> s.startsWith("a")).forEach(log::info);
    }

    /**
     * 排序是一个 中间操作，返回的是排序好后的 Stream。如果你不指定一个自定义的 Comparator 则会使用默认排序。
     * @param stringList
     */
    public static void sorted(List<String> stringList) {
        stringList.stream().sorted().filter(s -> s.startsWith("a")).forEach(log::info);
    }

    /**
     * 中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象。
     * @param stringList
     */
    public static void map(List<String> stringList) {
        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(log::info);
    }

    /**
     * Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是 最终操作 ，并返回一个 boolean 类型的值。
     * @param stringList
     */
    public static void match(List<String> stringList) {
        // 测试 Match (匹配)操作
        boolean anyStartsWithA =
                stringList
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringList
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringList
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
    }

    /**
     * 计数是一个 最终操作，返回Stream中元素的个数，返回值类型是 long。
     * @param stringList
     */
    public static void count(List<String> stringList) {
        long count = stringList
                .stream()
                .count();

        log.info("集合长度：{}", count);
    }

    /**
     *  这个方法的主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则（BinaryOperator），
     *  和前面 Stream 的第一个、第二个、第 n 个元素组合。从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。
     *  例如 Stream 的 sum 就相当于Integer sum = integers.reduce(0, (a, b) -> a+b);也有没有起始值的情况，
     *  这时会把 Stream 的前面两个元素组合起来，返回的是 Optional。
     * @param stringList
     */
     public static void reduced(List<String> stringList) {
         Optional<String> reduced = stringList
                 .stream()
                 .sorted()
                 .reduce((a, b) -> a + "@" +b);

         reduced.ifPresent(log::info);
     }

     public static void parallelStreams(List<String> stringList) {

     }
}
