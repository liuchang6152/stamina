package com.stamina.stamina.common.util;
/**
 * 公共枚举
 * 模块编号：CommonEnum
 * 作    者：weijian.hou
 * 创建时间：2017/09/10
 * 修改编号：1
 * 描    述：公共枚举
 */
public class CommonEnum {

    /**
     *单位(0秒,1厘米,2公斤,3个,4毫升)
     */
    public enum Unit {
        SECONDS(0,"秒"),
        CM(1,"厘米"),
        KG(2,"公斤"),
        ONE(3,"个"),
        ML(4,"毫升");
        Unit(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public static String getName(Integer index) {
            for (Unit c : Unit.values()) {
                if (c.getId().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public static Integer getId(String name) {
            for (Unit c : Unit.values()) {
                if (c.getName().equals(name)) {
                    return c.id;
                }
            }
            return null;
        }
        private Integer id;

        private String name;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }

    /**
     *（0取最大值，1取最小值，2取平均值）
     */
    public enum Value {
        MAXIMUM(0,"最大值"),
        MINIMUM(1,"最小值"),
        AVERAGE(2,"平均值");
        Value(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public static String getName(Integer index) {
            for (Unit c : Unit.values()) {
                if (c.getId().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public static Integer getId(String name) {
            for (Unit c : Unit.values()) {
                if (c.getName().equals(name)) {
                    return c.id;
                }
            }
            return null;
        }
        private Integer id;

        private String name;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }
}
