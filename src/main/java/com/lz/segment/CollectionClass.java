package com.lz.segment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionClass {
    /**
     * 排序中遇到null的处理
     */
    public static void sort() {
        List<Model> models = new ArrayList<>();
        models.add(new Model(2));
        models.add(new Model(3));
        models.add(new Model(null));
        models.add(new Model(1));
        models.add(new Model(null));
        models = models.stream().sorted(
                Comparator.comparing(Model::getSort, Comparator.nullsLast(Comparator.naturalOrder()))
        ).collect(Collectors.toList());
        System.out.println(models.toString());
    }

    public static void main(String[] args) {
        sort();
    }
}


@Getter
class Model {
    private Integer sort;

    public Model(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Model{" +
                "sort=" + sort +
                '}';
    }
}