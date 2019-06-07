package com.ysdd.tblm.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * 拷贝工具类
 *
 * @author chenfa
 * @date 2019/6/6 17:31
 */
public class CopyUtils {
    /**
     * 属性为null的名称
     *
     * @param source 类
     * @return null值的属性名称
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 拷贝属性，默认不拷贝null
     *
     * @param src    原类
     * @param target 目标类
     */
    public static void copyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    /**
     * 拷贝属性，拷贝过程中null值覆盖
     *
     * @param src    原类
     * @param target 目标类
     */
    public static void copuPropertiesIncludeNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target);
    }

}
