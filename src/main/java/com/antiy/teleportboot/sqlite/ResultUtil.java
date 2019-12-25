package com.antiy.teleportboot.sqlite;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 13:49
 */
public class ResultUtil<T> {

    /**
     * 注意保持查询结果的属性名称与对象域名一致。
     *
     * @param resultSet
     * @param clazz
     * @param <T>
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    public static <T> List<T> getReflectObject(ResultSet resultSet, Class<T> clazz) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        List<T> list = new LinkedList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();
        while (resultSet.next()) {
            T t = clazz.newInstance();
            // 一个对象
            for (int i = 1; i < count + 1; i++) {
                String columnName = metaData.getColumnName(i);
                Field declaredField = clazz.getDeclaredField(columnName);
                declaredField.setAccessible(true);
                Class<?> type = declaredField.getType();

                if (type.isAssignableFrom(String.class)) {
                    declaredField.set(t, resultSet.getString(i));
                } else if (type.isAssignableFrom(Integer.class)) {
                    declaredField.set(t, resultSet.getInt(i));
                }
            }
            list.add(t);
        }
        return list;
    }
}
